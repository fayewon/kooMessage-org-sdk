package org.github.kooMessage.core.response;

import com.alibaba.fastjson.JSONObject;
import org.github.kooMessage.core.exception.KResponseException;

import java.util.function.Supplier;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.response
 * @Author: 王飞
 * @CreateTime: 2022-09-28  09:25
 * @Description: 返回值信息
 * @Version: 1.0
 */
public class ResponseBody<R> {
    private final static String ERROR_CODE_URL = "https://support.huaweicloud.com/api-KooMessage/ErrorCode.html";
    private Integer status = 200;
    private String message = "success";
    private R r;
    public ResponseBody(){};
    public ResponseBody(Supplier<Class> supplier, String response){
        r = (R)JSONObject.parseObject(response,supplier.get());
    };
    public ResponseBody( String response){
        r = (R)response;
    };

    public ResponseBody(int status, String message){
        this.status = status;
        this.message = message;
    };
    public ResponseBody(int status, String message,String documentUrl){
        this.status = status;
        this.message = message;
        throw new KResponseException("请求状态："+status+"，错误信息："+message+"，参见错误码："+ERROR_CODE_URL+"，开发文档："+documentUrl);
    }
    public R getData(){
        return r;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
