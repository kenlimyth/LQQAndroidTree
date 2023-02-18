package com.lqq.tree.recyclerview.tree;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lqq.tree.R;
import com.lqq.tree.recyclerview.tree.adapter.TreeAdapter;
import com.lqq.tree.recyclerview.tree.bean.TreeBean;
import com.lqq.tree.recyclerview.util.RecyclerViewDivider;

import java.util.ArrayList;

/**
 * 树形结构，无限层分类
 */
public class RecyclerViewTreeDemo extends AppCompatActivity {

    RecyclerView recyclerView;
    TreeAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);


        //模拟数据
        TreeBean treeBean = new TreeBean(1 + "", "root", 0,  new ArrayList<>());

        treeBean.children.add(new TreeBean("22", "一层1", 1,  new ArrayList<>()));
        treeBean.children.add(new TreeBean("22", "一层2", 1, new ArrayList<>()));

        treeBean.children.get(0).children.add(new TreeBean("33", "二层", 2, new ArrayList<>()));
        treeBean.children.get(0).children.get(0).children.add(new TreeBean("44", "三层", 3,  new ArrayList<>()));
        treeBean.children.get(0).children.get(0).children.get(0).children.add(new TreeBean("44", "四层", 4, new ArrayList<>()));
        treeBean.children.get(0).children.get(0).children.get(0).children.get(0).children.add(new TreeBean("44", "五层", 5, new ArrayList<>()));

        treeBean.children.get(1).children.add(new TreeBean("33", "二层", 2, new ArrayList<>()));



        recyclerView = findViewById(R.id.recycler_view);

        treeBean.children.get(0).setShowAll(true);//设置默认打开，关闭
        treeBean.children.get(1).setShowAll(false);
        initLinearRecyclerView(this, recyclerView, 0, R.color.white);
        recyclerViewAdapter = new TreeAdapter(this, treeBean);
        recyclerView.setAdapter(recyclerViewAdapter);


    }

    public static void initLinearRecyclerView(Context context, RecyclerView view, float dividerHeight, int color) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);// 设置 recyclerview 布局方式为横向布局
        RecyclerViewDivider divider = new RecyclerViewDivider(context, LinearLayout.VERTICAL, dp2Px((int) dividerHeight), ContextCompat.getColor(context, color));
        view.setLayoutManager(linearLayoutManager);
        view.addItemDecoration(divider);
        view.setHasFixedSize(true);
        view.setNestedScrollingEnabled(false);
    }


    public static int dp2Px(int dp) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return Math.round(dp * displayMetrics.density);
    }

    @SuppressLint("WrongConstant")
    public static void showToast(Context context, String msg) {
        if (context == null) {
            return;
        }
//        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
