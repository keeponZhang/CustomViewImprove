package com.darren.view_day10;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Email 240336124@qq.com
 * Created by Darren on 2017/6/17.
 * Version 1.0
 * Description:
 */
public class TouchViewGroup extends LinearLayout{

    public TouchViewGroup(Context context) {
        super(context);
    }

    public TouchViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 事件分发
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TAG","ViewGroup dispatchTouchEvent -> "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    // 事件拦截
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("TAG","ViewGroup onInterceptTouchEvent -> "+ev.getAction());
        return true;
    }

    // 事件触摸
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "ViewGroup onTouchEvent -> " + event.getAction());
        return super.onTouchEvent(event);
    }
}
