package com.lty.tvdemo.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.lty.tvdemo.NavView;
import com.lty.tvdemo.R;
import com.lty.tvdemo.domain.Navigation;
import com.lty.tvdemo.utils.UIUtil;
import com.lty.tvdemo.view.MyLinearLayout;

import java.util.List;

/**
 * Created by andy on 2018/3/31.
 * Version : 1.0
 * Description :
 */
public class TianchiAdapter extends RecyclerView.Adapter<TianchiAdapter.ViewHolder> {


    public static final int TYPE_6 = 6;
    public static final int TYPE_3 = 3;
    public static final int TYPE_2 = 2;
    public static final int TYPE_1 = 1;

    private List<Navigation> data;

    public TianchiAdapter(List<Navigation> data) {
        this.data = data;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private Button btn1;

        public ViewHolder(View itemView) {
            super(itemView);
            btn1 = itemView.findViewById(R.id.btn1);
        }
    }


    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tianchi_list_item_6, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(200, 100);
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.navView.setText(data.get(position).name);
    }


    @Override

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {

        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();

        if (manager instanceof GridLayoutManager) {

            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;

            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

                @Override

                public int getSpanSize(int position) {

                    int type = getItemViewType(position);

                    switch (type) {
                        case TYPE_6:
                            return 1;
                        case TYPE_3:
                            return 2;
                        case TYPE_2:
                            return 3;
                    }
                    return 6;
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (TYPE_6 == data.get(position).spec) {
            return TYPE_6;
        } else if (TYPE_3 == data.get(position).spec) {
            return TYPE_3;
        } else if (TYPE_2 == data.get(position).spec) {
            return TYPE_2;
        } else if (TYPE_1 == data.get(position).spec) {
            return TYPE_1;
        }

        return super.getItemViewType(position);
    }
}
