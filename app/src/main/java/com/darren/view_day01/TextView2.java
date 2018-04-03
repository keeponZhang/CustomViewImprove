package com.darren.view_day01;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Email 240336124@qq.com
 * Created by Darren on 2017/5/13.
 * Version 1.0
 * Description:
 */
public class TextView2 extends View {

    private String mText;
    private int mTextSize = 15;
    private int mTextColor = Color.BLACK;


    // 构造函数会在代码里面new的时候调用
    // TextView tv = new TextView(this);
    public TextView2(Context context) {
        this(context, null);
    }

    // 在布局layout中使用(调用)
    /*<com.darren.view_day01.TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello World!" />*/
    public TextView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    // 在布局layout中使用(调用)，但是会有style

    /**
     <com.darren.view_day01.TextView
     style="@style/defualt"
     android:text="Hello World!"
     */
    public TextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 获取自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TextView2);

        mText = array.getString(R.styleable.TextView2_text);
        mTextColor = array.getColor(R.styleable.TextView2_textColor, mTextColor);
        // 15 15px 15sp
        mTextSize = array.getDimensionPixelSize(R.styleable.TextView2_textSize,mTextSize);

        // 回收
        array.recycle();
    }


    /**
     * 自定义View的测量方法
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 布局的宽高都是由这个方法指定
        // 指定控件的宽高，需要测量
        // 获取宽高的模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    }

    /**
     * 用于绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*// 画文本
        canvas.drawText();
        // 画弧
        canvas.drawArc();
        // 画圆
        canvas.drawCircle();*/
    }

    /**
     * 处理跟用户交互的，手指触摸等等
     * @param event 事件分发事件拦截
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 手指按下
                Log.e("TAG","手指按下");
                break;

            case MotionEvent.ACTION_MOVE:
                // 手指移动
                Log.e("TAG","手指移动");
                break;

            case MotionEvent.ACTION_UP:
                // 手指抬起
                Log.e("TAG","手指抬起");
                break;
        }

        return super.onTouchEvent(event);
    }
}
