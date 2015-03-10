package com.heike.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;


public class DateUtils extends org.apache.commons.lang.time.DateUtils{
	
	public static String FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_NORMAL_NO_SIGN = "yyyyMMddHHmmss";
	public static String FORMAT_NO_SIGN = "yyyy-MM-dd";
	public static String FORMAT_YEAR_MONTH = "yyyy-MM";
	
	/**
	 * 将日期转换成字符串
	 * @param format
	 * @param date
	 * @return
	 */
	public static String format(String format, Date date) {
		if(StringUtils.isBlank(format)) {
			format = FORMAT_NORMAL;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		return dateFormat.format(date);
	}
	
	public static String getCurrentDate(String format) {
		if(StringUtils.isBlank(format)) {
			format = FORMAT_NORMAL;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		
		return dateFormat.format(date);
	}
}




















