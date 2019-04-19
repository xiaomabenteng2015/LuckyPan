package com.example.walle.luckpan.utils;


/**
 * 为了防止用户频繁点击某个按钮，导致程序在短时间内进行多次数据提交or数据处理，那到时候就比较坑了~
    那么如何有效避免这种情况的发生呢？
     我的想法是，判断用户点击按钮间隔时间，如果间隔时间太短，则认为是无效操作，否则进行相关业务处理
     首先将这块提取为工具类(方便接下来的调用)
 * Created on 2018/6/21.
 */

public class ButtonUtils {
    private static long lastClickTime = 0;
    private static long DIFF = 2000;
    private static int lastButtonId = -1;

    /**
     * 判断两次点击的间隔，如果小于1000，则认为是多次无效点击
     *
     * @return
     */
    public static boolean isFastDoubleClick() {
        return isFastDoubleClick(-1, DIFF);
    }

    /**
     * 判断两次点击的间隔，如果小于1000，则认为是多次无效点击
     *
     * @return
     */
    public static boolean isFastDoubleClick(int buttonId) {
        return isFastDoubleClick(buttonId, DIFF);
    }
    /**
     * 判断两次点击的间隔，如果小于diff，则认为是多次无效点击
     * @param diff
     * @return
     */
    public static boolean isFastDoubleClick(int buttonId, long diff) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (lastButtonId == buttonId && lastClickTime > 0 && timeD < diff) {

            return true;
        }
        lastClickTime = time;
        lastButtonId = buttonId;
        return false;
    }

    /**
     * 清空保存的上一次点击时间
     */
    public static void clearLastClickTime(){
        lastClickTime = 0;
    }

}
