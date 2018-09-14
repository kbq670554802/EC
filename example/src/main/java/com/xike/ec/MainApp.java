package com.xike.ec;

import android.app.Application;

import com.xike.kbq.core.app.Kbq;

/**
 * Author: 柯葆青
 * Date: 2018/9/14
 * Description: 主Application
 */
public class MainApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Kbq.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
