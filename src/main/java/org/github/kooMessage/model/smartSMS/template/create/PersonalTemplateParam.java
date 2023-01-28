package org.github.kooMessage.model.smartSMS.template.create;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.create
 * @Author: 王飞
 * @CreateTime: 2022-10-13  15:28
 * @Description: 创建个人模板
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/CreatePersonalTemplate.html
 */
@Data
public class PersonalTemplateParam {
    /**
     * 动态参数类型。1：表示文本类型。
     * 最小值：0
     * 最大值：100
     * 是否必填：是
     */
    @NotNull
    private Integer type;
    /**
     * 动态参数名称。示例：${param1}
     * 最小长度：1
     * 最大长度：20
     * 是否必填：是
     */
    @NotNull
    private String name;
    /**
     * 参数示例，动态参数对应的示例，不能大于100个字符。
     * 最小长度：1
     * 最大长度：100
     * 是否必填：是
     */
    @NotNull
    private String example;
}
