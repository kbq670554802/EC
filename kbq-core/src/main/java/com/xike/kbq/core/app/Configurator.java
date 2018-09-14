package com.xike.kbq.core.app;

import java.util.WeakHashMap;

/**
 * Author: 柯葆青
 * Date: 2018/9/13
 * Description: 配置类
 */
public class Configurator {
    private static final WeakHashMap<String, Object> CONFIGS = new WeakHashMap<>();

    private Configurator() {
        CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }
    final  WeakHashMap<String,Object> getConfigs(){
        return CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host){
        CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }
    private void checkConfigurarion(){
        final boolean isReady = (boolean) CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configurattion is not ready,call configure");
        }
    }
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfigurarion();
        return (T) CONFIGS.get(key);
    }
}
