package com.example.xulei.ucas_helper.utils;

import com.example.xulei.ucas_helper.model.CommonRes;

/**
 * @author lei.X
 * @date 2018/9/26
 */
public class ReturnUtil {
    public static <T> CommonRes<T> failed(String message) {
        return failed(message, status_other);
    }

    public static <T> CommonRes<T> failed(Exception exception) {
        return failed(exception.toString());
    }

    public static <T> CommonRes<T> failed(String message, int status) {
        return new CommonRes<>(status, message, null);
    }

    public static <T> CommonRes<T> success(T t) {
        return new CommonRes<>(status_success, "success", t);
    }

    public static <T> CommonRes<T> failed(CommonRes<?> source) {
        return failed(source.getMessage(), source.getStatus());
    }


    public static final int status_other = -1;
    public static final int status_success = 0;
    public static final int status_timeout = 1;
}
