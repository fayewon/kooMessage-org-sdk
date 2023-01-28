package org.github.kooMessage.model.smartSMS.sms.create;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-09-07  19:09
 * @Description: 短信发送通道参数
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/SendAIMTask.html
 */
@Data
public class SmsChannel {
    /**
     * 短信通道号。
     *
     * 说明：
     * 必须与另外三个字段sms_tpl_id、sms_sign、sms_app_name相匹配，这些字段信息可以从“云消息服务KooMessage-管理控制台-短信配置-短信签名管理-通道号”中获取。
     * 是否必填：是
     */
    @NotNull
    private String channel_number;
    /**
     * 短信模板ID。
     *
     * 说明：
     * 必须与另外三个字段channel_number、sms_sign、sms_app_name相匹配，这些字段信息可以从“云消息服务KooMessage-管理控制台-短信配置-短信模板管理-模板ID”中获取。
     * 是否必填：是
     */
    @NotNull
    private String sms_tpl_id;
    /**
     * 短信签名。
     *
     * 说明：
     * 必须与另外三个字段channel_number、sms_tpl_id、sms_app_name相匹配，这些字段信息可以从“云消息服务KooMessage-管理控制台-短信配置-短信模板管理-所属签名”中获取。
     * 是否必填：是
     */
    @NotNull
    private String sms_sign;
    /**
     * 短信应用名称。
     *
     * 说明：
     * 必须与另外三个字段channel_number、sms_sign、sms_tpl_id相匹配，这些字段信息可以从“云消息服务KooMessage-管理控制台-短信配置-短信模板管理-所属应用”中获取。
     * 是否必填：是
     */
    @NotNull
    private String sms_app_name;

}
