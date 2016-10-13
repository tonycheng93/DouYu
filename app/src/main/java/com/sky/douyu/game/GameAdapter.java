package com.sky.douyu.game;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sky.douyu.R;
import com.sky.douyu.entity.game.GameList;
import com.sky.douyu.utils.ImageLoader;

import java.util.List;

/**
 * Created by tonycheng on 2016/10/13.
 */

public class GameAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private Context mContext;
    private List<GameList> mData;
    private boolean isShowFooter = true;
    private OnItemClickListener mOnItemClickListener;

    public GameAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        //最后一个item设置为footerView
        if (!isShowFooter) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View rootView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_game_list, parent, false);
            ItemViewHolder holder = new ItemViewHolder(rootView);
            return holder;
        } else {
            View rootView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.footer, null);
            rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            FooterViewHolder holder = new FooterViewHolder(rootView);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            GameList gameList = mData.get(position);
            if (gameList == null) {
                return;
            }

            ImageLoader.display(mContext, gameList.getGame_src(),
                    ((ItemViewHolder) holder).mIvIamge);
            ((ItemViewHolder) holder).mTvName.setText(gameList.getGame_name());
        }
    }

    public void setData(List<GameList> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    public GameList getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    @Override
    public int getItemCount() {

        int begin = isShowFooter() ? 1 : 0;
        if (mData == null) {
            return begin;
        }
        return mData.size() + begin;
    }

    public boolean isShowFooter() {
        return isShowFooter;
    }

    public void isShowFooter(boolean isShowFooter) {
        this.isShowFooter = isShowFooter;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private ImageView mIvIamge;
        private TextView mTvName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mIvIamge = (ImageView) itemView.findViewById(R.id.ivImage);
            mTvName = (TextView) itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }
}
