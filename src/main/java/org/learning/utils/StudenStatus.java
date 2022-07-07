package org.learning.utils;

import java.time.LocalDate;

public class StudenStatus {
	public static final byte REGISTERD_STUDENT=1;
	public static final byte UNREGISTERD_STUDENT=0;
	
	public static LocalDate toDate(String stringDate) {
		String [] dateArray = stringDate.split("-");
		
		int year= Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int day = Integer.parseInt(dateArray[2]);
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}
	
	
}
