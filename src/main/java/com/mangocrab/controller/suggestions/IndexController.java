package com.mangocrab.controller.suggestions;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.mangocrab.service.SuggestionsService;

public class IndexController extends Controller {
	private SuggestionsService service=new SuggestionsService();
    @Override
    public Navigation run() throws Exception {
    	int suggCount=service.getSuggestionsCount("suggestion");
    	int compCount=service.getComplaintsCount("complaint");
    	requestScope("suggCount",suggCount);
    	requestScope("compCount",compCount);
        return forward("suggestionsHome.jsp");
    }
}
