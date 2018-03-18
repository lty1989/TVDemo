package com.lty.tvdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> list;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    /**
     * 返回需要展示的fragment
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    /**
     * 返回需要展示的fangment数量
     *
     * @return
     */
    @Override
    public int getCount() {
        return list.size();
    }
}