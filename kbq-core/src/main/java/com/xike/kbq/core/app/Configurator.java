package com.xike.kbq.core.app;

import java.util.WeakHashMap;

/**
 * Author: 柯葆青
 * Date: 2018/9/13
 * Description: 配置类
 */
public class Configurator {
    private static final WeakHashMap<String, Object> KBQ_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        KBQ_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }
    final  WeakHashMap<String,Object> getKbqConfigs(){
        return KBQ_CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        KBQ_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host){
        KBQ_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }
    private void checkConfiguration(){
        final boolean isReady = (boolean) KBQ_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configurattion is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = KBQ_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) KBQ_CONFIGS.get(key);
    }
}
