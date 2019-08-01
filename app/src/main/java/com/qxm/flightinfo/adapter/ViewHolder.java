package com.qxm.flightinfo.adapter;


import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Administrator on 16-7-18.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    public ViewHolder(View itemView) {
        super(itemView);
    }

}