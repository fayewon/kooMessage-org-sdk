package org.github.kooMessage.model.service.serviceNo.edit;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.edit
 * @Author: 王飞
 * @CreateTime: 2022-10-21  11:23
 * @Description: 修改主页信息
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/UpdatePortal.html
 */
@Data
public class EditServicePageTemplate implements Template {
    /**
     * 主页ID。
     *
     * 最小长度：32
     *
     * 最大长度：32
     */
    @NotNull
    private String portal_id;
    /**
     * 修改原因。
     *
     * 最小长度：5
     *
     * 最大长度：50
     */
    @NotNull
    private String change_reason;
    /**
     * 主页背景图片资源ID。
     *
     * 分辨率大于等于1440*810，支持jpg、jpeg、bmp、png。参数值为上传智能信息服务号图片资源API返回的resource_id。
     *
     * 最小长度：32
     *
     * 最大长度：32
     */
    private String background_img;
    /**
     * 简介。
     *
     * 最小长度：1
     *
     * 最大长度：75
     */
    private String summary;
    /**
     * 热线号列表。
     */
    private TelModel[] tels;
    /**
     * 快应用列表。
     */
    private UpdatePortalFastappModel[] fastapps;
    /**
     * 华为服务号列表。
     *
     * 说明：
     * 预留，暂未使用。
     */
    private String[] hw_pubs;
}
