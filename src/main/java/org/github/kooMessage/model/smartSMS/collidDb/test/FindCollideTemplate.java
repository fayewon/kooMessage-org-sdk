package org.github.kooMessage.model.smartSMS.collidDb.test;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-10-13  14:58
 * @Description: 撞库测试/查询手机号智能信息解析能力
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/BatchListMobileCapability.html
 */
@Data
public class FindCollideTemplate implements Template {
    /**
     * 待查询的手机号码，一次最多请求100个。
     * 说明：
     * 不加密时，参数可传入纯手机号或国家码加手机号，国家码不带“+”号，例如国内手机号“13100000000”，参数可传入“13100000000”、“8613100000000”、“008613100000000”。使用SHA1加密，mobiles传入号码国家码与手机号码的SHA1算法后的摘要，国家码格式为纯数字，不带“+”，去掉前面的0，例如国内手机号“13100000000”，使用“8613100000000”进行SHA1加密。
     * 最小长度：1
     * 最大长度：40
     */
    @NotNull
    private String[] mobiles;
    /**
     * 智能信息模板ID，由9位数字组成。
     * 说明：
     * 填写时，根据该模板所支持的厂商返回手机终端展示智能信息的能力状态
     * 不填则返回手机终端在所有厂商展示智能信息的能力状态
     */
    private String tpl_id;
    /**
     * 加密类型。
     * NONE：不加密
     * SHA1：使用SHA1加密算法加密
     * 说明：
     * 默认为NONE。
     */
    private String encryption_alg;
}
