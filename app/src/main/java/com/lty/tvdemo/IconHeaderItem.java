package com.lty.tvdemo;

import android.support.v17.leanback.widget.HeaderItem;

/**
 * Created by andy on 2018/3/6.
 * Version : 1.0
 * Description :
 */

public class IconHeaderItem extends HeaderItem {
    public static final int ICON_NONE = -1;

    /**
     * Hold an icon resource id
     */
    private int mIconResId = ICON_NONE;

    public IconHeaderItem(long id, String name, int iconResId) {
        super(id, name);
        mIconResId = iconResId;
    }

    public IconHeaderItem(long id, String name) {
        this(id, name, ICON_NONE);
    }

    public IconHeaderItem(String name) {
        super(name);
    }

    public int getIconResId() {
        return mIconResId;
    }

    public void setIconResId(int iconResId) {
        this.mIconResId = iconResId;
    }


}
