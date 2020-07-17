package com.harvic.ValueAnimator;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by qijian on 16/12/3.
 */
public class ValueAnimDemoActivity extends Activity {
    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate_anim_activity);

        tv = (TextView) findViewById(R.id.tv);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAnimation();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ValueAnimDemoActivity.this, "clicked me", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doAnimation(){
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.setDuration(1000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (Integer)animation.getAnimatedValue();
                tv.layout(curValue,curValue,curValue+tv.getWidth(),curValue+tv.getHeight());
            }
        });
        animator.start();
    }

}
