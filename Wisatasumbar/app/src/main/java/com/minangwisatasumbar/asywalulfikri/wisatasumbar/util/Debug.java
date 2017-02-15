package com.minangwisatasumbar.asywalulfikri.wisatasumbar.util;

import android.util.Log;

public class Debug {
	public static void i(String tag, String message) {
		if (Constanta.ENABLE_DEBUG) Log.i(tag, message);
	}
	
	public static void i(String message) {
		Debug.i(Constanta.TAG, message);
	}
	
	public static void e(String tag, String message) {
		if (Constanta.ENABLE_DEBUG) Log.e(tag, message);
	}
	
	public static void e(String message) {
		Debug.e(Constanta.TAG, message);
	}
	
	public static void e(String tag, String message, Exception e) {
		if (Constanta.ENABLE_DEBUG) {
			Log.e(tag, message);

			e.printStackTrace();
		}
	}
}
