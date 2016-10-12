package com.sky.douyu.game.view;

import com.sky.douyu.entity.game.GameList;

import java.util.List;

/**
 * Created by tonycheng on 2016/10/12.
 */

public interface IGameListView {

    void showProgress();

    void addGames(List<GameList> gameList);

    void hideProgress();

    void showLoadFailMsg();
}
