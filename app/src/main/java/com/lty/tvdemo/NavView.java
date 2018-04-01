package com.lty.tvdemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;

/**
 * Created by andy on 2018/3/31.
 * Version : 1.0
 * Description :
 */
public class NavView extends android.support.v7.widget.AppCompatTextView {
    public NavView(Context context) {
        super(context);
        init();
    }

    public NavView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NavView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setGravity(Gravity.CENTER);
        setTextColor(Color.WHITE);
        setTextSize(TypedValue.COMPLEX_UNIT_PX, 42);
    }

    public void setText(String value) {
        TextPaint newPaint = getPaint();
        newPaint.setTextSize(45);
        float newPaintWidth = newPaint.measureText(value);
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.width = Math.round(newPaintWidth);
        super.setText(value);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            setBackgroundResource(R.drawable.fragment_home_navigation_bg);
            setTextSize(TypedValue.COMPLEX_UNIT_PX, 45);
        } else {
            setBackgroundColor(Color.TRANSPARENT);
            setTextSize(TypedValue.COMPLEX_UNIT_PX, 42);
        }
    }


}
