package com.hcdarren.view_day28;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 延迟模拟获取后台数据
        final LoadingView loadingView = (LoadingView) findViewById(R.id.thirdScreenView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingView.disappear();
            }
        },2000);
    }
}
