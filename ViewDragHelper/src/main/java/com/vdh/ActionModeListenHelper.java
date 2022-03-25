package com.vdh;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * createBy keepon
 */
class ActionModeListenHelper {
    private float downX, downY;

    private final float SLIDE_ANGLE = 45;

    private boolean mIsSlideHorizontally;//是否是水平滑动

    public void processTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:

                downX = ev.getX();

                downY = ev.getY();

                break;

            case MotionEvent.ACTION_MOVE:

            case MotionEvent.ACTION_UP:

                float moveX = ev.getX();

                float moveY = ev.getY();

                float xDiff = Math.abs(moveX - downX);

                float yDiff = Math.abs(moveY - downY);

                double squareRoot = Math.sqrt(xDiff * xDiff + yDiff * yDiff);

                //滑动的角度

                int yAngle = Math.round((float) (Math.asin(yDiff / squareRoot) / Math.PI * 180));

                int xAngle = Math.round((float) (Math.asin(xDiff / squareRoot) / Math.PI * 180));

                boolean isMeetSlidingYAngle = yAngle > SLIDE_ANGLE;//滑动角度是否大于45du

                boolean isMeetSlidingXAngle = xAngle > SLIDE_ANGLE;//滑动角度是否大于45du

                boolean isSlideUp = moveY < downY && isMeetSlidingYAngle;

                boolean isSlideDown = moveY > downY && isMeetSlidingYAngle;

                boolean isSlideLeft = moveX < downX && isMeetSlidingXAngle;

                boolean isSlideRight = moveX > downX && isMeetSlidingXAngle;

                if (isSlideUp) {
                    if (mCallback != null) {
                        mCallback.onMoveUp();
                    }
                    Log.d("chenhaocc", "向上滑动");

                    mIsSlideHorizontally = false;
                } else if (isSlideDown) {
                    Log.d("chenhaocc", "向下滑动");
                    if (mCallback != null) {
                        mCallback.onMoveDown();
                    }
                    mIsSlideHorizontally = false;

                } else if (isSlideLeft) {
                    if (mCallback != null) {
                        mCallback.onMoveLeft();
                    }
                    Log.d("chenhaocc", "向左边滑动");

                    mIsSlideHorizontally = true;

                } else if (isSlideRight) {
                    if (mCallback != null) {
                        mCallback.onMoveRight();
                    }
                    mIsSlideHorizontally = true;

                    Log.d("chenhaocc", "向右边滑动");

                }

                break;
            default:
                break;
        }
    }

    Callback mCallback;

    public interface Callback {
        void onMoveDown();

        void onMoveUp();

        void onMoveRight();

        void onMoveLeft();
    }
}
