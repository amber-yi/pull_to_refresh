package com.amber.refresh.unicorn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.amber.refresh.R;

/**
 * Created by luosiyi on 2017/6/28.
 */

public class HeadView extends View {
    private float percent = 0;
    private float p_percent = 0;
    private int oval_color;
    private RectF drawableRectF;
    private Rect drawableRect;
    private Rect groupRect;
    private Paint drawablePaint;
    private Paint textPaint;

    private Drawable drawable;
    private float drawableHeight;
    private float drawableWidth;
    private float drawableMarginLeft;
    private float textMarginLeft;
    private String text;
    private float textSize;
    private int textColor = Color.BLACK;
    private float drawableMarginTop;
    private Bitmap bmp;


//    public HeadView(Context context) {
//        super(context);
//        initView(null);
//    }

    public HeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public HeadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.HeadView, 0, 0);
            drawable = arr.getDrawable(R.styleable.HeadView_hv_drawable);
            drawableHeight = arr.getDimension(R.styleable.HeadView_hv_drawable_height, 0);
            drawableWidth = arr.getDimension(R.styleable.HeadView_hv_drawable_width, 0);
            drawableMarginLeft = arr.getDimension(R.styleable.HeadView_hv_drawable_marginLeft, 0);
            textMarginLeft = arr.getDimension(R.styleable.HeadView_hv_text_marginLeft, 0);
            text = arr.getString(R.styleable.HeadView_hv_text);
            textSize = arr.getDimension(R.styleable.HeadView_hv_text_size, dip2px(12));
            textColor = arr.getColor(R.styleable.HeadView_hv_text_color, Color.BLACK);
            if (drawable != null) {
                BitmapDrawable bd = (BitmapDrawable) drawable;
                bmp = bd.getBitmap();
            }

        }
        initTool();
    }

    private void initTool() {
        drawablePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        drawablePaint.setFilterBitmap(true);
        drawablePaint.setDither(true);
        drawableRectF = new RectF();// 设置个新的长方形，扫描测量
        drawableRect = new Rect(0, 0, bmp.getWidth(), bmp.getHeight());
        groupRect = new Rect();
        textPaint = new Paint();
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawableMarginTop =  (getMeasuredHeight() - drawableHeight) / 2;
        groupRect.set((int) drawableMarginLeft, (int) ((getMeasuredHeight() - drawableMarginTop) * (1 - p_percent)), (int) (drawableMarginLeft + drawableWidth), (int) (getMeasuredHeight() - drawableMarginTop));
//        canvas.drawBitmap(bmp,drawableMarginLeft,(getMeasuredHeight()-drawableMarginTop)*(1 - ipercent),drawablePaint);
        canvas.drawBitmap(bmp, drawableRect, groupRect, drawablePaint);
//        canvas.drawOval(drawableRectF, drawablePaint);
        canvas.drawText(text, drawableMarginLeft + drawableWidth + textMarginLeft+dip2px(40), (getMeasuredHeight() + drawableHeight*(1-p_percent))/2, textPaint);

    }


    @Override
    public void setBackgroundColor(@ColorInt int color) {
        oval_color = color;
    }

    public void setPercent(float percent) {
        this.percent = percent;
        if (percent <= 1) {
            p_percent = percent;
        } else {
            p_percent = 1;
        }
        invalidate();
    }

    public void setOvalColor(int oval_color) {
        this.oval_color = oval_color;
    }

    private float dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (dpValue * scale + 0.5f);
    }
}
