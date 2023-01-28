package org.github.kooMessage.model.service.examination.find;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.examination.find
 * @Author: 王飞
 * @CreateTime: 2022-10-11  17:01
 * @Description: 服务号菜单催审
 * @Version: 1.0
 * @see :https://support.huaweicloud.com/api-KooMessage/PushMenusInfol.html
 */
@Data
public class FindServiceMenuExaminationTemplate implements Template {
    /**菜单ID**/
    @NotNull
    private String menu_id;
}
