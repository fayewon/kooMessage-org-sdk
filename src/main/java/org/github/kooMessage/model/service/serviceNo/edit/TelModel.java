package org.github.kooMessage.model.service.serviceNo.edit;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.edit
 * @Author: 王飞
 * @CreateTime: 2022-10-21  11:26
 * @Description: 热线号列表。
 * @Version: 1.0
 */
@Data
public class TelModel {
    /**
     * 电话号码（只能包含数字和-，且开头和结尾必须为数字）。
     *
     * 最小长度：1
     *
     * 最大长度：20
     */
    @NotNull
    private String tel;
    /**
     * 号码用途。
     *
     * 说明：
     * 号码用途长度范围为1-30个字符，中文占2个字符，英文占1个字符。
     */
    @NotNull
    private String usage;
}
