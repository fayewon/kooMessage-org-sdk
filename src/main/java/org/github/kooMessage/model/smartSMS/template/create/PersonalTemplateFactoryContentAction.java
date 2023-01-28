package org.github.kooMessage.model.smartSMS.template.create;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.create
 * @Author: 王飞
 * @CreateTime: 2022-10-13  15:36
 * @Description: https://support.huaweicloud.com/api-KooMessage/CreatePersonalTemplate.html
 * @Version: 1.0
 */
@Data
public class PersonalTemplateFactoryContentAction {
    /**
     * 此字段根据action_type对应不同的含义，具体对应如下。
     * action_type=OPEN_URL：表示H5访问地址。必须为HTTPS，支持含动态参数。字符长度为1-1000。示例：https://XXXXX/${param1}
     * action_type=OPEN_QUICK：表示快应用deeplink地址。支持含动态参数，字符长度为1-1000。示例：hap://app/xxx/${param1}
     * action_type=OPEN_APP：表示APP的deeplink地址。支持含动态参数，字符长度为1-1000。示例：weixin://
     * action_type=DIAL_PHONE：表示电话号码。不能超过20个字符。示例：18600000000
     * action_type=OPEN_SMS：表示电话号码。不能超过20个字符。示例：18600000000
     * action_type=OPEN_EMAIL：表示邮箱地址。不能超过100个字符。示例：1046520406@qq.com。
     * action_type=OPEN_SCHEDULE：表示日程标题。不能超过100个字符。示例：日常需求评审
     * action_type=OPEN_MAP：表示位置名。不能超过100个字符。示例：龙泰利科技大厦
     * action_type=OPEN_BROWSER：表示网址。支持HTTPS或HTTP，支持含动态参数，不能超过1000个字符。示例：https://XXXXX/${param1}
     * action_type=OPEN_POPUP：表示弹窗标题。不能超过30个字符。参数示例：xxx商品
     * action_type=COPY_PARAMETER：表示复制的内容。支持含动态参数，不能超过20个字符。复制验证码示例：83721
     * action_type=VIEW_PIC：表示要打开的大图ID。配置在打开大图的资源地址与模板上的图片资源地址一致。如果模板资源类型是ID，则传ID，如果是资源地址，则使用资源地址。最大长度不能超过1000个字符。例如：当src_type为1时，传入ID：691996319597764608。当src_type为2时，使用资源地址：https://www.xxxx.cn/src/image/head.jpg
     * 是否必填：是
     */
    @NotNull
    private String target;
    /**
     * 弹窗内容。
     * 说明：
     * action_type=OPEN_POPUP为必填。不能超过100个字符。示例：是否喜欢该商品。
     * 最小长度：0
     * 最大长度：100
     * 是否必填：否
     */
    private String content;
    /**
     * 包名。
     * 说明：
     * action_type=OPEN_APP为必填。不能超过50个字符。示例：com.xxxx.service.koomsg。
     * 最小长度：0
     * 最大长度：50
     * 是否必填：否
     */
    private String package_name;
    /**
     * 兜底URL。支持快应用deeplink或H5的HTTPS网址，不能超过1000个字。
     * 说明：
     * action_type=OPEN_APP为选填，其他类型不填
     * 兜底类型为0时，可不填
     * 当兜底类型为2并且提交厂商列表中包含OPPO厂商时为必填
     * 最小长度：0
     * 最大长度：1000
     * 是否必填：否
     */
    private String floor_url;
    /**
     * 兜底类型。如果传入的厂商不支持该兜底类型，接口会返回错误。如果不传入厂商，则不对兜底类型进行校。
     * 0：打开应用市场
     * 1：打开H5页面（通过收件箱内置浏览器打开）
     * 2：打开浏览器
     * 3：打开快应用
     * 说明：
     * action_type=OPEN_APP为选填，其他类型不填；action_type=OPEN_APP时此参数不填则默认打开应用市场。打开链接为http格式时必须选择打开浏览器；打开链接为https格式且内容只是一个普通页面时，可以使用打开H5页面，当链接中有下载指引或打开小程序由于部分内置浏览器功能不全可能导致打开异常，建议使用打开浏览器，请按需选择兜底类型。
     * 华为：支持以上4种兜底
     * 魅族：支持以上4种兜底
     * 小米：不支持打开H5页面兜底
     * OPPO：不支持打开H5页面和打开快应用兜底
     * VIVO：不支持打开H5页面和打开快应用兜底
     * 最小值：0
     * 最大值：3
     * 是否必填：否
     */
    private Integer floor_type;
    /**
     * 邮件标题。
     * 说明：
     * action_type=OPEN_EMAIL为必填。不能超过100个字符。示例：618活动促销。
     * 是否必填：否
     */
    private String subject;
    /**
     * 邮件正文/短信正文。
     * 说明：
     * action_type=OPEN_SMS或OPEN_EMAIL为必填。不能超过100个字符。
     * 短信正文示例1：今天回家吃饭吗；
     * 邮件正文示例2：您有一张优惠券领取。
     * 是否必填：否
     */
    private String body;
    /**
     * 日程内容描述。
     * 说明：
     * action_type=OPEN_SCHEDULE为必填。不能超过100个字符。示例：评审这个月版本需求。
     * 最小长度：0
     * 最大长度：100
     * 是否必填：否
     */
    private String description;
    /**
     * 日程开始时间。格式为：yyyy-MM-dd HH:mm:ss。
     * 说明：
     * 当action_type=OPEN_SCHEDULE时为必填。
     * 最小长度：0
     * 最大长度：100
     * 是否必填：否
     */
    private String begin_time;
    /**
     * 日程结束时间。格式为：yyyy-MM-dd HH:mm:ss。
     * 说明：
     * 当action_type=OPEN_SCHEDULE时为必填。
     * 最小长度：0
     * 最大长度：100
     * 是否必填：否
     */
    private String end_time;
    /**
     * 地址的详细说明。
     * 说明：
     * action_type=OPEN_MAP为必填。不能超过100个字符。示例：高新中四道龙泰利科技大厦。
     * 最小长度：0
     * 最大长度：100
     * 是否必填：否
     */
    private String address;
    /**
     * 地图经度。
     * 说明：
     * action_type=OPEN_MAP为必填。不能超过20个字符。示例：113.941618。
     * 最小长度：0
     * 最大长度：20
     * 是否必填：否
     */
    private String longitude;
    /**
     * 地图纬度。
     * 说明：
     * action_type=OPEN_MAP为必填。不能超过20个字符。示例：22.548804。
     * 最小长度：0
     * 最大长度：20
     * 是否必填：否
     */
    private String latitude;
    /**
     * 按钮展示文本。
     * 说明：
     * action_type=OPEN_POPUP为必填。不能超过12个字符。示例：确定。
     * 最小长度：0
     * 最大长度：12
     * 是否必填：否
     */
    private String text_button;
    /**
     * 弹窗模态。
     * 0：模态（默认）
     * 1：非模态（暂不支持）
     * 说明：
     * action_type=OPEN_POPUP为必填。
     * 是否必填：否
     */
    private Integer mode;
}
