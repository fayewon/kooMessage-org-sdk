package org.github.kooMessage.core.exception;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.core.exception
 * @Author: 王飞
 * @CreateTime: 2022-10-19  09:45
 * @Description: 华为云返回异常信息
 * @Version: 1.0
 */
public class KResponseException extends RuntimeException {
    public KResponseException() {
        super();
    }

    public KResponseException(String message) {
        super(message);
    }
}
