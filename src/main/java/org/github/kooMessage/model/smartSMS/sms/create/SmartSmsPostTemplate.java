package org.github.kooMessage.model.smartSMS.sms.create;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-09-07  19:06
 * @Description: 智能信息基础版发送
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/SendAIMTask.html#SendAIMTask__request_CreateAIMSendResolve
 */
@Data
public class SmartSmsPostTemplate  implements Template {
    /**
     * 短信任务名称。
     * 是否必填：是
     */
    @NotNull
    private String task_name;
    /**
     * 短信发送通道参数。
     * 是否必填：是
     */
    @NotNull
    private SmsChannel sms_channel;
    /**
     * 短链生成配置。
     * 是否必填：是
     */
    @NotNull
    private CreateAIMSendResolve resolve_task;
}
