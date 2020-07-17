package com.harvic.ShapeDrawable_7_3;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 16/9/15.
 */
public class ShapeView extends View {
    private ShapeDrawable mShapeDrawable;
    public ShapeView(Context context) {
        super(context);
        init();
    }

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShapeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
//        //RectShape
//        mShapeDrawable = new ShapeDrawable(new RectShape());
//        mShapeDrawable.setBounds(new Rect(50,50,200,100));
//        mShapeDrawable.getPaint().setColor(Color.YELLOW);

//        //OvalShape
//        mShapeDrawable = new ShapeDrawable(new OvalShape());
//        mShapeDrawable.setBounds(new Rect(50,50,200,100));
//        mShapeDrawable.getPaint().setColor(Color.YELLOW);

//       //ArcShape 15968145727
//        mShapeDrawable = new ShapeDrawable(new ArcShape(0,300));
//        mShapeDrawable.setBounds(new Rect(50,50,200,100));
//        mShapeDrawable.getPaint().setColor(Color.YELLOW);

//        //RoundRectShape
//        float[] outerR = new float[] { 12, 12, 12, 12, 0, 0, 0, 0 };
//        RectF inset = new RectF(6, 6, 6,6);
//        float[] innerR = new float[] { 50, 12, 0, 0, 12, 50, 0, 0 };
//        mShapeDrawable = new ShapeDrawable(new RoundRectShape(outerR,inset,innerR));
//        mShapeDrawable.setBounds(new Rect(50,50,200,100));
//        mShapeDrawable.getPaint().setColor(Color.BLACK);

//        //PathShape
//        Path path = new Path();
//        path.moveTo(0,0);
//        path.lineTo(100,0);
//        path.lineTo(100,100);
//        path.lineTo(0,100);
//        // 封闭前面点所绘制的路径
//        path.close();
//        mShapeDrawable = new ShapeDrawable(new PathShape(path,100,200));
//        mShapeDrawable.setBounds(new Rect(0,0,250,150));
//        mShapeDrawable.getPaint().setColor(Color.YELLOW);

        //ReginShape
        //构造两个矩形
        Rect rect1 = new Rect(50,0,90,150);
        Rect rect2 = new Rect(0,50,250,100);
        //构造两个Region
        Region region = new Region(rect1);
        Region region2= new Region(rect2);
        //取两个区域的交集
        region.op(region2, Region.Op.XOR);
        mShapeDrawable = new ShapeDrawable(new RegionShape(region));
        mShapeDrawable.setBounds(new Rect(0,0,200,100));
        mShapeDrawable.getPaint().setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mShapeDrawable.draw(canvas);
    }
}
