package org.github.kooMessage.config;

import org.github.kooMessage.core.method.KHttpMethodService;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.config.ConfigReplacer
 * @Author: 王飞
 * @CreateTime: 2022-09-23  11:49
 * @Description: 配置置换器
 * @Version: 1.0
 */
@Component
public class ConfigureReplacer  implements KHttpMethodService  {
    public ConfigureReplacer executeModifyConfig(TokenMessageCopy tokenMessageCopy) {
        TokenMessage.setNAME(tokenMessageCopy.getName());
        TokenMessage.setPASSWORD(tokenMessageCopy.getPassword());
        TokenMessage.setTokenUrl(tokenMessageCopy.getTokenUrl());
        TokenMessage.setDOMAIN(tokenMessageCopy.getDomain());
        TokenMessage.setPROJECT(tokenMessageCopy.getProject());
        return this;
    }

    public ConfigureReplacer executeModifyConfig(KooMessageUrlCopy kooMessageUrlCopy) {
        KooMessageUrl.setSendTask(kooMessageUrlCopy.getSend_task());
        return this;
    }
}
