package com.example.AnimDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.*;
import android.widget.ImageView;

/**
 * Created by qijian on 16/11/16.
 */
public class LoadingDemo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_demo_activity);

        ImageView imageView = (ImageView)findViewById(R.id.loading);

        RotateAnimation rotateAnim = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnim.setRepeatCount(Animation.INFINITE);
        rotateAnim.setDuration(2000);
        rotateAnim.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(rotateAnim);
    }
}
