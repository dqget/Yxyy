package com.ssh.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class SSHDateConverter extends StrutsTypeConverter{
	private DateFormat dareFormat;
	{
		dareFormat=new SimpleDateFormat("yyyy-MM=dd");
	}
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		if(arg2 == Date.class){
			try {
				return dareFormat.parse(arg1[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Date){
			return dareFormat.format((Date)arg1);
		}
		return null;
	}

}
