package com.xike.kbq.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Author: 柯葆青
 * Date: 2018/9/18
 * Description: LauncherHolderCreator
 */
public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder> {

    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
