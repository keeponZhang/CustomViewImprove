package com.harvic.RegionBasis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 16/10/31.
 */

public class RegionOpView extends View {
    private Paint paint;
    private Rect rect1,rect2;
    private Region region,region2;
    public RegionOpView(Context context) {
        super(context);
        init();
    }

    public RegionOpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RegionOpView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        //构造两个矩形
        rect1 = new Rect(100,100,400,200);
        rect2 = new Rect(200,0,300,300);

        //构造一个画笔，画出矩形轮廓
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);


        //构造两个Region
        region = new Region(rect1);
        region2= new Region(rect2);

        //取两个区域的交集
        region.op(region2, Region.Op.INTERSECT);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画出相交的矩形
        canvas.drawRect(rect1, paint);
        canvas.drawRect(rect2, paint);

        //画面相交的结果
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        drawRegion(canvas, region, paint);
    }

    private void drawRegion(Canvas canvas,Region rgn,Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }
}
