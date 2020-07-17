package com.harvic.Interpolater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.*;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.tv);

//                Animation scaleAnim = AnimationUtils.loadAnimation(MyActivity.this,R.anim.scaleanim);
//                scaleAnim.setInterpolator(new AccelerateDecelerateInterpolator());
//                tv.startAnimation(scaleAnim);

                Animation tranlateAnim = AnimationUtils.loadAnimation(MyActivity.this, R.anim.translateanim);
                tranlateAnim.setInterpolator(new CycleInterpolator(1));
                tv.startAnimation(tranlateAnim);

                //Animation rotateAnim = AnimationUtils.loadAnimation(MyActivity.this,R.anim.rotateanim);
                //rotateAnim.setInterpolator(new LinearInterpolator());
                //tv.startAnimation(rotateAnim);

            }
        });
    }
}
