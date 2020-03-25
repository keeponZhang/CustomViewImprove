package com.aigestudio.customviewdemo.utils;

import android.util.Log;

/**
 * 日志输出工具类
 * 
 * @author AigeStudio
 * @version 1.0.0
 * @since 2014/9/5
 */
public final class LogUtil {
	private static final boolean IS_LOG = true;// Log的全局开关
	private static final String TAG = "AigeStudio";// 默认的TAG

	public static void v(Object msg) {
		if (IS_LOG)
			Log.v(TAG, msg + "");
	}

	public static void d(Object msg) {
		if (IS_LOG)
			Log.d(TAG, msg + "");
	}

	public static void i(Object msg) {
		if (IS_LOG)
			Log.i(TAG, msg + "");
	}

	public static void w(Object msg) {
		if (IS_LOG)
			Log.w(TAG, msg + "");
	}

	public static void e(Object msg) {
		if (IS_LOG)
			Log.e(TAG, msg + "");
	}

	public static void v(String tag, Object msg) {
		if (IS_LOG)
			Log.v(tag, msg + "");
	}

	public static void d(String tag, Object msg) {
		if (IS_LOG)
			Log.d(tag, msg + "");
	}

	public static void i(String tag, Object msg) {
		if (IS_LOG)
			Log.i(tag, msg + "");
	}

	public static void w(String tag, Object msg) {
		if (IS_LOG)
			Log.w(tag, msg + "");
	}

	public static void e(String tag, Object msg) {
		if (IS_LOG)
			Log.e(tag, msg + "");
	}
}
