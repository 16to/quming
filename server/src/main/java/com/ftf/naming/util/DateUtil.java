package com.ftf.naming.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtil {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static Calendar getCalender(String dateStr) {
		try {
			DATE_FORMAT.setLenient(false);
			Date date = DATE_FORMAT.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		} catch (ParseException e) {
			log.error("日期格式错误");
		}
		return null;
	}
}
