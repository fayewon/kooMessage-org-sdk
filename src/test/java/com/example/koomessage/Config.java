package com.example.koomessage;

import org.github.kooMessage.config.ConfigureReplacer;
import org.github.kooMessage.config.CustomKMConfigureService;
import org.github.kooMessage.config.KooMessageUrlCopy;
import org.github.kooMessage.config.TokenMessageCopy;
import org.github.kooMessage.core.method.HttpMethod;
import org.github.kooMessage.core.method.KHttpMethodBody;
import org.github.kooMessage.model.smartSMS.sms.resolve.SmartSmsResolveAnalysisTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: com.example.koomessage
 * @Author: 王飞
 * @CreateTime: 2022-09-23  14:18
 * @Description: 自定义配置
 * @Version: 1.0
 */
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
