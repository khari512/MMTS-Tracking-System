package com.mangocrab.dao;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;
import com.mangocrab.meta.TrainTrackerMeta;
import com.mangocrab.model.Suggestions;
import com.mangocrab.model.TimeAndNumberMapping;
import com.mangocrab.model.TrainTracker;

public class TrainTrackerDao extends DaoBase<TrainTracker>{
	private TrainTrackerMeta meta =new TrainTrackerMeta();
	
	
	public void updateTrainTracker(TrainTracker tracker){
		TrainTracker existingTracker=null;
		/* In two cases we will tracker.getTrainNo()==0. (1) when user selects unknow destination.(2) when there is no available train for the selection */
		if(tracker.getTrainNo()!=0){
			existingTracker=getTrainTrackerByNo(tracker.getTrainNo());
		}else if(tracker.getTrainName()!=null && tracker.getTrainName().equalsIgnoreCase("unknow")){
			tracker.setTrainNo(TrainTracker.UNKNOW_DEST_CODE);
		}else{
			tracker.setTrainNo(TrainTracker.TRAIN_NUMBER_NOT_FOUND);
		}
		
		if(existingTracker!=null){
			System.out.println("TrainTracker obj for this train already exist in Datastrore");			
			existingTracker.setCreatedDate(tracker.getCreatedDate());
			existingTracker.setCurrentLocation(tracker.getCurrentLocation());				
		}else{
			existingTracker=tracker;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		
		try {
			Calendar rightNow = Calendar.getInstance();
			Calendar cal = new GregorianCalendar(
			   rightNow.get(Calendar.YEAR),
			   rightNow.get(Calendar.MONTH),
			   rightNow.get(Calendar.DAY_OF_MONTH));
			Date now = cal.getTime();
			
			existingTracker.setCreatedDate(now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Transaction tx = Datastore.beginTransaction();
		Datastore.put(existingTracker);
		tx.commit();
		System.out.println("TrainTracker obj inserted successfully");		
	}
	
	public TrainTracker getTrainTrackerByNo(int trainNo){
		
		List<TrainTracker> tracker=Datastore.query(meta).filter(meta.trainNo.equal(trainNo)).sortInMemory(meta.createdDate.desc).limit(1).asList();
		TrainTracker trackerFirstObj=null;
		for (Iterator iterator = tracker.iterator(); iterator.hasNext();) {
			TrainTracker trainTracker = (TrainTracker) iterator.next();
			System.out.println(trainTracker.toString());
			
		}
		if(tracker.size()>0){
			trackerFirstObj=tracker.get(0);
		}
		
		return trackerFirstObj;
	}
	public List<TrainTracker> getTrackingInfoByDest(String destination){
		//qurery not completed yet--add time filter too
		Calendar rightNow = Calendar.getInstance();
		Calendar cal = new GregorianCalendar(
		   rightNow.get(Calendar.YEAR),
		   rightNow.get(Calendar.MONTH),
		   rightNow.get(Calendar.DAY_OF_MONTH));
		Date now = cal.getTime();
		
		DateTime dt=new DateTime();		
		DateTime dtInd = dt.withZone(DateTimeZone.forID("Asia/Calcutta"));
		dtInd=dtInd.minusMinutes(80); //60 mins past to currnet time
		DateTimeFormatter fmt = DateTimeFormat.forPattern("HH.mm");
		double pastTime=Double.parseDouble(fmt.print(dtInd));
		
		List<TrainTracker> tracker=null;
		if(destination.equalsIgnoreCase("all")){
			tracker=Datastore.query(meta).filter(meta.createdDate.equal(now)).filter(meta.time.greaterThanOrEqual(pastTime)).sortInMemory(meta.createdDate.desc).asList();
		}else{
			tracker=Datastore.query(meta).filter(meta.createdDate.equal(now)).filter(meta.trainName.equal(destination)).filter(meta.time.greaterThanOrEqual(pastTime)).sortInMemory(meta.createdDate.desc).asList();	
		}
		
	
		
		if(tracker!=null){
			//tracker=filter(having(on(TrainTracker.class).getTime(), greaterThanOrEqualTo(pastTime)), tracker);
		}
		
		return tracker;
		
	}
	
	public int getAllActiveTrainsCount() {
		int count=0;
		Calendar rightNow = Calendar.getInstance();
		Calendar cal = new GregorianCalendar(
		   rightNow.get(Calendar.YEAR),
		   rightNow.get(Calendar.MONTH),
		   rightNow.get(Calendar.DAY_OF_MONTH));
		Date now = cal.getTime();
		
		DateTime dt=new DateTime();		
		DateTime dtInd = dt.withZone(DateTimeZone.forID("Asia/Calcutta"));
		dtInd=dtInd.minusMinutes(60); //60 mins past to currnet time
		DateTimeFormatter fmt = DateTimeFormat.forPattern("HH.mm");
		double pastTime=Double.parseDouble(fmt.print(dtInd));
		
		count=Datastore.query(meta).filter(meta.createdDate.equal(now)).filter(meta.time.greaterThanOrEqual(pastTime)).count();	
		
		//tracker=filter(having(on(TrainTracker.class).getTime(), greaterThanOrEqualTo(pastTime)), tracker);
	
		return count;
	}

	public int getActiveTrainsCount(String trainName) {
		int count=0;		
		
		Calendar rightNow = Calendar.getInstance();
		Calendar cal = new GregorianCalendar(
		   rightNow.get(Calendar.YEAR),
		   rightNow.get(Calendar.MONTH),
		   rightNow.get(Calendar.DAY_OF_MONTH));
		Date now = cal.getTime();
		
		DateTime dt=new DateTime();		
		DateTime dtInd = dt.withZone(DateTimeZone.forID("Asia/Calcutta"));
		dtInd=dtInd.minusMinutes(60); //60 mins past to currnet time
		DateTimeFormatter fmt = DateTimeFormat.forPattern("HH.mm");
		double pastTime=Double.parseDouble(fmt.print(dtInd));
		
		count=Datastore.query(meta).filter(meta.createdDate.equal(now)).filter(meta.trainName.equal(trainName)).filter(meta.time.greaterThanOrEqual(pastTime)).count();			
		return count;
	}

	public TrainTracker getTrackingInfoByTrainNumber(int trainNumber) {
		Calendar rightNow = Calendar.getInstance();
		Calendar cal = new GregorianCalendar(
		   rightNow.get(Calendar.YEAR),
		   rightNow.get(Calendar.MONTH),
		   rightNow.get(Calendar.DAY_OF_MONTH));
		Date now = cal.getTime();
		TrainTracker tracker=Datastore.query(meta).filter(meta.createdDate.equal(now)).filter(meta.trainNo.equal(trainNumber)).sortInMemory(meta.createdDate.desc).asSingle();
		return tracker;
	}


}
