package com.lqq.tree.recyclerview.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * 共通的 RecyclerView.ViewHolder
 * 适用于：ViewBinding
 */
public class CommonViewBindHolder extends RecyclerView.ViewHolder {
    public ViewBinding mBinding;

    public CommonViewBindHolder(ViewBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }
}
