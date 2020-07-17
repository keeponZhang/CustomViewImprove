package com.harvic.xmlAnimator;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/13.
 */
public class ValueAnimXMLActivity extends Activity {
    private TextView mTv1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.value_anim_activity);

        mTv1 = (TextView)findViewById(R.id.tv);

        findViewById(R.id.start_anim).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(ValueAnimXMLActivity.this,
                        R.animator.value_animator);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int offset = (Integer)animation.getAnimatedValue();
                        mTv1.layout( offset,offset,mTv1.getWidth()+offset,mTv1.getHeight() + offset);
                    }
                });
                valueAnimator.start();
            }
        });
    }
}
