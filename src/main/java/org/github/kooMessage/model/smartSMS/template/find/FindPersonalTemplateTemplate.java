package org.github.kooMessage.model.smartSMS.template.find;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.find
 * @Author: 王飞
 * @CreateTime: 2022-10-14  15:49
 * @Description: 查询个人模板
 * @Version: 1.0
 * @see ： https://support.huaweicloud.com/api-KooMessage/ListAIMTemplates.html
 */
@Data
public class FindPersonalTemplateTemplate implements Template {
    /**
     * 智能信息模板ID。
     * 最小长度：0
     * 最大长度：36
     * 是否必填：否
     */
    private String tpl_id;
    /**
     * 智能信息模板名称。
     * 最小长度：0
     * 最大长度：100
     * 是否必填：否
     */
    private String tpl_name;
    /**
     * 模板分类。
     * public：查公共模板
     * private：查个人模板
     * 说明：
     * 不传查全部模板。
     * 是否必填：否
     */
    private String tpl_type;
    /**
     * 厂商类型。暂不支持VIVO。
     * HUAWEI：华为
     * Xiaomi：小米
     * OPPO：OPPO
     * MEIZU：魅族
     * VIVO：VIVO
     * 是否必填：否
     */
    private String[] factory_type;

    /**
     * 模板是否携带参数。
     * true：是
     * false：否
     * 是否必填：否
     */
    private Boolean has_param;
    /**
     * 模板创建开始时间。样例：2019-10-12T07:20:50Z。
     * 最小长度：0
     * 最大长度：30
     * 是否必填：否
     */
    private String begin_time;
    /**
     * 模板创建结束时间。样例：2019-10-12T07:20:50Z。
     * 最小长度：0
     * 最大长度：30
     * 是否必填：否
     */
    private String end_time;
    /**
     * 偏移量，表示从此偏移量开始查询，offset大于等于0。
     * 最小值：0
     * 最大值：1000000
     * 缺省值：0
     * 是否必填：是
     */
    @NotNull
    private Integer offset;
    /**
     * 每页显示的条目数量。
     * 最小值：1
     * 最大值：100
     * 缺省值：20
     */
    @NotNull
    private Integer limit;
}
