package org.github.kooMessage.model.smartSMS.template.delete;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.delete
 * @Author: 王飞
 * @CreateTime: 2022-10-13  19:48
 * @Description: 删除素材
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/DeleteTemplateMaterial.html
 */
@Data
public class DeleteMaterialTemplate implements Template {
    /**
     * 模板素材ID数组。
     * 是否必填：是
     */
    @NotNull
    private String[] material_ids;
}
