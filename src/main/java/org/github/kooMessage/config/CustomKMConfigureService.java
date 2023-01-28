package org.github.kooMessage.config;

import org.github.kooMessage.core.method.KHttpMethodBody;
import org.github.kooMessage.model.Result;
import org.github.kooMessage.model.Template;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.config.KooMessageConfigService
 * @Author: 王飞
 * @CreateTime: 2022-09-23  11:50
 * @Description: 设置自定义的配置
 * @Version: 1.0
 */
public interface CustomKMConfigureService {
    /**
     * 修改内置的请求URL和token，修改标的是原型的副本对象。
     * 新增请求对象
     * 构建请求信息（KHttpMethodBody）的 template对象必须实现Template 接口。不然会报类型转换异常.参见：org.github.kooMessage.model包
     * 构建请求信息（KHttpMethodBody）的 result对象必须继承Result。不然会报类型转换异常.参见：org.github.kooMessage.model包
     * @param configReplacer 配置修改器
     * @param tokenMessageCopy token副本
     * @param kooMessageUrlCopy 内置URL副本
     * @see KHttpMethodBody
     * @see Template
     * @see Result
     * @return
     */
    ConfigureReplacer modifyAndNewRequest (ConfigureReplacer configReplacer, TokenMessageCopy tokenMessageCopy, KooMessageUrlCopy kooMessageUrlCopy );

}
