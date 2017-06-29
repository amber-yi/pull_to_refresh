package com.amber.refresh.orgin;

import android.view.View;

/**
 * Created by luosiyi on 2017/6/28.
 */

public interface PtrHandler2 extends PtrHandler {

    /**
     * Check can do load more or not. For example the content is empty or the first child is in view.
     * @param frame
     * @param content
     * @param footer
     * @return
     */
    boolean checkCanDoLoadMore(final PtrFrameLayout frame, final View content, final View footer);

    /**
     * When load more begin
     *
     * @param frame
     */
    void onLoadMoreBegin(final PtrFrameLayout frame);
}
