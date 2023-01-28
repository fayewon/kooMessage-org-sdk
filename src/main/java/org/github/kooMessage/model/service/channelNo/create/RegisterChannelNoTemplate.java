package org.github.kooMessage.model.service.channelNo.create;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.channelNo.create
 * @Author: 王飞
 * @CreateTime: 2022-10-12  17:50
 * @Description: 注册通道号
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/RegisterPort.html
 */
@Data
public class RegisterChannelNoTemplate implements Template {
    /**
     * 通道号。
     * port_type=5时 ，长度必须为5
     * port_type=1或3，长度在21位内
     * 最小长度：0
     * 最大长度：21
     * 是否必填：是
     */
    @NotNull
    private String port;
    /**
     * 签名列表，最大长度为5。单个签名长度为2-18。
     * 最小长度：2
     * 最大长度：18
     * 是否必填：是
     */
    @NotNull
    private String[] sign;
    /**
     * 通道号类型。
     * 1：普通
     * 3：前缀号段
     * 5：后缀号段
     * 最小值：1
     * 最大值：5
     * 是否必填：是
     */
    @NotNull
    private Integer port_type;
    /**
     * 是否需要校验。
     * 0：不校验
     * 1：校验签名
     * 说明：
     * 当port_type为3或者5时，sign_check必须为1。
     * 最小值：0
     * 最大值：1
     * 是否必填：是
     */
    @NotNull
    private Integer sign_check;
    /**
     * 授权证明图片资源，最多支持5张。参数格式为：资源ID:资源URL，样例：3d214a61672846f88ad77597f935cccc:AimSauploadService/272957b708ac4891a6d5282ccd2175cccc.png。
     * 说明：
     * 资源ID与资源URL对应上传智能信息服务号图片资源API返回的resource_id和resource_url。
     * 是否必填：是
     */
    @NotNull
    private String[] authorization_files;
}
