package com.food.pos.contract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AeUtils {
	public static String getNowDate() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());

	}

	public static String getNowYearMon() {
		return new SimpleDateFormat("yyyyMM").format(new Date());

	}

	public static String getTx() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

	}

	public static String getShowDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	public static String getNowShowTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public static String getDate(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	public static String getNowYear() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}

	public static String getNowTime() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}
}
