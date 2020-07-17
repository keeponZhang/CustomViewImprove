package com.harvic.SurfaceViewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by qijian on 16/10/4.
 */
public class SurfaceViewGesturePath extends SurfaceView {
    private Paint mPaint;
    private Path mPath;

    public SurfaceViewGesturePath(Context context) {
        super(context);
        init();
    }

    public SurfaceViewGesturePath(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SurfaceViewGesturePath(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);

        mPath = new Path();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mPath.moveTo(x, y);
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            mPath.lineTo(x, y);
        }
        drawCanvas();

        return super.onTouchEvent(event);
    }

    private void drawCanvas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SurfaceHolder surfaceHolder = getHolder();
                Canvas canvas = surfaceHolder.lockCanvas();

                canvas.drawPath(mPath, mPaint);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }).start();
    }
}
