package com.sky.douyu.game.model;

import com.sky.douyu.game.model.impl.GameModelImpl;

/**
 * Created by tonycheng on 2016/10/12.
 */

public interface IGameModel {

    void loadGameList(GameModelImpl.OnLoadGameListListener listener);
}
