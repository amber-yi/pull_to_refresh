package com.amber.refresh.orgin;

import android.view.View;

/**
 * Created by luosiyi on 2017/6/29.
 */

public abstract class RefreshHandler implements PtrHandler {
    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return true;
    }

    @Override
    public abstract void onRefreshBegin(PtrFrameLayout frame) ;

}
