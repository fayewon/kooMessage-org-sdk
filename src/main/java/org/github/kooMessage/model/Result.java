package org.github.kooMessage.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.model
 * @Author: 王飞
 * @CreateTime: 2022-09-29  15:42
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class Result implements  Serializable,CharSequence,Cloneable {
    private String status;
    private String message;

    @Override
    public int length() {
        return this.toString().length();
    }

    @Override
    public char charAt(int index) {
        return this.toString().charAt(index);
    }

    @NotNull
    @Override
    public CharSequence subSequence(int start, int end) {
        return this.toString().subSequence(start,end);
    }
}
