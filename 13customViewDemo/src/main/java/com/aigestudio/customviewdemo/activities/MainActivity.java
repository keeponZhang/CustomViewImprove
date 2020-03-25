package com.aigestudio.customviewdemo.activities;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.aigestudio.customviewdemo.R;
import com.aigestudio.customviewdemo.views.AnimListView;

/**
 * Ö÷½çÃæ
 * 
 * @author Aige
 * @since 2014/11/17
 */
public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		AnimListView animListView = (AnimListView) findViewById(R.id.main_alv);
//		animListView.setAdapter(new BaseAdapter() {
//
//			@Override
//			public View getView(int position, View convertView, ViewGroup parent) {
//				convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item, null);
//				return convertView;
//			}
//
//			@Override
//			public long getItemId(int position) {
//				return 0;
//			}
//
//			@Override
//			public Object getItem(int position) {
//				return null;
//			}
//
//			@Override
//			public int getCount() {
//				return 100;
//			}
//		});
	}
}
