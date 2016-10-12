package com.sky.douyu.network;

import com.sky.douyu.config.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonycheng on 2016/10/12.
 */

public class RetrofitClient {

    private static volatile RetrofitClient instance = null;

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private ApiService mApiService;

    //私有化构造函数
    private RetrofitClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiService = mRetrofit.create(ApiService.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    public ApiService getApiService(){
        return mApiService;
    }
}
