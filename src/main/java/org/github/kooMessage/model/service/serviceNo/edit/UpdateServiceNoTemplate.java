package org.github.kooMessage.model.service.serviceNo.edit;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.edit
 * @Author: 王飞
 * @CreateTime: 2022-10-21  11:05
 * @Description: 更新服务号信息
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/UpdatePubInfo.html
 */
@Data
public class UpdateServiceNoTemplate implements Template {
    /**
     * 服务号ID。
     */
    @NotNull
    private String pub_id;
    /**
     * 更新原因。
     *
     * 最小长度：1
     *
     * 最大长度：200
     */
    @NotNull
    private String change_reason;
    /**
     * 服务号LOGO图片资源ID。
     *
     * 说明：
     * 通过上传智能信息服务号图片资源接口上传LOGO图片后获得的图片resource_id。图片要求大于等于240*240且比例相同。
     *
     * 最小长度：32
     *
     * 最大长度：32
     */
    private String logo_img;
    /**
     * 授权证明图片资源ID，最多支持6张。
     */
    private String[] authorization_files;
    /**
     * 服务号名称。
     *
     * 最小长度：1
     *
     * 最大长度：15
     */
    private String pub_name;
    /**
     * 服务号简介。
     *
     * 最小长度：1
     *
     * 最大长度：75
     */
    @NotNull
    private String pub_abstract;
    /**
     * 服务号摘要。
     *
     * 最小长度：1
     *
     * 最大长度：15
     */
    private String pub_remark;
    /**
     * 自动获取端口。
     *
     * 最小值：0
     *
     * 最大值：1
     */
    private Integer auto_get_port;
    /**
     * 自动收集端口使用的签名列表。
     *
     * 说明：
     * auto_get_port为1时，该字段为必填，每个签名长度须为2-18个字符，每个服务号签名不可以重复。
     */
    private String[] signs_for_auto_get_port;
    /**
     * 从事行业，默认取服务号所属商家的行业分类。
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
    private Integer industry;
}
