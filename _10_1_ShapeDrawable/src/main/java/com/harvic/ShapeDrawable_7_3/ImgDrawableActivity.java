package com.harvic.ShapeDrawable_7_3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by qijian on 16/9/19.
 */
public class ImgDrawableActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_drawable_activity);

        //setBounds与Imagview的scaleType有关系
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avator);
        CustomDrawable drawable = new CustomDrawable(bitmap);

        CustomDrawable drawable2 = new CustomDrawable(bitmap);

        ImageView iv1 = (ImageView) findViewById(R.id.img1);
        iv1.setImageDrawable(drawable);

        ImageView iv2 = (ImageView) findViewById(R.id.img2);
        iv2.setImageDrawable(drawable);

        ImageView iv3 = (ImageView) findViewById(R.id.img3);
        iv3.setImageDrawable(drawable);

        ImageView iv4 = (ImageView) findViewById(R.id.img4);
        iv4.setImageDrawable(drawable);

        ImageView iv5 = (ImageView) findViewById(R.id.img5);
        iv5.setImageDrawable(drawable);

        ImageView iv6 = (ImageView) findViewById(R.id.img6);
        iv6.setImageDrawable(drawable);

        ImageView iv7 = (ImageView) findViewById(R.id.img7);
        iv7.setImageDrawable(drawable2);

    }
}
