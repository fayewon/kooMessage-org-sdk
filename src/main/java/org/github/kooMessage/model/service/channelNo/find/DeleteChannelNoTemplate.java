package org.github.kooMessage.model.service.channelNo.find;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.channelNo.find
 * @Author: 王飞
 * @CreateTime: 2022-10-12  17:31
 * @Description: 删除通道号
 * @Version: 1.0
 * @see :https://support.huaweicloud.com/api-KooMessage/DeletePort.html
 */
@Data
public class DeleteChannelNoTemplate implements Template {
    /**
     * 主键ID，取查询通道号绑定信息列表返回的ID字段。
     * 最小长度：32
     * 最大长度：32
     * 是否必填：是
     */
    @NotNull
    private String id;
}
