package org.github.kooMessage.model.service.serviceNo.find;

import org.github.kooMessage.model.Template;
import lombok.Data;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-10  17:53
 * @Description: 查询服务号列表
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/SearchPubDetail.html
 */
@Data
public class FindServiceNoTemplate implements Template {
    /**
     * 服务号名称。
     *
     * 最小长度：1
     *
     * 最大长度：15
     */
    private String pub_name;
    /**
     * 服务号状态。
     *
     * 1：未生效
     *
     * 2：已生效
     *
     * 3：已失效
     *
     * 4：已冻结
     *
     * 最小值：1
     *
     * 最大值：4
     */
    private Integer state;
    /**
     * 开始上线时间，格式为：yyyy-MM-ddTHH:mm:ssZ。
     */
    private String start_time;
    /**
     * 偏移量，表示从此偏移量开始查询，offset大于等于0。
     *
     * 最小值：0
     *
     * 最大值：214748364
     *
     * 缺省值：0
     */
    private Integer offset;
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
     * 结束上线时间，格式为：yyyy-MM-ddTHH:mm:ssZ。
     */
    private String end_time;
    /**
     *
     * 服务号所属行业。
     *
     * 1：金融理财
     *
     * 2：社交通讯
     *
     * 3：影音娱乐
     *
     * 4：旅游出行
     *
     * 5：购物
     *
     * 6：本地生活
     *
     * 7：运动健康
     *
     * 8：教育培训
     *
     * 9：新闻阅读
     *
     * 10：运营商
     *
     * 11：其他
     *
     * 最小值：1
     *
     * 最大值：11
     */
    private String industry;
    /**
     * 审核状态。
     *
     * 1：审核中
     *
     * 2：审核通过
     *
     * 3：驳回
     */
    private Integer approve_state;
}
