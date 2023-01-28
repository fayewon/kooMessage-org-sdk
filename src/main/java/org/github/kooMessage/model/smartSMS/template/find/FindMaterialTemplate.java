package org.github.kooMessage.model.smartSMS.template.find;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.find
 * @Author: 王飞
 * @CreateTime: 2022-10-13  19:29
 * @Description: 查询素材
 * @Version: 1.0
 * @see :https://support.huaweicloud.com/api-KooMessage/ShowTemplateMaterial.html
 */
@Data
public class FindMaterialTemplate implements Template {
    /**
     * 资源类型。
     * image：表示图片
     * video：表示视频
     * 最小长度：1
     * 最大长度：16
     * 是否必填：是
     */
    @NotNull
    private String resource_type;
    /**
     * 文件名称。
     * 最小长度：0
     * 最大长度：100
     * 是否必填：否
     */
    private String file_name;
    /**
     * 素材ID。
     * 最小长度：0
     * 最大长度：36
     * 是否必填：否
     */
    private String material_id;
    /**
     * 资源ID。
     * 最小长度：0
     * 最大长度：64
     * 是否必填：否
     */
    private String aim_resource_id;
    /**
     * 翻页页数，从1开始。
     * 最小值：1
     * 最大值：1000
     * 是否必填：是
     */
    @NotNull
    private Integer offset;
    /**
     * 每页展示的条数。
     * 最小值：1
     * 最大值：1000
     * 是否必填：是
     */
    @NotNull
    private Integer limit;
}
