package com.harvic.TextBasis;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by qijian on 16/10/18.
 */
public class CanvasView extends View {
    private Context mContext;
    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 1.3.2.1 普通绘制
         */
//        drawSubText(canvas);

        /**
         * 1.3.2.2 逐个指定文字位置
         */
//        drawPosText(canvas);

        /**
         * 1.3.2.3 沿路径绘制
         */
        drawPathText(canvas);

        /**
         * 1.3.3.2 自字义字体
         */
        drawCustomFont(canvas);

    }

    /**
     * 1.3.2.1 普通绘制
     *
     * @param canvas
     */
    private void drawSubText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);

        canvas.drawText("床前明月光", 2, 4, 10, 100, paint);
    }

    /**
     * 1.3.2.2 逐个指定文字位置
     */
    private void drawPosText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);

        float[] pos = new float[]{80, 100,
                80, 200,
                80, 300,
                80, 400};
        canvas.drawPosText("床前明月", pos, paint);
    }

    /**
     * 1.3.2.3 沿路径绘制
     * @param canvas
     */
    private void drawPathText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setTextSize(45);
        paint.setStyle(Paint.Style.STROKE);

        //先创建两个相同的圆形路径，并先画出两个路径原图
        Path circlePath = new Path();
        circlePath.addCircle(220, 300, 150, Path.Direction.CCW);//逆向绘制
        canvas.drawPath(circlePath, paint);//绘制出路径原形

        Path circlePath2 = new Path();
        circlePath2.addCircle(600, 300, 150, Path.Direction.CCW);
        canvas.drawPath(circlePath2, paint);//绘制出路径原形

        String string = "床前明月光,疑是地上霜";
        paint.setColor(Color.GREEN);
        //hoffset、voffset参数值全部设为0，看原始状态是怎样的
        canvas.drawTextOnPath(string, circlePath, 0, 0, paint);
        //第二个路径，改变hoffset、voffset参数值
        canvas.drawTextOnPath(string, circlePath2, 80, 30, paint);

    }

    /**
     * 1.3.3.2 自字义字体
     * @param canvas
     */
    private void drawCustomFont(Canvas canvas){
        //自定义字体，，，迷你简罗卜
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(60);

        AssetManager mgr= mContext.getAssets();//得到AssetManager
        //根据路径得到Typeface
        Typeface typeface=Typeface.createFromAsset(mgr, "fonts/jian_luobo.ttf");
        paint.setTypeface(typeface);
        canvas.drawText("床前明月光,疑是地上霜",10,550, paint);
    }
}
