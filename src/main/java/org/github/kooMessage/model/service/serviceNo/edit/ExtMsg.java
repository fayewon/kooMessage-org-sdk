package org.github.kooMessage.model.service.serviceNo.edit;

import lombok.Data;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-21  10:15
 * @Description: 额外需要携带的信息。
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
 * @Version: 1.0
 */
@Data
public class ExtMsg {
    /**
     * 打开方式。
     *
     * 0：webView打开
     *
     * 1：浏览器打开
     *
     * 说明：
     * action_type=OPEN_URL必填，其他不填。
     */
    private String open_in_browser;
    /**
     * 标题，必填，长度范围为1-20个字符。
     *
     * 说明：
     * action_type=OPEN_URL必填，其他不填。
     */
    private String web_title;
    /**
     *
     * app包名，长度范围为1-50个字符。
     *
     * 说明：
     * action_type=OPEN_APP必填，其他不填。
     */
    private String package_name;
    /**
     * 商家应用的appid，长度范围为0-60个字符。
     *
     * 说明：
     * action_type=OPEN_APP必填，其他不填。
     */
    private String app_id;
    /**
     * 兜底url，长度范围为0-1000个字符，支持http/https。
     *
     * 说明：
     * action_type=OPEN_APP选填，其他不填。
     */
    private String browser_floor_url;
    /**
     * 依赖的快应用引擎版本号，长度范围为1-50个字符。
     *
     * 说明：
     * action_type=OPEN_QUICK必填，其他不填。
     */
    private String depend_engine_ver;
    /**
     * 第三方服务名，长度范围为1-50个字符。
     *
     * 说明：
     * action_type=OPEN_QUICK必填，其他不填。
     */
    private String third_service_name;
}
