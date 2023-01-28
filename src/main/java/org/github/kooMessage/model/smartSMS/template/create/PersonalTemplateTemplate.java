package org.github.kooMessage.model.smartSMS.template.create;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.create
 * @Author: 王飞
 * @CreateTime: 2022-10-13  15:18
 * @Description: 创建个人模板
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/CreatePersonalTemplate.html
 */
@Data
public class PersonalTemplateTemplate implements Template {
    /**
     * 布局类型。
     * MultipleImageAndText：多图文类
     * StandardImageAndText：图文类
     * PureText：长文本类
     * VideoImageAndText：视频图文类
     * Video：视频类
     * ECImageAndText：电商类
     * RedPacket：红包类
     * RedPacketPersonal：个性化红包类
     * ImageTextAndVideo：图文视频类
     * Notification1：一般通知类
     * Notification2：增强通知类
     * Carousel：横滑类1
     * CarouselTitle：横滑类2
     * CarouselSquareImage：图片轮播类（1:1）
     * CarouselImageSixteenToNine：图片轮播类（16:9）
     * CarouselVerticalImage：图片轮播类（48:65）
     * CardVoucher：单卡券
     * CardVouchers：多卡券（最多支持四张卡券）
     * 是否必填：是
     */
    @NotNull
    private String card_id;
    /**
     * 模板用途。
     * 1：表示商用
     * 2：表示试商用
     * 说明：
     * 模板用途为1，即“商用”时，所有字段中不允许有测试字样，否则影响送审
     * 模板用途为2，即“试商用”时，请在模板名称（tpl_name）、模板主标题中增加测试字样
     * 是否必填：是
     */
    @NotNull
    private Integer use_id;
    /**
     * 智能信息模板名称。
     * 最小长度：1
     * 最大长度：17
     * 是否必填：是
     */
    @NotNull
    private String tpl_name;
    /**
     * 模板使用场景类型。
     * 最小长度：0
     * 最大长度：10
     * 是否必填：否
     */
    private String scene;
    /**
     * 要发送的原始文本消息示例。
     * 最小长度：0
     * 最大长度：70
     * 是否必填：否
     */
    private String sms_example;
    /**
     * 模板协议，最大支持10页协议。
     * 是否必填：是
     */
    @NotNull
    private PersonalTemplatePage[] pages;
    /**
     * 模板参数集。
     * 是否必填：否
     */
    private PersonalTemplateParam[] params;
    /**
     * 需要提交的厂商列表。
     * 是否必填：否
     */
    private PersonalTemplateFactory [] factorys;
}
