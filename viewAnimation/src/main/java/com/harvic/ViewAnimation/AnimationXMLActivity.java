package com.harvic.ViewAnimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by qijian on 16/11/11.
 */
public class AnimationXMLActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_xml_activity);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tv = (TextView)findViewById(R.id.tv);

                /**
                 * 缩放动画
                 */
                Animation scaleAnim = AnimationUtils.loadAnimation(AnimationXMLActivity.this, R.anim.scaleanim);

                /**
                 * 透明度动画
                 */
                Animation alphaAnim = AnimationUtils.loadAnimation(AnimationXMLActivity.this,R.anim.alphaanim);

                /**
                 * 旋转动画
                 */
                Animation rotateAnim = AnimationUtils.loadAnimation(AnimationXMLActivity.this,R.anim.rotateanim);

                /**
                 * 平移动画
                 */
                Animation tanslateAnim = AnimationUtils.loadAnimation(AnimationXMLActivity.this,R.anim.translateanim);

                /**
                 * 动画集合
                 */
                Animation setAnim = AnimationUtils.loadAnimation(AnimationXMLActivity.this,R.anim.setanim);

                tv.startAnimation(scaleAnim);
            }
        });
    }
}
