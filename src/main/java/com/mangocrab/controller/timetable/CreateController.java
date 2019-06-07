package com.mangocrab.controller.timetable;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

import com.mangocrab.model.Timings;
import com.mangocrab.service.TimeTableService;
import com.mangocrab.meta.TimingsMeta;

public class CreateController extends Controller {

	private TimeTableService service = new TimeTableService();

    private TimingsMeta meta = TimingsMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        if (!validate()) {
            return forward("timeTableInput.jsp");
        }
        Timings timings = new Timings();
        BeanUtil.copy(request, timings);
       // timings.arrayListTimings();
        timings.timingsAndNumberMapping();
        String userMessage=timings.getUserMessage();
        if(userMessage==null || "".equals(userMessage)){
        	System.out.println("form data mapped to timings object "+timings);
        	service.createTimetable(timings);
        }else{
        	System.out.println("found error "+userMessage);
        }
        return redirect(basePath);
    }

    protected boolean validate() {
    	Validators v = new Validators(request);
        v.add("timingsRawData", v.required());
      //  v.add("trainNumbersRawData", v.required());
        v.add("boardingAt", v.required());
        v.add("trainName", v.required());
        return v.validate();
    }


}
