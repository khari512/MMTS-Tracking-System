<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html> 
<html>
<head>
    <%@ include file="../meta.jsp"%>  

</head> 
  
<body> 
<div data-role="page" id="serachTimingsForm">
  <div data-role="header">
    <h2>Search train timings</h2>
    <a href="/" data-role="button" data-icon="home" >Home</a>
    <a href="#" data-role="button" data-icon="back" data-rel="back">Back</a>
    
  </div>
  <div data-role="content">
  <c:if test="${not empty message}"> 
  	<p id="resultMesg" ><a href="#" data-icon="check" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong id='resultText'>${message}</strong></p>	
  </c:if>
    <form action="/timetable/GetTimings" method="post" id="trainTimingsSearch">
    <ul data-role="listview" data-inset="true">
      <li data-role="fieldcontain">
        <label for="fromStation">From :</label>
        <select name="fromStation" id="fromStation"  data-filter="true" data-mini="true">
            <!-- <option value="">Select station</option> -->
            <option value="art:600">Arts College</option>
            <option value="beg:9">Begumpet</option>
            <option value="bar:6">Bharathnagar</option>
            <option value="bor:5">Borabanda</option>
            <option value="cha:2">Chandanagar</option>
            <option value="dab:1100">Dabirpura</option>
            <option value="fal:1400">Falaknuma</option> 
            <option value="fat:7">Fathenagar</option>
            <option value="haf:3">Hafizpet</option>
            <option value="hit:4">Hitech city</option>
            <option value="hyd:50000">Hyderabad/Nampally</option>
            <option value="jam:700">Jamai Osmania</option>
            <option value="jam:300">James Street</option>
            <option value="kac:900">Kacheguda</option>
            <option value="kha:30000">Khairatabad</option>  
            <option value="lak:40000">Lakdikapool</option>            
            <option value="lin:1">Lingampally</option>
            <option value="mal:1000">Malakpet</option>
            <option value="nat:8">Nature Cure Hospital</option>
            <option value="nec:20000">Neckless road</option>  
            <option value="san:200">Sanjivaiah Park</option>
            <option value="sec:400">Secunderabad</option>
            <option value="sit:500">Sitafal Mandi</option>
            <option value="upp:1300">Uppuguda</option>
            <option value="vid:800">Vidya Nagar</option>
           	<option value="yak:1200">Yakutpura</option>
       </select>         
    </li>
    <li data-role="fieldcontain">
        <label for="toStation">To :</label>
        <select name="toStation" id="toStation"  data-filter="true" data-mini="true">
            <!-- <option value="">Select station</option> -->
            <option value="art:600">Arts College</option>
            <option value="beg:9">Begumpet</option>
            <option value="bar:6">Bharathnagar</option>
            <option value="bor:5">Borabanda</option>
            <option value="cha:2">Chandanagar</option>
            <option value="dab:1100">Dabirpura</option>
            <option value="fal:1400">Falaknuma</option> 
            <option value="fat:7">Fathenagar</option>
            <option value="haf:3">Hafizpet</option>
            <option value="hit:4">Hitech city</option>
            <option value="hyd:50000">Hyderabad/Nampally</option>
            <option value="jam:700">Jamai Osmania</option>
            <option value="jam:300">James Street</option>
            <option value="kac:900">Kacheguda</option>
            <option value="kha:30000">Khairatabad</option>  
            <option value="lak:40000">Lakdikapool</option>            
            <option value="lin:1">Lingampally</option>
            <option value="mal:1000">Malakpet</option>
            <option value="nat:8">Nature Cure Hospital</option>
            <option value="nec:20000">Neckless road</option>  
            <option value="san:200">Sanjivaiah Park</option>
            <option value="sec:400">Secunderabad</option>
            <option value="sit:500">Sitafal Mandi</option>
            <option value="upp:1300">Uppuguda</option>
            <option value="vid:800">Vidya Nagar</option>
           	<option value="yak:1200">Yakutpura</option>       
      </select>             
    </li>
    <li data-role="fieldcontain" >
    <div data-role="collapsible-set"  data-inset="true" data-content-theme="d">
      <div data-role="collapsible" data-mini="true">
        <h3>Quick time selection &nbsp; &nbsp; &nbsp;(OR)</h3>
                
        <div data-role="controlgroup">        
          <input type="radio" name="quickTimeSelectionRadio" id="twoHours" value="twoHours" checked="checked"></input>
          <label for="twoHours">In 2 hours</label>
          <input type="radio" name="quickTimeSelectionRadio" id="morningTime" value="morningTime" ></input>
          <label for="morningTime">Morning Trains</label>
          <input type="radio" name="quickTimeSelectionRadio" id="afternoonTime" value="afternoonTime" ></input>
          <label for="afternoonTime">Afternoon Trains</label>
          <input type="radio" name="quickTimeSelectionRadio" id="eveningTime" value="eveningTime" ></input>
          <label for="eveningTime">Evening Trains</label>                       
        </div>
      </div>
      <div data-role="collapsible" data-mini="true">
        <h3>Select time range</h3>
        <div data-role="controlgroup">
         	 <input type="hidden" name="isSliderValue" id="isSliderValue" value="false"/>
        	<label for="timeRangeFrom">From:</label>
            <input type="range" name="timeRangeFrom" id="timeRangeFrom" min="0" max="24" step="1" value="${currentTime}" data-mini="true" data-highlight="true">
            <div id="something"></div>
        </div>
         <div data-role="controlgroup">
               <label for="timeRangeTo">To:</label>
               <input type="range" name="timeRangeTo" id="timeRangeTo" min="0" max="24"  step="1" value="${twoHoursLaterTime}"  data-mini="true" data-highlight="true">
       	</div>  
      </div>
    </div>
    </li>
    <li data-role="fieldcontain" class="ui-body ui-body-d">
    <div>
      <fieldset class="ui-grid-a">
          <div class="ui-block-a"><button type="reset" data-theme="d" data-mini="true">Reset</button></div>
          <div class="ui-block-b"><button type="submit" data-theme="a" data-mini="true">Submit</button></div>
  
        </fieldset>
    </div>
    </li>     
  </ul>
    </form>
  </div>
  <div data-role="footer" data-position="fixed">
   <h4>&copy; 2013 FlyingRail</h4>
  </div>
  
    <script>
  
      
    $("#serachTimingsForm").live('pageinit',function(){
        console.log('search train timings form page initialization');
    	console.log("current time from server=${currentTime} two hours later time=${twoHoursLaterTime}");
    	$("#resultMesg").delay(4000).hide(1000);
        var timeSliderFrom=${currentTime};
        var timeSliderTo=${twoHoursLaterTime};
        function changeSlider(fromTime,toTime){
        	$("#timeRangeFrom").val(fromTime);
			$("#timeRangeTo").val(toTime);
			$("#timeRangeFrom").slider("refresh");
			$("#timeRangeTo").slider("refresh");
        }       
    	$("#timeRangeFrom").change(function(){
			console.log("from slider value changed:from="+$(this).val());
		});
    	$("#timeRangeTo").change(function(){
			console.log("To slider value changed:to="+$(this).val());
		});
    	

	    $("input[name=quickTimeSelectionRadio]:radio").bind("change", function(event, ui) {
	        console.log('quickTimeSelectionRadio has changed to '+$(this).val());
	        var currSelectionVal=$(this).val();
	        if(currSelectionVal=="morningTime"){
	        	timeSliderFrom=0;
	        	timeSliderTo=12;
		    }else if(currSelectionVal=="afternoonTime"){
		    	timeSliderFrom=12;
	        	timeSliderTo=17;
			}else if(currSelectionVal=="eveningTime"){
				timeSliderFrom=17;
	        	timeSliderTo=24;
			}	      
	        changeSlider(timeSliderFrom,timeSliderTo);
	      });
	    
	    $("#trainTimingsSearch").submit(function(){
	    	console.log("trainTimingsSearch form submited");	
	    	if($("#toStation").val()==$("#fromStation").val()){
	    		console.log("to station and from station should not be same");
	    		alert("to station and from station should not be same");
	    		//$.mobile.changePage("#dialogPage");
	    		return false;
	    	}
	    });
	    
	    /*
	    $( "#timeRangeFrom" ).change(function(){
	        var slider_value = $(this).val();	        
	        var hours = Math.floor($(this).val() / 60);
            var minutes = $(this).val() - (hours * 60);
            $(this).val(minutes);
            if(hours.length == 1) hours = '0' + hours;
            if(minutes.length == 1) minutes = '0' + minutes;
            console.log(slider_value);
	        // do whatever you want with that value...
	    }); */
	   
    });  
   
  
    </script>

</div>


<div data-role="page" id="dialogPage">
	<div data-role="header">
		<h2>Dialog</h2>
	</div>
	<div data-role="content">
		<p>There are no trains for your search criteria.</p>
	</div>
</div>
    <%@ include file="../footer.jsp"%>  
</body>
</html>
