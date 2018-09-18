package com.xike.kbq.core.util.timer;

import java.util.TimerTask;

/**
 * Author: 柯葆青
 * Date: 2018/9/18
 * Description: 倒计时 TimerTask
 */
public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
