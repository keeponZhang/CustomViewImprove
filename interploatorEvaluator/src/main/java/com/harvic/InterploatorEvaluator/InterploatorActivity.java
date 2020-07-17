package com.harvic.InterploatorEvaluator;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/5.
 */
public class InterploatorActivity extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interpolater_activity);
        tv = (TextView)findViewById(R.id.tv);

        findViewById(R.id.start_anim).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ValueAnimator animator = ValueAnimator.ofInt(0,300);

                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (Integer)animation.getAnimatedValue();
                        tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
                    }
                });
                animator.setDuration(1000);
                animator.setInterpolator(new MyInterpolator());
                animator.start();
            }
        });
    }
}
