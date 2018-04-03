package com.darren.view_day10;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Email 240336124@qq.com
 * Created by Darren on 2017/6/11.
 * Version 1.0
 * Description:
 */
public class TouchView extends View{

    public TouchView(Context context) {
        super(context);
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "View onTouchEvent -> " + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("TAG", "View dispatchTouchEvent -> " + event.getAction());
        return super.dispatchTouchEvent(event);
    }

}
