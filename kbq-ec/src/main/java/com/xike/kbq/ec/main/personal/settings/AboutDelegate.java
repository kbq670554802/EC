package com.xike.kbq.ec.main.personal.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.xike.kbq.core.delegates.KbqDelegate;
import com.xike.kbq.core.net.RestClient;
import com.xike.kbq.core.net.callback.ISuccess;
import com.xike.kbq.ec.R;
import com.xike.kbq.ec.R2;

import butterknife.BindView;

/**
 * Created by 傅令杰
 */

public class AboutDelegate extends KbqDelegate {

    @BindView(R2.id.tv_info)
    AppCompatTextView mTextView = null;


    @Override
    public Object setLayout() {
        return R.layout.delegate_about;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        RestClient.builder()
                .url("about.php")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final String info = JSON.parseObject(response).getString("data");
                        mTextView.setText(info);
                    }
                })
                .build()
                .get();
    }

    @Override
    public void post(Runnable runnable) {

    }
}
