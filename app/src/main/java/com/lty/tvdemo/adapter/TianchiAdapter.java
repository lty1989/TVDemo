package com.lty.tvdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lty.tvdemo.NavView;
import com.lty.tvdemo.R;
import com.lty.tvdemo.domain.Navigation;
import com.lty.tvdemo.view.MyLinearLayout;

import java.util.List;

/**
 * Created by andy on 2018/3/31.
 * Version : 1.0
 * Description :
 */
public class TianchiAdapter extends RecyclerView.Adapter<TianchiAdapter.ViewHolder> {


    private List<Navigation> data;

    public TianchiAdapter(List<Navigation> data) {
        this.data = data;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private Button btn1;
        private Button btn2;
        private MyLinearLayout btn3;

        public ViewHolder(View itemView) {
            super(itemView);
            btn1 = itemView.findViewById(R.id.btn1);
            btn2 = itemView.findViewById(R.id.btn2);
            btn3 = itemView.findViewById(R.id.btn3);
        }
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tianchi_list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.navView.setText(data.get(position).name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
