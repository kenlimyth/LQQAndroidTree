# LQQ类库

#### 介绍

类库模块介绍：
LQQLib 		--总类库
AMaplib 			--高德地图
doubledatepicker 	--双日历日期选择
zxinglibrary 		--扫描
imageselector		--图片选择器
//NBZxing扫码优化库
include ':module_camera'
include ':module_grayscale'



常用插件
GsonFormatPlus 	--格式化json成bean
ScreenMatch 	--屏幕适配
statistic       --代码统计





#### 项目依赖
方式一：依赖到项目(推荐)
settings.gradle添加：

include ':LQQAndroid'
project(':LQQAndroid').projectDir = new File(settingsDir,'../../LQQAndroid')
include ':LQQAndroid:LQQLib'
项目引用（build.gradle添加）：implementation project(path: ':LQQAndroid:LQQLib')

方式二：直接依赖到类库
settings.gradle添加：

    include ':LQQLib'
    project(':LQQLib').projectDir= new File("../../LQQAndroid", 'LQQLib')
项目引用（build.gradle添加）：implementation project(path: ':LQQLib')








#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

