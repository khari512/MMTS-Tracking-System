package com.mangocrab.controller.sharetrain;

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

import com.mangocrab.model.TimeAndNumberMapping;
import com.mangocrab.service.TimeTableService;
import com.mangocrab.service.TrainTrackerService;
import com.mangocrab.util.MangoCrabUtil;

public class GetAvailTrainsListController extends Controller {
	private MangoCrabUtil util=new MangoCrabUtil();
	private TimeTableService service = new TimeTableService();
	TrainTrackerService serviceTracker=new TrainTrackerService();
	
    @Override
    public Navigation run() throws Exception {
    	
    	System.out.println("In com.mangocrab.controller.sharetrain.GetAvailTrainsListController run() method ");
		
		String currentStation = request.getParameter("currentStation");
		String trainName = request.getParameter("trainName");
		
		if(currentStation!=null && currentStation.contains(":")){
			System.out.println("found : in share train form.extarcting name only");
			currentStation=currentStation.split(":")[0];			
		}
		
		DateFormat firstFormat = new SimpleDateFormat("HH:mm");
		TimeZone firstTime = TimeZone.getTimeZone("IST");
		firstFormat.setTimeZone(firstTime);
		
		Calendar cal = Calendar.getInstance(); // creates calendar
	    cal.setTime(new Date()); // sets calendar time/date
	    // comment below line  before commit and deploy as it used for testing after 00:00 hrs
	    //cal.add(Calendar.HOUR_OF_DAY, -2); 
	    
		String currentTimeStr=firstFormat.format( cal.getTime()).replaceAll(":", ".");
		System.out.println("Time now=" + currentTimeStr);
		
		// adds -1 to below HOUR_OF_DAY before commit and deploy.Its also used for testing after 00:00 hrs (mid night 12)
		cal.add(Calendar.HOUR_OF_DAY, -1); 
		//cal.add(Calendar.MINUTE,-30);
		//  cal.getTime(); // returns new date object, two hours in the future
		
		String pastHourTimeStr=firstFormat.format( cal.getTime()).replaceAll(":", ".");
		System.out.println("Time now -1 hours= " + pastHourTimeStr);
		
		double timeRangeFrom=Double.parseDouble(pastHourTimeStr);
		double timeRangeTo=Double.parseDouble(currentTimeStr);			
	
		    	
    	List<TimeAndNumberMapping> timingsList=new ArrayList<TimeAndNumberMapping>();
    	timingsList.addAll(service.getTimeTableList(currentStation, trainName,timeRangeFrom, timeRangeTo));
    	timingsList=sort(timingsList,on(TimeAndNumberMapping.class).getTime());
    	
    	if(timingsList.size()>1){
    		requestScope("time",currentTimeStr);
        	requestScope("currentStation",currentStation);
        	requestScope("timingsList",timingsList);
        	
            return forward("getAvailTrainsList.jsp");
    		
    	}else{
    		if(timingsList.size()==1){
    			for (Iterator iterator = timingsList.iterator(); iterator
						.hasNext();) {
					TimeAndNumberMapping timeAndNumberMapping = (TimeAndNumberMapping) iterator
							.next();
					serviceTracker.updateTrainTrackingInfo(currentStation, trainName, timeAndNumberMapping.getTrainNumber(), Double.parseDouble(currentTimeStr));
					requestScope("message","Thank you very much for your input.");
				}
    			
    		}else{
    			requestScope("message","We coudn't find any train for past 1 hour.Anyways thaks for your input.");
    			serviceTracker.updateTrainTrackingInfo(currentStation, trainName,000, Double.parseDouble(currentTimeStr));
    		}
    		
    	
    		return forward("shareTrainForm.jsp");
    	}
    	
    	
      //  return forward("getAvailTrainsList.jsp");
    }

}
