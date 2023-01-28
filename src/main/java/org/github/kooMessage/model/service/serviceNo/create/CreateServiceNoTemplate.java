package org.github.kooMessage.model.service.serviceNo.create;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.create
 * @Author: 王飞
 * @CreateTime: 2022-10-21  13:43
 * @Description: 一站式服务号创建
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/CreatePubInfo.html
 */
@Data
public class CreateServiceNoTemplate implements Template {
    /**
     * 创建服务号的请求体。
     */
    @NotNull
    private PubCreateRequestBody pub_request_body;
    /**
     * 创建主页的请求体。
     */
    @NotNull
    private PortalRequestBody portal_request_body;
    /**
     * 创建菜单的请求体。
     */
    @NotNull
    private MenuRequestBody menu_request_body;
}
