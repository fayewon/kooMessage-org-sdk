package org.github.kooMessage.core.method;

import org.github.kooMessage.model.Result;
import org.github.kooMessage.model.Template;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.method
 * @Author: 王飞
 * @CreateTime: 2022-10-19  11:26
 * @Description: 请求对象配置信息
 * @Version: 1.0
 */
@Data
public class KHttpMethodBody implements Serializable,Cloneable {
    private String requestName;
    /**
     * 模板
     */
    @NotNull
    private Class< ? extends Template> template;
    /**
     * 请求URL
     */
    @NotNull
    private String url;
    /**
     * 方法
     */
    @NotNull
    private HttpMethod method;
    /**
     * 结果
     */
    private Class< ? extends Result> result;
    /**
     * 文档URL
     */
    private String documentUrl;
    /**
     * 数据类型
     * @see  DataType
     */
    private DataType dataType = DataType.JSON_STRING;
}
