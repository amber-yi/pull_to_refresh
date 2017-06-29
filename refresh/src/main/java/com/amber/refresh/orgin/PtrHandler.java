package com.amber.refresh.orgin;

import android.view.View;

/**
 * Created by luosiyi on 2017/6/28.
 */

public interface PtrHandler {
    /**
     * Check can do refresh or not. For example the content is empty or the first child is in view.
     * @param frame
     * @param content
     * @param header
     * @return
     */
    boolean checkCanDoRefresh(final PtrFrameLayout frame, final View content, final View header);

    /**
     * When refresh begin
     *
     * @param frame
     */
    void onRefreshBegin(final PtrFrameLayout frame);
}
