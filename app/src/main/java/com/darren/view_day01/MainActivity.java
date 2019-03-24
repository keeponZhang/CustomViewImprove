package com.darren.view_day01;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.relativeLayout);
        View scrollView = findViewById(R.id.scroll_view);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", "run: "+"viewById=="+viewById.getMeasuredHeight() );
                Log.e("TAG", "run: "+"scrollView=="+scrollView.getMeasuredHeight() );
            }
        }, 3000);
    }
}
