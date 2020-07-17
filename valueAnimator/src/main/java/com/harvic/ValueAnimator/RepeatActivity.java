package com.harvic.ValueAnimator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/5.
 */
public class RepeatActivity extends Activity {
    private TextView tv;
    private Button btnStart,btnCancel;
    private ValueAnimator repeatAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repeat_activity);

        tv = (TextView) findViewById(R.id.tv);

        btnStart = (Button) findViewById(R.id.btn);
        btnCancel = (Button)findViewById(R.id.btn_cancel);

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                repeatAnimator = doRepeatAnim();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                repeatAnimator.removeAllListeners();
                repeatAnimator.cancel();
            }
        });
    }

    private ValueAnimator doRepeatAnim(){
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (Integer)animation.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
                Log.d("qijian","animation start");
            }

            public void onAnimationEnd(Animator animation) {
                Log.d("qijian","animation end");
            }

            public void onAnimationCancel(Animator animation) {
                Log.d("qijian", "animation cancel");
            }

            public void onAnimationRepeat(Animator animation) {
                Log.d("qijian","animation repeat");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(1000);
        animator.start();
        return animator;
    }
}
