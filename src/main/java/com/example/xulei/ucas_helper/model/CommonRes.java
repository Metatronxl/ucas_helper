package com.example.xulei.ucas_helper.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lei.X
 * @date 2018/9/26
 */
@Data
@AllArgsConstructor
public class CommonRes<T> {
    private int status = statusOK;
    private String message;
    private T data;

    public static final int statusOK = 0;

    public boolean success() {
        return status == statusOK;
    }
}
