package com.lty.tvdemo.mytest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lty.tvdemo.R;

/**
 * Created by andy on 2018/4/30.
 * Version : 1.0
 * Description :
 */
@SuppressLint("AppCompatCustomView")
public class MyButton extends FrameLayout {

    private ImageView btn;

    private int GAP = 5;

    public MyButton(Context context) {
        super(context);
        init();
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setFocusable(true);
        setPadding(GAP, GAP, GAP, GAP);
        setBackgroundColor(Color.TRANSPARENT);

        btn = new ImageView(getContext());
        btn.setScaleType(ImageView.ScaleType.FIT_XY);
        btn.setImageResource(R.drawable.app_icon_your_company);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        btn.setLayoutParams(lp);
        addView(btn);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            AniUtil.getInstance().da(this);
            setBackgroundColor(Color.WHITE);
        } else {
            AniUtil.getInstance().xiao(this);
            setBackgroundColor(Color.TRANSPARENT);

        }


    }
}
