package com.qa.rediff.utilities;

import java.util.Date;

public class Rediff_Utilities {
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace("", "_").replace(",", "_");
		return "chowdhurygs" +emailTimeStamp+ "@gmail.com";
	}
	
	public static String generatePasswordWithTimeStamp() {
		Date date = new Date();
		String passwordTimeStamp = date.toString().replace("", "_").replace(",", "_");
		return "Shajlee1@" +passwordTimeStamp;
		
	}
	
	public static final int PAGELOAD_WAIT_TIME = 10;
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int SCRIPTLOAD_WAIT_TIME = 100;
	
	
	}


