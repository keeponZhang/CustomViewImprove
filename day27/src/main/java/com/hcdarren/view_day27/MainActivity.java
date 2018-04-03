package com.hcdarren.view_day27;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hcdarren.view_day27.parallax.animation.ParallaxViewPager;

public class MainActivity extends AppCompatActivity {
    // 2.2.1 先把布局和 Fragment 创建好
    private ParallaxViewPager mParallaxViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findViewById 给ViewPager设置Adapter，意味着代码全部写到activity来了，封装（自定义View）
        mParallaxViewPager = (ParallaxViewPager) findViewById(R.id.parallax_vp);
        // 给一个方法 得一个布局数组 // 用最简便的方式让别人使用
        mParallaxViewPager.setLayout(getSupportFragmentManager(),
                new int[]{R.layout.fragment_page_first,R.layout.fragment_page_second,
                        R.layout.fragment_page_third,R.layout.fragment_page_first});

    }
}
