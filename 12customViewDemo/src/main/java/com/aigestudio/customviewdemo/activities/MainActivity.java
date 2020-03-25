package com.aigestudio.customviewdemo.activities;

import android.app.Activity;
import android.os.Bundle;

import com.aigestudio.customviewdemo.R;
import com.aigestudio.customviewdemo.views.PolylineView;

/**
 * Ö÷½çÃæ
 * 
 * @author Aige
 * @since 2014/11/17
 */
public class MainActivity extends Activity {
	private PolylineView mPolylineView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		// mPolylineView = (PolylineView) findViewById(R.id.main_pv);
		//
		// List<PointF> pointFs = new ArrayList<PointF>();
		// pointFs.add(new PointF(0.3F, 0.5F));
		// pointFs.add(new PointF(1F, 2.7F));
		// pointFs.add(new PointF(2F, 3.5F));
		// pointFs.add(new PointF(3F, 3.2F));
		// pointFs.add(new PointF(4F, 1.8F));
		// pointFs.add(new PointF(5F, 1.5F));
		// pointFs.add(new PointF(6F, 2.2F));
		// pointFs.add(new PointF(7F, 5.5F));
		// pointFs.add(new PointF(8F, 7F));
		// pointFs.add(new PointF(8.6F, 5.7F));
		//
		// mPolylineView.setData(pointFs, "Money", "Time");
	}
}
