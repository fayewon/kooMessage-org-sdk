package org.github.kooMessage.model.service.serviceNo.edit;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-21  10:11
 * @Description: 修改智能信息服务号菜单
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/UpdateMenu.html
 */
@Data
public class Menus {
    @NotNull
    private MenuItem[] menu_items;
}
