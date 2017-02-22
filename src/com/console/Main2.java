package com.console;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


public class Main2 {

	public static void main(String[] args) {

		try {
			LocalDateTime time = LocalDateTime.now();
			System.out.println(time);
			Calendar calendar = Calendar.getInstance();
			System.out.println(calendar.getTime());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dateFormat.parse(dateFormat.format(new Date()));
			System.out.println(dateFormat.format(new Date()));
			calendar.setTime(date);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
