package com.mangocrab.controller.sharetrain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mangocrab.dao.TrainTrackerDao;
import com.mangocrab.model.TrainTracker;
import com.mangocrab.service.TrainTrackerService;

public class UpdateTrackingInfoController extends Controller {
	TrainTrackerDao dao=new TrainTrackerDao();
	TrainTrackerService service=new TrainTrackerService();
	
    @Override
    public Navigation run() throws Exception {
    	
    	System.out.println("In com.mangocrab.controller.sharetrain.UpdateTrackingInfoController run() method ");
		
		String currentStation = request.getParameter("currentStation");
		String trainName = request.getParameter("trainName");
		int trainNo=Integer.parseInt(request.getParameter("trainNo"));
		double time=Double.parseDouble(request.getParameter("time"));
				
		if(currentStation!=null && currentStation.contains(":")){
			System.out.println("found : in share train form.extarcting name only");
			currentStation=currentStation.split(":")[0];			
		}		
		
		
		service.updateTrainTrackingInfo(currentStation,trainName,trainNo,time);
		
		requestScope("message", "Thank you very much for your input.");
		return forward("/sharetrain/");
    }
    
}
