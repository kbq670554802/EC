package com.xike.kbq.core.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Author: 柯葆青
 * Date: 2018/9/13
 * Description:
 */
public class Kbq {
    public static Configurator init(Context context){
        getConfiguration().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }
    private static WeakHashMap<String,Object> getConfiguration(){
        return Configurator.getInstance().getConfigs();
    }
}











