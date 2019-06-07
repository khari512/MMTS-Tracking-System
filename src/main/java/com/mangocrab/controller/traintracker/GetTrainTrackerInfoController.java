package com.mangocrab.controller.traintracker;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mangocrab.model.Suggestions;
import com.mangocrab.model.TrainTracker;
import com.mangocrab.service.SuggestionsService;
import com.mangocrab.service.TrainTrackerService;

public class GetTrainTrackerInfoController extends Controller {

	private TrainTrackerService service=new TrainTrackerService();
    @Override
    public Navigation run() throws Exception {
    	System.out.println("In com.mangocrab.controller.traintracker.GetTrainTrackerInfoController navigation() method");
    	
    	String destination=request.getParameter("trainName");
    	if(destination==null || "".equals(destination)==true){
    		destination="all";
    	}
    	List<TrainTracker> trackingInfoList=service.getTrackingInfoByDest(destination);
    	
    	requestScope("trackingInfoList",trackingInfoList);
        return forward("getTrainTrackerInfo.jsp");
    }

}
