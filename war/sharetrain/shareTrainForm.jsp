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
<div data-role="page" id="shareTrainForm">
  <div data-role="header">
    <h2>Share your train location</h2>
    <a href="/" data-role="button" data-icon="home" >Home</a>
    <a href="#" data-role="button" data-icon="back" data-rel="back">Back</a>
    
  </div>
  <div data-role="content" > 
  <c:if test="${not empty message}"> 
  	<p id="resultMesg" ><a href="#" data-icon="check" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong id='resultText'>${message}</strong></p>	
  </c:if>	
    <form action="/sharetrain/GetAvailTrainsList" method="GET" id="sharetrainFormId" >
    <ul data-role="listview" data-inset="true">
      <li data-role="fieldcontain">
        <label for="fromStation">Share your current location :</label>
        <select name="currentStation" id="currentStation"  data-filter="true" data-mini="true">
           	<option value="">Select station</option> 
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
        <label for="toStation">Destination :</label>
        <fieldset data-role="controlgroup" data-mini="true" >		   		
		        <input name="trainName" id="destinationFal" value="fal"  type="radio">
		        <label for="destinationFal">Falaknuma</label>
		        <input name="trainName" id="destinationHyd" value="hyd" type="radio">
		        <label for="destinationHyd">Hyderabad/Nampally</label>
		        <input name="trainName" id="destinationLin" value="lin" type="radio">
		        <label for="destinationLin">Lingampally</label>
		        <input name="trainName" id="destinationUnknow" value="unknown" type="radio">
		        <label for="destinationUnknow">Don't know</label>
		        
		</fieldset>
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
      
    $("#shareTrainForm").on('pageinit',function(){
        console.log('share trains form page initialization');
		$("#sharetrainFormId").submit(function(){
			console.log('share trains form submited');
			var currLoc=$("#currentStation").val();
			if(currLoc==""){
					alert('please select the current location');
					  return false; 
			}
		    if ($('input[name=trainName]:checked').length) {
		           // at least one of the radio buttons was checked
		          // return true; // allow whatever action would normally happen to continue
		    }
		    else {
		         alert('please select destination option');
		         return false; // stop whatever action would normally happen
		    }
			
		});		
	
		$("#resultMesg").delay(4000).hide(1000);
		
    });  
 
  
    </script>

</div>
<%@ include file="../footer.jsp"%>
</body>
</html>
