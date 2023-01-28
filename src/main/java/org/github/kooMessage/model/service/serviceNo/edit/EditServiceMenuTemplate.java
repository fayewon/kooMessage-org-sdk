package org.github.kooMessage.model.service.serviceNo.edit;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-21  09:35
 * @Description: 修改智能信息服务号菜单
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/UpdateMenu.html
 */
@Data
public class EditServiceMenuTemplate implements Template {
    /**
     * 菜单ID。
     *
     * 最小长度：0
     *
     * 最大长度：32
     */
    @NotNull
    private String menu_id;
    /**
     * 修改原因。
     * 最小长度：1
     * 最大长度：1000
     */
    @NotNull
    private String change_reason;
    /**
     * 菜单配置信息。
     */
    @NotNull
    private Menus menu;
}
