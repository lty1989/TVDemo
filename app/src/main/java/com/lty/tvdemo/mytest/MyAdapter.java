package com.lty.tvdemo.mytest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lty.tvdemo.R;

import java.util.List;

/**
 * Created by andy on 2018/4/30.
 * Version : 1.0
 * Description :
 */
public class MyAdapter extends RecyclerView.Adapter {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_SIX = 6;


    private List<DataModel> data;

    public MyAdapter(List<DataModel> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        ViewHolder viewHolder = null;
        if (viewType == TYPE_ONE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mytest_list_item_one, parent, false);
            viewHolder = new OneViewHolder(view);
        } else if (viewType == TYPE_TWO) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mytest_list_item_two, parent, false);
            viewHolder = new TwoViewHolder(view);
        } else if (viewType == TYPE_THREE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mytest_list_item_three, parent, false);
            viewHolder = new ThreeViewHolder(view);
        } else if (viewType == TYPE_SIX) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mytest_list_item_six, parent, false);
            viewHolder = new SixViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    class OneViewHolder extends ViewHolder {

        private TextView view1;

        public OneViewHolder(View itemView) {
            super(itemView);
            view1 = itemView.findViewById(R.id.view1);
        }
    }

    class TwoViewHolder extends ViewHolder {

        private MyButton view1;
        private MyButton view2;

        public TwoViewHolder(View itemView) {
            super(itemView);
            view1 = itemView.findViewById(R.id.view1);
            view2 = itemView.findViewById(R.id.view2);
        }
    }

    class ThreeViewHolder extends ViewHolder {

        private MyButton view1;
        private MyButton view2;
        private MyButton view3;

        public ThreeViewHolder(View itemView) {
            super(itemView);
            view1 = itemView.findViewById(R.id.view1);
            view2 = itemView.findViewById(R.id.view2);
            view3 = itemView.findViewById(R.id.view3);
        }
    }

    class SixViewHolder extends ViewHolder {

        private MyButton view1;
        private MyButton view2;
        private MyButton view3;
        private MyButton view4;
        private MyButton view5;
        private MyButton view6;

        public SixViewHolder(View itemView) {
            super(itemView);
            view1 = itemView.findViewById(R.id.view1);
            view2 = itemView.findViewById(R.id.view2);
            view3 = itemView.findViewById(R.id.view3);
            view4 = itemView.findViewById(R.id.view4);
            view5 = itemView.findViewById(R.id.view5);
            view6 = itemView.findViewById(R.id.view6);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (TYPE_ONE == data.get(position).getType()) {
            return TYPE_ONE;
        } else if (TYPE_TWO == data.get(position).getType()) {
            return TYPE_TWO;
        } else if (TYPE_THREE == data.get(position).getType()) {
            return TYPE_THREE;
        } else if (TYPE_SIX == data.get(position).getType()) {
            return TYPE_SIX;
        }
        return super.getItemViewType(position);
    }
}
