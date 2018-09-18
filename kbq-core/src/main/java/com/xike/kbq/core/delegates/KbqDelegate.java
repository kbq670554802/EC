package com.xike.kbq.core.delegates;

/**
 * Author: 柯葆青
 * Date: 2018/9/14
 * Description:
 */
public abstract class KbqDelegate extends PermissionCheckerDelegate{
    @SuppressWarnings("unchecked")
    public <T extends KbqDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
