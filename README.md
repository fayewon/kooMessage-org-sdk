# kooMessage-org-sdk
华为云koomessage工具包
# 简述
&nbsp;&nbsp;&nbsp;*发送富文本短信* 
# 配置
```java
@Configuration
public class Config implements CustomKMConfigureService {
    /**
     * 修改和自定义新的请求对象
     * @param configReplacer
     * @param tokenMessageCopy
     * @param kooMessageUrlCopy
     * @return
     */
    @Bean
    @Override
    public ConfigureReplacer modifyAndNewRequest(ConfigureReplacer configReplacer, TokenMessageCopy tokenMessageCopy, KooMessageUrlCopy kooMessageUrlCopy) {
        tokenMessageCopy.setDomain("domain");
        tokenMessageCopy.setName("name");
        tokenMessageCopy.setPassword("password");
        tokenMessageCopy.setTokenUrl("tokenurl");
        tokenMessageCopy.setProject("project");

        kooMessageUrlCopy.setSend_task("https://koomessage.myhuaweicloud.cn/v1/aim/send-tasks");


        KHttpMethodBody request1 =  new KHttpMethodBody(SmartSmsResolveAnalysisTemplate.class,"https://koomessage.myhuaweicloud.cn/v1/aim/resolve-tasks", HttpMethod.POST);
        KHttpMethodBody request2 =  new KHttpMethodBody(SmartSmsResolveAnalysisTemplate.class,"https://koomessage.myhuaweicloud.cn/v1/aim/resolve-tasks", HttpMethod.POST);
        configReplacer.
                executeModifyConfig(tokenMessageCopy).
                executeModifyConfig(kooMessageUrlCopy).
                executeNewConfig(request1).
                executeNewConfig(request2);
        return configReplacer;
    }
}
```
