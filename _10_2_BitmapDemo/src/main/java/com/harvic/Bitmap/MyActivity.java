package com.harvic.Bitmap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ImageView;

public class MyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.decode_byte_array_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, decodeByteArrayActivity.class));
            }
        });

        findViewById(R.id.decode_stream_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, decodeStreamActivity.class));
            }
        });

        findViewById(R.id.bitmap_factory_option_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, BitmapFactoryOptionsActivity.class));
            }
        });

        findViewById(R.id.bitmap_static_constructor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, BitmapStaticConstructorActivity.class));
            }
        });

        findViewById(R.id.bitmap_extract_alpha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, ExtraAlphaActivity.class));
            }
        });

        findViewById(R.id.bitmap_density).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, BitmapDensityActivity.class));
            }
        });

        findViewById(R.id.bitmap_pixel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, BitmapPixelActivity.class));
            }
        });

        findViewById(R.id.bitmap_compress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, BitmapCompressActivity.class));
            }
        });

        findViewById(R.id.bitmap_watermark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, WaterMarkActivity.class));
            }
        });
    }




}
