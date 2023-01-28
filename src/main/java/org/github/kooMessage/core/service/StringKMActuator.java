package org.github.kooMessage.core.service;

import org.github.kooMessage.core.response.ResponseBody;
import org.github.kooMessage.model.Template;

import java.util.concurrent.ExecutionException;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.service
 * @Author: 王飞
 * @CreateTime: 2022-09-21  18:15
 * @Description: 字符串执行器
 * @Version: 1.0
 */
final public class StringKMActuator<T extends Template> extends ModelKMActuator<String,T> {

    public StringKMActuator request (KooMessageService<String,T> kooMessageService) {
        kooMessageService.init(kooMessageService,
                (k) -> {
                    this.kooMessageService = kooMessageService;
                }
        );
        t = kooMessageService.convertData();
        return this;
    }


    public StringKMActuator execute ()  {
        try {
            responseBody = kooMessageService.execute(
                     ()->t,
                     ()->{

                        return String.class;
                    }) ;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }


    public ResponseBody<String> result () {
        kooMessageService.result(  ()-> responseBody  );
        return responseBody;
    }
}
