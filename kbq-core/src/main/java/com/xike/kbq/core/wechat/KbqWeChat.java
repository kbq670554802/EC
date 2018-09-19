package com.xike.kbq.core.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xike.kbq.core.app.ConfigKeys;
import com.xike.kbq.core.app.Kbq;
import com.xike.kbq.core.wechat.callbacks.IWeChatSignInCallback;

/**
 * Created by 傅令杰 on 2017/4/25
 */

public class KbqWeChat {
    public static final String APP_ID = Kbq.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
    public static final String APP_SECRET = Kbq.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;
    private IWeChatSignInCallback mSignInCallback = null;

    private static final class Holder {
        private static final KbqWeChat INSTANCE = new KbqWeChat();
    }

    public static KbqWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private KbqWeChat() {
        final Activity activity = Kbq.getConfiguration(ConfigKeys.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public KbqWeChat onSignSuccess(IWeChatSignInCallback callback) {
        this.mSignInCallback = callback;
        return this;
    }

    public IWeChatSignInCallback getSignInCallback() {
        return mSignInCallback;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }

}
