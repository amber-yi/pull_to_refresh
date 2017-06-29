package com.amber.refresh.classic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.RotateAnimation;

import com.amber.refresh.R;
import com.amber.refresh.orgin.PtrFrameLayout;

/**
 * Created by luosiyi on 2017/6/29.
 */

public class PtrClassicDefaultFooter extends PtrClassicDefaultHeader {
    public PtrClassicDefaultFooter(Context context) {
        super(context);
    }

    public PtrClassicDefaultFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PtrClassicDefaultFooter(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void buildAnimation() {
        super.buildAnimation();
        RotateAnimation tmp = mFlipAnimation;
        mFlipAnimation = mReverseFlipAnimation;
        mReverseFlipAnimation = tmp;
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        super.onUIRefreshPrepare(frame);
        if (frame.isPullToRefresh()) {
            mTitleTextView.setText(getResources().getString(R.string.cube_ptr_pull_up_to_load));
        } else {
            mTitleTextView.setText(getResources().getString(R.string.cube_ptr_pull_up));
        }
    }
}
