package com.amber.refresh.unicorn;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.amber.refresh.R;
import com.amber.refresh.orgin.PtrFrameLayout;
import com.amber.refresh.orgin.PtrIndicator;
import com.amber.refresh.orgin.PtrUIHandler;

/**
 * Created by luosiyi on 2017/6/28.
 */

public class PtrDefaultHeader extends FrameLayout implements PtrUIHandler {

    private HeadView mHeadView;
    private TextView tvRefreshHint;

    public PtrDefaultHeader(@NonNull Context context) {
        super(context);
        initViews(null);
    }

    public PtrDefaultHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(attrs);
    }

    public PtrDefaultHeader(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(attrs);
    }

    protected void initViews(AttributeSet attrs) {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.default_header, this);
        mHeadView = (HeadView) header.findViewById(R.id.mOvalView);
        tvRefreshHint = (TextView) header.findViewById(R.id.tv_refresh_hint);
    }

    /**
     * When the content view has reached top and refresh has been completed, view will be reset.
     * 当内容视图已达到顶部和更新已经完成,视图将被重新设置。
     *
     * @param frame
     */
    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    /**
     * prepare for loading
     * 准备加载
     *
     * @param frame
     */
    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    /**
     * perform refreshing UI
     * 执行刷新界面
     */
    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {

    }

    /**
     * perform UI after refresh
     * 执行用户界面刷新后
     */
    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {

    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        mHeadView.setBackgroundColor(Color.RED);
        mHeadView.setPercent(ptrIndicator.getCurrentPercent());

    }
}
