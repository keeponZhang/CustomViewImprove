package com.aigestudio.customviewdemo.activities;

import android.app.Activity;
import android.os.Bundle;

import com.aigestudio.customviewdemo.R;
import com.aigestudio.customviewdemo.views.CustomView;

/**
 * 主界面
 * 
 * @author Aige
 * @since 2014/11/17
 */
public class MainActivity extends Activity {
	private CustomView mCustomView;// 我们的自定义View

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 获取控件
		mCustomView = (CustomView) findViewById(R.id.main_cv);

		/*
		 * 开线程
		 */
		new Thread(mCustomView).start();
	}
}
