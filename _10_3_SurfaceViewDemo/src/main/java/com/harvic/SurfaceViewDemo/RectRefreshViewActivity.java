package com.harvic.SurfaceViewDemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * 7.6.3.2 双缓冲技术局部更新原理
 * Created by qijian on 16/10/10.
 */
public class RectRefreshViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rect_refresh_view_activity);
    }
}
