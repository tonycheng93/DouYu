package com.sky.douyu.entity;

/**
 * Created by tonycheng on 2016/10/11.
 */

public class HttpResult<T> {

    private int error;
    private T data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
