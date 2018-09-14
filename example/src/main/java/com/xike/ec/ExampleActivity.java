package com.xike.ec;

import com.xike.kbq.core.activities.ProxyActivity;
import com.xike.kbq.core.delegates.KbqDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public KbqDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
