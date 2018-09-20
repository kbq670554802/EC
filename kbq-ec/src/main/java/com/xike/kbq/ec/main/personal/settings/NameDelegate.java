package com.xike.kbq.ec.main.personal.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.xike.kbq.core.delegates.KbqDelegate;
import com.xike.kbq.ec.R;

/**
 * Created by 傅令杰
 */

public class NameDelegate extends KbqDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_name;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public void post(Runnable runnable) {

    }
}
