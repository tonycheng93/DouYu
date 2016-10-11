package com.sky.douyu.game;

import com.sky.douyu.entity.BaseWrapper;
import com.sky.douyu.entity.game.GameList;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by tonycheng on 2016/10/11.
 */

public interface ApiService {
    @GET("/game")
    Observable<BaseWrapper<List<GameList>>> getGameList();
}
