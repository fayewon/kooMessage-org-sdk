package org.github.kooMessage.model.smartSMS.template.upload;

import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model.smartSMS.template.upload
 * @Author: 王飞
 * @CreateTime: 2022-10-13  18:05
 * @Description: 上传素材
 * @Version: 1.0
 * @see : https://support.huaweicloud.com/api-KooMessage/UploadTemplateMaterial.html
 */
@Data
public class UploadMaterialTemplate implements Template {
    /**
     * 资源类型。
     * image：图片
     * video：视频
     * thumbnail：缩略图
     * 说明：
     * 图片支持png、jpeg、jpg格式，最大2M; 视频支持格式mp4，大小不超过10M，建议时长不超过33S; 缩略图支持png、jpeg、jpg格式，大小不超过100K。
     * 最小长度：1
     * 最大长度：16
     * 是否必填：是
     */
    @NotNull
    private String resource_type;
    /**
     * 素材ID。
     * 说明：
     * resource_type=thumbnail时，material_id必填，填写内容为上传视频资源返回的material_id字段的值。
     * 最小长度：0
     * 最大长度：36
     * 是否必填：否
     */
    private String material_id;
    /**
     * 文件类型。
     * url：资源为URL链接地址
     * stream：资源为多媒体资源文件流的BASE64编码，需要带资源类型前缀，样例："data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/4gIoSUNDX1BST0ZJTEUAAQEAAAIYAAAAAAQwAABtbnRyUkdCIFhZWiAAAAAAAAAAAAAAAABhY3NwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAA9tYAAQAAAADTLQ..."，样例过长，未显示全部
     * 最小长度：1
     * 最大长度：16
     * 是否必填：是
     */
    @NotNull
    private String file_type;
    /**
     * 文件URL。
     * 说明：
     * file_type=url时，file_url为必填。URL地址必须包含文件格式的后缀，例如：jpg、jpeg，大小写后缀都支持。
     * 最大长度：1000
     * 是否必填：否
     */
    private String file_url;
    /**
     * 文件资源码流。
     * 说明：
     * file_type=stream时，file_stream为必填。
     * 是否必填：否
     */
    private String file_stream;
    /**
     * 图像比例。
     * oneToOne：指1:1比例
     * sixteenToNine：指16:9比例
     * threeToOne：指3:1比例
     * fortyEightToSixtyFive：指48:65比例
     * twentyOneToNine：指21:9比例
     * 说明：
     * resource type=image时，image_rate必填。
     * 最大长度：32
     * 是否必填：否
     */
    private String image_rate;
    /**
     * 文件名称。
     * 说明：
     * file_type=stream时，file_name必填。
     * 最大长度：200
     * 是否必填：否
     */
    private String file_name;
    /**
     * 描述。
     * 最大长度：50
     * 是否必填：否
     */
    private String description;

}
