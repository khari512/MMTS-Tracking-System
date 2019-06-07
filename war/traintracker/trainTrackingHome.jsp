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
<div data-role="page" id="trainTrackerHome">
  <div data-role="header">
    <h2>Train Tracker</h2>
    <a href="/" data-role="button" data-icon="home" >Home</a>
    <a href="#" data-role="button" data-icon="back" data-rel="back">Back</a>
    
  </div>
  <div data-role="content">
  	<p id="resultMesg" style="display:none"><a href="#" data-icon="check" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong id='resultText'>Successfully inserted.</strong></p>
  
    <ul data-role="listview" data-inset="true">
    
    <!-- 
	    <form id="getTrackerForm" method="POST" action='/traintracker/GetTrainTrackerInfo' style="display:none;">
	    	<input type="hidden" id="trainNameHidden" name="trainName" value="hyd" />
	    	<input type="submit" value="submit"/>
	    </form>
	   -->
    
      	<li><a href="/traintracker/GetTrainTrackerInfo?trainName=hyd" class="trackerNav" trainName="hyd">Nampally/Hyderabad Trains  <span class="ui-li-count" style='color:red'>${hydCount }</span></a></li>
    	<li><a href="/traintracker/GetTrainTrackerInfo?trainName=fal" class="trackerNav" trainName="fal">Falaknuma/Secunderabad Trains <span class="ui-li-count" style='color:red'>${falCount }</span></a></li>
    	<li><a href="/traintracker/GetTrainTrackerInfo?trainName=lin" class="trackerNav" trainName="lin">Lingampally Trains <span class="ui-li-count" style='color:red'>${linCount}</span></a></li>
    	<li><a href="/traintracker/GetTrainTrackerInfo?trainName=all" class="trackerNav" trainName="all">All Running Trains <span class="ui-li-count" style='color:red'>${allActiveTrains}</span></a></li>
    	<li><a href="/traintracker/GetTrainTrackerInfo?trainName=unknown" class="trackerNav" trainName="unknown">Unknown Destination Trains <span class="ui-li-count" style='color:red'>${unKnownDestCount}</span></a></li>
   </ul>
   </div>
  <div data-role="footer" data-position="fixed">
   <h4>&copy; 2013 FlyingRail</h4>
  </div>
  
    <script>
  
      
    $("#trainTrackerHome").on('pageinit',function(){
        console.log('trainTrackerHome page initialization');
        /* commenting ajax submitiona as it is handling in anchor tag itself 
		$(".trackerNav").click(function(){			
			var trainName=$(this).attr('trainName');
			$("#trainNameHidden").val(trainName);
			$("#getTrackerForm").submit();

			
		}); 
        */
	   
    });  
   
  
    </script>

</div>
<%@ include file="../footer.jsp"%>
</body>
</html>
