package com.harvic.Bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by qijian on 16/9/30.
 */
public class BitmapDensityActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_density_activity);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);

        ImageView iv1 = (ImageView) findViewById(R.id.img1);
        iv1.setImageBitmap(bitmap);
        int density = bitmap.getDensity();
        Log.d("qijian", "density:" + density + "  width:" + bitmap.getWidth() + " height:" + bitmap.getHeight());

        int scaledDensity = density * 2;
        bitmap.setDensity(scaledDensity);
        Log.d("qijian", "density:" + bitmap.getDensity() + "  width:" + bitmap.getWidth() + " height:" + bitmap.getHeight());
        ImageView iv2 = (ImageView) findViewById(R.id.img2);
        iv2.setImageBitmap(bitmap);
    }
}
