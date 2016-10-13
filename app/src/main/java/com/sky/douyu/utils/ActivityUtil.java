package com.sky.douyu.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by tonycheng on 2016/10/13.
 */

public class ActivityUtil {

    public static void addFragmentToActivity(FragmentManager manager, Fragment fragment, int containerId) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.commit();
    }
}
