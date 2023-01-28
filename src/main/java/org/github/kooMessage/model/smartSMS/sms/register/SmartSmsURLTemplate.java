package org.github.kooMessage.model.smartSMS.sms.register;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-10-18  15:31
 * @Description: 注册智能信息回执URL
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/AddCallBack.html
 */
@Data
public class SmartSmsURLTemplate implements Template {
    /**
     * 回调地址。
     * 说明：
     * 建议使用https。
     * 最小长度：1
     * 最大长度：1000
     * 是否必填：是
     */
    @NotNull
    private String callback_url;
    /**
     * 回调类型。
     * 0：智能信息发送回调
     * 1：模板状态回调
     * 缺省值：0
     * 是否必填：否
     */
    private Integer url_type;
}
