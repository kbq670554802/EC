package com.xike.kbq.core.net;

import com.xike.kbq.core.app.ConfigType;
import com.xike.kbq.core.app.Kbq;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Author: 柯葆青
 * Date: 2018/9/14
 * Description: RestCreator
 */
public class RestCreator {

    private static final class ParamsHolder {
        static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVEICE;
    }


    private static final class RetrofitHolder {
        private static final String BASE_URL = (String) Kbq.getConfiguration().get(ConfigType.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkhttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OkhttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVEICE = RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }
}
