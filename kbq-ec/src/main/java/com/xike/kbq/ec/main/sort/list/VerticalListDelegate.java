package com.xike.kbq.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xike.kbq.core.delegates.KbqDelegate;
import com.xike.kbq.core.net.RestClient;
import com.xike.kbq.core.net.callback.ISuccess;
import com.xike.kbq.ec.R;
import com.xike.kbq.ec.R2;
import com.xike.kbq.ec.main.sort.SortDelegate;
import com.xike.kbq.ui.recycler.MultipleItemEntity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by 傅令杰
 */

public class VerticalListDelegate extends KbqDelegate {

    @BindView(R2.id.rv_vertical_menu_list)
    RecyclerView mRecyclerView = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    private void initRecyclerView() {
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        //屏蔽动画效果
        mRecyclerView.setItemAnimator(null);
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initRecyclerView();
    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("sort_list.php")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final List<MultipleItemEntity> data =
                                new VerticalListDataConverter().setJsonData(response).convert();
                        final SortDelegate delegate = getParentDelegate();
                        final SortRecyclerAdapter adapter = new SortRecyclerAdapter(data, delegate);
                        mRecyclerView.setAdapter(adapter);

                    }
                })
                .build()
                .get();
    }
}
