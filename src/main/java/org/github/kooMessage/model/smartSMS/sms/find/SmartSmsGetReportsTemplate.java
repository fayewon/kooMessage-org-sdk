package org.github.kooMessage.model.smartSMS.sms.find;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.sms.find
 * @Author: 王飞
 * @CreateTime: 2022-10-18  15:20
 * @Description: 查询智能信息发送报表
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/ListAimSendReport.html
 */
@Data
public class SmartSmsGetReportsTemplate implements Template {
    /**
     * 报表类型。
     * 1：日报表
     * 2：月报表
     * 最小长度：0
     * 最大长度：8
     * 是否必填：是
     */
    @NotNull
    private String report_type;
    /**
     * 智能信息模板ID。
     * 最小长度：0
     * 最大长度：9
     * 是否必填：否
     */
    private String tpl_id;
    /**
     * 智能信息模板名称。
     * 最小长度：0
     * 最大长度：100
     * 是否必填：否
     */
    private String tpl_name;
    /**
     * 开始时间。格式为：2022-05-01T00:00:00Z。
     * 最小长度：0
     * 最大长度：30
     * 是否必填：否
     */
    private String begin_time;
    /**
     * 结束时间。格式为：2022-05-01T00:00:00Z。
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
    private Integer limit;
}
