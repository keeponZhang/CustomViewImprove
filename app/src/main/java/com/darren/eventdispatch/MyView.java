package com.darren.eventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("TAG", "MyView dispatchTouchEvent-- action=" + event.getAction());
        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
//        Log.e("TAG", "TestButton dispatchTouchEvent-- return =" + dispatchTouchEvent);
        return dispatchTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "MyView onTouchEvent-- action=" + event.getAction());
        return super.onTouchEvent(event);
    }
}
