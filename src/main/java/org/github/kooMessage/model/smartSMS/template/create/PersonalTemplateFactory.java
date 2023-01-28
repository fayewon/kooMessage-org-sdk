package org.github.kooMessage.model.smartSMS.template.create;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.create
 * @Author: 王飞
 * @CreateTime: 2022-10-13  15:29
 * @Description: 创建个人模板
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/CreatePersonalTemplate.html
 */
@Data
public class PersonalTemplateFactory {
    /**
     * 厂商类型。暂不支持VIVO。
     * HUAWEI：华为
     * XIAOMI：小米
     * OPPO：OPPO
     * VIVO：VIVO
     * MEIZU：魅族
     * 说明：
     * 各厂商支持的布局类型，布局类型与card_id字段相对应。
     * HUAWEI：多图文类（MultipleImageAndText）、图文类（StandardImageAndText）、长文本类（PureText）、横滑类1（Carousel）、横滑类2（CarouselTitle）、视频图文类（VideoImageAndText）、视频类（Video）、电商类（ECImageAndText）、红包类（RedPacket）、个性化红包类（RedPacketPersonal）、增强通知类（Notification2）、图片轮播类1:1（CarouselSquareImage）、图片轮播类16:9（CarouselImageSixteenToNine）、图片轮播类48:65（CarouselVerticalImage）、图文视频类（ImageTextAndVideo）、一般通知类（Notification1）、单卡券（CardVoucher）、多卡券（CardVouchers）
     * XIAOMI：多图文类（MultipleImageAndText）、图文类（StandardImageAndText）、红包类（RedPacket）、增强通知类（Notification2）、一般通知类（Notification1）
     * OPPO：多图文类（MultipleImageAndText）、图文类（StandardImageAndText）、长文本类（PureText）、横滑类（Carousel）、视频类（Video）、电商类（ECImageAndText）、红包类（RedPacket）、图片轮播类1:1（CarouselSquareImage）、图片轮播类16:9（CarouselImageSixteenToNine）、图片轮播类48:65（CarouselVerticalImage）
     * MEIZU：多图文类（MultipleImageAndText）、图文类（StandardImageAndText）、横滑类1（Carousel）、横滑类2（CarouselTitle）
     * 最小长度：1
     * 最大长度：16
     * 是否必填：是
     */
    @NotNull
    private String factory_type;
    /**
     * 支持状态。
     * 1：支持
     * 0：不支持
     * 最小值：0
     * 最大值：1
     * 是否必填：是
     */
    @NotNull
    private Integer state;
}
