package com.sky.douyu.game.model.impl;

import com.sky.douyu.entity.HttpResult;
import com.sky.douyu.entity.game.GameList;
import com.sky.douyu.game.model.IGameModel;
import com.sky.douyu.network.ApiService;
import com.sky.douyu.network.HttpResultSubscriber;
import com.sky.douyu.network.RetrofitClient;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tonycheng on 2016/10/12.
 */

public class GameModelImpl implements IGameModel {


    @Override
    public void loadGameList(final OnLoadGameListListener listener) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();

        Observable<HttpResult<List<GameList>>> gameList = apiService.getGameList();
        gameList
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpResultSubscriber<List<GameList>>() {
                    @Override
                    public void onSuccess(HttpResult<List<GameList>> t) {
                        listener.onSuccess(t.getData());
                    }

                    @Override
                    public void onFail(Throwable e) {
                        listener.onFailure(e);
                    }
                });
    }

    public interface OnLoadGameListListener {

        void onSuccess(List<GameList> gameList);

        void onFailure(Throwable e);
    }
}
