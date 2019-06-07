package com.mangocrab.controller.traintracker;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mangocrab.service.TrainTrackerService;

public class IndexController extends Controller {
	TrainTrackerService trackerService=new TrainTrackerService(); 
    @Override
    public Navigation run() throws Exception {
    	int hydCount=trackerService.getActiveTrainsCount("hyd");
    	int falCount=trackerService.getActiveTrainsCount("fal");
    	int linCount=trackerService.getActiveTrainsCount("lin");
    	int unKnownDestCount=trackerService.getActiveTrainsCount("unknown");
    	int allActiveTrains=request.getParameter("allActiveTrains")!=null?Integer.parseInt(request.getParameter("allActiveTrains")):0;
    	
    	requestScope("hydCount", hydCount);
    	requestScope("falCount", falCount);
    	requestScope("linCount", linCount);
    	requestScope("unKnownDestCount", unKnownDestCount);
    	requestScope("allActiveTrains", allActiveTrains);
    	
        return forward("trainTrackingHome.jsp");
    }
}
