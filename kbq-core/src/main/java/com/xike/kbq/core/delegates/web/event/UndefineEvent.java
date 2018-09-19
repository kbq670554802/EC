package com.xike.kbq.core.delegates.web.event;


import com.xike.kbq.core.util.log.KbqLogger;

/**
 * Created by 傅令杰
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        KbqLogger.e("UndefineEvent", params);
        return null;
    }
}
