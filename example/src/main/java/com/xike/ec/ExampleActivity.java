package com.xike.ec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.xike.kbq.core.activities.ProxyActivity;
import com.xike.kbq.core.app.Kbq;
import com.xike.kbq.core.delegates.KbqDelegate;
import com.xike.kbq.ec.launcher.LauncherDelegate;
import com.xike.kbq.ec.main.EcBottomDelegate;
import com.xike.kbq.ec.sign.ISignListener;
import com.xike.kbq.ec.sign.SignInDelegate;
import com.xike.kbq.ec.sign.SignUpDelegate;
import com.xike.kbq.ui.launcher.ILauncherListener;
import com.xike.kbq.ui.launcher.OnLauncherFinishTag;

import qiu.niorgai.StatusBarCompat;

/**
 * Author: 柯葆青
 * Date: 2018/9/18
 * Description: 应用启动Activity
 */
public class ExampleActivity extends ProxyActivity implements
        ISignListener,
        ILauncherListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Kbq.getConfigurator().withActivity(this);
        StatusBarCompat.translucentStatusBar(this, true);

    }
    @Override
    public KbqDelegate setRootDelegate() {
//        return new ExampleDelegate();
        return new LauncherDelegate();
//        return new SignUpDelegate();
//        return new SignInDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束，用户登录了", Toast.LENGTH_LONG).show();
                getSupportDelegate().startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "启动结束，用户没登录", Toast.LENGTH_LONG).show();
                getSupportDelegate().startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
