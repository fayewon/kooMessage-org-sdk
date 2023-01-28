package org.github.kooMessage.model.service.serviceNo.create;

import org.github.kooMessage.model.service.serviceNo.edit.TelModel;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.create
 * @Author: 王飞
 * @CreateTime: 2022-10-21  13:44
 * @Description: 创建主页的请求体。
 * @Version: 1.0
 */
@Data
public class PortalRequestBody {
    /**
     *
     * 主页背景图片资源ID。
     *
     * 说明：
     * 分辨率大于等于1440*810，支持jpg、jpeg、bmp、png。参数值为上传智能信息服务号图片资源API返回的resource_id。
     *
     * 最小长度：32
     *
     * 最大长度：32
     */
    @NotNull
    private String background_img;
    /**
     * 简介。
     *
     * 最小长度：1
     *
     * 最大长度：75
     */
    @NotNull
    private String summary;
    /**
     * 热线号列表。
     */
    private TelModel[] tels;
    /**
     * 快应用列表。
     */
    private CreatePubFastappModel fastapps;
    /**
     *
     * 华为服务号列表。
     *
     * 说明：
     * 预留，暂未使用。
     *
     * 最小长度：1
     *
     * 最大长度：50
     */
    private String[] hw_pubs;
}
