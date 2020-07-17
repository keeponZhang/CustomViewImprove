package com.harvic.ShapeDrawable_7_3;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 16/9/15.
 */
public class ShapeShaderView extends View {
    private ShapeDrawable mShapeDrawable;
    public ShapeShaderView(Context context) {
        super(context);
        init();
    }

    public ShapeShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShapeShaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mShapeDrawable = new ShapeDrawable(new RectShape());
        mShapeDrawable.setBounds(new Rect(100,100,300,300));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.avator);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mShapeDrawable.getPaint().setShader(bitmapShader);


        // 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1/2f,1/2f,1/2f,0,0,
                1/3f,1/3f,1/3f,0,0,
                1/4f,1/4f,1/4f,0,0,
                0,0,0,1,0
        });
        mShapeDrawable.getPaint().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
//        mShapeDrawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mShapeDrawable.draw(canvas);
    }
}
