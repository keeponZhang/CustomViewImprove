package com.aigestudio.customviewdemo.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class ColumnsView extends View{
	
	private Paint mPaint;//坐标轴画笔
	private Path mPath;//坐标轴路径
	private int mWidth,mHeight;//宽高
	private int mStartX,mStartY;//画坐标轴的起始点
	private int mColumnWidth,mColumnHeight;//柱子的宽高
	private Path mColumnPath;//柱子的路径
	private Paint mColumnPaint;//柱子的画笔
	private int mSpace = 15;//柱子的一半间距
	private List<Float> mColumnHeiList;//柱子高度集合 
	private List<Integer> mColoerList = new ArrayList<Integer>();
	private List<Paint> mColoerPaintRandom;//颜色值的随机值集合

	public ColumnsView(Context context) {
		super(context);
		init();
		initData();
	}
	public ColumnsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		initData();
	}
	public ColumnsView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
		initData();
	}
	
	private void init(){
		mPaint = new Paint(Paint.DITHER_FLAG|Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.BLACK);
		mPaint.setStrokeWidth(5);
		mColumnPaint = new Paint(Paint.DITHER_FLAG|Paint.ANTI_ALIAS_FLAG);
		mColumnPaint.setStyle(Paint.Style.FILL);
		mColumnPaint.setColor(Color.RED);
//		mColumnPaint.setStrokeWidth(5);
		mPath = new Path();
		
		mColumnPath = new Path();
		mColoerList.add(Color.BLUE);
		mColoerList.add(Color.GREEN);
		mColoerList.add(Color.MAGENTA);
		mColoerList.add(Color.RED);
		mColoerList.add(Color.WHITE);
		mColoerList.add(Color.YELLOW);
		mColoerList.add(Color.CYAN);
		Paint p2 = new Paint();
		p2.setColor(Color.BLUE);
		Paint p3 = new Paint();
		p3.setColor(Color.GREEN);
		Paint p4 = new Paint();
		p4.setColor(Color.MAGENTA);
		Paint p5 = new Paint();
		p5.setColor(Color.RED);
		Paint p6 = new Paint();
		p6.setColor(Color.WHITE);
		Paint p7 = new Paint();
		p7.setColor(Color.YELLOW);
		Paint p8 = new Paint();
		p8.setColor(Color.CYAN);
		mColoerPaintRandom = new ArrayList<Paint>();
    	mColoerPaintRandom.add(p2);
    	mColoerPaintRandom.add(p3);
    	mColoerPaintRandom.add(p4);
    	mColoerPaintRandom.add(p5);
    	mColoerPaintRandom.add(p6);
    	mColoerPaintRandom.add(p7);
    	mColoerPaintRandom.add(p8);
	}
	/** 
     * 初始化柱子高度数据
     */  
    private void initData() {  
        Random random = new Random();  
        mColumnHeiList = new ArrayList<Float>();
        for (int i = 0; i < 7; i++) {  
        	mColumnHeiList.add((float) (random.nextInt(1000)));  
//        	mColoerPaintRandom.add(random.nextInt(7));  
        }  
    }  
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mWidth = w;
		mHeight = h;
		mStartX = mWidth/10;
		mStartY = mHeight/20;
		mColumnWidth = mStartX/2;
		mColumnHeight = 200;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 填充背景  
        canvas.drawColor(0xFF9596C4);
        //绘制坐标
        drawCoordinat(canvas);
		//绘制单位长度标记
        drawUnitLength(canvas);
        //绘制柱子
        drawColumns(canvas);
		
	}
	Paint paint = new Paint(Paint.DITHER_FLAG|Paint.ANTI_ALIAS_FLAG);
	private void drawColumns(Canvas canvas) {
		
		canvas.save();
		for (int i = 0; i < 7; i++) {
			mColumnPath.reset();
			mColumnPath.moveTo(i*mStartX+mStartX*3/2+mSpace, 19*mStartY);
			mColumnPath.lineTo(i*mStartX+mStartX*5/2-mSpace, 19*mStartY);
			mColumnPath.lineTo(i*mStartX+mStartX*5/2-mSpace, 19*mStartY-mColumnHeiList.get(i));
			mColumnPath.lineTo(i*mStartX+mStartX*3/2+mSpace, 19*mStartY-mColumnHeiList.get(i));
			mColumnPath.close();
			//设置画笔随机颜色
			Random random2 = new Random();  
//			mColumnPaint.setColor(mColoerList.get(random2.nextInt(7)));
//			mColumnPaint.setColor(mColoerList.get(i));
			
//			canvas.drawPath(mColumnPath, mColumnPaint);
//			canvas.drawPath(mColumnPath, mColoerPaintRandom.get(i));
			
			
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(mColoerList.get(i));
			canvas.drawPath(mColumnPath, paint);
			canvas.drawText("NO."+i, i*mStartX+mStartX*3/2+mSpace, 19*mStartY-mColumnHeiList.get(i), mPaint);
//			mColumnPaint.reset();
		}
		canvas.restore();
		
		
	}
	private void drawUnitLength(Canvas canvas) {
		canvas.save();
		for (int i = 1; i < 20; i++) {//绘制Y轴单位标记
			canvas.drawLine(mStartX-15, mStartY*i, mStartX, mStartY*i, mPaint);
		}
		for (int i = 1; i < 20; i++) {//绘制X轴单位标记
			canvas.drawLine(mStartX*i, 19*mStartY+15, mStartX*i, 19*mStartY, mPaint);
		}
		for (int i = 19; i > 1; i--) {//绘制Y轴单位数字
			canvas.drawText(mStartY*(19-i)+"", mStartX-80, mStartY*i+15, mPaint);
		}
		for (int i = 19; i > 1; i--) {//绘制X轴单位数字
			canvas.drawText(mStartX*(19-i)+"", (20-i)*mStartX, 19*mStartY+50, mPaint);
		}
		
		canvas.restore();
	}
	private void drawCoordinat(Canvas canvas) {
		canvas.save();
		mPath.moveTo(mStartX, mStartY);
		mPath.lineTo(mStartX, 19*mStartY);
		mPath.lineTo(19*mStartX, 19*mStartY);
		canvas.drawPath(mPath, mPaint);
		mPaint.setStrokeWidth(1);
		mPaint.setTextSize(30);
		canvas.drawText("X轴", mStartX+10, mStartY, mPaint);
		canvas.drawText("Y轴", 19*mStartX, 19*mStartY-20, mPaint);
		canvas.restore();
	}

}
