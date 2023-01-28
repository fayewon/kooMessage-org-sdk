package org.github.kooMessage.core.service;

import org.github.kooMessage.core.response.ResponseBody;
import org.github.kooMessage.model.Template;

/**
 * 执行器接口
 * @param <R>
 * @param <T>
 */
public interface KMActuator<R extends CharSequence,T extends Template > {
    /**
     * 构建请求对象
     * R:是返回值，分为字符串和实体类的返回值。具体实现参见： @see
     * T：请求参数
     * @param kooMessageService
     * @see ModelKMActuator
     * @see StringKMActuator
     * @return this
     */
    KMActuator request (KooMessageService<R,T> kooMessageService) ;

    /**
     * 连续请求对象
     * R:是返回值，分为字符串和实体类的返回值。具体实现参见： @see
     * T：请求参数
     * @param thenKooMessageService
     * @see ModelKMActuator
     * @see com.example.koomessage.KooMessageTest#FindChannelNo() 用例
     * @return this
     */
    KMActuator request (ThenKooMessageService<R,T> thenKooMessageService) ;

    /**
     * 请求过程
     * @return this
     * @see  KooMessageService
     */
    KMActuator execute () ;


    /**
     * 连续请求，在execute之后有调用。不然无法拿到上次请求结果。convertData(ResponseBody<R> responseBody) responseBody为空
     * @see ThenKooMessageService#convertData(ResponseBody)
     * @param thenKooMessageService
     * @return
     */
    KMActuator then ( ThenKooMessageService<R,T> thenKooMessageService) ;

    /**
     * 结果集
     * @return ResponseBody
     * @see ResponseBody
     */
    ResponseBody<R> result ();
}
