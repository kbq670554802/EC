package com.xike.ec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xike.kbq.core.activities.ProxyActivity;
import com.xike.kbq.core.delegates.KbqDelegate;

public class ExampleDelegate extends KbqDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
