package com.mangocrab.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slim3.util.BeanUtil;

import com.mangocrab.dao.TrainTrackerDao;
import com.mangocrab.model.TrainTracker;


public class TrainTrackerService {
	private TrainTrackerDao dao=new TrainTrackerDao();
	
	public List<TrainTracker> getTrackingInfoByDest(String destination){
		return dao.getTrackingInfoByDest(destination);
	}
	public TrainTracker getTrackingInfoByTrainNumber(int trainNumber){
		
		return dao.getTrackingInfoByTrainNumber(trainNumber);
	}
	public void updateTrainTrackingInfo(String currentStation,String trainName,int trainNo,double time){
		
		TrainTracker tracker=new TrainTracker();
		tracker.setCurrentLocation(currentStation);
		tracker.setTrainName(trainName);
		tracker.setTrainNo(trainNo);
		tracker.setTime(time);
	
		dao.updateTrainTracker(tracker);
	}
	public int getActiveTrainsCount(String trainName){
		return dao.getActiveTrainsCount(trainName);
		
	}
	public int getAllActiveTrainsCount() {		
		return dao.getAllActiveTrainsCount();
	}


}
