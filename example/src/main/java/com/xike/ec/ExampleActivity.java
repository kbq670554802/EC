package com.xike.ec;

import com.xike.kbq.core.activities.ProxyActivity;
import com.xike.kbq.core.delegates.KbqDelegate;
import com.xike.kbq.ec.launcher.LauncherDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public KbqDelegate setRootDelegate() {
//        return new ExampleDelegate();
        return new LauncherDelegate();
    }
}
