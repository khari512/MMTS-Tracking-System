<!-- Start of third page: #timings -->
<div data-role="page" id="timings" data-title="Time Table">
	<div data-role="header" data-theme="e" data-add-back-btn="true">
		<h1>Train Timings</h1>
		<a href="/home" data-icon="home" >Home</a>
		<a href="/home" data-direction="reverse" data-icon="back"  data-rel="back">back</a>	
	</div><!-- /header -->

	<div data-role="content" data-theme="d">		
		<form action="/timetable/GetTimings" method="post" id="timingsForm" >	
			<div data-role="fieldcontain" >		
				<h2>Select from and to stations :</h2> 	
			</div>	
			<div data-role="fieldcontain" >						
				<label for="fromStation" class="select"> From :</label>		
				<select name="fromStation" id="fromStation"  data-theme="c" force-dialog="true" data-native-menu="false" data-filter="true" data-mini="true">
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
			<div data-role="fieldcontain" > 			
				<label for="toStation" class="select">To :</label>		
				<select name="toStation" id="toStation"  data-theme="c" force-dialog="true" data-native-menu="false" data-filter="true" data-mini="true">
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
				<h2>Select Time Range:</h2>
			</div>
			<div data-role="fieldcontain">							
					<label for="timeRangeFrom">From:</label>				
					<input type="range" name="timeRangeFrom" id="timeRangeFrom" value="7" min="0" max="24" data-highlight="true" data-mini="true"  />								
			</div>	
			<div data-role="fieldcontain">					
					<label for="timeRangeTo">To:</label>				
					<input type="range" name="timeRangeTo" id="timeRangeTo" value="10" min="0" max="24" data-highlight="true" data-mini="true" />				
			</div>		
			
		<div class="ui-body ui-body-b">
		<fieldset class="ui-grid-a">
				<div class="ui-block-a"><button type="submit" data-theme="d" data-mini="true">Cancel</button></div>
				<div class="ui-block-b"><button type="submit" data-theme="a" data-mini="true">Submit</button></div>

	    </fieldset>
		</div>
	</form>
	</div><!-- /content -->
	
		<%@ include file="footer.jsp"%>
</div><!-- /page timings -->