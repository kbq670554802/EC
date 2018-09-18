package com.xike.ec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.xike.kbq.core.app.Kbq;
import com.xike.kbq.core.net.interceptors.DebugInterceptor;
import com.xike.kbq.ec.icon.FontEcModule;

/**
 * Author: 柯葆青
 * Date: 2018/9/14
 * Description: 主Application
 */
public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Kbq.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
    }
}
