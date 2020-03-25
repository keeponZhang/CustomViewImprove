package com.aigestudio.customviewdemo.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.aigestudio.customviewdemo.R;
import com.aigestudio.customviewdemo.views.ImgView;

/**
 * Ö÷½çÃæ
 * 
 * @author Aige {@link http://blog.csdn.net/aigestudio}
 * @since 2014/11/17
 */
public class MainActivity extends Activity {
//	private ImgView mImgView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		mImgView = (ImgView) findViewById(R.id.main_pv);
//		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lovestory);
//		mImgView.setBitmap(bitmap);
	}
}
