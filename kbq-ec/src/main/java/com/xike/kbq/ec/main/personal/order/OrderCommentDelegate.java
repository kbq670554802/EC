package com.xike.kbq.ec.main.personal.order;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import com.xike.kbq.core.delegates.KbqDelegate;
import com.xike.kbq.core.util.callback.CallbackManager;
import com.xike.kbq.core.util.callback.CallbackType;
import com.xike.kbq.core.util.callback.IGlobalCallback;
import com.xike.kbq.ec.R;
import com.xike.kbq.ec.R2;
import com.xike.kbq.ui.widget.AutoPhotoLayout;
import com.xike.kbq.ui.widget.StarLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 傅令杰
 */

public class OrderCommentDelegate extends KbqDelegate {

    @BindView(R2.id.custom_star_layout)
    StarLayout mStarLayout = null;
    @BindView(R2.id.custom_auto_photo_layout)
    AutoPhotoLayout mAutoPhotoLayout = null;

    @OnClick(R2.id.top_tv_comment_commit)
    void onClickSubmit() {
        Toast.makeText(getContext(), "评分： " + mStarLayout.getStarCount(), Toast.LENGTH_LONG).show();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_order_comment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mAutoPhotoLayout.setDelegate(this);
        CallbackManager.getInstance()
                .addCallback(CallbackType.ON_CROP, new IGlobalCallback<Uri>() {
                    @Override
                    public void executeCallback(@Nullable Uri args) {
                        mAutoPhotoLayout.onCropTarget(args);
                    }
                });
    }

    @Override
    public void post(Runnable runnable) {

    }
}
