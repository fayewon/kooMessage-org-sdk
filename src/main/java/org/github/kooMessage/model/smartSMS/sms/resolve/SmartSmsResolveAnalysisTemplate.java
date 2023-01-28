package org.github.kooMessage.model.smartSMS.sms.resolve;

import org.github.kooMessage.model.Template;
import org.github.kooMessage.model.smartSMS.sms.create.CreateResolveTaskParam;
import lombok.Data;
import org.jetbrains.annotations.NotNull;


/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-10-18  16:42
 * @Description: 生成解析任务
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/CreateResolveTask.html
 */
@Data
public class SmartSmsResolveAnalysisTemplate implements Template {
    /**
     * 智能信息模板ID，由9位数字组成。
     * 最小长度：1
     * 最大长度：9
     * 是否必填：是
     */
    @NotNull
    private String tpl_id;
    /**
     * 短信签名列表，需要与最终发送短信的签名一致，才能解析。
     * 最小长度：1
     * 最大长度：18
     * 是否必填：是
     */
    @NotNull
    private String[] sms_signs;
    /**
     * 短链的最大解析次数。
     * 说明：
     * 个性化短链只支持最大解析数为1，设置其他值无效
     * 最小值：1
     * 最大值：10000000
     * 是否必填：是
     */
    @NotNull
    private Integer resolving_times;
    /**
     * 智能信息编码类型。
     * group：群发
     * individual：个性化
     * 说明：
     * 智能信息编码类型选择群发时，所有发送使用同一个短链，无法获取到单个手机号码的解析情况。
     * 是否必填：是
     */
    @NotNull
    private String aim_code_type;
    /**
     * 失效时间（天）。aim_code_type为group时，取值范围为1~30；aim_code_type为individual个性化时，取值范围为1~7。
     * 说明：
     * 失效时间精确到秒，例如参数设置为1，创建时间为2022-07-22 21:10:12，过期时间为2022-07-23 21:10:12。
     * 是否必填：是
     */
    @NotNull
    private Integer expiration_time;
    /**
     * 自定义短链域名，由大小写字母和数字组成的二级域名。
     *
     * 最大长度：100
     * 是否必填：否
     */
    private String domain;
    /**
     * 短链解析详情列表。一次请求最多100个短链。
     * 是否必填：是
     */
    @NotNull
    private CreateResolveTaskParam[] params;
}
