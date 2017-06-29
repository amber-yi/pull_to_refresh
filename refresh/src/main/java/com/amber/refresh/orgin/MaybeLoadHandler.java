package com.amber.refresh.orgin;

import android.view.View;

/**
 * Created by luosiyi on 2017/6/29.
 */

public abstract class MaybeLoadHandler implements PtrHandler2 {
    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return true;
    }

    @Override
    public abstract void onRefreshBegin(PtrFrameLayout frame);

    @Override
    public abstract boolean checkCanDoLoadMore(PtrFrameLayout frame, View content, View footer);

    @Override
    public abstract void onLoadMoreBegin(PtrFrameLayout frame);
}
