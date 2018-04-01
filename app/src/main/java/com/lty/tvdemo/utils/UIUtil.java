package com.lty.tvdemo.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by andy on 2018/4/1.
 * Version : 1.0
 * Description :
 */
public class UIUtil {

    public static int sSTAND_WIDTH = 1920;
    public static int sSTAND_HEIGHT = 1080;

    private static int sScreenWidth;
    private static int sScreenHeigth;

    public static int getScreenWidth(Context ctx) {
        if (sScreenWidth == 0) {
            setUp(ctx);
        }
        return sScreenWidth;
    }

    public static int getScreenHeight(Context ctx) {
        if (sScreenHeigth == 0) {
            setUp(ctx);
        }
        return sScreenHeigth;
    }

    private static void setUp(Context ctx) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        sScreenWidth = dm.widthPixels;
        sScreenHeigth = dm.heightPixels;
    }

}
