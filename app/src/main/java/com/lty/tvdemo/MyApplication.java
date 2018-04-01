package com.lty.tvdemo;

import android.app.Application;

/**
 * Created by andy on 2018/4/1.
 * Version : 1.0
 * Description :
 */
public class MyApplication extends Application {
    static MyApplication mContext;

    public static MyApplication getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

}
