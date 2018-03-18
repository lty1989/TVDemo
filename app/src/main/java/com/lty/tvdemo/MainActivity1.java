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


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.lty.tvdemo.fragment.FragmentView;
import com.lty.tvdemo.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 * MainActivity class that loads {@link MainFragment}.
 */
public class MainActivity1 extends FragmentActivity {

    ViewPager viewPager;
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //setContentView(R.layout.activity_main2);
        viewPager = (ViewPager) findViewById(R.id.vp);
        btn = (Button) findViewById(R.id.btn);
        initData();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = viewPager.getCurrentItem();
                int total = viewPager.getChildCount();
                int currentIndex = (index + 1 >= 4) ? (index + 1) % total : index + 1;
                viewPager.setCurrentItem(currentIndex);
            }
        });

    }

    public void initData() {

        List<Fragment> list = new ArrayList<>();

        Bundle bundle1 = new Bundle();
        bundle1.putString("Title", "第一个Fragment");
        bundle1.putInt("pager_num", 1);
        Fragment fg1 = FragmentView.newInstance(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putString("Title", "第二个Fragment");
        bundle2.putInt("pager_num", 2);
        Fragment fg2 = FragmentView.newInstance(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putString("Title", "第三个Fragment");
        bundle3.putInt("pager_num", 3);
        Fragment fg3 = FragmentView.newInstance(bundle3);

        Bundle bundle4 = new Bundle();
        bundle4.putString("Title", "第四个Fragment");
        bundle4.putInt("pager_num", 4);
        Fragment fg4 = FragmentView.newInstance(bundle4);

        list.add(fg1);
        list.add(fg2);
        list.add(fg3);
        list.add(fg4);

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), list));

    }


}
