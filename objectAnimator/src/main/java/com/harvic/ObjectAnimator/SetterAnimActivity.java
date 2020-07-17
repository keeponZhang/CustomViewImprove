package com.harvic.ObjectAnimator;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/7.
 */
public class SetterAnimActivity extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_activity);

final CustomTextView tv2 = (CustomTextView)findViewById(R.id.customtv);
findViewById(R.id.demobtn).setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv2, "ScaleSize", 6);
        animator.setDuration(2000);
        animator.start();
    }
});

        tv = (TextView)findViewById(R.id.tv);

        findViewById(R.id.start_alpha).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * 实现alpha值变化
                 */
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"alpha",1,0,1);
                animator.setDuration(2000);
                animator.start();
            }
        });

        findViewById(R.id.start_rotation).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * Z轴旋转
                 */
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"rotation",0,270,0);
                animator.setDuration(2000);
                animator.start();
            }
        });

        findViewById(R.id.start_rotationX).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * RotationX旋转
                 */
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"rotationX",0,270,0);
                animator.setDuration(2000);
                animator.start();
            }
        });

        findViewById(R.id.start_rotationY).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * RotationY 旋转
                 */
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"rotationY",0,180,0);
                animator.setDuration(2000);
                animator.start();

            }
        });

        findViewById(R.id.start_translationX).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * translationX动画
                 */
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", 0, 200, -200,0);
                animator.setDuration(2000);
                animator.start();
            }
        });

        findViewById(R.id.start_translationY).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * translationY动画
                 */
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationY", 0, 200, -100, 0);
                animator.setDuration(2000);
                animator.start();
            }
        });

        findViewById(R.id.start_scaleX).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * scaleX缩放动画
                 */
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "scaleX", 0, 3, 1);
                animator.setDuration(2000);
                animator.start();
            }
        });

        findViewById(R.id.start_scaleY).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /**
                 * scaleY缩放动画
                 */
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "scaleY", 0, 3, 1);
                animator.setDuration(2000);
                animator.start();
            }
        });



    }
}
