package com.vacinejaws.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat formatDatahora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static Date toDate(String date) throws ParseException {
		return format.parse(date);
	}
	
	public static String toString(Date date) {
		return format.format(date);
	}
	
	
	public static Date toDataHora(String date) throws ParseException {
		return formatDatahora.parse(date);
	}
	
	public static String toStringDataHora(Date date) {
		return formatDatahora.format(date);
	}
	
	
}
