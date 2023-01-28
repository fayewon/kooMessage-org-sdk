package org.github.kooMessage.model.smartSMS.sms.find;

import org.github.kooMessage.model.Template;
import lombok.Data;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-09-28  11:35
 * @Description: 查询智能信息基础版发送任务
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/ListVMSSendTasks.html
 */
@Data
public class SmartSmsGetTemplate implements Template {
    /**
     * 智能信息基础版任务名称。
     * 是否必填：否
     */
    private String task_name;
    /**
     * 智能信息基础版任务ID。
     * 是否必填：否
     */
    private String task_id;
    /**
     * 智能信息基础版模板ID。
     * 是否必填：否
     */
    private String tpl_id;
    /**
     * 智能信息基础版模板名称。
     * 是否必填：否
     */
    private String tpl_name;
    /**
     * 智能信息基础版任务创建开始时间。 样例为：2019-10-12T07:20:50Z。
     * 是否必填：否
     */
    private String begin_time;
    /**
     * 智能信息基础版任务创建结束时间。 样例为：2019-10-12T07:20:50Z。
     * 是否必填：否
     */
    private String end_time;
    /**
     * 智能信息基础版任务发送开始时间。 样例为：2019-10-12T07:20:50Z。
     * 是否必填：否
     */
    private String send_begin_time;
    /**
     * 智能信息基础版任务发送结束时间。 样例为：2019-10-12T07:20:50Z。
     * 是否必填：否
     */
    private String send_end_time;
    /**
     * 操作员。
     * 是否必填：否
     */
    private String operator;
    /**
     * 发送状态类型。
     * submit_success：提交成功
     * submit_failed：提交失败
     * processing：发送中
     * sending_failed：发送失败
     * re_submit_success：重试提交成功
     * sending_complete：发送完成
     * re_submit_failed：重试提交成功
     * re_processing：重试进行中
     * re_sending_complete：重试发送完成
     * scheduled：定时任务
     * 是否必填：否
     */
    private String task_status;
    /**
     * 偏移量，表示从此偏移量开始查询，offset大于等于0。
     * 最小值：0
     * 最大值：2147483647
     * 缺省值：0
     * 是否必填：否
     */
    private Integer offset;
    /**
     * 每页显示的条目数量。
     * 最小值：1
     * 最大值：100
     * 缺省值：20
     * 是否必填：否
     */
    private String limit;

}
