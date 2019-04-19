# LuckyPan 幸运抽奖转盘
## 效果图
![效果图](https://github.com/xiaomabenteng2015/LuckyPan/blob/master/scan_demo.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1920)

## 使用说明：
* 1.直接复制lucypan包下的所有文件到项目中
* 2.在对应的Activity类中使用，参照MainActvity即可

## 注意事项
* 1.一般奖品信息（名称、图片、个数）都是有服务端控制，所以我们需要从网络获取。网络获取有可能会有延迟，导致转盘显示黑色背景，所以我们需要在本地预先使用占位图，将转盘显示出来
* 2.当请求网络成功后，更新UI即可
