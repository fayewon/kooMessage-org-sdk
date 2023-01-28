package org.github.kooMessage.model.smartSMS.template.create;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.create
 * @Author: 王飞
 * @CreateTime: 2022-10-13  15:27
 * @Description: 创建个人模板
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/CreatePersonalTemplate.html
 */
@Data
public class PersonalTemplatePage {
    /**
     * 分页显示，指示当前展示第几页，从1开始，最大支持10页。
     * 是否必填：是
     */
    @NotNull
    private Integer page_order;
    /**
     * 该page下的协议内容。
     * 是否必填：是
     */
    @NotNull
    private PersonalTemplateFactoryContent[] contents;
}
