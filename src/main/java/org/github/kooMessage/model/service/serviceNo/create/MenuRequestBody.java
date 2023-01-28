package org.github.kooMessage.model.service.serviceNo.create;

import org.github.kooMessage.model.service.serviceNo.edit.Menus;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.create
 * @Author: 王飞
 * @CreateTime: 2022-10-21  13:44
 * @Description: 创建菜单的请求体。
 * @Version: 1.0
 */
@Data
public class MenuRequestBody {
    @NotNull
    private Menus menu;
}
