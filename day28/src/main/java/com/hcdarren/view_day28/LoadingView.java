package com.hcdarren.view_day28;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by hcDarren on 2017/8/13.
 */

public class LoadingView extends View {
    // 旋转动画执行的时间
    private final long ROTATION_ANIMATION_TIME = 1400;
    // 当前大圆旋转的角度（弧度）
    private float mCurrentRotationAngle = 0F;
    // 小圆的颜色列表
    private int[] mCircleColors;
    // 大圆里面包含很多小圆的半径 - 整宽度的 1/4
    private float mRotationRadius;
    // 每个小圆的半径 - 大圆半径的 1/8
    private float mCircleRadius;
    // 绘制所有效果的画笔
    private Paint mPaint;
    // 中心点
    private int mCenterX, mCenterY;
    // 整体的颜色背景
    private int mSplashColor = Color.WHITE;
    // 代表当前状态所画动画
    private LoadingState mLoadingState;
    // 当前大圆的半径
    private float mCurrentRotationRadius = mRotationRadius;
    // 空心圆初始半径
    private float mHoleRadius = 0F;
    // 屏幕对角线的一半
    private float mDiagonalDist;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 小圆的颜色列表
        mCircleColors = getContext().getResources().getIntArray(R.array.splash_circle_colors);
    }

    private boolean mInitParams = false;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!mInitParams) {
            initParams();
        }

        if (mLoadingState == null) {
            mLoadingState = new RotationState();
        }

        mLoadingState.draw(canvas);
    }

    /**
     * 初始化参数
     */
    private void initParams() {
        mRotationRadius = getMeasuredWidth() / 4;
        // 每个小圆的半径 - 大圆半径的 1/8
        mCircleRadius = mRotationRadius / 8;
        mInitParams = true;
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mCenterX = getMeasuredWidth() / 2;
        mCenterY = getMeasuredHeight() / 2;
        mDiagonalDist = (float) Math.sqrt(mCenterX * mCenterX + mCenterY * mCenterY);
    }

    /**
     * 消失
     */
    public void disappear() {
        // 关闭旋转动画
        if (mLoadingState instanceof RotationState) {
            RotationState rotationState = (RotationState) mLoadingState;
            rotationState.cancel();
        }
        // 开始聚合动画
        mLoadingState = new MergeState();
    }

    public abstract class LoadingState {
        public abstract void draw(Canvas canvas);
    }

    /**
     * 旋转动画
     */
    public class RotationState extends LoadingState {
        private ValueAnimator mAnimator;

        public RotationState() {
            // 搞一个变量不断的去改变 打算采用属性动画 旋转的是 0 - 360
            mAnimator = ObjectAnimator.ofFloat(0f, 2 * (float) Math.PI);
            mAnimator.setDuration(ROTATION_ANIMATION_TIME);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotationAngle = (float) animation.getAnimatedValue();
                    // 重新绘制
                    invalidate();
                }
            });
            // 线性差值器
            mAnimator.setInterpolator(new LinearInterpolator());
            // 不断反复执行
            mAnimator.setRepeatCount(-1);
            mAnimator.start();
        }

        @Override
        public void draw(Canvas canvas) {
            // 画一个背景 白色
            canvas.drawColor(mSplashColor);
            // 画六个圆  每份角度
            double percentAngle = Math.PI * 2 / mCircleColors.length;
            for (int i = 0; i < mCircleColors.length; i++) {
                mPaint.setColor(mCircleColors[i]);
                // 当前的角度 = 初始角度 + 旋转的角度
                double currentAngle = percentAngle * i + mCurrentRotationAngle;
                int cx = (int) (mCenterX + mRotationRadius * Math.cos(currentAngle));
                int cy = (int) (mCenterY + mRotationRadius * Math.sin(currentAngle));
                canvas.drawCircle(cx, cy, mCircleRadius, mPaint);
            }
        }

        /**
         * 取消动画
         */
        public void cancel() {
            mAnimator.cancel();
        }
    }

    /**
     * 聚合动画
     */
    public class MergeState extends LoadingState {
        private ValueAnimator mAnimator;

        public MergeState() {
            mAnimator = ObjectAnimator.ofFloat(mRotationRadius, 0);
            mAnimator.setDuration(ROTATION_ANIMATION_TIME / 2);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotationRadius = (float) animation.getAnimatedValue();// 最大半径到 0
                    // 重新绘制
                    invalidate();
                }
            });
            // 开始的时候向后然后向前甩
            mAnimator.setInterpolator(new AnticipateInterpolator(3f));
            // 等聚合完毕画展开
            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoadingState = new ExpendState();
                    // invalidate();
                }
            });
            mAnimator.start();
        }

        @Override
        public void draw(Canvas canvas) {
            // 画一个背景 白色
            canvas.drawColor(mSplashColor);
            // 开始写聚合动画
            // 画六个圆  每份角度
            double percentAngle = Math.PI * 2 / mCircleColors.length;
            for (int i = 0; i < mCircleColors.length; i++) {
                mPaint.setColor(mCircleColors[i]);
                // 当前的角度 = 初始角度 + 旋转的角度
                double currentAngle = percentAngle * i + mCurrentRotationAngle;
                int cx = (int) (mCenterX + mCurrentRotationRadius * Math.cos(currentAngle));
                int cy = (int) (mCenterY + mCurrentRotationRadius * Math.sin(currentAngle));
                canvas.drawCircle(cx, cy, mCircleRadius, mPaint);
            }
        }
    }

    /**
     * 展开动画
     */
    public class ExpendState extends LoadingState {
        private ValueAnimator mAnimator;

        public ExpendState() {
            mAnimator = ObjectAnimator.ofFloat(0, mDiagonalDist);
            mAnimator.setDuration(ROTATION_ANIMATION_TIME / 2);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mHoleRadius = (float) animation.getAnimatedValue(); // 0 - 对角线的一半
                    invalidate();
                }
            });
            mAnimator.start();
        }

        @Override
        public void draw(Canvas canvas) {
            // 画笔的宽度
            float strokeWidth = mDiagonalDist - mHoleRadius;
            mPaint.setStrokeWidth(strokeWidth);
            mPaint.setColor(mSplashColor);
            mPaint.setStyle(Paint.Style.STROKE);
            Log.e("TAG", "mHoleRadius -> " + mHoleRadius);
            float radius = strokeWidth / 2 + mHoleRadius;
            // 绘制一个圆
            canvas.drawCircle(mCenterX, mCenterY, radius, mPaint);
        }
    }
}
