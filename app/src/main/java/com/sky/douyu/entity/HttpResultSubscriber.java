package com.sky.douyu.entity;

import com.sky.douyu.utils.Debugger;

import rx.Subscriber;

/**
 * Created by tonycheng on 2016/10/12.
 */

public abstract class HttpResultSubscriber<T> extends
        Subscriber<HttpResult<T>> {

    @Override
    public void onNext(HttpResult<T> httpResult) {
        if (httpResult.getError() == 0) {
            Debugger.d(httpResult.toString());
            onSuccess(httpResult);
        } else {
            onFail(new Throwable("error = " + httpResult.getError()));
        }
    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
    }

    @Override
    public void onCompleted() {
    }

    public abstract void onSuccess(HttpResult<T> t);

    public abstract void onFail(Throwable e);
}
