package com.xike.kbq.core.net.interceptors;

import android.support.annotation.NonNull;
import android.support.annotation.RawRes;


import com.xike.kbq.core.util.file.FileUtil;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Author: 柯葆青
 * Date: 2018/9/18
 * Description: Debug拦截器
 */
public class DebugInterceptor extends BaseInterceptor {

    private final String DEBUG_URL = "debug";


    private Response getResponse(Chain chain, String json) {
        return new Response.Builder()
                .code(200)
                .addHeader("Content-Type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), json))
                .message("OK")
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .build();
    }

    private Response debugResponse(Chain chain, @RawRes int rawId) {
        final String json = FileUtil.getRawFile(rawId);
        return getResponse(chain, json);
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final String url = chain.request().url().toString();
        if (url.contains(DEBUG_URL)) {
            String debug = getUrlParameters(chain, "debug");
            return debugResponse(chain, Integer.parseInt(debug));
        }
        return chain.proceed(chain.request());
    }
}
