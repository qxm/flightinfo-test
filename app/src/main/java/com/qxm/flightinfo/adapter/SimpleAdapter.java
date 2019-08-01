package com.qxm.flightinfo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpleAdapter<T> extends RecyclerView.Adapter<ViewHolder>{

    private List<T> mDatas;

    private int layoutId;

    private int brId;

    public SimpleAdapter(List<T> mDatas, int layoutId, int brId) {
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        this.brId = brId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        android.util.Log.d("ViewHolder","---------------------------------onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(binding.getRoot());
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        android.util.Log.d("ViewHolder","---------------------------------onBindViewHolder");
        holder.getBinding().setVariable(brId,mDatas.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void refreshData(List<T> data) {
        android.util.Log.d("ViewHolder","---------------------------------rereshData");
        mDatas.clear();
        mDatas.addAll(data);
        notifyDataSetChanged();
    }

    public void loadMoreData(List<T> data) {
        mDatas.addAll(data);
        notifyDataSetChanged();
    }
}

