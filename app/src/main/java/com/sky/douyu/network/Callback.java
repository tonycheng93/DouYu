package com.sky.douyu.network;

import com.sky.douyu.entity.BaseWrapper;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by tonycheng on 2016/10/11.
 */

public abstract class Callback<T extends BaseWrapper>
        implements retrofit2.Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.body().getError() == 0) {//0表示成功

        } else if (response.body().getError() == 501) {//不存在此分类

        } else if (response.body().getError() == 999) {//接口维护中

        } else {//失败响应
            onFailure(call, new RuntimeException("response error,detail = "
                    + response.raw().toString()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
