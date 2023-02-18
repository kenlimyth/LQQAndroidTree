package com.lqq.tree.recyclerview.tree.adapter;

import static com.lqq.tree.recyclerview.tree.RecyclerViewTreeDemo.showToast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.lqq.tree.R;
import com.lqq.tree.databinding.ItemTreeBinding;
import com.lqq.tree.recyclerview.adapter.CommonViewBindHolder;
import com.lqq.tree.recyclerview.tree.bean.TreeBean;


/**
 * 树形适配器
 */
public class TreeAdapter extends RecyclerView.Adapter<CommonViewBindHolder> {


    private Context mContext;
    private TreeBean list;

    public TreeAdapter(Context context, TreeBean list) {
        mContext = context;
        this.list = list;
    }

    public void setBeans(TreeBean mBeans) {
        this.list = mBeans;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewBindHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTreeBinding binding = ItemTreeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CommonViewBindHolder myHolder = new CommonViewBindHolder(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(CommonViewBindHolder holder, @SuppressLint("RecyclerView") int position) {
        ItemTreeBinding databind = (ItemTreeBinding) holder.mBinding;

        TreeBean treeBean = list.getTreeItem(position + 1);
        databind.tvName.setText(treeBean.name);

        if (treeBean.children == null || treeBean.children.size() == 0) {
            databind.ivXjt.setImageResource(R.mipmap.yjt);
            databind.llContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showToast(mContext,"over");

                }
            });
        } else {
            databind.ivXjt.setImageResource(R.mipmap.xjt);
            databind.llContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!treeBean.childrenIsHide()) {
                        treeBean.setShowAll(false);
                    } else {
                        treeBean.setShow(true);
                    }
                    notifyDataSetChanged();

                }
            });
        }

        //层级缩进，根据leave层级
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) databind.ivXjt.getLayoutParams();
        layoutParams.leftMargin = treeBean.leave * 30;
        ;
        databind.ivXjt.setLayoutParams(layoutParams);


        if (treeBean.isShow) {
            databind.llContainer.setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = 20;
            databind.llContainer.setLayoutParams(params);
        } else {
            databind.llContainer.setVisibility(View.GONE);
            databind.llContainer.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
    }


    @Override
    public int getItemCount() {
        return null == list ? 0 : list.getSumOfChildren();
    }

}
