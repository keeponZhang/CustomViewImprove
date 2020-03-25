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
		// ������ʱ�����洢������������ֵ
		int parentDesireWidth = 0;
		int parentDesireHeight = 0;

		/*
		 * �������Ԫ��
		 */
		if (getChildCount() > 0) {
			// ��ô������Ԫ�ز�������в���
			for (int i = 0; i < getChildCount(); i++) {

				// ��ȡ��Ԫ��
				View child = getChildAt(i);

				// ��ȡ��Ԫ�صĲ��ֲ���
				LayoutParams clp = (LayoutParams) child.getLayoutParams();

				// ������Ԫ�ز�������߾�
				measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);

				// ���㸸����������ֵ
				parentDesireWidth += child.getMeasuredWidth() + clp.leftMargin + clp.rightMargin;
				parentDesireHeight += child.getMeasuredHeight() + clp.topMargin + clp.bottomMargin;
			}

			// ���Ǹ��������ڱ߾�
			parentDesireWidth += getPaddingLeft() + getPaddingRight();
			parentDesireHeight += getPaddingTop() + getPaddingBottom();

			// ���ԱȽϽ�����Сֵ������ֵ�Ĵ�С��ȡ��ֵ
			parentDesireWidth = Math.max(parentDesireWidth, getSuggestedMinimumWidth());
			parentDesireHeight = Math.max(parentDesireHeight, getSuggestedMinimumHeight());
		}

		// �������ղ���ֵO
		setMeasuredDimension(resolveSize(parentDesireWidth, widthMeasureSpec), resolveSize(parentDesireHeight, heightMeasureSpec));
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// ��ȡ�������ڱ߾�
		int parentPaddingLeft = getPaddingLeft();
		int parentPaddingTop = getPaddingTop();

		/*
		 * �������Ԫ��
		 */
		if (getChildCount() > 0) {
			// ����һ����ʱ�����洢�߶ȱ���ֵ
			int mutilHeight = 0;

			// ��ô������Ԫ�ز�������ж�λ����
			for (int i = 0; i < getChildCount(); i++) {
				// ��ȡһ����Ԫ��
				View child = getChildAt(i);

				LayoutParams clp = (LayoutParams) child.getLayoutParams();

				// ֪ͨ��Ԫ�ؽ��в���
				// ��ʱ���Ǹ������ڱ߾����Ԫ����߾��Ӱ��
				child.layout(parentPaddingLeft + clp.leftMargin, mutilHeight + parentPaddingTop + clp.topMargin, child.getMeasuredWidth() + parentPaddingLeft + clp.leftMargin, child.getMeasuredHeight() + mutilHeight + parentPaddingTop + clp.topMargin);

				// �ı�߶ȱ���ֵ
				mutilHeight += child.getMeasuredHeight() + clp.topMargin + clp.bottomMargin;
			}
		}
	}

	/**
	 * ����Ĭ�ϵĲ��ֲ���
	 */
	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		return new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
	}

	/**
	 * ���ɲ��ֲ���
	 * �����ֲ�����װ�����ǵ�
	 */
	@Override
	protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
		return new LayoutParams(p);
	}

	/**
	 * ���ɲ��ֲ���
	 * �������������������ǵĲ��ֲ���
	 */
	@Override
	public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new LayoutParams(getContext(), attrs);
	}

	/**
	 * ��鵱ǰ���ֲ����Ƿ������Ƕ������������code�������ֲ���ʱ�����õ�
	 */
	@Override
	protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
		return p instanceof LayoutParams;
	}

	/**
	 * 
	 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
	 * 
	 */
	public static class LayoutParams extends MarginLayoutParams {

		public LayoutParams(MarginLayoutParams source) {
			super(source);
		}

		public LayoutParams(android.view.ViewGroup.LayoutParams source) {
			super(source);
		}

		public LayoutParams(Context c, AttributeSet attrs) {
			super(c, attrs);
		}

		public LayoutParams(int width, int height) {
			super(width, height);
		}
	}
}
