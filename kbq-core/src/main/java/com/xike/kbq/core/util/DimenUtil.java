package com.xike.kbq.core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.xike.kbq.core.app.Kbq;

/**
 * Author: 柯葆青
 * Date: 2018/9/17
 * Description: 测量工具类
 */
public class DimenUtil {

    /**
     * 获取屏幕宽
     *
     * @return
     */
    public static int getScreenWidth() {
        final Resources resource = Kbq.getApplicationContext().getResources();
        final DisplayMetrics dm = resource.getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高
     *
     * @return
     */
    public static int getScreenHeight() {
        final Resources resource = Kbq.getApplicationContext().getResources();
        final DisplayMetrics dm = resource.getDisplayMetrics();
        return dm.heightPixels;
    }
}
