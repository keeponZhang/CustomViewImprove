package com.harvic.xmlAnimator;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/13.
 */
public class ObjectAnimXmlActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private TextView mTv1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.value_anim_activity);

        mTv1 = (TextView)findViewById(R.id.tv);

        findViewById(R.id.start_anim).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(ObjectAnimXmlActivity.this,
                        R.animator.object_animator);
                animator.setTarget(mTv1);
                animator.start();
            }
        });
    }
}
