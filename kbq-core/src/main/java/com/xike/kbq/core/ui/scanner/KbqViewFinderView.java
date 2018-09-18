package com.xike.kbq.core.ui.scanner;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import me.dm7.barcodescanner.core.ViewFinderView;

/**
 * Created by 傅令杰
 */

public class KbqViewFinderView extends ViewFinderView {

    public KbqViewFinderView(Context context) {
        this(context, null);
    }

    public KbqViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mSquareViewFinder = true;
        mBorderPaint.setColor(Color.YELLOW);
        mLaserPaint.setColor(Color.YELLOW);
    }
}
