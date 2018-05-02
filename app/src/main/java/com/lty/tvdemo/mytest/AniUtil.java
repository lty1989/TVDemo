package com.lty.tvdemo.mytest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by andy on 2018/4/30.
 * Version : 1.0
 * Description :
 */
public class AniUtil {

    AnimatorSet animatorSet;
    static AniUtil instance = new AniUtil();


    public static AniUtil getInstance() {
        return instance;
    }


    public void da(View view) {
        if (animatorSet == null) {
            animatorSet = new AnimatorSet();
        }
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.2f, 1.15f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.2f, 1.15f);
        if (!animatorSet.isRunning()) {
            animatorSet.setDuration(800);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
            animatorSet.start();
            animatorSet = null;
        }
    }

    public void xiao(View view) {
        if (animatorSet == null) {
            animatorSet = new AnimatorSet();
        }
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.15f, 0.95f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.15f, 0.95f, 1f);
        if (!animatorSet.isRunning()) {
            animatorSet.setDuration(800);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
            animatorSet.start();
            animatorSet = null;
        }
    }
}
