package com.aigestudio.customviewdemo.views;

import com.aigestudio.customviewdemo.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * ����BitmapDemo
 * 
 * @author Aige
 * @since 2014/12/8
 */
public class BitmapMeshView extends View {
	private static final int WIDTH = 19;// ����ָ�ɵ���������
	private static final int HEIGHT = 19;// ����ָ�ɵ���������
	private static final int COUNT = (WIDTH + 1) * (HEIGHT + 1);// ����������֯�����ĵ�����

	private Bitmap mBitmap;// λͼ��Դ

	private float[] verts;// �������������

	public BitmapMeshView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// ��ȡλͼ��Դ
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gril);

		// ʵ��������
		verts = new float[COUNT * 2];

		/*
		 * ���ɸ�����������
		 */
		int index = 0;  
        float multiple = mBitmap.getWidth();  
        for (int y = 0; y <= HEIGHT; y++) {  
            float fy = mBitmap.getHeight() * y / HEIGHT;  
            for (int x = 0; x <= WIDTH; x++) {  
                float fx = mBitmap.getWidth() * x / WIDTH + ((HEIGHT - y) * 1.0F / HEIGHT * multiple);  
                setXY(fx, fy, index);  
                index += 1;  
            }  
        }  
//		int index = 0;
//		float multipleY = mBitmap.getHeight() / HEIGHT;
//		float multipleX = mBitmap.getWidth() / WIDTH;
//		for (int y = 0; y <= HEIGHT; y++) {
//			float fy = multipleY * y;
//			for (int x = 0; x <= WIDTH; x++) {
//				float fx = multipleX * x;
//
//				setXY(fx, fy, index);
//
//				if (5 == y) {
//					if (8 == x) {
//						setXY(fx - multipleX, fy - multipleY, index);
//					}
//					if (9 == x) {
//						setXY(fx + multipleX, fy - multipleY, index);
//					}
//				}
//				if (6 == y) {
//					if (8 == x) {
//						setXY(fx - multipleX, fy + multipleY, index);
//					}
//					if (9 == x) {
//						setXY(fx + multipleX, fy + multipleY, index);
//					}
//				}
//
//				index += 1;
//			}
//		}
	}

	/**
	 * �������Ľ��������������
	 * 
	 * @param fx
	 *            x����
	 * @param fy
	 *            y����
	 * @param index
	 *            ��ʶֵ
	 */
	private void setXY(float fx, float fy, int index) {
		verts[index * 2 + 0] = fx;
		verts[index * 2 + 1] = fy;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// ��������λͼ
		canvas.drawBitmapMesh(mBitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);
	}
}
