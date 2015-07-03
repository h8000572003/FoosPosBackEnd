package com.food.pos.contract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AeUtils {
	public static String getNowTime() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	public static String getNowTime(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	
	public static String getNowYear() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}
}
