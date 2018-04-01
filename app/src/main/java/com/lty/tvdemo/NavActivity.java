package com.lty.tvdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lty.tvdemo.adapter.NavAdapter;
import com.lty.tvdemo.adapter.SpacesItemDecoration;
import com.lty.tvdemo.adapter.TianchiAdapter;
import com.lty.tvdemo.domain.Navigation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2018/3/31.
 * Version : 1.0
 * Description :
 */
public class NavActivity extends Activity {


    RecyclerView rv;
    RecyclerView rv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        rv = findViewById(R.id.rv);
        rv1 = findViewById(R.id.rv1);


        String[] title = {"电影", "电视剧", "综艺", "纪录片", "VIP", "123", "V I P", "动漫", "党建", "新闻","生活"};

        List<Navigation> data = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Navigation nav = new Navigation();
            nav.name = title[i];
            data.add(nav);
        }
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv.addItemDecoration(new SpacesItemDecoration(20));
        rv.setAdapter(new NavAdapter(data));


        rv1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //rv1.addItemDecoration(new SpacesItemDecoration(20));
        rv1.setAdapter(new TianchiAdapter(data));
    }
}
