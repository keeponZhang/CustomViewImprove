package com.harvic.SurfaceViewDemo;

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

        findViewById(R.id.view_path_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ViewPathActivity.class));
            }
        });

        findViewById(R.id.surface_path_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,SurfacePathActivity.class));
            }
        });

        findViewById(R.id.animation_bg_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,AnimationBGActivity.class));
            }
        });
        findViewById(R.id.double_buffer_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,DoubleBufferTextActivity.class));
            }
        });

        //7.6.3.2 双缓冲技术局部更新原理之派生自SurfaceView
        findViewById(R.id.rectrefresh_sufaceview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,RectRefreshSurfaceActivity.class));
            }
        });

        //7.6.3.2 双缓冲技术局部更新原理之派生自View
        findViewById(R.id.rectrefresh_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,RectRefreshViewActivity.class));
            }
        });

        //7.6.3.4 双缓冲技术解决方案之一:保存所有要绘制内容，全屏重绘
        findViewById(R.id.resolve_text_1_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,Resolve_1_Activity.class));
            }
        });

        //7.6.3.4 双缓冲技术解决方案之二:内容不交叉时，可以增量绘制
        findViewById(R.id.resolve_text_2_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,Resolve_2_Activity.class));
            }
        });
    }
}
