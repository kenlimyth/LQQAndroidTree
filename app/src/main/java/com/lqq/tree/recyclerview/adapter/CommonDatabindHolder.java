package com.lqq.tree.recyclerview.adapter;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 共通的 RecyclerView.ViewHolder
 * 适用于：DataBinding
 */
public class CommonDatabindHolder extends RecyclerView.ViewHolder {
    public ViewDataBinding mBinding;

    public CommonDatabindHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }
}
