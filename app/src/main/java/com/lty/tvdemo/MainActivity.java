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

package com.lty.tvdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
 * MainActivity class that loads {@link MainFragment}.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main1);


        ImageCardView icv;
        HeaderItem item = new HeaderItem(0L, "");

        //HorizontalGridView gv = findViewById(R.id.gv);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("热门推荐" + i);
        }
//        data.add("热门推荐");
//        data.add("萌宠");
//        data.add("生活");
//        data.add("经济");
//        data.add("运动");
        // gv.setAdapter(new MyAdapter(data));}
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


        private List<String> data;

        public MyAdapter(List<String> data) {
            this.data = data;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public Button tv_text;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_text = (Button) itemView.findViewById(R.id.tv);
            }
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.activity_list_item, null);
            ViewHolder holder = new ViewHolder(inflate);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv_text.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
