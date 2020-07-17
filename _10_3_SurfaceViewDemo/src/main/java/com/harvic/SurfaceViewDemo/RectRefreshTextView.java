package com.harvic.SurfaceViewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by qijian on 16/10/6.
 */
public class RectRefreshTextView extends SurfaceView {
    private Paint mPaint;

    public RectRefreshTextView(Context context) {
        super(context);
        init();
    }

    public RectRefreshTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectRefreshTextView(Context context, AttributeSet attrs, int defStyle) {
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
            //先进行清屏操作
            while (true) {
                Rect dirtyRect = new Rect(0, 0, 1, 1);
                Canvas canvas = holder.lockCanvas(dirtyRect);
                Rect canvasRect = canvas.getClipBounds();
                if (getWidth() == canvasRect.width() && getHeight() == canvasRect.height()) {
                    canvas.drawColor(Color.BLACK);
                    holder.unlockCanvasAndPost(canvas);
                    Log.d("qijian","clear canvas");
                } else {
                    holder.unlockCanvasAndPost(canvas);
                    break;
                }
            }

            //画图
            for (int i = 0; i < 10; i++) {
                int itemWidth = 50;
                int itemHeight = 50;
                Rect rect = new Rect(i*itemWidth,0,(i+1)*itemWidth-10,itemHeight);
                Canvas canvas = holder.lockCanvas(rect);
                if (canvas != null) {
                    canvas.drawColor(Color.GREEN);
                    canvas.drawText(i + "", i*itemWidth+10, itemHeight/2, mPaint);
                }
                holder.unlockCanvasAndPost(canvas);

                try {
                    Thread.sleep(800);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
}

}
