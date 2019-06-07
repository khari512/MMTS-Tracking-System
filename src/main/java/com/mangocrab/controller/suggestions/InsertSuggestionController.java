package com.mangocrab.controller.suggestions;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.mangocrab.service.SuggestionsService;

public class InsertSuggestionController extends Controller {
	private SuggestionsService suggService=new SuggestionsService();
    @Override
    public Navigation run() throws Exception {
    	System.out.println("In com.mangocrab.controller.suggestions.InsertSuggestionController run() method");
        suggService.createSuggestion(new RequestMap(request));
        
        return redirect("/suggestions/");
    }
}
