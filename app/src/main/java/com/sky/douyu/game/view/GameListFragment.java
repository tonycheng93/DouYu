package com.sky.douyu.game.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sky.douyu.R;
import com.sky.douyu.entity.game.GameList;
import com.sky.douyu.game.GameAdapter;
import com.sky.douyu.game.presenter.IGamePresenter;
import com.sky.douyu.game.presenter.impl.GamePresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameListFragment extends Fragment
        implements IGameListView, SwipeRefreshLayout.OnRefreshListener,
        GameAdapter.OnItemClickListener {

    private static final String TAG = "GameListFragment";

    private IGamePresenter mIGamePresenter;

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private GameAdapter mAdapter;

    private List<GameList> mData;

    public GameListFragment() {
        // Required empty public constructor
    }

    public static GameListFragment getInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        GameListFragment fragment = new GameListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIGamePresenter = new GamePresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_game_list, container, false);
        mRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_widget);
        mRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        mRefreshLayout.setOnRefreshListener(this);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GameAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(this);

        onRefresh();

        return rootView;
    }

    @Override
    public void showProgress() {
        mRefreshLayout.setRefreshing(true);
    }

    @Override
    public void addGames(List<GameList> gameList) {
        mAdapter.isShowFooter(true);
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.addAll(gameList);
        mAdapter.setData(mData);
    }

    @Override
    public void hideProgress() {
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showLoadFailMsg() {

    }

    @Override
    public void onRefresh() {
        if (mData != null) {
            mData.clear();
        }
        mIGamePresenter.loadGameList();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
    }
}
