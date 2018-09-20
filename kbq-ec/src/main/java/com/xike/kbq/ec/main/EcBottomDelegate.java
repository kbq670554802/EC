package com.xike.kbq.ec.main;

import android.graphics.Color;

import com.xike.kbq.core.delegates.bottom.BaseBottomDelegate;
import com.xike.kbq.core.delegates.bottom.BottomItemDelegate;
import com.xike.kbq.core.delegates.bottom.BottomTabBean;
import com.xike.kbq.core.delegates.bottom.ItemBuilder;
import com.xike.kbq.ec.main.cart.ShopCartDelegate;
import com.xike.kbq.ec.main.discover.DiscoverDelegate;
import com.xike.kbq.ec.main.index.IndexDelegate;
import com.xike.kbq.ec.main.personal.PersonalDelegate;
import com.xike.kbq.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by 傅令杰
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }

    @Override
    public void post(Runnable runnable) {

    }
}
