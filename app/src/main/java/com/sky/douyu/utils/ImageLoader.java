package com.sky.douyu.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by tonycheng on 2016/10/11.
 */

public class ImageLoader {

    public static void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
