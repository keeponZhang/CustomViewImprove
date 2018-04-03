package com.darren.view_day17;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setActivityTranslucent(this);
        // QQ 效果 1.不断监听ScrollView的滚动，判断当前滚动的位置跟头部的ImageView比较计算背景透明度
        // 2.自定义 Behavior  简书有文章
    }
}
