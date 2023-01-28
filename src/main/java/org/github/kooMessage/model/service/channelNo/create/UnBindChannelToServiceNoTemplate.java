package org.github.kooMessage.model.service.channelNo.create;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.channelNo.create
 * @Author: 王飞
 * @CreateTime: 2022-10-13  11:21
 * @Description: 通道号解定服务号
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/UnlockPort.html
 * 2、请求Body
 * {
 *   "id" : "b7e67a1935524f439019b4e874f186c7"
 * }
 */
@Data
public class UnBindChannelToServiceNoTemplate implements Template {
    /**
     * 主键ID，取查询通道号绑定信息列表返回的ID字段。
     * 最小长度：32
     * 最大长度：32
     * 是否必填：是
     */
    @NotNull
    private String id;
}
