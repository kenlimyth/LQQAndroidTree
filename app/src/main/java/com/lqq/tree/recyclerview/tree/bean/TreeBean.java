package com.lqq.tree.recyclerview.tree.bean;

import java.util.List;

/**
 * 树形bean
 *
 * @author ken
 * @date 2023/2/17 13:27
 */
public class TreeBean {
    public String name;
    public String id;
    public List<TreeBean> children;
    public int leave;
    public String parentId;
    public boolean isShow = true;

    public TreeBean(String id, String name, int leave, List<TreeBean> child) {
        this.id = id;
        this.name = name;
        this.leave = leave;
        this.children = child;

    }

    /**
     * 设置所有的子类显示/隐藏
     *
     * @param b
     */
    public void setShowAll(boolean b) {
        if (children == null) {
            return;
        }
        for (TreeBean skillTree : children) {
            skillTree.isShow = b;
            skillTree.setShowAll(b);
        }
    }

    /**
     * 设置子类显示/隐藏
     *
     * @param b
     */
    public void setShow(boolean b) {
        if (children == null) {
            return;
        }
        for (TreeBean skillTree : children) {
            skillTree.isShow = b;
        }
    }

    /**
     * 子类是否隐藏
     *
     * @return
     */
    public boolean childrenIsHide() {
        if (children == null) {
            return true;
        }
        for (TreeBean skillTree : children) {
            if (!skillTree.isShow) {
                return true;
            }

        }
        return false;
    }

    /**
     * 子类总数
     *
     * @return
     */
    public int getSumOfChildren() {
        if (children == null) {
            return 0;
        }
        int size = children.size();
        if (size == 0) {
            return 0;
        }
        int sum = size;
        for (TreeBean item : children) {
            sum += item.getSumOfChildren();
        }
        return sum;
    }

    /**
     * 牛逼算法，根据树形顺序位置数取出对应的bean
     *
     * @param position
     * @return
     */
    public TreeBean getTreeItem(int position) {
        if (position == 0) {
            return this;
        }
        if (position < 0) {
            return null;
        }
        for (TreeBean item : children) {
            position--;
            if (position == 0) {
                return item;
            }
            int num = item.getSumOfChildren();
            if (position <= num) {
                return item.getTreeItem(position);
            }
            position -= num;
        }
        return null;
    }

}

