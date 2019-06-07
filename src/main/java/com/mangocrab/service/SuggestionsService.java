package com.mangocrab.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.mangocrab.dao.SuggestionsDao;
import com.mangocrab.model.Suggestions;

public class SuggestionsService {	
	private SuggestionsDao suggDao=new SuggestionsDao();
	
	public void createSuggestion(Map<String, Object> input){
		Suggestions sugg=new Suggestions();
				
		BeanUtil.copy(input, sugg);
		if(sugg.getCatageory()==null ){
			sugg.setCatageory("suggestion");			
		}
		sugg.setCreatedDate(new Date());
		System.out.println("Input fields copied to Suggestions Obj="+sugg.toString());
		
		if((sugg.getName()!=null && sugg.getSubject()!=null && sugg.getSuggestionString()!=null) && 
				(("".equals(sugg.getName())==false) && ("".equals(sugg.getSubject())==false) && ("".equals(sugg.getSuggestionString())==false))){
			suggDao.createSuggestions(sugg);
		}
		
	}
	public List<Suggestions> getSuggestions(String catageory){
		List<Suggestions> timingsList= suggDao.getSuggestions(catageory,null);
		return timingsList;		
	}
	public int getSuggestionsCount(String catageory) {
		return suggDao.getSuggestionsCount(catageory);
		
	}
	public int getComplaintsCount(String catageory) {		
		return suggDao.getComplaintsCount(catageory);
	}
}
