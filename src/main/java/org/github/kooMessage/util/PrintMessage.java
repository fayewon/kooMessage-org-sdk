package org.github.kooMessage.util;

import org.github.kooMessage.core.method.KHttpMethod;
import org.github.kooMessage.core.method.KHttpMethodBody;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @BelongsProject: koomessage
 * @BelongsPackage: org.github.kooMessage.util
 * @Author: 王飞
 * @CreateTime: 2022-11-29  00:55
 * @Description: 打印注册表
 * @Version: 1.0
 */
@Slf4j
public class PrintMessage {
    public static void printRegistry (Map<Class, KHttpMethodBody> registry){
        String requestName = "|             请求名称             |";
        String template = "                 参数模板                |";
        String dataType = "     数据类型   |";
        String method = "  请求类型 |";
        String url = "                                     URL                                    |";
        String result = "                返回模板                |";
        String documentUrl = "                                        文档                                       |";
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n"+"kooMessage请求注册表数量：【"+registry.size()+"】，明细如下↓");
        sb.append("\r\n"+"————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————"+"\r\n");
        sb.append(requestName+template+dataType+method+url+result+documentUrl+"\r\n");
        KHttpMethod.get().values().forEach((body)->{
            String requestNameName = body.getRequestName() == null ? "未设置":body.getRequestName();
            requestNameName = addChinese(requestNameName);
            String templateName = body.getTemplate().getSimpleName();
            String dataTypeName = body.getDataType().toString();
            String methodName = body.getMethod().toString();
            String urlName = body.getUrl();
            String resultName = body.getResult() == null ? "Not set":body.getResult().getSimpleName();
            String documentUrlName = body.getDocumentUrl() == null ? "Not set":body.getDocumentUrl();
            String space0 = addSpace(requestName.length() - requestNameName.length()-11);
            String space1 = addSpace(template.length() - templateName.length()-2);
            String space2 = addSpace(dataType.length() - dataTypeName.length());
            String space3 = addSpace(method.length() - methodName.length()-1);
            String space4 = addSpace(url.length() - urlName.length()-5);
            String space5 = addSpace(result.length() - resultName.length()-3);
            String space6 = addSpace(documentUrl.length() - documentUrlName.length()-4);
            sb.append("|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\r\n");
            sb.append("|  "+requestNameName+space0+"  |  "+templateName+space1+"|  "+dataTypeName+space2+"|  "+methodName+space3+"|  "+urlName+space4+"  |  "+resultName+space5+"  |  "+documentUrlName+space6+"  |"+"\r\n");

        });
        sb.append("————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————"+"\r\n");
        log.info(sb.toString());
    }

    private static String addSpace(int index){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<index;i++){
            sb.append(' ');
        }
        return sb.toString();
    }

    private static String addChinese(String requestName) {
        StringBuilder sb = new StringBuilder(requestName);
        int maxLength = 13;
        if( requestName.length() < maxLength ){
            for (int i=0;i<maxLength-requestName.length();i++) {
                sb.append('》');
            }
        }
        return sb.toString();
    }
}
