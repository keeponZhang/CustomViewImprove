package com.harvic.PaintBasis;

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

        findViewById(R.id.summarize_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,Summarize_1_1_1_Activity.class));
            }
        });

        findViewById(R.id.canvas_basis_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,Summarize_1_1_3_Activity.class));
            }
        });
        findViewById(R.id.rect_point_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,RectPontView_1_1_4_Activity.class));
            }
        });

        findViewById(R.id.intersect_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,intersect_1_1_4_Activity.class));
            }
        });

        findViewById(R.id.path_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,PathView_1_2_Activity.class));
            }
        });
        findViewById(R.id.spider_view_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,SpiderActivity.class));
            }
        });
    }
}
