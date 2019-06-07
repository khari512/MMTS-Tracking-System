package com.mangocrab.controller.timetable;

import static ch.lambdaj.Lambda.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import com.google.gson.Gson;

import com.mangocrab.model.TimeAndNumberMapping;
import com.mangocrab.service.TimeTableService;
import com.mangocrab.service.TrainTrackerService;
import com.mangocrab.util.MangoCrabUtil;

public class GetTimingsController extends Controller {	
	MangoCrabUtil util=new MangoCrabUtil();
	
	@Override
	public Navigation run() throws Exception {
			System.out
					.println("In com.mangocrab.controller.timetable.GetTimingsController run() method ");
	
			String fromStation = request.getParameter("fromStation");
			String toStation = request.getParameter("toStation");
			double timeRangeFrom = Double.parseDouble(request
					.getParameter("timeRangeFrom"));
			double timeRangeTo = Double.parseDouble(request
					.getParameter("timeRangeTo"));
			
			/* commenting logic as it was handling in javscript
			String quickTimeSelectionRadio=request.getParameter("quickTimeSelectionRadio");
			if("".equals("quickTimeSelectionRadio")==false && quickTimeSelectionRadio!=null){
				if(quickTimeSelectionRadio.equals("twoHours")){
					DateFormat firstFormat = new SimpleDateFormat("HH:mm");
					TimeZone firstTime = TimeZone.getTimeZone("IST");
					firstFormat.setTimeZone(firstTime);
					
					Calendar cal = Calendar.getInstance(); // creates calendar
					    cal.setTime(new Date()); // sets calendar time/date
					String currentTimeStr=firstFormat.format( cal.getTime()).replaceAll(":", ".");
					System.out.println("Time now=" + currentTimeStr);
					    cal.add(Calendar.HOUR_OF_DAY, 2); // adds one hour
					  //  cal.getTime(); // returns new date object, two hours in the future
					
					String addTwoHoursTimeStr=firstFormat.format( cal.getTime()).replaceAll(":", ".");
					System.out.println("Time now + 2hours= " + addTwoHoursTimeStr);
					timeRangeFrom=Double.parseDouble(currentTimeStr);
					timeRangeTo=Double.parseDouble(addTwoHoursTimeStr);
					
				}else if(quickTimeSelectionRadio.equals("morningTime")){
					timeRangeFrom=3.0;
					timeRangeTo=12.0;
					
				}else if(quickTimeSelectionRadio.equals("afternoonTime")){
					timeRangeFrom=12.0;
					timeRangeTo=18.0;
					
				}else if(quickTimeSelectionRadio.equals("eveningTime")){
					timeRangeFrom=18.0;
					timeRangeTo=23.59;
					
				}
			} */
	
			    
			List<TimeAndNumberMapping> timingsList=util.getTimingsList(fromStation, toStation, timeRangeFrom, timeRangeTo);
			
			if(timingsList.size()>0){
				requestScope("timingsList", timingsList);
				return forward("gettimings.jsp");
				
			}else{
				requestScope("message", "There are no trains for your search.please change the search criteria.");
				return forward("/searchtraintimings/");
			}
			
		}

	}
