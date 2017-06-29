# pull_to_refresh
最近项目要求自己定制的刷新控件，产品提出来头部等需要使用自己定制的一些东西，可能会有自己的logo以及一些动画效果。查看了许多刷新控件，
感觉PullToRefresh框架很是符合自己想要的结果，由于后面需要自己定制一些头部文件，所以我将PullToRefresh的代码拉取下来，可以说是copy的一遍，
在这copy的过程也对它有了更近一步的了解。
由于时间的原因，这里也只是大概说明一下其大概架构，产品也没有说明具体刷新头部，所以现在那也还是待做
# 总的来说
PullToRefresh的主界面就是其定制的PtrFrameLayout（我的在refresh的module的origin包下面），这里不做具体分析，后面有时间再来说明。
然后就是其刷新接口：UI刷新接口PtrUIHandler（头部与尾部），数据刷新接口PtrHandler(我们调用的界面)
我们如果需要修改头部文件的话，自己定义的头部需要实现PtrUIHandler然后自己做各个阶段的处理，如果不太熟悉可以参考PtrClassicDefaultHeader的实现方式，
然后参考PtrClassicFrameLayout定制自己的刷新控件


# 刷新的使用：

<?xml version="1.0" encoding="utf-8"?>
<com.amber.refresh.unicorn.UnicornFrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/mRefresh"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <!--里面只能包裹一个控件，如果有多个控件则用LinearLayout等布局将其包裹再放在这里-->
    <!--被包裹的布局高度需要为match_parent，否则加载底部可能会出现在屏幕上的bug-->
    
    
    <TextView
        android:id="@+id/mTextView"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:text="Hello World!" />
        
    
</com.amber.refresh.unicorn.UnicornFrameLayout>

UnicornFrameLayout为我自己定制的刷新界面（暂时只是继承了PtrClassicFrameLayout，后面根据产品修改），你也可以改成自己定制的，或者直接就是使用经典的
刷新 PtrClassicFrameLayout
然后 在activity等地方
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
# 待续...
