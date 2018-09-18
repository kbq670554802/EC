package com.xike.kbq.core.app;

import android.content.Context;
import android.os.Handler;

/**
 * Author: 柯葆青
 * Date: 2018/9/13
 * Description:
 */
public class Kbq {
    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getKbqConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }

    public static void test(){
    }
}











