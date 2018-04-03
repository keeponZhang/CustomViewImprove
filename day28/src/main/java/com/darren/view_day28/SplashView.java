package com.darren.view_day28;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;

import com.hcdarren.view_day28.R;

/**
 * description:
 * author: Darren on 2017/7/28 14:35
 * email: 240336124@qq.com
 * version: 1.0
 */
public class SplashView extends View {

    private SplashState mSplashState;
    // 是否初始化参数
    private boolean mIsInitParams = false;
    // 大圆里面包含很多小圆的半径 - 整宽度的 1/4
    private float mRotationRadius;
    // 每个小圆的半径 - 大圆半径的 1/10
    private float mCircleRadius;
    // 小圆的颜色列表
    private int[] mCircleColors;
    // 旋转动画执行的时间
    private final long ROTATION_ANIMATION_TIME = 2000;
    // 第二部分动画执行的总时间 (包括三个动画的时间)
    private final long SPLASH_ANIMATION_TIME = 1200;
    // 整体的颜色背景
    private int mSplashColor = Color.WHITE;

    /**
     * 一些变化的参数
     */
    // 空心圆初始半径
    private float mHoleRadius = 0F;
    // 当前大圆旋转的角度（弧度）
    private float mCurrentRotationAngle = 0F;
    // 当前大圆的半径
    private float mCurrentRotationRadius = mRotationRadius;

    // 绘制圆的画笔
    private Paint mPaint = new Paint();
    // 绘制背景的画笔
    private Paint mPaintBackground = new Paint();

    // 屏幕最中心的位置
    private int mCenterX;
    private int mCenterY;
    // 屏幕对角线的一半
    private float mDiagonalDist;


    public SplashView(Context context) {
        this(context, null);
    }

    public SplashView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SplashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!mIsInitParams) {
            initParams();
            mIsInitParams = true;
        }

        if (mSplashState == null) {
            mSplashState = new RotationState();
        }

        mSplashState.draw(canvas);
    }

    /**
     * 初始化参数
     */
    private void initParams() {
        int width = getMeasuredWidth();
        // 大圆里面包含很多小圆的半径 - 整宽度的1/4
        mRotationRadius = width / 4;
        // 每个小圆的半径 - 大圆半径的 1/10
        mCircleRadius = mRotationRadius / 8;
        // 屏幕最中心的位置
        mCenterX = width / 2;
        mCenterY = getMeasuredHeight() / 2;
        // 小圆的颜色列表
        mCircleColors = getContext().getResources().getIntArray(R.array.splash_circle_colors);


        // 初始化画笔
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mPaintBackground.setDither(true);
        mPaintBackground.setAntiAlias(true);
        mPaintBackground.setStyle(Paint.Style.STROKE);
        mPaintBackground.setColor(mSplashColor);
        // 屏幕对角线的一半
        mDiagonalDist = (float) Math.sqrt((mCenterX * mCenterX + mCenterY * mCenterY));
    }

    /**
     * 消失
     */
    public void disappear() {
        if (mSplashState instanceof RotationState) {
            RotationState rs = (RotationState) mSplashState;
            rs.cancelAnimator();
            // 进入下一个动画
            mSplashState = new MergeState();
        }
    }

    private abstract class SplashState {
        public abstract void draw(Canvas canvas);
    }

    /**
     * 绘制小圆的旋转动画
     */
    private class RotationState extends SplashState {
        private ValueAnimator mAnimator;

        public RotationState() {
            // 属性动画
            mAnimator = ValueAnimator.ofFloat(0, (float) Math.PI * 2);
            mAnimator.setDuration(ROTATION_ANIMATION_TIME);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // 不断获取值 当前大圆旋转的角度
                    mCurrentRotationAngle = (float) animation.getAnimatedValue();
                    // 提醒View重新绘制
                    invalidate();
                }
            });
            mAnimator.setRepeatCount(-1);
            mAnimator.setInterpolator(new LinearInterpolator());
            // 开始计算
            mAnimator.start();
        }

        @Override
        public void draw(Canvas canvas) {
            canvas.drawColor(mSplashColor);
            // 绘制六个小圆 坐标
            float preAngle = (float) (2 * Math.PI / mCircleColors.length);
            for (int i = 0; i < mCircleColors.length; i++) {
                mPaint.setColor(mCircleColors[i]);
                // 初始角度 + 当前旋转的角度
                double angle = i * preAngle + mCurrentRotationAngle;
                float cx = (float) (mCenterX + mRotationRadius * Math.cos(angle));
                float cy = (float) (mCenterY + mRotationRadius * Math.sin(angle));
                canvas.drawCircle(cx, cy, mCircleRadius, mPaint);
            }
        }

        public void cancelAnimator() {
            mAnimator.cancel();
            mAnimator = null;
        }
    }


    /**
     * 绘制小圆的聚合动画
     */
    private class MergeState extends SplashState {
        private ValueAnimator mAnimator;

        public MergeState() {
            // 属性动画
            mAnimator = ValueAnimator.ofFloat(mRotationRadius, 0);
            mAnimator.setDuration(SPLASH_ANIMATION_TIME / 2);
            mAnimator.setInterpolator(new AnticipateInterpolator(6f));
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // 不断获取值 当前大圆旋转的角度
                    mCurrentRotationRadius = (float) animation.getAnimatedValue();
                    // 提醒View重新绘制
                    invalidate();
                }
            });

            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mSplashState = new ExpandingState();
                }
            });

            // 开始计算
            mAnimator.start();
        }

        @Override
        public void draw(Canvas canvas) {
            canvas.drawColor(mSplashColor);
            // 绘制六个小圆 坐标
            float preAngle = (float) (2 * Math.PI / mCircleColors.length);
            for (int i = 0; i < mCircleColors.length; i++) {
                mPaint.setColor(mCircleColors[i]);
                // 初始角度 + 当前旋转的角度
                double angle = i * preAngle + mCurrentRotationAngle;
                float cx = (float) (mCenterX + mCurrentRotationRadius * Math.cos(angle));
                float cy = (float) (mCenterY + mCurrentRotationRadius * Math.sin(angle));
                canvas.drawCircle(cx, cy, mCircleRadius, mPaint);
            }
        }
    }

    /**
     * 绘制小圆的扩散动画
     */
    private class ExpandingState extends SplashState {
        private ValueAnimator mAnimator;

        public ExpandingState() {
            // 属性动画
            mAnimator = ValueAnimator.ofFloat(0, mDiagonalDist);
            mAnimator.setDuration(SPLASH_ANIMATION_TIME/2);
            mAnimator.setInterpolator(new AccelerateInterpolator());
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // 不断获取值 当前大圆旋转的角度
                    mHoleRadius = (float) animation.getAnimatedValue();
                    // 提醒View重新绘制
                    invalidate();
                }
            });
            // 开始计算
            mAnimator.start();
        }

        @Override
        public void draw(Canvas canvas) {
            if (mHoleRadius > 0) {
                float strokeWidth = mDiagonalDist - mHoleRadius;
                mPaintBackground.setStrokeWidth(strokeWidth);
                float radius = mHoleRadius + strokeWidth / 2;
                canvas.drawCircle(mCenterX, mCenterY, radius, mPaintBackground);
            } else {
                canvas.drawColor(mSplashColor);
            }
        }
    }
}
