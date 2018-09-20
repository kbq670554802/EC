package com.xike.kbq.core.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.xike.kbq.core.delegates.web.event.Event;
import com.xike.kbq.core.delegates.web.event.EventManager;
import com.xike.kbq.core.util.log.KbqLogger;


/**
 * Created by 傅令杰
 */

final class KbqWebInterface {
    private final WebDelegate DELEGATE;

    private KbqWebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static KbqWebInterface create(WebDelegate delegate) {
        return new KbqWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        KbqLogger.d("WEB_EVENT",params);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }
}
