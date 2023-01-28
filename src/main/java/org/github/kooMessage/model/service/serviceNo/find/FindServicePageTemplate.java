package org.github.kooMessage.model.service.serviceNo.find;

import org.github.kooMessage.model.Template;
import lombok.Data;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-10  18:13
 * @Description: 查询服务号主页列表
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/ListPortals.html
 */
@Data
public class FindServicePageTemplate implements Template {
    /**
     * 服务号名称。
     *
     * 最小长度：0
     *
     * 最大长度：15
     */
    private String pub_name;
    /**
     * 起始上线时间。格式为：yyyy-MM-ddTHH:mm:ssZ。
     *
     * 最小长度：10
     *
     * 最大长度：50
     */
    private String begin_time;
    /**
     * 截止上线时间。格式为：yyyy-MM-ddTHH:mm:ssZ。
     *
     * 最小长度：10
     *
     * 最大长度：50
     */
    private String end_time;
    /**
     * 主页状态。
     *
     * 1：未生效
     *
     * 2：已生效
     *
     * 3：已失效
     *
     * 4：已冻结
     */
    private Integer state;
    /**
     * 每页显示的条目数量。
     *
     * 最小值：1
     *
     * 最大值：100
     *
     * 缺省值：10
     */
    private Integer limit;
    /**
     * 偏移量，表示从此偏移量开始查询，offset大于等于0。
     *
     * 最小值：0
     *
     * 最大值：2147483647
     *
     * 缺省值：0
     */
    private Integer offset;
}
