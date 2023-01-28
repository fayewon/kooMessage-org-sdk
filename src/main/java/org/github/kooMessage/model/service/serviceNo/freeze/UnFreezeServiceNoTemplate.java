package org.github.kooMessage.model.service.serviceNo.freeze;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.freeze
 * @Author: 王飞
 * @CreateTime: 2022-10-11  17:41
 * @Description: 解冻服务号
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/UnfreezePub.html
 */
@Data
public class UnFreezeServiceNoTemplate implements Template {
    /**
     * 服务号ID。
     */
    @NotNull
    private String pub_id;
    /**
     * 冻结原因。
     *
     * 最小长度：1
     *
     * 最大长度：200
     */
    @NotNull
    private String change_reason;
}