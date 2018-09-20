package com.xike.kbq.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.xike.kbq.core.delegates.KbqDelegate;
import com.xike.kbq.ec.detail.GoodsDetailDelegate;
import com.xike.kbq.ui.recycler.MultipleFields;
import com.xike.kbq.ui.recycler.MultipleItemEntity;

/**
 * Created by 傅令杰
 */

public class IndexItemClickListener extends SimpleClickListener {

    private final KbqDelegate DELEGATE;

    private IndexItemClickListener(KbqDelegate delegate) {
        this.DELEGATE = delegate;
    }

    public static SimpleClickListener create(KbqDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final MultipleItemEntity entity = (MultipleItemEntity) baseQuickAdapter.getData().get(position);
        final int goodsId = entity.getField(MultipleFields.ID);
        final GoodsDetailDelegate delegate = GoodsDetailDelegate.create(goodsId);
        DELEGATE.getSupportDelegate().start(delegate);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
    }
}
