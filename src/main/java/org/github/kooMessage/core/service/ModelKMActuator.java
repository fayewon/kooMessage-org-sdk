package org.github.kooMessage.core.service;

import org.github.kooMessage.core.response.ResponseBody;
import org.github.kooMessage.model.Result;
import org.github.kooMessage.model.Template;

import java.util.concurrent.ExecutionException;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.service
 * @Author: 王飞
 * @CreateTime: 2022-10-18  14:08
 * @Description: 模型执行器
 * @Version: 1.0
 */
public  class ModelKMActuator<R extends CharSequence,T extends Template> implements KMActuator<R,T> {

    protected KooMessageService<R,T> kooMessageService;
    protected ResponseBody<R> responseBody;
    protected T t;

    public ModelKMActuator request (KooMessageService<R,T> kooMessageService) {
        kooMessageService.init(kooMessageService,
                (k) -> {
                    this.kooMessageService = kooMessageService;
                }
        );
        t = kooMessageService.convertData();
        return this;
    }

    public ModelKMActuator request (ThenKooMessageService<R,T> thenKooMessageService) {
        kooMessageService.init(thenKooMessageService,
                (k) -> {
                    this.kooMessageService = thenKooMessageService;
                }
        );
        t = thenKooMessageService.convertData(responseBody);
        return this;
    }

    public ModelKMActuator execute ()  {
        try {
            responseBody = kooMessageService.execute(
                     ()->t ,
                     ()->{

                        return Result.class;
            }) ;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public ModelKMActuator then ( ThenKooMessageService<R,T> thenKooMessageService) {
        request(thenKooMessageService);
        execute ();
        return this;
    }

    public ResponseBody<R> result () {
        kooMessageService.result( ()-> responseBody  );
        return responseBody;
    }
}
