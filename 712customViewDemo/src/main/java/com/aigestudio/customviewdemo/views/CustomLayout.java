package com.aigestudio.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
 * @since 2015/1/15
 * 
 */
public class CustomLayout extends ViewGroup {

	public CustomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// 声明临时变量存储父容器的期望值
		int parentDesireWidth = 0;
		int parentDesireHeight = 0;

		/*
		 * 如果有子元素
		 */
		if (getChildCount() > 0) {
			// 那么遍历子元素并对其进行测量
			for (int i = 0; i < getChildCount(); i++) {

				// 获取子元素
				View child = getChildAt(i);

				// 获取子元素的布局参数
				CustomLayoutParams clp = (CustomLayoutParams) child.getLayoutParams();

				// 测量子元素并考虑外边距
				measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);

				// 计算父容器的期望值
				parentDesireWidth += child.getMeasuredWidth() + clp.leftMargin + clp.rightMargin;
				parentDesireHeight += child.getMeasuredHeight() + clp.topMargin + clp.bottomMargin;
			}

			// 考虑父容器的内边距
			parentDesireWidth += getPaddingLeft() + getPaddingRight();
			parentDesireHeight += getPaddingTop() + getPaddingBottom();

			// 尝试比较建议最小值和期望值的大小并取大值
			parentDesireWidth = Math.max(parentDesireWidth, getSuggestedMinimumWidth());
			parentDesireHeight = Math.max(parentDesireHeight, getSuggestedMinimumHeight());
		}

		// 设置最终测量值O
		setMeasuredDimension(resolveSize(parentDesireWidth, widthMeasureSpec), resolveSize(parentDesireHeight, heightMeasureSpec));
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// 获取父容器内边距
		int parentPaddingLeft = getPaddingLeft();
		int parentPaddingTop = getPaddingTop();

		/*
		 * 如果有子元素
		 */
		if (getChildCount() > 0) {
			// 声明一个临时变量存储高度倍增值
			int mutilHeight = 0;

			// 那么遍历子元素并对其进行定位布局
			for (int i = 0; i < getChildCount(); i++) {
				// 获取一个子元素
				View child = getChildAt(i);

				CustomLayoutParams clp = (CustomLayoutParams) child.getLayoutParams();

				// 通知子元素进行布局
				// 此时考虑父容器内边距和子元素外边距的影响
				child.layout(parentPaddingLeft + clp.leftMargin, mutilHeight + parentPaddingTop + clp.topMargin, child.getMeasuredWidth() + parentPaddingLeft + clp.leftMargin, child.getMeasuredHeight() + mutilHeight + parentPaddingTop + clp.topMargin);

				// 改变高度倍增值
				mutilHeight += child.getMeasuredHeight() + clp.topMargin + clp.bottomMargin;
			}
		}
	}

	/**
	 * 生成默认的布局参数
	 */
	@Override
	protected CustomLayoutParams generateDefaultLayoutParams() {
		return new CustomLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
	}

	/**
	 * 生成布局参数
	 * 将布局参数包装成我们的
	 */
	@Override
	protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
		return new CustomLayoutParams(p);
	}

	/**
	 * 生成布局参数
	 * 从属性配置中生成我们的布局参数
	 */
	@Override
	public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new CustomLayoutParams(getContext(), attrs);
	}

	/**
	 * 检查当前布局参数是否是我们定义的类型这在code声明布局参数时常常用到
	 */
	@Override
	protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
		return p instanceof CustomLayoutParams;
	}

	/**
	 * 
	 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
	 * 
	 */
	public static class CustomLayoutParams extends MarginLayoutParams {

		public CustomLayoutParams(MarginLayoutParams source) {
			super(source);
		}

		public CustomLayoutParams(android.view.ViewGroup.LayoutParams source) {
			super(source);
		}

		public CustomLayoutParams(Context c, AttributeSet attrs) {
			super(c, attrs);
		}

		public CustomLayoutParams(int width, int height) {
			super(width, height);
		}
	}
}
