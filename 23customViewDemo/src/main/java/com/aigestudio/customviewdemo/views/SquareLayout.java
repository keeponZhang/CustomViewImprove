package com.aigestudio.customviewdemo.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.aigestudio.customviewdemo.R;

/**
 * 
 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
 * @since 2015/1/23
 * 
 */
public class SquareLayout extends ViewGroup {
	private static final int ORIENTATION_HORIZONTAL = 0, ORIENTATION_VERTICAL = 1;// 排列方向的常量标识值
	private static final int DEFAULT_MAX_ROW = Integer.MAX_VALUE, DEFAULT_MAX_COLUMN = Integer.MAX_VALUE;// 最大行列默认值

	private int mMaxRow = DEFAULT_MAX_ROW;// 最大行数
	private int mMaxColumn = DEFAULT_MAX_COLUMN;// 最大列数

	private int mOrientation = ORIENTATION_VERTICAL;// 排列方向默认横向

	public SquareLayout(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 初始化最大行列数
		mMaxRow = 2;
		mMaxColumn = 2;
	}

	@Override
	public boolean shouldDelayChildPressedState() {
		return false;
	}
	
	@SuppressLint("NewApi")
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		/*
		 * 声明临时变量存储父容器的期望值
		 * 该值应该等于父容器的内边距加上所有子元素的测量宽高和外边距
		 */
		int parentDesireWidth = 0;
		int parentDesireHeight = 0;

		// 声明临时变量存储子元素的测量状态
		int childMeasureState = 0;

		/*
		 * 如果父容器内有子元素
		 */
		if (getChildCount() > 0) {
			// 声明两个一维数组存储子元素宽高数据
			int[] childWidths = new int[getChildCount()];
			int[] childHeights = new int[getChildCount()];

			/*
			 * 那么就遍历子元素
			 */
			for (int i = 0; i < getChildCount(); i++) {
				// 获取对应遍历下标的子元素
				View child = getChildAt(i);

				/*
				 * 如果该子元素没有以“不占用空间”的方式隐藏则表示其需要被测量计算
				 */
				if (child.getVisibility() != View.GONE) {

					// 测量子元素并考量其外边距
					measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);

					// 比较子元素测量宽高并比较取其较大值
					int childMeasureSize = Math.max(child.getMeasuredWidth(), child.getMeasuredHeight());

					// 重新封装子元素测量规格
					int childMeasureSpec = MeasureSpec.makeMeasureSpec(childMeasureSize, MeasureSpec.EXACTLY);

					// 重新测量子元素
					child.measure(childMeasureSpec, childMeasureSpec);

					// 获取子元素布局参数
					MarginLayoutParams mlp = (MarginLayoutParams) child.getLayoutParams();

					/*
					 * 考量外边距计算子元素实际宽高并将数据存入数组
					 */
					childWidths[i] = child.getMeasuredWidth() + mlp.leftMargin + mlp.rightMargin;
					childHeights[i] = child.getMeasuredHeight() + mlp.topMargin + mlp.bottomMargin;

					// 合并子元素的测量状态
					childMeasureState = combineMeasuredStates(childMeasureState, child.getMeasuredState());
				}
			}

			// 声明临时变量存储行/列宽高
			int indexMultiWidth = 0, indexMultiHeight = 0;

			/*
			 * 如果为横向排列
			 */
			if (mOrientation == ORIENTATION_HORIZONTAL) {
				/*
				 * 如果子元素数量大于限定值则进行折行计算
				 */
				if (getChildCount() > mMaxColumn) {

					// 计算产生的行数
					int row = getChildCount() / mMaxColumn;

					// 计算余数
					int remainder = getChildCount() % mMaxColumn;

					// 声明临时变量存储子元素宽高数组下标值
					int index = 0;

					/*
					 * 遍历数组计算父容器期望宽高值
					 */
					for (int x = 0; x < row; x++) {
						for (int y = 0; y < mMaxColumn; y++) {
							// 单行宽度累加
							indexMultiWidth += childWidths[index];

							// 单行高度取最大值
							indexMultiHeight = Math.max(indexMultiHeight, childHeights[index++]);
						}
						// 每一行遍历完后将该行宽度与上一行宽度比较取最大值
						parentDesireWidth = Math.max(parentDesireWidth, indexMultiWidth);

						// 每一行遍历完后累加各行高度
						parentDesireHeight += indexMultiHeight;

						// 重置参数
						indexMultiWidth = indexMultiHeight = 0;
					}

					/*
					 * 如果有余数表示有子元素未能占据一行
					 */
					if (remainder != 0) {
						/*
						 * 遍历剩下的这些子元素将其宽高计算到父容器期望值
						 */
						for (int i = getChildCount() - remainder; i < getChildCount(); i++) {
							indexMultiWidth += childWidths[i];
							indexMultiHeight = Math.max(indexMultiHeight, childHeights[i]);
						}
						parentDesireWidth = Math.max(parentDesireWidth, indexMultiWidth);
						parentDesireHeight += indexMultiHeight;
						indexMultiWidth = indexMultiHeight = 0;
					}
				}

				/*
				 * 如果子元素数量还没有限制值大那么直接计算即可不须折行
				 */
				else {
					for (int i = 0; i < getChildCount(); i++) {
						// 累加子元素的实际高度
						parentDesireHeight += childHeights[i];

						// 获取子元素中宽度最大值
						parentDesireWidth = Math.max(parentDesireWidth, childWidths[i]);
					}
				}
			}

			/*
			 * 如果为竖向排列
			 */
			else if (mOrientation == ORIENTATION_VERTICAL) {
				if (getChildCount() > mMaxRow) {
					int column = getChildCount() / mMaxRow;
					int remainder = getChildCount() % mMaxRow;
					int index = 0;

					for (int x = 0; x < column; x++) {
						for (int y = 0; y < mMaxRow; y++) {
							indexMultiHeight += childHeights[index];
							indexMultiWidth = Math.max(indexMultiWidth, childWidths[index++]);
						}
						parentDesireHeight = Math.max(parentDesireHeight, indexMultiHeight);
						parentDesireWidth += indexMultiWidth;
						indexMultiWidth = indexMultiHeight = 0;
					}

					if (remainder != 0) {
						for (int i = getChildCount() - remainder; i < getChildCount(); i++) {
							indexMultiHeight += childHeights[i];
							indexMultiWidth = Math.max(indexMultiHeight, childWidths[i]);
						}
						parentDesireHeight = Math.max(parentDesireHeight, indexMultiHeight);
						parentDesireWidth += indexMultiWidth;
						indexMultiWidth = indexMultiHeight = 0;
					}
				} else {
					for (int i = 0; i < getChildCount(); i++) {
						// 累加子元素的实际宽度
						parentDesireWidth += childWidths[i];

						// 获取子元素中高度最大值
						parentDesireHeight = Math.max(parentDesireHeight, childHeights[i]);
					}
				}
			}

			/*
			 * 考量父容器内边距将其累加到期望值
			 */
			parentDesireWidth += getPaddingLeft() + getPaddingRight();
			parentDesireHeight += getPaddingTop() + getPaddingBottom();

			/*
			 * 尝试比较父容器期望值与Android建议的最小值大小并取较大值
			 */
			parentDesireWidth = Math.max(parentDesireWidth, getSuggestedMinimumWidth());
			parentDesireHeight = Math.max(parentDesireHeight, getSuggestedMinimumHeight());
		}

		// 确定父容器的测量宽高
		setMeasuredDimension(resolveSizeAndState(parentDesireWidth, widthMeasureSpec, childMeasureState),
				resolveSizeAndState(parentDesireHeight, heightMeasureSpec, childMeasureState << MEASURED_HEIGHT_STATE_SHIFT));
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		/*
		 * 如果父容器下有子元素
		 */
		if (getChildCount() > 0) {
			// 声明临时变量存储宽高倍增值
			int multi = 0;

			// 指数倍增值
			int indexMulti = 1;

			// 声明临时变量存储行/列宽高
			int indexMultiWidth = 0, indexMultiHeight = 0;

			// 声明临时变量存储行/列临时宽高
			int tempHeight = 0, tempWidth = 0;

			/*
			 * 遍历子元素
			 */
			for (int i = 0; i < getChildCount(); i++) {
				// 获取对应遍历下标的子元素
				View child = getChildAt(i);

				/*
				 * 如果该子元素没有以“不占用空间”的方式隐藏则表示其需要被测量计算
				 */
				if (child.getVisibility() != View.GONE) {
					// 获取子元素布局参数
					MarginLayoutParams mlp = (MarginLayoutParams) child.getLayoutParams();

					// 获取控件尺寸
					int childActualSize = child.getMeasuredWidth();// child.getMeasuredHeight()

					/*
					 * 如果为横向排列
					 */
					if (mOrientation == ORIENTATION_HORIZONTAL) {
						/*
						 * 如果子元素数量比限定值大
						 */
						if (getChildCount() > mMaxColumn) {
							/*
							 * 根据当前子元素进行布局
							 */
							if (i < mMaxColumn * indexMulti) {
								child.layout(getPaddingLeft() + mlp.leftMargin + indexMultiWidth, getPaddingTop() + mlp.topMargin + indexMultiHeight,
										childActualSize + getPaddingLeft() + mlp.leftMargin + indexMultiWidth, childActualSize + getPaddingTop()
												+ mlp.topMargin + indexMultiHeight);
								indexMultiWidth += childActualSize + mlp.leftMargin + mlp.rightMargin;
								tempHeight = Math.max(tempHeight, childActualSize) + mlp.topMargin + mlp.bottomMargin;

								/*
								 * 如果下一次遍历到的子元素下标值大于限定值
								 */
								if (i + 1 >= mMaxColumn * indexMulti) {
									// 那么累加高度到高度倍增值
									indexMultiHeight += tempHeight;

									// 重置宽度倍增值
									indexMultiWidth = 0;

									// 增加指数倍增值
									indexMulti++;
								}
							}
						} else {
							// 确定子元素左上、右下坐标
							child.layout(getPaddingLeft() + mlp.leftMargin + multi, getPaddingTop() + mlp.topMargin, childActualSize
									+ getPaddingLeft() + mlp.leftMargin + multi, childActualSize + getPaddingTop() + mlp.topMargin);

							// 累加倍增值
							multi += childActualSize + mlp.leftMargin + mlp.rightMargin;
						}
					}

					/*
					 * 如果为竖向排列
					 */
					else if (mOrientation == ORIENTATION_VERTICAL) {
						if (getChildCount() > mMaxRow) {
							if (i < mMaxRow * indexMulti) {
								child.layout(getPaddingLeft() + mlp.leftMargin + indexMultiWidth, getPaddingTop() + mlp.topMargin + indexMultiHeight,
										childActualSize + getPaddingLeft() + mlp.leftMargin + indexMultiWidth, childActualSize + getPaddingTop()
												+ mlp.topMargin + indexMultiHeight);
								indexMultiHeight += childActualSize + mlp.topMargin + mlp.bottomMargin;
								tempWidth = Math.max(tempWidth, childActualSize) + mlp.leftMargin + mlp.rightMargin;
								if (i + 1 >= mMaxRow * indexMulti) {
									indexMultiWidth += tempWidth;
									indexMultiHeight = 0;
									indexMulti++;
								}
							}
						} else {
							// 确定子元素左上、右下坐标
							child.layout(getPaddingLeft() + mlp.leftMargin, getPaddingTop() + mlp.topMargin + multi, childActualSize
									+ getPaddingLeft() + mlp.leftMargin, childActualSize + getPaddingTop() + mlp.topMargin + multi);

							// 累加倍增值
							multi += childActualSize + mlp.topMargin + mlp.bottomMargin;
						}
					}
				}
			}
		}
	}

	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		return new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
	}

	@Override
	protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
		return new LayoutParams(p);
	}

	@Override
	public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new LayoutParams(getContext(), attrs);
	}

	@Override
	protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
		return p instanceof LayoutParams;
	}

	public static class LayoutParams extends MarginLayoutParams {
		public int mGravity = Gravity.LEFT | Gravity.RIGHT;// 对齐方式

		public LayoutParams(MarginLayoutParams source) {
			super(source);
		}

		public LayoutParams(android.view.ViewGroup.LayoutParams source) {
			super(source);
		}

		public LayoutParams(Context c, AttributeSet attrs) {
			super(c, attrs);

			/*
			 * 获取xml对应属性
			 */
			TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.SquareLayout);
			mGravity = a.getInt(R.styleable.SquareLayout_my_gravity, 0);
		}

		public LayoutParams(int width, int height) {
			super(width, height);
		}
	}
}
