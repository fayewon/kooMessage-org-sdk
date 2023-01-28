package org.github.kooMessage.model.service.serviceNo.edit;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-21  10:14
 * @Description: TODO
 * @Version: 1.0
 * {
 *   "change_reason" : "我要修改菜单",
 *   "menu" : {
 *     "menu_items" : [ {
 *       "action_type" : "OPEN_APP",
 *       "name" : "通过申请",
 *       "sub_menu_items" : [ ],
 *       "content" : "hap://app/xxxx.deeplink.xxxxx",
 *       "ext_msg" : {
 *         "package_name" : "baoming",
 *         "app_id" : "",
 *         "x_app_id" : "",
 *         "x_package_names" : "",
 *         "browser_floor_url" : "https://www.xxxx.com/"
 *       }
 *     }, {
 *       "action_type" : "OPEN_URL",
 *       "name" : "打开链接",
 *       "sub_menu_items" : [ ],
 *       "content" : "https://www.xxxx.com/",
 *       "ext_msg" : {
 *         "web_title" : "百度百度",
 *         "open_in_browser" : "1"
 *       }
 *     }, {
 *       "action_type" : "OPEN_SUBMENU",
 *       "name" : "通过菜单",
 *       "ext_msg" : { },
 *       "sub_menu_items" : [ {
 *         "action_type" : "OPEN_URL",
 *         "name" : "百度一下",
 *         "sub_menu_items" : [ ],
 *         "content" : "https://www.xxxx.com/",
 *         "ext_msg" : {
 *           "web_title" : "url标题",
 *           "open_in_browser" : "1"
 *         }
 *       }, {
 *         "action_type" : "CALLING",
 *         "name" : "电一下",
 *         "sub_menu_items" : [ ],
 *         "content" : "17732635412",
 *         "ext_msg" : { }
 *       }, {
 *         "action_type" : "OPEN_APP",
 *         "name" : "手机软件",
 *         "sub_menu_items" : [ ],
 *         "content" : "hap://app/xxxx.deeplink.xxxxx",
 *         "ext_msg" : {
 *           "package_name" : "开心消消乐",
 *           "app_id" : "appid",
 *           "x_app_id" : "xappid",
 *           "x_package_names" : "packagenames",
 *           "browser_floor_url" : "https://www.xxxx.com/"
 *         }
 *       }, {
 *         "action_type" : "OPEN_QUICK",
 *         "name" : "快应用1",
 *         "sub_menu_items" : [ ],
 *         "content" : "hap://app/11111111111",
 *         "ext_msg" : {
 *           "depend_engine_ver" : "快应用引擎",
 *           "third_service_name" : "服务名"
 *         }
 *       }, {
 *         "action_type" : "OPEN_QUICK",
 *         "name" : "快应用2",
 *         "sub_menu_items" : [ ],
 *         "content" : "hap://app/dfs/dfdf",
 *         "ext_msg" : {
 *           "depend_engine_ver" : "v1.1.0",
 *           "third_service_name" : "测试"
 *         }
 *       } ]
 *     } ]
 *   }
 * }
 */
@Data
public class MenuItem {
    /**
     * 菜单动作类型。
     *
     * OPEN_SUBMENU：打开子菜单
     *
     * OPEN_URL：打开URL
     *
     * CALLING：拨打电话
     *
     * OPEN_APP：打开APP
     *
     * OPEN_QUICK：打开快应用
     *
     * 最小长度：0
     *
     * 最大长度：30
     */
    @NotNull
    private String action_type;
    /**
     *
     * 子菜单名称。
     *
     * 一级菜单名长度和菜单数量有关，具体约束为：
     *
     * 当菜单数量为1个时，菜单名长度范围在1-24个字符。
     *
     * 当菜单数量为2个时，菜单名长度范围在1-12个字符。
     *
     * 当菜单数量为3个时，菜单名长度范围在1-8个字符。
     *
     * 二级菜单名长度范围恒为1-16个字符。
     *
     * 说明：
     * 以上字符区分中英文，一个中文占2个字符，字母和数字占1个字符，且同时生效的一组菜单内名称不能重复。
     */
    @NotNull
    private String name;
    /**
     * 子菜单配置项。
     *
     * 说明：
     * 仅当action_type=OPEN_SUBMENU时生效，且该项内不允许再配置子菜单
     */
    private MenuItem[] sub_menu_items;
    /**
     * 对应值类型。对应不同action_type值，content含义如下：
     *
     * action_type=OPEN_SUBMENU：不填
     *
     * action_type=OPEN_URL：参数数值为跳转URL
     *
     * action_type=CALLING：参数数值为电话号码
     *
     * action_type=OPEN_APP：参数数值为APP的跳转deeplink
     *
     * action_type=OPEN_QUICK：参数数值为快应用跳转的deeplink
     *
     * 最小长度：0
     *
     * 最大长度：1000
     */
    private String content;
    /**
     * 额外需要携带的信息。
     *
     * action_type=OPEN_SUBMENU时，不填
     *
     * action_type=CALLING时，不填
     *
     * action_type=OPEN_URL时，必填
     *
     * action_type=OPEN_APP时，必填
     *
     * action_type=OPEN_QUICK时，必填
     */
    private ExtMsg ext_msg;
}
