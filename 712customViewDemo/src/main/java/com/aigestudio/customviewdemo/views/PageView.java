package com.aigestudio.customviewdemo.views;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 翻页View
 * 
 * @author Aige
 * @since 2014/12/17
 */
public class PageView extends View {
	private List<Bitmap> mBitmaps;// 位图数据列表

	public PageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {

	}
}
