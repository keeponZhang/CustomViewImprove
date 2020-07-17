package com.harvic.xmlAnimator;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/13.
 */
public class SetAnimXMLActivity extends Activity {
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
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(SetAnimXMLActivity.this,
                        R.animator.set_animator);
                set.setTarget(mTv1);
                set.start();
            }
        });
    }
}
