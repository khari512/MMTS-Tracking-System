package com.mangocrab.controller.timetable;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mangocrab.model.TimeAndNumberMapping;
import com.mangocrab.service.TimeTableService;



public class IndexController extends Controller {
	 private TimeTableService service = new TimeTableService();
    @Override
    public Navigation run() throws Exception {
    	System.out.println("In com.mangocrab.controller.timetable.IndexController run() method ");
    	List<TimeAndNumberMapping> timingsList=service.getTimeTableList("lingampally", "hyd", 8.10, 9.30);
    	requestScope("timingsList", timingsList);
        return forward("timeTableInput.jsp");
    }
}
