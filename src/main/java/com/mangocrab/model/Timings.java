package com.mangocrab.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.google.appengine.api.datastore.Key;
import com.mangocrab.service.TrainTrackerService;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.*;

@Model(schemaVersion = 1)
public class Timings implements Serializable {

	private String trainName;
	private String boardingAt;
	private String timingsRawData;
	@Attribute(persistent = false)
	private String timingsDelimeter;
	private String trainNumbersRawData;
	@Attribute(persistent = false)
	private String numbersDelimeter;
	private Date validFromDate;
	private Date validToDate;
	private Date lastUpdatedDate;
	private String sundayTrainDelimeter;
	@Attribute(persistent = false)
	private String userMessage;
	@Attribute(lob = true)
	List<Number> trainTimings = new ArrayList<Number>();
	@Attribute(persistent = false)
	DecimalFormat twoDForm = new DecimalFormat("#.00");
	@Attribute(lob = true)
	List<TimeAndNumberMapping> timeAndNumberMappingList=new ArrayList<TimeAndNumberMapping>();
	@Attribute(persistent=false)
	TrainTrackerService trackerService=new TrainTrackerService();

	public List<Number> arrayListTimings(){		
		if(timingsRawData!=null && ("".equals(timingsRawData)==false)){
			if (timingsDelimeter == null) {
				System.out.println("timingsDelimeter is null so setting it to ,");
				timingsDelimeter = ",";
			}
			timingsDelimeter=timingsDelimeter.trim();			
			timingsRawData=timingsRawData.replaceAll(":", "\\.");
			String[] timingsArray=timingsRawData.split(timingsDelimeter);		
			for(int i=0;i<timingsArray.length;i++){
				System.out.println("timingsArray.length--->"+timingsArray.length+"-- value="+timingsArray[i].trim());
				trainTimings.add(Double.parseDouble(timingsArray[i].trim()));
			}			
		}
		System.out.println("timings ArrayList is unsort");
		for(Number trainTimings1: trainTimings){
			System.out.println(trainTimings1);
		}
		trainTimings=sort(trainTimings,on(Number.class).doubleValue());
 		//after sorted
		System.out.println("timings ArrayList is sorted");
		for(Number trainTimings1: trainTimings){			
			System.out.println(twoDForm.format(trainTimings1));
		}
		return trainTimings;
	}
	
	public boolean timingsAndNumberMapping() {
		if ((timingsRawData != null) && ("".equals(timingsRawData) == false)
				&& (trainNumbersRawData != null)
				&& ("".equals(trainNumbersRawData) == false)) {
			if (timingsDelimeter == null) {
				timingsDelimeter = ",";
			}
			if(numbersDelimeter==null){
				numbersDelimeter=",";
			}
			if(sundayTrainDelimeter==null){
				sundayTrainDelimeter="*";
			}
			
			timingsRawData=timingsRawData.replaceAll(":", "\\.");			
			String[] timingsArray=timingsRawData.split(timingsDelimeter.trim());			
			String[] trainNumberArray=trainNumbersRawData.split(numbersDelimeter.trim());
			
			if(timingsArray.length==trainNumberArray.length){
				//timeAndNumberMappingList=new ArrayList<TimeAndNumberMapping>();	
				for(int i=0;i<timingsArray.length;i++){
					TimeAndNumberMapping timeAndNumberMapping=new TimeAndNumberMapping();
					timeAndNumberMapping.setTime(Double.parseDouble(timingsArray[i]));
					String trainNumStr=trainNumberArray[i].trim();
					if(trainNumStr.contains(sundayTrainDelimeter.trim())){
						trainNumStr=trainNumStr.replace(sundayTrainDelimeter.trim(), "");
						timeAndNumberMapping.setNotOnSundayFlag(true);
					}
					timeAndNumberMapping.setTrainNumber(Integer.parseInt(trainNumStr));
					
					//timeAndNumberMapping.getTimingsRef().setModel(this);
					timeAndNumberMappingList.add(timeAndNumberMapping);
				}
				return true;
				
			}else{
				setUserMessage("There is a mismacth between no of timings and train numbers");
			}
		
			
		}
		return false;
	}

	public List<TimeAndNumberMapping> getTimeAndNumberMappingList() {
		return timeAndNumberMappingList;
	}
	public void setTimeAndNumberMappingList(
			List<TimeAndNumberMapping> timeAndNumberMappingList) {
		this.timeAndNumberMappingList = timeAndNumberMappingList;
	}
	public List<Number> getTrainTimings() {
		return trainTimings;
	}
	public void setTrainTimings(List<Number> trainTimings) {
		this.trainTimings = trainTimings;
	}
	
	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	/*
	 * one to many bidirection relation -- Timings (one)->
	 * TimeAndNumberMapping(many)
	 */
	@Attribute(persistent = false)
	private InverseModelListRef<TimeAndNumberMapping, Timings> timeAndNumberListRef = new InverseModelListRef<TimeAndNumberMapping, Timings>(
			TimeAndNumberMapping.class, "timeAndNumberRef", this);

	public InverseModelListRef<TimeAndNumberMapping, Timings> getTimeAndNumberListRef() {
		return timeAndNumberListRef;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getBoardingAt() {
		return boardingAt;
	}

	public void setBoardingAt(String boardingAt) {
		this.boardingAt = boardingAt;
	}

	public String getTimingsRawData() {
		return timingsRawData;
	}

	public void setTimingsRawData(String timingsRawData) {
		this.timingsRawData = timingsRawData;
	}

	public String getTimingsDelimeter() {
		return timingsDelimeter;
	}

	public void setTimingsDelimeter(String timingsDelimeter) {
		this.timingsDelimeter = timingsDelimeter;
	}

	public String getTrainNumbersRawData() {
		return trainNumbersRawData;
	}

	public void setTrainNumbersRawData(String trainNumbersRawData) {
		this.trainNumbersRawData = trainNumbersRawData;
	}

	public String getNumbersDelimeter() {
		return numbersDelimeter;
	}

	public void setNumbersDelimeter(String numbersDelimeter) {
		this.numbersDelimeter = numbersDelimeter;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	public Date getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getSundayTrainDelimeter() {
		return sundayTrainDelimeter;
	}

	public void setSundayTrainDelimeter(String sundayTrainDelimeter) {
		this.sundayTrainDelimeter = sundayTrainDelimeter;
	}

	@Override
	public String toString() {
		return "Timings [boardingAt=" + boardingAt
				+ ", sundayTrainDelimeter=" + sundayTrainDelimeter
				+ ", key=" + key + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", numbersDelimeter=" + numbersDelimeter
				+ ", timeAndNumberListRef=" + timeAndNumberListRef
				+ ", timingsDelimeter=" + timingsDelimeter
				+ ", timingsRawData=" + timingsRawData + ", trainName="
				+ trainName + ", trainNumbersRawData=" + trainNumbersRawData
				+ ", trainTimings=" + trainTimings + ", twoDForm=" + twoDForm
				+ ", userMessage=" + userMessage + ", validFromDate="
				+ validFromDate + ", validToDate=" + validToDate + ", version="
				+ version + ", getBoardingAt()=" + getBoardingAt()
				+ ", getCancelledSundayNumbers()="
				+ getSundayTrainDelimeter() + ", getKey()=" + getKey()
				+ ", getLastUpdatedDate()=" + getLastUpdatedDate()
				+ ", getNumbersDelimeter()=" + getNumbersDelimeter()
				+ ", getTimeAndNumberListRef()=" + getTimeAndNumberListRef()
				+ ", getTimingsDelimeter()=" + getTimingsDelimeter()
				+ ", getTimingsRawData()=" + getTimingsRawData()
				+ ", getTrainName()=" + getTrainName()
				+ ", getTrainNumbersRawData()=" + getTrainNumbersRawData()
				+ ", getTrainTimings()=" + getTrainTimings()
				+ ", getUserMessage()=" + getUserMessage()
				+ ", getValidFromDate()=" + getValidFromDate()
				+ ", getValidToDate()=" + getValidToDate() + ", getVersion()="
				+ getVersion() + ", hashCode()=" + hashCode()+ "]";
	}
	
	private static final long serialVersionUID = 1L;

	@Attribute(primaryKey = true)
	private Key key;

	@Attribute(version = true)
	private Long version;

	/**
	 * Returns the key.
	 * 
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            the key
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * Returns the version.
	 * 
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 * 
	 * @param version
	 *            the version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Timings other = (Timings) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}
}
