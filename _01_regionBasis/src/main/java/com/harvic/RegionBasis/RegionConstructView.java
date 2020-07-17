package com.harvic.RegionBasis;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 16/10/20.
 */
public class RegionConstructView extends View {
    public RegionConstructView(Context context) {
        super(context);
    }

    public RegionConstructView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RegionConstructView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        Region region = new Region(10, 10, 200, 100);
        region.union(new Rect(10, 10, 50, 300));
        drawRegion(canvas, region, paint);


    }

    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }

    /**
     * 1.4.1.1 直接构造
     *
     * @param canvas
     */
    private void drawRectRegion(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        canvas.drawRect(new Rect(50, 50, 200, 100), paint);

        Region region = new Region(new Rect(50, 50, 200, 100));
        drawRegion(canvas, region, paint);
    }

    /**
     * 1.4.1.2 间接构造
     *
     * @param canvas
     */
    private void drawPathRegion(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        //构造一个椭圆路径
        Path ovalPath = new Path();
        RectF rect = new RectF(50, 50, 200, 500);
        ovalPath.addOval(rect, Path.Direction.CCW);
        //SetPath时,传入一个比椭圆区域小的矩形区域,让其取交集
        Region rgn = new Region();
        rgn.setPath(ovalPath, new Region(50, 50, 200, 200));
        //画出路径
        drawRegion(canvas, rgn, paint);
    }

    /**
     * 1.4.2 枚举区域——RegionIterator类
     */
    private void regionIterator(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        //构造一个椭圆路径
        Path ovalPath = new Path();
        RectF rect = new RectF(50, 50, 200, 500);
        ovalPath.addOval(rect, Path.Direction.CCW);

        //构造椭圆Region
        Region rgn = new Region();
        rgn.setPath(ovalPath, new Region(50, 50, 200, 500));
        drawRegion(canvas, rgn, paint);
    }
}
