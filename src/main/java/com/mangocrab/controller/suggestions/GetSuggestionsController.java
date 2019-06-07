package com.mangocrab.controller.suggestions;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mangocrab.service.SuggestionsService;
import com.mangocrab.model.Suggestions;

public class GetSuggestionsController extends Controller {
	private SuggestionsService service=new SuggestionsService();
    @Override
    public Navigation run() throws Exception {
    	String catageory=request.getParameter("catageory");
    	if(catageory==null || "".equals(catageory)==true){
    		catageory="suggestion";
    	}
    	List<Suggestions> suggestionsList=service.getSuggestions(catageory);
    	
    	requestScope("suggestionsList",suggestionsList);
        return forward("getSuggestions.jsp");
    }
}
