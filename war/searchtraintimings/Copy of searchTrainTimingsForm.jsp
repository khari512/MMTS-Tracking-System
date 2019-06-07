<!DOCTYPE html> 
<html>
<head>
    <%@ include file="../meta.jsp"%>  
</head> 
  
<body> 
<div data-role="page">
  <div data-role="header">
    <h2>Search train timings</h2>
    <a href="/" data-role="button" data-icon="home" >Home</a>
    <a href="#" data-role="button" data-icon="back" data-rel="back">Back</a>
    
  </div>
  <div data-role="content">
  	<form action="/timetable/GetTimings" method="post" id="">
  		<div data-role="fieldcontain">
  			<label for="fromStation">From :</label>
  			<select name="fromStation" id="fromStation"  data-filter="true" data-mini="true">
						<!-- <option value="">Select station</option> -->
						<option value="lin:1">Lingampally</option>
						<option value="cha:2">Chandanagar</option>
					   	<option value="haf:3">Hafizpet</option>
					   	<option value="hit:4">Hitech city</option>
					   	<option value="bor:5">Borabanda</option>
					   	<option value="bar:6">Bharathnagar</option>
					   	<option value="fat:7">Fathenagar</option>
					   	<option value="nat:8">Nature Cure Hospital</option>
					   	<option value="beg:9">Begumpet</option>
					   	<option value="nec:20000">Neckless road</option>	
					   	<option value="kha:30000">Khairatabad</option>	
					   	<option value="lak:40000">Lakdikapool</option>	
						<option value="hyd:50000">Nampally/Hyderabad</option>
						<option value="san:200">Sanjivaiah Park</option>
						<option value="jam:300">James Street</option>
						<option value="sec:400">Secunderabad</option>
						<option value="sit:500">Sitafal Mandi</option>
						<option value="art:600">Arts College</option>
						<option value="jam:700">Jamai Osmania</option>
						<option value="vid:800">Vidya Nagar</option>
						<option value="kac:900">Kacheguda</option>
						<option value="mal:1000">Malakpet</option>
						<option value="dab:1100">Dabirpura</option>
						<option value="yak:1200">Yakutpura</option>
						<option value="upp:1300">Uppuguda</option>
						<option value="fal:1400">Falaknuma</option>		
				</select> 				
		</div>
		<div data-role="fieldcontain">
  			<label for="toStation">To :</label>
  			<select name="toStation" id="toStation"  data-filter="true" data-mini="true">
						<!-- <option value="">Select station</option> -->
						<option value="lin:1">Lingampally</option>
						<option value="cha:2">Chandanagar</option>
					   	<option value="haf:3">Hafizpet</option>
					   	<option value="hit:4">Hitech city</option>
					   	<option value="bor:5">Borabanda</option>
					   	<option value="bar:6">Bharathnagar</option>
					   	<option value="fat:7">Fathenagar</option>
					   	<option value="nat:8">Nature Cure Hospital</option>
					   	<option value="beg:9">Begumpet</option>
					   	<option value="nec:20000">Neckless road</option>	
					   	<option value="kha:30000">Khairatabad</option>	
					   	<option value="lak:40000">Lakdikapool</option>	
						<option value="hyd:50000">Nampally/Hyderabad</option>
						<option value="san:200">Sanjivaiah Park</option>
						<option value="jam:300">James Street</option>
						<option value="sec:400">Secunderabad</option>
						<option value="sit:500">Sitafal Mandi</option>
						<option value="art:600">Arts College</option>
						<option value="jam:700">Jamai Osmania</option>
						<option value="vid:800">Vidya Nagar</option>
						<option value="kac:900">Kacheguda</option>
						<option value="mal:1000">Malakpet</option>
						<option value="dab:1100">Dabirpura</option>
						<option value="yak:1200">Yakutpura</option>
						<option value="upp:1300">Uppuguda</option>
						<option value="fal:1400">Falaknuma</option>					
			</select> 						
		</div>
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
					<input type="hidden" name="isSliderValue" id="isSliderValue" value=""/>
					<label for="timeRangeFrom">From:</label>
                	<input type="range" name="timeRangeFrom" id="timeRangeFrom" min="0" max="24" step="1" value="8" data-mini="true" data-highlight="true">
               	</div>
               	<div data-role="controlgroup">
               		<label for="timeRangeTo">To:</label>
                	<input type="range" name="timeRangeTo" id="timeRangeTo" min="0" max="24"  step="1" value="10"  data-mini="true" data-highlight="true">
				</div>	
			</div>
		</div>
		
		<div class="ui-body ui-body-b">
			<fieldset class="ui-grid-a">
					<div class="ui-block-a"><button type="reset" data-theme="d" data-mini="true">Reset</button></div>
					<div class="ui-block-b"><button type="submit" data-theme="a" data-mini="true">Submit</button></div>
	
		    </fieldset>
		</div>
					
		
  	</form>
  </div>
  <div data-role="footer">
   <h4>&copy; 2013 Flyingrail</h4>
  </div>
</div>

</body>
</html>
