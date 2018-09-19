package com.xike.kbq.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Author: 柯葆青
 * Date: 2018/9/18
 * Description: 图标
 */
public enum EcIcons implements Icon {
    icon_scan('\ue602'),
    icon_ali_pay('\ue606');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
