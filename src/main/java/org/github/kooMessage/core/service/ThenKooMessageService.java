package org.github.kooMessage.core.service;

import org.github.kooMessage.core.response.ResponseBody;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.service
 * @Author: 王飞
 * @CreateTime: 2023-1-13  15:03
 * @Description: 连续服务请求
 * @see KMActuator#then(ThenKooMessageService)
 * @see com.example.koomessage.KooMessageTest#FindChannelNo() 用例
 * @Version: 1.0
 */
public interface ThenKooMessageService<R,T> extends KooMessageService<R,T> {
    @Override
    default T  convertData(){
        throw new Error("该类不支持实现此方法，此方法实现类参见："+KooMessageService.class);
    }

    T  convertData(ResponseBody<R> responseBody);
}
