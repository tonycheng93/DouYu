package com.sky.douyu.entity;

import com.sky.douyu.entity.game.GameList;

import java.util.List;

/**
 * Created by tonycheng on 2016/10/11.
 */

public class BaseWrapper {

    private int error;
    private List<GameList> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<GameList> getData() {
        return data;
    }

    public void setData(List<GameList> data) {
        this.data = data;
    }
}
