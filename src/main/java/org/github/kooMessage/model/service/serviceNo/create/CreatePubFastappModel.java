package org.github.kooMessage.model.service.serviceNo.create;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.create
 * @Author: 王飞
 * @CreateTime: 2022-10-21  13:58
 * @Description: 快应用列表。
 * @Version: 1.0
 */
@Data
public class CreatePubFastappModel {
    /**
     * 快应用名。
     *
     * 说明：
     * 长度范围为1-30个字符，中文占2个字符，英文占1个字符。
     */
    @NotNull
    private String name;
    /**
     * 快应用LOGO图片资源ID。
     *
     * 说明：
     * 图片格式为jpg、bmp、jpeg，分辨率大于等于192*192，比例+-0.15，大小不超过5M。参数值为上传智能信息服务号图片资源API返回的resource_id。
     *
     * 最小长度：32
     *
     * 最大长度：32
     */
    @NotNull
    private String logo_img;
    /**
     * 快应用描述。
     *
     * 说明：
     * 长度范围为1-38个字符，中文占2个字符，英文占1个字符。
     */
    private String description;
    /**
     * 快应用跳转链接。
     *
     * 最小长度：1
     *
     * 最大长度：1000
     */
    @NotNull
    private String deeplink;
    /**
     * 快应用依赖引擎版本。
     *
     * 说明：
     * 长度范围为1-50个字符，中文占2个字符，英文占1个字符。
     */
    @NotNull
    private String depend_engine_version;
}
