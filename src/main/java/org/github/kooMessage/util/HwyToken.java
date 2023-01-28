package org.github.kooMessage.util;

import org.github.kooMessage.core.exception.KResponseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.nio.charset.Charset;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.util
 * @Author: 王飞
 * @CreateTime: 2022-09-28  10:11
 * @Description: 获取TOKEN
 * @Version: 1.0
 */
@Slf4j
public class HwyToken {
    public static String getHwyToken(String name, String password, String tokenUrl, String domain, String project)  {

        String paramPart1 = "{\"auth\":{\"identity\":{\"methods\":[\"password\"],\"password\":{\"user\":{\"name\":\"";
        String paramPart2 = "\",\"password\":\"";
        String paramPart3 = "\",\"domain\":{\"name\":\"";
        String paramPart4 = "\"}}}},\"scope\":{\"project\":{\"name\":\"";
        String paramPart5 = "\"}}}}";
        StringBuffer param = new StringBuffer();
        param.append(paramPart1).append(name)
                .append(paramPart2).append(password)
                .append(paramPart3).append(domain)
                .append(paramPart4).append(project)
                .append(paramPart5);
        log.info("请求的json参数param={}", param);

        try {
            String token = getXsubjectToken(tokenUrl, param.toString());
            log.info("获取token成功-" + token);
            return token;
        } catch (Exception e) {
            log.error("获取token失败-");
            throw new RuntimeException("获取华为云ORC接口token失败:" + e);
        }
    }


    private static String getXsubjectToken(String url, String params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(params, Charset.forName("UTF-8")));
        CloseableHttpResponse response = null;
        response = httpclient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        //只有状态码是201的时候，才表示正确拿到华为云的OCR接口的token认证
        if (statusCode == HttpStatus.SC_CREATED) {
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                if(header.getName().equals("X-Subject-Token")){
                    log.info("返回的token值，X-Subject-Token={}",header.getValue());
                    return header.getValue();
                }
            }
        } else {
            String context = HttpUtil.inputStreamToString(response.getEntity().getContent());
            throw new KResponseException("请求状态："+statusCode+"，错误信息："+context);
        }
        response.close();
        return null;
    }
}
