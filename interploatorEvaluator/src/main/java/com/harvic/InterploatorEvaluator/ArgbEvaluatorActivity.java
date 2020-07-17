package com.harvic.InterploatorEvaluator;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/5.
 */
public class ArgbEvaluatorActivity extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluator_activity);

        tv = (TextView)findViewById(R.id.tv);

        findViewById(R.id.start_anim).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ValueAnimator animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
                animator.setEvaluator(new ArgbEvaluator());
                animator.setDuration(3000);

                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (Integer) animation.getAnimatedValue();
                        tv.setBackgroundColor(curValue);
                    }
                });

                animator.start();
            }
        });
    }
}
