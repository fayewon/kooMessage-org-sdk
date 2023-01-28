package org.github.kooMessage.model.smartSMS.sms.find;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.sms.find
 * @Author: 王飞
 * @CreateTime: 2022-10-18  15:06
 * @Description: 查询智能信息发送明细
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/ListSendDetails.html
 */
@Data
public class SmartSmsGetDetailsTemplate implements Template {
    /**
     *任务ID。
     * 最小长度：0
     * 最大长度：36
     * 是否必填：否
     */
    private String task_id;
    /**
     * 智能信息模板ID。
     * 最小长度：0
     * 最大长度：9
     * 是否必填：否
     */
    private String tpl_id;
    /**
     * 签名。
     * 最小长度：0
     * 最大长度：18
     * 是否必填：否
     */
    private String sms_sign;
    /**
     * 创建解析任务时填写用户唯一标识。s
     * 说明：
     * 手机号码或者任何的唯一标识，唯一标识不超过64个字符。发送智能信息时则必须填客户的手机号码。此处为手机号。样例为：13000000001。
     * 最小长度：0
     * 最大长度：64
     * 是否必填：否
     */
    private String cust_flag;
    /**
     * 发送开始时间。格式为：2019-10-12T07:20:50Z。
     * 说明：
     * 需同时传入end_time才能生效，单独传begin_time不会作为过滤条件。
     * 最小长度：0
     * 最大长度：30
     * 是否必填：否
     */
    private String begin_time;
    /**
     * 发送结束时间。格式为：2019-10-12T07:20:50Z。
     * 说明：
     * 需同时传入begin_time才能生效，单独传end_time不会作为过滤条件。
     * 最小长度：0
     * 最大长度：30
     * 是否必填：否
     */
    private String end_time;
    /**
     * 偏移量，表示从此偏移量开始查询，offset大于等于0。
     * 说明：
     * 为提高查询效率，offset+limit须小于等于10000，超出范围查询为空。
     * 最小值：0
     * 最大值：1000000
     * 是否必填：是
     */
    @NotNull
    private Integer offset;
    /**
     * 每页显示的条目数量。
     * 最小值：1
     * 最大值：100
     * 是否必填：是
     */
    @NotNull
    private Integer limit;
}
