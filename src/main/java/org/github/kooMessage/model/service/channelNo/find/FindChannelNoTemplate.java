package org.github.kooMessage.model.service.channelNo.find;

import org.github.kooMessage.model.Template;
import lombok.Data;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.channelNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-12  16:46
 * @Description: 查询通道号
 * @Version: 1.0
 * @see :https://support.huaweicloud.com/api-KooMessage/SearchPort.html
 */
@Data
public class FindChannelNoTemplate implements Template {
    /**
     * 操作类型。
     * 0：查询通道号列表
     * 1：查询绑定关系列表
     * 最小长度：0
     * 最大长度：1
     * 是否必填：否
     */
    private Integer type;
    /**
     * 通道号。
     * 最小长度：0
     * 最大长度：21
     * 是否必填：否
     */
    private String port;
    /**
     * 通道号类型。
     * 1：普通
     * 3：前缀号段
     * 5：后缀号段
     * 最小值：1
     * 最大值：5
     * 是否必填：否
     */
    private Integer port_type;
    /**
     * 单个通道号签名。
     * 说明：
     * 不支持多个签名查询，支持模糊搜索。长度要求0-18。
     * 最小长度：0
     * 最大长度：18
     * 是否必填：否
     */
    private String sign_search;
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
     * 缺省值：10
     * 是否必填：否
     */
    private Integer limit;
    /**
     * 开始时间。格式为：yyyy-MM-ddTHH:mm:ssZ。
     * 是否必填：否
     */
    private String startTime;
    /**
     * 结束时间。格式为：yyyy-MM-ddTHH:mm:ssZ。
     * 是否必填：否
     */
    private String end_time;
    /**
     * 服务号名称。
     * 说明：
     * type=1时，此字段作为过滤条件
     * type=0时，不作为过滤条件
     * 最小长度：0
     * 最大长度：64
     * 是否必填：否
     */
    private String pub_name;
}
