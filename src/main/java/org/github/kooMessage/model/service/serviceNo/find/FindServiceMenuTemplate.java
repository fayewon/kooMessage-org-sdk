package org.github.kooMessage.model.service.serviceNo.find;

import org.github.kooMessage.model.Template;
import lombok.Data;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-10  18:18
 * @Description: 查询服务号菜单列表
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/ListMenus.html
 */
@Data
public class FindServiceMenuTemplate implements Template {
    /**
     * 菜单ID。
     *
     * 最小长度：0
     *
     * 最大长度：32
     */
    private String menu_id;
    /**
     * 服务号ID。
     *
     * 最小长度：0
     *
     * 最大长度：32
     */
    private String pub_id;
    /**
     * 服务号名称。
     *
     * 最小长度：0
     *
     * 最大长度：50
     */
    private String pub_name;
    /**
     * 上线开始时间。格式为：yyyy-MM-ddTHH:mm:ssZ。
     */
    private String online_begin_time;
    /**
     * 上线结束时间。格式为：yyyy-MM-ddTHH:mm:ssZ。
     */
    private String online_end_time;
    /**
     * 主页状态。
     *
     * 1：未生效
     *
     * 3：已生效
     *
     * 4：已失效
     *
     * 5：已冻结
     *
     * 最小值：1
     *
     * 最大值：4
     */
    private Integer state;
    /**
     * 一级菜单名称。
     *
     * 最小长度：0
     *
     * 最大长度：50
     */
    private String menu_name;
    /**
     * 偏移量，表示从此偏移量开始查询，offset大于等于0。
     *
     * 最小值：0
     *
     * 最大值：2147483647
     *
     * 缺省值：0
     */
    private Integer limit;
    /**
     * 每页显示的条目数量。
     *
     * 最小值：1
     *
     * 最大值：100
     *
     * 缺省值：10
     */
    private Integer offset;
}
