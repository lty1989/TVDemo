package com.lty.tvdemo.mytest;

import java.util.List;

/**
 * Created by andy on 2018/4/30.
 * Version : 1.0
 * Description :
 */
public class DataModel<T> {

    private int type;

    private List<T> data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
