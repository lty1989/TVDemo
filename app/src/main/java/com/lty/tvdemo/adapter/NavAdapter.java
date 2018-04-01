package com.lty.tvdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lty.tvdemo.NavView;
import com.lty.tvdemo.R;
import com.lty.tvdemo.domain.Navigation;

import java.util.List;

/**
 * Created by andy on 2018/3/31.
 * Version : 1.0
 * Description :
 */
public class NavAdapter extends RecyclerView.Adapter<NavAdapter.ViewHolder> {


    private List<Navigation> data;

    public NavAdapter(List<Navigation> data) {
        this.data = data;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private NavView navView;

        public ViewHolder(View itemView) {
            super(itemView);
            navView = itemView.findViewById(R.id.nav);
        }
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.navView.setText(data.get(position).name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
