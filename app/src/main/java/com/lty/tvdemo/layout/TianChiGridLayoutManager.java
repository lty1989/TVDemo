package com.lty.tvdemo.layout;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by andy on 2018/4/15.
 * Version : 1.0
 * Description :
 */
public class TianChiGridLayoutManager extends GridLayoutManager {

    private final String TAG = "TianChiGrid";


    public TianChiGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public TianChiGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public TianChiGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public View onInterceptFocusSearch(View focused, int direction) {
        Log.i(TAG, "onInterceptFocusSearch , focused = " + focused + " direction = " + direction);
        int count = getItemCount();
        int fromPos = getPosition(focused);
        int span = getSpanSizeLookup().getSpanSize(fromPos);
        Log.i(TAG, "onInterceptFocusSearch , span = " + span + " fromPos = " + fromPos);
        switch (direction) {
            case View.FOCUS_UP:
                fromPos = (fromPos - span);
                break;
            case View.FOCUS_DOWN:
                fromPos = (fromPos + span);
                break;
            case View.FOCUS_RIGHT:
                fromPos++;
                break;
            case View.FOCUS_LEFT:
                fromPos--;
                break;
        }

        Log.d(TAG, "onInterceptFocusSearch , fromPos = " + fromPos + " count = " + count + " span = " + span);
        if (fromPos < 0) {
            return focused;
        } else if (fromPos >= count) {
            return focused;
        } else {
            return findViewByPosition(fromPos);
            //            return getChildAt(fromPos);
        }
    }
}