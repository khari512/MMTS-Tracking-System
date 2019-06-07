package com.mangocrab.controller.searchtraintimings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

	@Override
	public Navigation run() throws Exception {
		System.out
				.println("In com.mangocrab.controller.searchtraintimings.IndexController run() method ");
		
		DateFormat firstFormat = new SimpleDateFormat("HH:mm");
		TimeZone firstTime = TimeZone.getTimeZone("IST");
		firstFormat.setTimeZone(firstTime);
		
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date()); // sets calendar time/date
		String currentTimeStr=firstFormat.format( cal.getTime()).split(":")[0];
		System.out.println("Time now=" + currentTimeStr);
		 cal.add(Calendar.HOUR_OF_DAY, 2); // adds one hour
		  //  cal.getTime(); // returns new date object, two hours in the future
		
		String addTwoHoursTimeStr=firstFormat.format( cal.getTime()).split(":")[0];
		System.out.println("Time now + 2hours= " + addTwoHoursTimeStr);
		requestScope("currentTime", currentTimeStr);
		requestScope("twoHoursLaterTime", addTwoHoursTimeStr);
		return forward("searchTrainTimingsForm.jsp");
	}
}
