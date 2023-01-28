package org.github.kooMessage.model.smartSMS.sms.create;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-09-07  19:10
 * @Description: 短链解析详情列表。一次请求最多100个短链。
 * @Version: 1.0
 */
@Data
public class CreateResolveTaskParam {
    /**
     * 创建解析任务时填写用户唯一标识，手机号码或者任何的唯一标识，唯一标识不超过64个字符。 发送智能信息时则必须填客户的手机号码。样例为：13000000001。
     * 最大长度：64
     * 是否必填：是
     */
    @NotNull
    private String cust_flag;
    /**
     * 动态参数。
     *
     * 说明：
     * 使用动态参数模板时，aim_code_type字段只能为individual。
     * 是否必填：否
     */
    private Map<String,String> dync_params;
    /**
     * 自定义跳转地址。长度要求不超过256。
     * 说明：
     * 未填时，终端用户点击短信原文中的短链后，跳转智能信息模板H5页
     * 已填时，终端用户点击短信原文中的短链后，跳转该字段对应的页面，填写时必须为http或https作为前缀
     * 使用自定义跳转链接功能请联系KooMessage运营人员进行域名备案
     * 是否必填：否
     */
    private String custom_url;
    /**
     * 自定义短码，5-8位数字字母组合
     * 是否必填：否
     */
    private String custom_short_code;
}
