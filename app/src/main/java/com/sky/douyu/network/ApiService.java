package com.sky.douyu.network;

import com.sky.douyu.entity.HttpResult;
import com.sky.douyu.entity.game.GameList;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by tonycheng on 2016/10/12.
 */

public interface ApiService {

    @GET("/game")
    Observable<HttpResult<List<GameList>>> getGameList();
}
