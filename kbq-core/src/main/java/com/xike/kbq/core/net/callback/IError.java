package com.xike.kbq.core.net.callback;

/**
 * Author: 柯葆青
 * Date: 2018/9/14
 * Description: 错误回调
 */
public interface IError {

    void onError(int code, String msg);
}
