package org.github.kooMessage.model.smartSMS.template.delete;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.delete
 * @Author: 王飞
 * @CreateTime: 2022-10-14  16:06
 * @Description: 删除个人模板
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/DeletePersonalTemplate.html
 */
@Data
public class DeletePersonalTemplateTemplate implements Template {
    /**
     * 智能信息模板ID。
     * 最小长度：1
     * 最大长度：36
     * 是否必填：是
     */
    @NotNull
    private String tpl_id;
}
