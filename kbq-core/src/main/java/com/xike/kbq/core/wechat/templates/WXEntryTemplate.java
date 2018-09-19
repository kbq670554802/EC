package com.xike.kbq.core.wechat.templates;


import com.xike.kbq.core.wechat.BaseWXEntryActivity;
import com.xike.kbq.core.wechat.KbqWeChat;

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        KbqWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
