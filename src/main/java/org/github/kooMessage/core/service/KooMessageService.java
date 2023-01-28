package org.github.kooMessage.core.service;

import com.alibaba.fastjson.JSONObject;
import org.github.kooMessage.config.TokenService;
import org.github.kooMessage.core.method.DataType;
import org.github.kooMessage.core.method.HttpMethod;
import org.github.kooMessage.core.method.KHttpMethodBody;
import org.github.kooMessage.core.method.KHttpMethodService;
import org.github.kooMessage.core.response.ResponseBody;
import org.github.kooMessage.model.Result;
import org.github.kooMessage.util.HttpUtil;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.service
 * @Author: 王飞
 * @CreateTime: 2022-09-21  18:08
 * @Description: 服务请求
 * @Version: 1.0
 */
public interface KooMessageService<R,T> extends TokenService , KHttpMethodService {
    Lock lock = new ReentrantLock();
    /**
     * CPU密集型（CPU-bound）
     * 线程数一般设置为：
     * 线程数 = CPU核数+1 (现代CPU支持超线程)
     *
     *
     * IO密集型（I/O bound）
     * 线程数一般设置为：
     * 线程数 = （（线程等待时间+线程CPU时间）/线程CPU时间 ）* CPU数目
     */
    //设置CPU密集型  假设CPU是8核，可根据实际情况设定。
    ExecutorService executorService = Executors.newFixedThreadPool( 8 +1 );


    default void init (KooMessageService<R,T> kooMessageService,Consumer<KooMessageService<R,T>> consumer)  {
        consumer.accept(kooMessageService);
    }

    T  convertData();

    default ResponseBody<R> execute(Supplier<T> supplier1, Supplier<Class> supplier2) throws ExecutionException, InterruptedException {
        CompletableFuture<ResponseBody<R>> result = CompletableFuture.supplyAsync(  ()->{
            return http(supplier1,supplier2);
        },executorService).exceptionally(e-> {
            throw new RuntimeException(e);
        });
        return  result.get();
    }

    default ResponseBody<R> http(Supplier<T> supplier1, Supplier<Class> supplier2) {
        T t = supplier1.get();
        ResponseBody<R> responseBody = null;
        String response = null;
        Assert.notNull(t,"请求模板为空，请检查！");
        KHttpMethodBody kHttpMethodBody = this.getConfig(t :: getClass);
        Assert.notNull(kHttpMethodBody,t.getClass()+"，未注册到注册表中。参考："+KHttpMethodService.class);
        try {
            lock.lock();
            if(kHttpMethodBody.getDataType() == DataType.JSON_STRING){
                String tJsonStr = JSONObject.toJSONString(t);
                JSONObject tJson = JSONObject.parseObject(tJsonStr);
                if(kHttpMethodBody.getMethod() == HttpMethod.POST){
                    response = post   ( kHttpMethodBody :: getUrl ,tJson, this ::getToken,kHttpMethodBody :: getDocumentUrl);
                } else if(kHttpMethodBody.getMethod() == HttpMethod.GET) {
                    response = get    ( kHttpMethodBody :: getUrl ,tJson, this ::getToken,kHttpMethodBody :: getDocumentUrl);
                } else if(kHttpMethodBody.getMethod() == HttpMethod.DELETE) {
                    response = delete ( kHttpMethodBody :: getUrl ,tJson, this ::getToken,kHttpMethodBody :: getDocumentUrl);
                } else if(kHttpMethodBody.getMethod() == HttpMethod.PUT) {
                    response = put    ( kHttpMethodBody :: getUrl ,tJson, this ::getToken,kHttpMethodBody :: getDocumentUrl);
                } else {
                    Assert.isTrue(false,kHttpMethodBody.toString()+"未实现该请求类型发送请求："+kHttpMethodBody.getMethod()+",数据类型："+ kHttpMethodBody.getDataType());
                }
            } else if(kHttpMethodBody.getDataType() == DataType.FORM_DATA){
                Map<String, Object> requestMap = objectToMap(t);
                if(kHttpMethodBody.getMethod() == HttpMethod.POST){
                    response = post_form_data(kHttpMethodBody :: getUrl,requestMap,this ::getToken,kHttpMethodBody :: getDocumentUrl);
                } else {
                    Assert.isTrue(false,kHttpMethodBody.toString()+"未实现该请求类型发送请求："+kHttpMethodBody.getMethod()+",数据类型："+ kHttpMethodBody.getDataType());
                }
            }
            if (supplier2.get() == String.class) {
                responseBody = new ResponseBody<R>(response);
            } else
            if (supplier2.get() == Result.class) {
                responseBody = new ResponseBody<R>(  kHttpMethodBody :: getResult ,response);
            }
            return responseBody;
        } finally {
            lock.unlock();
        }
    }

    default String get(Supplier<String> supplier1, JSONObject json, Supplier<String> supplier2,Supplier<String> supplier3) {
        return HttpUtil.doGetWithParam(supplier1.get(),json,supplier2.get(),supplier3.get());
    }

    default String post (Supplier<String> supplier1, JSONObject json, Supplier<String> supplier2,Supplier<String> supplier3) {
        return HttpUtil.doPostJson(supplier1.get(),json,supplier2.get(),supplier3.get());
    }

    default String delete (Supplier<String> supplier1, JSONObject json, Supplier<String> supplier2,Supplier<String> supplier3) {
        return HttpUtil.doDelete(supplier1.get(),json,supplier2.get(),supplier3.get());
    }

    default String put (Supplier<String> supplier1, JSONObject json, Supplier<String> supplier2,Supplier<String> supplier3) {
        return HttpUtil.doPutJson(supplier1.get(),json,supplier2.get(),supplier3.get());
    }

    default String post_form_data (Supplier<String> supplier1, Map<String, Object> map, Supplier<String> supplier2,Supplier<String> supplier3) {
        return HttpUtil.httpClientUploadFile(supplier1.get(),map,supplier2.get(),supplier3.get());
    }

    default ResponseBody<R> result (Supplier<ResponseBody<R>> supplier1) {
        //组装到result的结果集中
        return supplier1.get();
    }

    static <T> Map<String, Object> objectToMap(T t, String... ignoreFields) {
        Map<String, Object> map = new HashMap<>();
        Field[] declaredFields = t.getClass().getDeclaredFields();
        List<String> ignoreFieldList = Arrays.asList(ignoreFields);
        Arrays.stream(declaredFields).forEach(data -> {
            data.setAccessible(true);
            try {
                if (ignoreFieldList.isEmpty() || !ignoreFieldList.contains(data.getName())) {
                    map.put(data.getName(), data.get(t));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return map;
    }
}
