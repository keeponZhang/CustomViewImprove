package com.harvic.SurfaceViewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

/**
 * Created by qijian on 16/10/4.
 */
public class ViewGesturePath extends SurfaceView {
    private Paint mPaint;
    private Path mPath;
    public ViewGesturePath(Context context) {
        super(context);
        init();
    }
    public ViewGesturePath(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public ViewGesturePath(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setWillNotDraw(false);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);

        mPath = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int)event.getX();
        int y = (int)event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            mPath.moveTo(x,y);
            return true;
        }else if (event.getAction() == MotionEvent.ACTION_MOVE){
            mPath.lineTo(x,y);
        }
        postInvalidate();
        Log.d("qijian","invalidate");

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
        Log.d("qijian","ondraw");
    }
}
