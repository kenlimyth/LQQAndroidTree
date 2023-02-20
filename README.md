---

typora-root-url: ./
---

# LQQAndroidTree

#### 介绍

### **一个控件，无限级分类的树形结构**



![](/5efbd02757d3c1180a1dbb81a345b1f5.gif)

### 使用说明：开箱即用，直接运行项目即可。RecyclerViewTreeDemo里有详细的使用例子。

```
//模拟数据，接口接收到数据按下面的结构填充bean即可
TreeBean treeBean = new TreeBean(1 + "", "root", 0,  new ArrayList<>());
treeBean.children.add(new TreeBean("22", "一层", 1,  new ArrayList<>()));
treeBean.children.get(0).children.add(new TreeBean("33", "二层", 2, new ArrayList<>()));
treeBean.children.get(0).children.get(0).children.add(new TreeBean("44", "三层", 3,  new ArrayList<>()));



```

### 设置默认打开，关闭

```
treeBean.children.get(0).setShowAll(false);//设置默认打开，关闭
```

### 关键代码

```
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
```

```
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
```
