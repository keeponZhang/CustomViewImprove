package com.darren.view_day26;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private LoveLayout mLoveLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoveLayout = (LoveLayout) findViewById(R.id.love_layout);
    }

    public void addLove(View view){
        mLoveLayout.addLove();
    }
}
