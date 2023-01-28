# kooMessage-org-sdk
华为云koomessage工具包
![官方开发文档]([https://github.com/fayewon/LuckyExp](https://support.huaweicloud.com/api-KooMessage/CreatePubInfo.html))
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
# 调用
```java
@Slf4j
public class KooMessageTest {
    //加载注册表
    static {
        KHttpMethod.
                loadRegistry();
    }
    //智能信息基础版/智能信息基础版发送#智能信息发送 成功  群发、个性化、自定义短码
    @Test
    public void smartSmsPost(){
        StringKMActuator<SmartSmsPostTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsPostTemplate>() {
                    @Override
                    public SmartSmsPostTemplate convertData() {
                        CreateResolveTaskParam createResolveTaskParam = new CreateResolveTaskParam("15387053XXX");
                        //createResolveTaskParam.setCustom_short_code("asdc24");
                        CreateResolveTaskParam[] array = new CreateResolveTaskParam[]{createResolveTaskParam};
                        SmsChannel smsChannel = new SmsChannel("8822082325917","15100556","XXXX","APP_NAME");
                        CreateAIMSendResolve createAIMSendResolve = new CreateAIMSendResolve("600156386",1,"individual",1,array);
                        //createAIMSendResolve.setGeneration_type(2);
                        SmartSmsPostTemplate smartSmsTemplate = new SmartSmsPostTemplate("XXXXX",smsChannel,createAIMSendResolve);
                        return smartSmsTemplate;
                    }
                })
                .execute()
                .result();
        System.out.println("result:  "+result.getData());
    }
    //智能信息基础版/智能信息基础版发送#查询智能信息基础版发送任务 成功
    @Test
    public void smartSmsGet () {
        ModelKMActuator<SmartSmsGetResult,SmartSmsGetTemplate> kooMessageActuator = new ModelKMActuator();
        ResponseBody<SmartSmsGetResult> result = kooMessageActuator.request(new KooMessageService<SmartSmsGetResult, SmartSmsGetTemplate>() {
            @Override
            public SmartSmsGetTemplate convertData() {
                SmartSmsGetTemplate smartSmsGetTemplate = new SmartSmsGetTemplate();
                smartSmsGetTemplate.setTask_id("a6067e45-2203-4432-98d2-b9a5de4aed48");
                smartSmsGetTemplate.setTask_name("测试-长城");
                return smartSmsGetTemplate;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData().getMessage());
    }
    @Test
    ...
}
```
