package org.github.kooMessage.model.smartBasicSMS.template.find;

import org.github.kooMessage.model.Template;
import lombok.Data;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-09-28  13:43
 * @Description: 智能信息基础版/创建智能信息基础版模板#查看基础类模板
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/ListAIMTemplates.html
 */
@Data
public class SmartSmsTemplatesGetTemplate implements Template {
    private Integer limit;
    private Integer offset;
    private String  tpl_type;
}
