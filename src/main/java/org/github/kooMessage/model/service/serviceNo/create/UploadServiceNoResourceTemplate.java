package org.github.kooMessage.model.service.serviceNo.create;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.service.serviceNo.create
 * @Author: 王飞
 * @CreateTime: 2022-10-21  14:27
 * @Description: 上传智能信息服务号图片资源
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/UploadMedia.html
 *
 * 文件类型。
 *
 * PUB_LOGO：上传服务号LOGO
 *
 * BG_IMAGE：上传服务号主页背景图
 *
 * FASTAPP_LOGO：上传快应用LOGO
 *
 * OTHER：上传授权证明和营业执照等
 */
@Data
public class UploadServiceNoResourceTemplate implements Template {
    /**
     * 图片文件二进制字符串。
     */
    @NotNull
    private File file;
    /**
     * 文件类型。
     *
     * PUB_LOGO：上传服务号LOGO
     *
     * BG_IMAGE：上传服务号主页背景图
     *
     * FASTAPP_LOGO：上传快应用LOGO
     *
     * OTHER：上传授权证明和营业执照等
     */
    @NotNull
    private String file_type;

}
