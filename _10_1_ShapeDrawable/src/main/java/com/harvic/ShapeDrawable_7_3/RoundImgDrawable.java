package com.harvic.ShapeDrawable_7_3;

import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by qijian on 16/9/18.
 */
public class RoundImgDrawable extends Drawable {
    private Paint mPaint;
    private Bitmap mBitmap;
    private BitmapShader bitmapShader;

    private RectF rectF;

    public RoundImgDrawable(Bitmap bitmap){
        mBitmap = bitmap;

        mPaint = new Paint();
        mPaint.setARGB(20,0xff,0x00,0x00);
        mPaint.setAntiAlias(true);



    }

    @Override
    public void setBounds(int left, int top, int right, int bottom)
    {
        super.setBounds(left, top, right, bottom);
        bitmapShader = new BitmapShader(Bitmap.createScaledBitmap(mBitmap,right-left,bottom-top,true), Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint.setShader(bitmapShader);
        rectF = new RectF(left, top, right, bottom);
        Log.e("qijian","left:"+left+" ," +top+"  ,"+right+"  ,"+bottom);
    }

    @Override
    public int getIntrinsicWidth()
    {
        return mBitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight()
    {
        return mBitmap.getHeight()*2;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(rectF, 20, 20, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        Log.e("qijian","getOpacity");
        return PixelFormat.OPAQUE;
    }
}
