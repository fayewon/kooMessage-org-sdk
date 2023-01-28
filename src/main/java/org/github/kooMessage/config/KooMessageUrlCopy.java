package org.github.kooMessage.config;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.config
 * @Author: 王飞
 * @CreateTime: 2022-09-23  16:12
 * @Description: 修改服务请求URL
 * @Version: 1.0
 */
@Component
public class KooMessageUrlCopy {
    private String send_task;

    public String getSend_task() {
        return send_task;
    }

    public void setSend_task(String send_task) {
        this.send_task = send_task;
    }
}