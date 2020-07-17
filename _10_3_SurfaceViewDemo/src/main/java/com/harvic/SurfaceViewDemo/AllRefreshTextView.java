package com.harvic.SurfaceViewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by qijian on 16/10/6.
 */
public class AllRefreshTextView extends SurfaceView {
    private Paint mPaint;

    public AllRefreshTextView(Context context) {
        super(context);
        init();
    }

    public AllRefreshTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AllRefreshTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30);

        getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                drawText(holder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    private void drawText(final SurfaceHolder holder) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Canvas canvas = holder.lockCanvas();
                //一次性绘制完成
                for (int i = 0; i < 10; i++) {

                    if (canvas != null) {
                        canvas.drawText(i + "", i * 30, 50, mPaint);
                    }

                }
                holder.unlockCanvasAndPost(canvas);
            }
        }).start();
    }

}
