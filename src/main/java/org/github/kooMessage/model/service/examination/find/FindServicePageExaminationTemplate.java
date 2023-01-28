package org.github.kooMessage.model.service.examination.find;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.examination.find
 * @Author: 王飞
 * @CreateTime: 2022-10-11  14:53
 * @Description: 服务号主页催审
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/PushPortalsInfo1.html
 */
@Data
public class FindServicePageExaminationTemplate implements Template {
    /**主页ID**/
    @NotNull
    private String portal_id;
}
