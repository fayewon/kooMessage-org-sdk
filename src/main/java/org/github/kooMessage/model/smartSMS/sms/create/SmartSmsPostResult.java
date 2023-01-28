package org.github.kooMessage.model.smartSMS.sms.create;

import org.github.kooMessage.model.Result;
import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-09-07  19:06
 * @Description: 智能信息基础版发送返回值
 * @Version: 1.0
 */
@Data
public class SmartSmsPostResult extends Result implements Serializable {
    private String task_name;
    private SmsChannel sms_channel;
    private CreateAIMSendResolve resolve_task;
}
