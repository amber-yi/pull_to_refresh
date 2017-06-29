package com.amber.pull_to_refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amber.refresh.orgin.DefaultHandler;
import com.amber.refresh.orgin.PtrFrameLayout;
import com.amber.refresh.unicorn.UnicornFrameLayout;

public class MainActivity extends AppCompatActivity {
    UnicornFrameLayout mRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRefresh = (UnicornFrameLayout) findViewById(R.id.mRefresh);
        //设置最后刷新时间
        mRefresh.setLastUpdateTimeHeaderRelateObject(this);
        //设置刷新处理器
        //DefaultHandler:刷新，加载都可用
        //RefreshHandler：只可以刷新
        //LoadHandler: 只可以加载
        //PtrHandler:自己控制是否可以刷新（不可以加载）
        //PtrHandler2:自己控制是否可以刷新以及加载
        //MaybeLoadHandler:可以刷新，自己控制是否可以加载（如：加载完成全部则不能上拉加载）
        mRefresh.setPtrHandler(new DefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mRefresh.refreshComplete();
            }

            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                mRefresh.refreshComplete();
            }
        });
    }
}
