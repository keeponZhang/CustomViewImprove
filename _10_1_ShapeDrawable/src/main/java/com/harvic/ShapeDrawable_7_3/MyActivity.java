package com.harvic.ShapeDrawable_7_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.btn_shape_instance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ShapeInstanceActivity.class));
            }
        });
        findViewById(R.id.btn_shape_construct).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ShapeConstructorActivity.class));
            }
        });

        findViewById(R.id.btn_shape_shader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ShaderDemoActivity.class));
            }
        });
        findViewById(R.id.btn_shape_telescope).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,TelescopeActivity.class));
            }
        });
        findViewById(R.id.btn_custom_drawable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ImgDrawableActivity.class));
            }
        });

        findViewById(R.id.btn_background_drawable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,BackgroundDrawableActivity.class));
            }
        });
    }
}
