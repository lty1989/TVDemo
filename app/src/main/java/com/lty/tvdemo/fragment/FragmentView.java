package com.lty.tvdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lty.tvdemo.R;

public class FragmentView extends Fragment {

    private Bundle arg;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arg = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);
        TextView tv = view.findViewById(R.id.tv);
        int page = arg.getInt("pager_num");

        if (page == 1) {
            view.setBackgroundResource(android.R.color.black);
        } else if (page == 2) {
            view.setBackgroundResource(android.R.color.holo_green_dark);
        } else if (page == 3) {
            view.setBackgroundResource(android.R.color.holo_red_dark);
        } else if (page == 4) {
            view.setBackgroundResource(android.R.color.holo_blue_dark);
        }
        tv.setText(arg.getString("Title"));
        return view;
    }


    public static FragmentView newInstance(Bundle args) {
        FragmentView fragment = new FragmentView();
        fragment.setArguments(args);
        return fragment;
    }
}
