package com.darren.view_day12;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.HorizontalScrollView;

/**
 * @创建者 keepon
 * @创建时间 2019/3/9 0009 下午 8:22
 * @描述 ${TODO}
 * @版本 $$Rev$$
 * @更新者 $$Author$$
 * @更新时间 $$Date$$
 */
public class MyHorizontalScrollView extends HorizontalScrollView {

	public MyHorizontalScrollView(Context context) {
		this(context,null);
	}

	public MyHorizontalScrollView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	private static final String TAG = "MyHorizontalScrollView";
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		Log.e(TAG, "onScrollChanged l: "+ l+"  oldl=="+oldl );
	}
}
