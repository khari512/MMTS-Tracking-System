package com.mangocrab.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.mangocrab.meta.Slim3ModelMeta;
import com.mangocrab.model.Slim3Model;
import com.mangocrab.service.TrainTrackerService;

public class IndexController extends Controller {
	TrainTrackerService service=new TrainTrackerService();
	@Override
	protected Navigation run() throws Exception {
		System.out
				.println("In com.mangocrab.controller.IndexController run() method ");

		int activeTrackerCount=service.getAllActiveTrainsCount();
		//int sharesCount=service.getActiveTrainsCount("hyd");
		requestScope("activeTrackerCount", activeTrackerCount);
		return forward("index.jsp");
		
		/*
		 * response.getWriter().println("hello, world!"); Slim3Model m = new
		 * Slim3Model(); m.setProp1(new Date().toString()); Datastore.put(m);
		 * Slim3ModelMeta meta = Slim3ModelMeta.get(); List<Slim3Model> list =
		 * Datastore.query(meta).asList(); for (Slim3Model model : list) {
		 * response.getWriter().println(model.getProp1()); }
		 * response.flushBuffer(); return null;
		 */
	}

}
