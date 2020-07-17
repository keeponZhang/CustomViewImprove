package com.harvic.InterploatorEvaluator;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.security.cert.PolicyNode;

/**
 * Created by qijian on 16/12/6.
 */
public class FallingBallActivity extends Activity {
    private Point mCurPoint;
    private ImageView ballImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.falling_ball_activity);

        ballImg = (ImageView) findViewById(R.id.ball_img);

        findViewById(R.id.start_anim).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                int width = wm.getDefaultDisplay().getWidth();
                int height = wm.getDefaultDisplay().getHeight();

                ValueAnimator animator = ValueAnimator.ofObject(new FallingBallEvaluator(),new Point(0,0),new Point(width*2/3,height*2/3));
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        mCurPoint = (Point) animation.getAnimatedValue();
                        ballImg.layout(mCurPoint.x, mCurPoint.y, mCurPoint.x + ballImg.getWidth(), mCurPoint.y + ballImg.getHeight());
                    }
                });
                animator.setDuration(2000);
                animator.start();
            }
        });


    }
}
