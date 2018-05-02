/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.lty.tvdemo.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lty.tvdemo.R;

import java.util.ArrayList;
import java.util.List;

/*
 * MainActivity class that loads {@link MainFragment}.
 */
public class MyTestActivity extends Activity {

    private ScaleRecyclerView rv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytest);


        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        List<DataModel> data = new ArrayList<>();


        add(data, MyAdapter.TYPE_TWO);
        add(data, MyAdapter.TYPE_THREE);
        add(data, MyAdapter.TYPE_ONE);
        add(data, MyAdapter.TYPE_THREE);
        add(data, MyAdapter.TYPE_TWO);
        add(data, MyAdapter.TYPE_THREE);
        add(data, MyAdapter.TYPE_THREE);
        add(data, MyAdapter.TYPE_ONE);
        add(data, MyAdapter.TYPE_THREE);
        add(data, MyAdapter.TYPE_TWO);
        add(data, MyAdapter.TYPE_THREE);
        add(data, MyAdapter.TYPE_SIX);
        add(data, MyAdapter.TYPE_ONE);
        add(data, MyAdapter.TYPE_SIX);
        add(data, MyAdapter.TYPE_SIX);
        add(data, MyAdapter.TYPE_ONE);
        add(data, MyAdapter.TYPE_THREE);
        add(data, MyAdapter.TYPE_SIX);

        rv.addItemDecoration(new ItemDecoration(20));
        rv.setAdapter(new com.lty.tvdemo.mytest.MyAdapter(data));


        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                //当前RecyclerView显示出来的最后一个的item的position
                int lastPosition = -1;
                //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager instanceof GridLayoutManager) {
                        //通过LayoutManager找到当前显示的最后的item的position
                        lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof LinearLayoutManager) {
                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    // 时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                    //如果相等则说明已经滑动到最后了
                    //发送一条广播通知更新数据
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                        Log.d("rv", "lastPosition-->" + lastPosition);
                        add(data, MyAdapter.TYPE_SIX);
                        rv.getAdapter().notifyItemRangeChanged(lastPosition, 6);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            }
        });
    }

    public void add(List<DataModel> data, int type) {
        int len = 0;
        switch (type) {
            case MyAdapter.TYPE_ONE:
                len = 1;
                break;
            case MyAdapter.TYPE_TWO:
                len = 2;
                break;
            case MyAdapter.TYPE_THREE:
                len = 3;
                break;
        }
        DataModel<String> dataModel = new DataModel<>();
        dataModel.setType(type);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String s = "";
            list.add(s);
        }
        dataModel.setData(list);
        data.add(dataModel);
    }


}
