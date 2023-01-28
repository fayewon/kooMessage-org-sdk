package org.github.kooMessage.model.service.channelNo.create;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.channelNo.create
 * @Author: 王飞
 * @CreateTime: 2022-10-13  11:05
 * @Description: 通道号绑定服务号
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/LockPortDetails.html
 * 2、请求Body
 * {
 *   "pub_id" : "b1209fd589724114ab0553603fa09a12",
 *   "merchant_id" : "2b57a7b50709446ab25401567c1dbff1",
 *   "ext_port_id" : "f23ac3e698d7407f9bbbf38d7b055bfb",
 *   "port" : "1065501013291497680",
 *   "sign" : [ "华为云aPaaS" ],
 *   "province" : "陕西省"
 * }
 */
@Data
public class BindChannelToServiceNoTemplate implements Template {
    /**
     * 服务号ID。
     * 最小长度：0
     * 最大长度：32
     * 是否必填：是
     */
    private String pub_id;
    /**
     * 商品ID
     */
    private String merchant_id;
    /**
     * 关联通道号ID，取通道号列表返回的ID。
     * 最小长度：32
     * 最大长度：32
     */
    @NotNull
    private String ext_port_id;
    /**
     * 通道号。
     * port_type=5时，长度必须为5
     * port_type=1或3，长度在21位内
     * 最小长度：0
     * 最大长度：21
     * 是否必填：是
     */
    @NotNull
    private String port;
    /**
     * 绑定签名，必须是该端口号签名的子集。单个签名长度为2-18。
     * 是否必填：是
     */
    @NotNull
    private String[] sign;
    /**
     * 通道号绑定/解绑的province字段取值范围如下： 全国、河北省、山西省、辽宁省、吉林省、黑龙江省、江苏省、浙江省、安徽省、福建省、江西省、山东省、河南省、湖北省、湖南省、广东省、海南省、四川省、贵州省、云南省、陕西省、甘肃省、青海省、台湾省、内蒙古自治区、广西壮族自治区、西藏自治区、宁夏回族自治区、新疆维吾尔自治区、北京市、天津市、上海市、重庆市、香港特别行政区、澳门特别行政区。
     * 最小长度：0
     * 最大长度：500
     * 是否必填：是
     */
    @NotNull
    private String province;
}
