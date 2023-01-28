package org.github.kooMessage.config;

import org.github.kooMessage.core.method.KHttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.config
 * @Author: 王飞
 * @CreateTime: 2022-10-19  16:29
 * @Description: 请求对象添加到对象池
 * @Version: 1.0
 */
@Configuration
public class RequestConfigure {
    @Bean(name = "addRequestConfigure")
    public boolean addRequestConfigure(){
        KHttpMethod.loadRegistry();
        return true;
    }
}
