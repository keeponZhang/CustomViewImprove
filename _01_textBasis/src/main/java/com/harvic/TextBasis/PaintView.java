package com.harvic.TextBasis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 16/10/17.
 */
public class PaintView extends View {
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         *  1.3.1.1 填充样式的区别
         */
//        setStyle(canvas);

        /**
         * 1.3.1.2 setTextAlign
         */
//        setAlign(canvas);

        /**
         * 1.3.1.3_1 设置字体样式_常规设置
         */
//        setTextStyle(canvas);

        /**
         * 1.3.1.3_2 设置字体样式_字体倾斜度设置
         */
//        setTextSkewX(canvas);

        /**
         * 1.3.1.4 水平拉伸
         */
        setTextScaleX(canvas);

    }

    /**
     * 1.3.1.1 填充样式的区别
     * @param canvas
     */
    private void setStyle(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth (5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(80);//设置文字大小

//绘图样式，设置为填充
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("床前明月光", 10,100, paint);
    }

    /**
     *1.3.1.2 setTextAlign
     * @param canvas
     */
    private void setAlign(Canvas canvas){

        Paint paint=new Paint();
        paint.setColor(Color.RED);

        paint.setStrokeWidth (5);
        paint.setAntiAlias(true);
        paint.setTextSize(80);
        paint.setTextAlign(Paint.Align.RIGHT);

        canvas.drawText("床前明月光", 400,100, paint);
    }

    /**
     * 1.3.1.3_1 设置字体样式_常规设置
     * @param canvas
     */
    private void setTextStyle(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        canvas.drawText("床前明月光", 10,100, paint);

        paint.setFakeBoldText(true);//设置是否为粗体文字
        paint.setUnderlineText(true);//设置下划线
        paint.setStrikeThruText(true);//设置带有删除线效果
        canvas.drawText("床前明月光", 10,250, paint);
    }

    /**
     * 1.3.1.3_2 设置字体样式_字体倾斜度设置
     * @param canvas
     */
    private void setTextSkewX(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        //正常样式
        canvas.drawText("床前明月光", 10,100, paint);

        //向右倾斜
        paint.setTextSkewX(-0.25f);
        canvas.drawText("床前明月光", 10,200, paint);

        //向左倾斜
        paint.setTextSkewX(0.25f);
        canvas.drawText("床前明月光", 10,300, paint);
    }

    /**
     * 1.3.1.4 水平拉伸
     * @param canvas
     */
    private void setTextScaleX(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        //正常样式
        canvas.drawText("床前明月光", 10,100, paint);
        //拉伸两倍
        paint.setTextScaleX(2);
        canvas.drawText("床前明月光", 10,200, paint);
    }
}
