package com.mangocrab.service;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mangocrab.model.TimeAndNumberMapping;
import com.mangocrab.model.Timings;
import com.mangocrab.meta.TimingsMeta;




public class TimeTableService {
	private TimingsMeta meta=new TimingsMeta();
	
	public void createTimetable(Timings timings) {
		Transaction tx = Datastore.beginTransaction();
		Datastore.put(timings);
		tx.commit();
		System.out.println("Timings obj inserted successfully");
		return ;
	}
	
	public List<TimeAndNumberMapping> getTimeTableList(String srcStation,String trainName,double timeRange1,double timeRange2) {
		List<TimeAndNumberMapping> timeAndNumberMappingList=new ArrayList<TimeAndNumberMapping>();
		List<TimeAndNumberMapping> resultsList= new ArrayList<TimeAndNumberMapping>();
		List<TimeAndNumberMapping> tempList= new ArrayList<TimeAndNumberMapping>();
		
		List<Timings> timingsList= Datastore.query(meta).filter(meta.boardingAt.startsWith(srcStation)).filter(meta.trainName.equal(trainName)).asList();
	
		for(Timings temp:timingsList){
			tempList=temp.getTimeAndNumberMappingList();
			if(tempList!=null){
				timeAndNumberMappingList.addAll(tempList);			
			}
		}
		if(timeAndNumberMappingList.size()>0){
			System.out.println("query results with out time range ");
			for(TimeAndNumberMapping timeAndNumberMapping:timeAndNumberMappingList){
				System.out.println("train Number "+timeAndNumberMapping.getTrainNumber()+"Time "+timeAndNumberMapping.getTime());
			}			
			resultsList= filter(having(on(TimeAndNumberMapping.class).getTime(), greaterThanOrEqualTo(timeRange1)), timeAndNumberMappingList);
			resultsList= filter(having(on(TimeAndNumberMapping.class).getTime(), lessThanOrEqualTo(timeRange2)), resultsList);
			System.out.println("query results with time range ");
			for(TimeAndNumberMapping timeAndNumberMapping:resultsList){
				System.out.println("train Number "+timeAndNumberMapping.getTrainNumber()+"Time "+timeAndNumberMapping.getTime());
			}
		}

		
		return resultsList;
	}
	public String getTimeTableListJSON(String srcStation,String trainName,double timeRange1,double timeRange2){
		List<TimeAndNumberMapping> resultsList= new ArrayList<TimeAndNumberMapping>();
		resultsList=getTimeTableList( srcStation, trainName, timeRange1, timeRange2);
		//converting to json format
		Gson gson = new Gson();		
		System.out.println("---JSON formated Result--");
		System.out.println(gson.toJson(resultsList).toString());
		if(resultsList!=null){
			return gson.toJson(resultsList).toString();
		}
		return null;
	}

	public List<Timings> getTimingsOnlyList(String srcStation,String trainName,double timeRange1,double timeRange2) {
		List<Number> numObj;	
		List<Timings> hyd= Datastore.query(meta).filter(meta.boardingAt.startsWith(srcStation)).filter(meta.trainName.equal(trainName)).asList();
		for(Timings temp:hyd){
			 numObj=temp.arrayListTimings();
			for(Number num:numObj){
				System.out.println("query results with out time range "+num);
			}			
			List<Number> results= filter(having(on(Number.class).doubleValue(), greaterThanOrEqualTo(timeRange1)), numObj);
			results= filter(having(on(Number.class).doubleValue(), lessThanOrEqualTo(timeRange2)), results);
			for(Number num:results){
				System.out.println("query  results with time range "+num);
			}		
		}		
		return hyd;
	}
}
