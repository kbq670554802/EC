package com.xike.kbq.core.app;

/**
 * Author: 柯葆青
 * Date: 2018/9/18
 * Description: 用户状态监测回调接口
 */
public interface IUserChecker {

    void onSignIn();

    void onNotSignIn();
}
