package com.sky.douyu.game.presenter.impl;

import com.sky.douyu.entity.game.GameList;
import com.sky.douyu.game.model.IGameModel;
import com.sky.douyu.game.model.impl.GameModelImpl;
import com.sky.douyu.game.presenter.IGamePresenter;
import com.sky.douyu.game.view.IGameListView;
import com.sky.douyu.utils.Debugger;

import java.util.List;

/**
 * Created by tonycheng on 2016/10/12.
 */

public class GamePresenterImpl implements IGamePresenter,
        GameModelImpl.OnLoadGameListListener {

    private static final String TAG = "GamePresenterImpl";

    private IGameModel mIGameModel;
    private IGameListView mIGameListView;

    public GamePresenterImpl(IGameListView gameListView) {
        this.mIGameListView = gameListView;
        mIGameModel = new GameModelImpl();
    }

    @Override
    public void loadGameList() {
        mIGameListView.showProgress();
        mIGameModel.loadGameList(this);
    }

    @Override
    public void onSuccess(List<GameList> gameList) {
        Debugger.d(TAG, gameList.toString());
        mIGameListView.addGames(gameList);
        mIGameListView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mIGameListView.hideProgress();
        mIGameListView.showLoadFailMsg();
    }
}
