package org.github.kooMessage.model.smartBasicSMS.template.create;

import org.github.kooMessage.model.Template;
import lombok.Data;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-09-30  16:25
 * @Description: 智能信息基础版/创建智能信息基础版模板#创建图片短信和视频短信
 * @Version: 1.0
 */
@Data
public class SmartSmsTemplatesCreateTemplate implements Template {
    private String tpl_name;
    private String title;
    /**智能信息基础版模板备注信息**/
    private String remarks;
    /**智能信息基础版模板有效期**/
    private Integer expiration_time;
    /**客户系统回调URL，可用于通知对端模板审核状态信息**/
    private String callbackurl;
    private Reslist[] reslist;

}
