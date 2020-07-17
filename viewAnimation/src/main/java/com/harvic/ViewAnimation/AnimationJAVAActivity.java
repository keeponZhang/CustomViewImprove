package com.harvic.ViewAnimation;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.TextView;

/**
 * Created by qijian on 16/11/16.
 */
public class AnimationJAVAActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_java_activity);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.tv);

                /**
                 * Scale动画
                 */
                ScaleAnimation scaleAnim = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnim.setDuration(700);

                /**
                 * alpha动画
                 */
                AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.1f);
                alphaAnim.setDuration(3000);
                alphaAnim.setFillBefore(true);

                /**
                 * RotateAnimation
                 */
                RotateAnimation rotateAnim = new RotateAnimation(0, -650, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnim.setDuration(3000);
                rotateAnim.setFillAfter(true);

                /**
                 * TranslateAnimation
                 */
                TranslateAnimation translateAnim = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -80,
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -80);
                translateAnim.setDuration(2000);
                translateAnim.setFillBefore(true);


                /**
                 * AnimationSet
                 */
                Animation alpha_Anim = new AlphaAnimation(1.0f, 0.1f);
                Animation scale_Anim = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                Animation rotate_Anim = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                AnimationSet setAnim = new AnimationSet(true);
                setAnim.addAnimation(alpha_Anim);
                setAnim.addAnimation(scale_Anim);
                setAnim.addAnimation(rotate_Anim);

                setAnim.setDuration(3000);
                setAnim.setFillAfter(true);


                tv.startAnimation(alphaAnim);

//                AnimationListener(tv);
            }
        });
    }


    /**
     * 使用AnimationListener
     *
     * @param tv
     */
    private void AnimationListener(final TextView tv) {
        final RotateAnimation rotateAnim = new RotateAnimation(0, -650, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim.setDuration(3000);
        rotateAnim.setFillAfter(true);


        ScaleAnimation scaleAnim = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnim.setDuration(700);
        scaleAnim.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {

            }

            public void onAnimationEnd(Animation animation) {
                tv.startAnimation(rotateAnim);

            }

            public void onAnimationRepeat(Animation animation) {

            }
        });

        tv.startAnimation(scaleAnim);
    }
}
