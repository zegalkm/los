package com.ncos.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TotalUtils {

	/**
	 * 업로드패스 생성 , yyyy/MM/dd
	 */
	public static String getUploadPathByDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String[] date = sdf.format(cal.getTime()).split("-");
		return "/" + date[0] + "/" + date[1] + "/" + date[2];
	}
}
