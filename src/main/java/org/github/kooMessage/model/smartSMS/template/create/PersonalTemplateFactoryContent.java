package org.github.kooMessage.model.smartSMS.template.create;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.create
 * @Author: 王飞
 * @CreateTime: 2022-10-13  15:32
 * @Description: 创建个人模板
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/CreatePersonalTemplate.html
 */
@Data
public class PersonalTemplateFactoryContent {
    /**
     * 模板资源类型。
     * text：表示文本
     * image：表示图片
     * video：表示视频
     * button：表示按钮
     * followPub：表示华为服务号，暂不支持
     * 最小长度：1
     * 最大长度：18
     * 是否必填：是
     */
    @NotNull
    private String type;
    /**
     * 资源类型为Text或Button时，为必填。文本长度限制请按智能短信模板版式格式标准。
     * 最小长度：0
     * 最大长度：1000
     * 是否必填：否
     */
    private String content;
    /**
     * src类型。资源类型为Image或Video时，该项为必填项。
     * 1：指资源ID
     * 2：指资源地址
     * 最小值：1
     * 最大值：10
     * 是否必填：否
     */
    private Integer src_type;
    /**
     * 资源来源，资源类型为Image或Video时，为必填。
     * 说明：
     * 如上src_type为1，即资源ID时，参数填入上传模板素材接口中返回的aim_resource_id，如：691996319597764608
     * 如上src_type为2，即资源地址时，参数填写资源完整的URL，最大长度不超过1000个字符
     * 是否必填：否
     */
    private String src;
    /**
     * 视频封面。
     * 说明：
     * 资源类型为Video时，为必填。
     * 如上src_type为1，即资源ID时，参数填入上传模板素材接口中返回的aim_resource_id，如：691996319597764608
     * 如上src_type为2，即资源地址时，参数填写资源完整的URL，最大长度不超过1000个字符
     * 最小长度：0
     * 最大长度：1000
     * 是否必填：否
     */
    private String cover;
    /**
     * 是否为文本标题。
     * true：是
     * false：不是
     * 说明：
     * 不填默认为false。
     * 最小长度：0
     * 最大长度：10
     * 是否必填：否
     */
    private String is_text_title;
    /**
     * 功能类型。
     * OPEN_URL：表示跳转H5
     * OPEN_QUICK：表示跳转快应用
     * OPEN_APP：表示跳转APP
     * DIAL_PHONE：表示拉起拨号盘
     * OPEN_SMS：表示新建短信息
     * OPEN_EMAIL：表示打开邮箱
     * OPEN_SCHEDULE：表示新建日程
     * OPEN_MAP：表示位置定位
     * OPEN_BROWSER：表示打开浏览器
     * OPEN_POPUP：表示弹窗
     * COPY_PARAMETER：表示复制
     * VIEW_PIC：表示打开大图
     * 说明：
     * type为Image和Button时为必填项，必须绑定事件
     * type为其他类型时则不必填
     * OPPO厂商点击事件类型只支持打开浏览器、打开快应用、打开APP
     * 横滑类1、横滑类2版式的图片不支持绑定事件，默认与按钮事件一致
     * 是否必填：否
     */
    private String action_type;
    /**
     * 片组件的位置序号。
     * 说明：
     * 资源在卡片上相对的位置序号，按照优先从左到右，再从上到下的编排原则，统一编号。
     * 是否必填：是
     */
    @NotNull
    private Integer position_number;
    /**
     * 组件是否可见。
     * 0：隐藏（某些组件可设置隐藏）
     * 1：可见
     * 是否必填：否
     */
    private Integer visible;
    /**
     * 是否显示货币符号。
     * 0：隐藏
     * 1：可见
     * 说明：
     * 当模板为电商类时是否显示￥符号，默认可见。
     * 是否必填：否
     */
    private Integer currency_display;
    /**
     * OPPO红包背景。
     * 说明：
     * 当src_type为1时，即资源ID时，参数填入上传模板素材接口中返回的aim_resource_id，如：691996319597764608
     * 当src_type为2时，即资源地址时，参数填写资源完整的URL，最大长度不超过1000个字符
     * 当模板为红包类，即card_id为RedPacket时用于指定OPPO厂商红包背景图，具体使用可参考创建红包类模板请求示例
     * 最小长度：0
     * 最大长度：1000
     * 是否必填：否
     */
    private String oppo_background;
    /**
     * 个人模板事件对象。
     * 是否必填：否
     */
    private PersonalTemplateFactoryContentAction action;
}
