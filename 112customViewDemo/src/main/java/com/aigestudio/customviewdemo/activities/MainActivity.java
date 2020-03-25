package com.aigestudio.customviewdemo.activities;

import android.app.Activity;
import android.os.Bundle;

import com.aigestudio.customviewdemo.R;
import com.aigestudio.customviewdemo.views.CustomView;

/**
 * ������
 * 
 * @author Aige
 * @since 2014/11/17
 */
public class MainActivity extends Activity {
	private CustomView mCustomView;// ���ǵ��Զ���View

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ��ȡ�ؼ�
		mCustomView = (CustomView) findViewById(R.id.main_cv);

		/*
		 * ���߳�
		 */
		new Thread(mCustomView).start();
	}
}
