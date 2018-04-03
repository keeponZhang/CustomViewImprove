package com.darren.view_day28;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.hcdarren.view_day28.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SplashView splashView = (SplashView) findViewById(R.id.thirdScreenView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashView.disappear();
            }
        },2000);
    }
}
