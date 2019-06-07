package com.mangocrab.dao;

import static ch.lambdaj.Lambda.*;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.S3QueryResultList;

import com.google.appengine.api.datastore.Transaction;
import com.mangocrab.meta.SuggestionsMeta;
import com.mangocrab.model.Suggestions;
import com.mangocrab.model.TimeAndNumberMapping;


public class SuggestionsDao extends DaoBase<Suggestions>{
	private SuggestionsMeta meta= new SuggestionsMeta();
	
	public void createSuggestions(Suggestions sugg){
		Transaction tx = Datastore.beginTransaction();
		Datastore.put(sugg);
		tx.commit();
		System.out.println("Suggestions obj inserted successfully");		
	}
	
	public List<Suggestions> getSuggestions(String catageory,String cursorString){
		//List<Suggestions> timingsList= Datastore.query(meta).filter(meta.catageory.startsWith(catageory)).sortInMemory(meta.createdDate.desc).limit(2).asList();
		
			S3QueryResultList<Suggestions> results = null;
			if(catageory==null || "".equals(catageory)==true){
	    		catageory="suggestion";
	    	}
			if(cursorString==null){
				results=Datastore.query(meta).filter(meta.catageory.equal(catageory)).sort(meta.createdDate.desc).limit(20).asQueryResultList();
			}else{				
				results= Datastore.query(meta).filter(meta.catageory.startsWith(catageory)).sortInMemory(meta.createdDate.desc)
						.encodedCursor(cursorString)
						.limit(2)
						.asQueryResultList();
			}
			
			// Use the first 20 results...
			        
			String encodedCursor = results.getEncodedCursor();
			String encodedFilter = results.getEncodedFilter();
			String encodedSorts = results.getEncodedSorts();
			// You can determine if a next entry exists
			boolean hasNext = results.hasNext();
			// Store the encodedCursor...

				
			
		return results;
	}

	public int getSuggestionsCount(String catageory) {
		return Datastore.query(meta).filter(meta.catageory.equal(catageory)).count();
	}

	public int getComplaintsCount(String catageory) {
		return Datastore.query(meta).filter(meta.catageory.equal(catageory)).count();
	} 
}
