package org.github.kooMessage.util;

import com.alibaba.fastjson.JSONObject;
import org.github.kooMessage.core.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.util
 * @Author: 王飞
 * @CreateTime: 2022-09-21  18:17
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class HttpUtil {
    /**
     * 参数替换URL特殊字符内容
     * @param url
     * @param body
     * @return
     */
    private static String specialCharacters(String url, JSONObject body) {
        int charStarIndex = url.indexOf('{');
        int charEndIndex = url.indexOf('}');
        if( charStarIndex != -1 && charEndIndex != -1){
            String specialChar = url.substring(charStarIndex+1,charEndIndex);
            Object o = body.remove(specialChar);
            if(Objects.nonNull(o)){
               return url.replaceAll("\\{"+specialChar+"\\}",String.valueOf(o));
            }
        }
        return url;
    }

    public static String doPostJson(String url, JSONObject body, String token,String documentUrl) {
        url = specialCharacters(url,body);
        log.info("doPostJson--{}--{}--{}",url,body);
        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        String response = null;
        CloseableHttpResponse res = null;
        try {
            //添加授权信息
            if (!StringUtils.isEmpty(token)) {
                post.setHeader("X-Auth-Token", token);
                post.setHeader("Content-Type","application/json");
            }
            StringEntity s = new StringEntity(body.toString(),"utf-8");
            post.setEntity(s);
            res = httpClient.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                response = EntityUtils.toString(res.getEntity());// 返回json格式：
                log.info("结果-成功-{}-{}--{}",res,url,res.getEntity());
            } else {
                String context = inputStreamToString(res.getEntity().getContent());
                new ResponseBody(res.getStatusLine().getStatusCode(),context,documentUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(res != null ) res.close();
                if(httpClient != null ) httpClient.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return response;
    }

    public static String doPutJson(String url, JSONObject body, String token,String documentUrl) {
        url = specialCharacters(url,body);
        log.info("doPutJson--{}--{}--{}",url,body);
        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut put = new HttpPut(url);
        String response = null;
        CloseableHttpResponse res = null;
        try {
            //添加授权信息
            if (!StringUtils.isEmpty(token)) {
                put.setHeader("X-Auth-Token", token);
                put.setHeader("Content-Type","application/json");
            }
            StringEntity s = new StringEntity(body.toString(),"utf-8");
            put.setEntity(s);
            res = httpClient.execute(put);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                response = EntityUtils.toString(res.getEntity());// 返回json格式：
                log.info("结果-成功-{}-{}--{}",res,url,res.getEntity());
            } else {
                String context = inputStreamToString(res.getEntity().getContent());
                new ResponseBody(res.getStatusLine().getStatusCode(),context,documentUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(res != null ) res.close();
                if(httpClient != null ) httpClient.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return response;
    }


    public static String doGetWithParam(String url, JSONObject param,String token,String documentUrl) {
        log.info("doGetWithParam--{}--{}--{}",url,param);
        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String response = null;
        CloseableHttpResponse res = null;
        try {
            //创建一个uri对象
            URIBuilder uriBuilder = new URIBuilder(url);
            if (param != null) {
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            HttpGet get = new HttpGet(uriBuilder.build());
            //添加授权信息
            if (!StringUtils.isEmpty(token)) {
                get.setHeader("X-Auth-Token", token);
            }
            //执行请求
            res = httpClient.execute(get);
            //取响应的结果
            int statusCode = res.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                response = EntityUtils.toString(entity, "utf-8");
                log.info("结果-成功-{}-{}--{}",res,url,res.getEntity());
            } else {
                String context = inputStreamToString(res.getEntity().getContent());
                new ResponseBody(res.getStatusLine().getStatusCode(),context,documentUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(res != null ) res.close();
                if(httpClient != null ) httpClient.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return response;
    }

    public static String doDelete(String url, JSONObject param,String token,String documentUrl) {
        url = specialCharacters(url,param);
        log.info("doDelete--{}--{}--{}",url,param);
        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String response = null;
        CloseableHttpResponse res = null;
        try {
            //创建一个uri对象
            URIBuilder uriBuilder = new URIBuilder(url);

            HttpDelete delete = new HttpDelete(uriBuilder.build());
            //添加授权信息
            if (!StringUtils.isEmpty(token)) {
                delete.setHeader("X-Auth-Token", token);
            }
            //执行请求
            res = httpClient.execute(delete);
            //取响应的结果
            int statusCode = res.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                response = EntityUtils.toString(entity, "utf-8");
                log.info("结果-成功-{}-{}--{}",res,url,res.getEntity());
            } else {
                String context = inputStreamToString(res.getEntity().getContent());
                new ResponseBody(res.getStatusLine().getStatusCode(),context,documentUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(res != null ) res.close();
                if(httpClient != null ) httpClient.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return response;
    }

    public static String httpClientUploadFile(String url, Map<String, Object> map,String token,String documentUrl) {
        if(Objects.isNull(map.get("file"))){
            throw  new RuntimeException("文件参数名必须叫file");
        }
        File file = (File) map.remove("file");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String response = null;
        CloseableHttpResponse res = null;
        //每个post参数之间的分隔。随意设定，只要不会和其他的字符串重复即可。
        String boundary ="--------------4585696313564699";
        try {
            //文件名
            String fileName = file.getName();
            HttpPost httpPost = new HttpPost(url);
            //设置请求头
            httpPost.setHeader("Content-Type","multipart/form-data; boundary="+boundary);
            //添加授权信息
            if (!StringUtils.isEmpty(token)) {
                httpPost.setHeader("X-Auth-Token", token);
            }
            //HttpEntity builder
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            //字符编码
            builder.setCharset(Charset.forName("UTF-8"));
            //模拟浏览器
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            //boundary
            builder.setBoundary(boundary);
            //multipart/form-data
            builder.addPart("file",new FileBody(file));
            // binary
//            builder.addBinaryBody("name=\"multipartFile\"; filename=\"test.docx\"", new FileInputStream(file), ContentType.MULTIPART_FORM_DATA, fileName);// 文件流
            //其他参数
            builder.addTextBody("filename", fileName,  ContentType.create("text/plain", Consts.UTF_8));
            Iterator it = map.entrySet().iterator();
            List<NameValuePair> params = new ArrayList();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                NameValuePair pair = new BasicNameValuePair((String) entry.getKey(),  (String)entry.getValue());
                params.add(pair);
                builder.addTextBody((String) entry.getKey(),  (String)entry.getValue());
            }
            //HttpEntity
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            // 执行提交
            res = httpClient.execute(httpPost);
            int statusCode = res.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                entity = res.getEntity();
                response = EntityUtils.toString(entity, "utf-8");
                log.info("结果-成功-{}-{}--{}",res,url,res.getEntity());
            } else {
                String context = inputStreamToString(res.getEntity().getContent());
                new ResponseBody(res.getStatusLine().getStatusCode(),context,documentUrl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    public static String inputStreamToString(InputStream is) {
        String line = "";
        StringBuilder total = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        try {
            while ((line = rd.readLine()) != null) {
                total.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return total.toString();
    }
}
