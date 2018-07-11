package util;

import java.text.SimpleDateFormat;

public class date {
	public date() {

	}

	public static java.sql.Date strToDate(String strDate) {
		String str = strDate;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		try {
			d = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date date = new java.sql.Date(d.getTime());
		return date;
	}

	public static java.sql.Date datt(String str) {
		System.out.println(str);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		try {
			d = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (d == null)
			return null;
		java.sql.Date date = new java.sql.Date(d.getTime());
		if (date == null) {
			return null;
		}
		return date;
	}
}
