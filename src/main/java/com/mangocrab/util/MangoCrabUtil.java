package com.mangocrab.util;

import static ch.lambdaj.Lambda.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mangocrab.model.TimeAndNumberMapping;
import com.mangocrab.service.TimeTableService;

public class MangoCrabUtil {
	
	private TimeTableService service = new TimeTableService();
	
	public List<TimeAndNumberMapping> getTimingsList(String fromStation,String toStation,double timeRangeFrom, double timeRangeTo){
		
		List<String> trainNames=getTrainNameByCode(fromStation.split(":")[1],toStation.split(":")[1]);
		List<TimeAndNumberMapping> timingsList=new ArrayList<TimeAndNumberMapping>();
		for (Iterator<String> iterator = trainNames.iterator(); iterator.hasNext();) {
			String trainName = (String) iterator.next();
			timingsList .addAll(service.getTimeTableList(fromStation.split(":")[0], trainName,timeRangeFrom, timeRangeTo));
		}
		timingsList=sort(timingsList,on(TimeAndNumberMapping.class).getTime());
		
		return timingsList;
	}

	public List<String> getTrainNameByCode(String from, String to) {
		System.out.println("In getTrainNameByCode() fromStationCode=" + from
				+ "toStationCode=" + to);
		int diff = Integer.parseInt(from) - Integer.parseInt(to);
		List<String> trainNameList = new ArrayList<String>();
		if (diff % 10000 == 0) {
			System.out.println(diff > 0 ? "HL,HF" : "LH,FH");
			if (diff > 0) {
				trainNameList.add("lin");
				trainNameList.add("fal");
			} else {
				trainNameList.add("hyd");
			}
		} else if (diff % 100 == 0) {
			if (Math.abs(diff) > 10000) {
				System.out.println(diff > 0 ? "HF" : "FH");
				if (diff > 0) {
					trainNameList.add("fal");
				} else {
					trainNameList.add("hyd");
				}
			} else {
				System.out.println(diff > 0 ? "FL,FH" : "HF,LF");
				if (diff > 0) {
					trainNameList.add("lin");
					trainNameList.add("fal");
				} else {
					trainNameList.add("fal");
				}
			}
		} else {
			if (Math.abs(diff) > 10000) {
				System.out.println(diff > 0 ? "HL" : "LH");
				if (diff > 0) {
					trainNameList.add("lin");
				} else {
					trainNameList.add("hyd");
				}
			} else if (Math.abs(diff) > 100) {
				System.out.println(diff > 0 ? "FL" : "LF");
				if (diff > 0) {
					trainNameList.add("lin");
				} else {
					trainNameList.add("fal");
				}
			} else {
				System.out.println(diff > 0 ? "FL,HL" : "LF,LH");
				if (diff > 0) {
					trainNameList.add("lin");
				} else {
					trainNameList.add("fal");
					trainNameList.add("hyd");
				}
			}
		}

		return trainNameList;
	}
}
