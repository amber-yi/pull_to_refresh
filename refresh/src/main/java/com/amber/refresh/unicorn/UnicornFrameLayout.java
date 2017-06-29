package com.amber.refresh.unicorn;

import android.content.Context;
import android.util.AttributeSet;

import com.amber.refresh.classic.PtrClassicFrameLayout;

/**
 * unicorn项目中用的，由于产品后面可能修改刷新头等，暂时先继承经典刷新
 * Created by luosiyi on 2017/6/29.
 */

public class UnicornFrameLayout extends PtrClassicFrameLayout {
    public UnicornFrameLayout(Context context) {
        super(context);
    }

    public UnicornFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UnicornFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
