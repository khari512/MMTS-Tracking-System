<!DOCTYPE html> 
<html>
<head>
	<%@ include file="meta.jsp"%>	
</head> 
	
<body> 

<!-- Start of first page: #one -->
<div data-role="page" id="shareMMTSLocation">
	<div data-role="header" data-theme="e" data-add-back-btn="true">
		<h1>Share MMTS train location</h1>
		<a href="#shareMMTSLocation" data-icon="home" >Home</a>
		<a href="index.html" data-icon="back"  data-rel="back">back</a>	
	</div><!-- /header -->

	<div data-role="content" data-theme="a">
	 <form action="submitTrainLocation.html" method="post" >		
			<div data-role="fieldcontain" > 			
				<legend>Current MMTS Location:</legend>				
				<button type="button" data-theme="c" data-mini="true" name="findlocation" value="find my location" id="findlocbtn">find my location</button>
				<legend style="text-align:center;margin-left:50%">(or)</legend>	
				<select name="currLoc" id="currLoc"  data-theme="c" force-dialog="true" data-native-menu="false" data-filter="true" >
						<option value="">Select station</option>
						<option value="lin">Lingampally</option>
					   	<option value="haf">Hafizpet</option>
					   	<option value="hit">Hitech city</option>
					   	<option value="bor">Borabanda</option>
					   	<option value="bar">Bharathnagar</option>
					   	<option value="fat">Fathenagar</option>
					   	<option value="nat">Nature Cure Hospital</option>
					   	<option value="beg">Begumpet</option>
					   	<option value="nec">Neckless road</option>			 
				</select> 				
			</div>
			<div data-role="fieldcontain" >
    			<fieldset data-role="controlgroup" data-mini="true" >
    					<legend>Choose Destination:</legend>		
				    	<input type="radio" name="destination" id="radio-mini-1" value="lin" checked="checked" data-theme="c"/>
				    	<label for="radio-mini-1">Lingampally</label>		
						<input type="radio" name="destination" id="radio-mini-2" value="nam" data-theme="c" />
				    	<label for="radio-mini-2">Nampally/Hyderabad</label>		    	
				    	<input type="radio" name="destination" id="radio-mini-3" value="fal"  data-theme="c"/>
				    	<label for="radio-mini-3">Secunderabad/Falaknuma</label>			    	
				</fieldset>
			</div>
			<button type="submit" data-theme="c" name="submit" value="submit-value">Submit</button>
			
		</fieldset>
	</form>
	</div><!-- /content -->
	
		<%@ include file="footer.jsp"%>

</div><!-- /page one -->


<!-- Start of second page: #trackMMTSLocation -->
<div data-role="page" id="trackMMTSLocation" data-theme="a">

	<div data-role="header" data-theme="e">
		<h1>Current MMTS train locations</h1>
	</div><!-- /header -->

	<div data-role="content" data-theme="a">			
		<label for="slider-mini">Input slider:</label>
		<input type="range" name="slider-mini" id="slider-mini" value="lin" min="0" max="100" data-highlight="true" data-mini="true" />
		<p><a href="#one" data-direction="reverse" data-role="button" data-theme="b">Back to page "one"</a></p>	
		
	</div><!-- /content -->
	
		<%@ include file="footer.jsp"%>
</div><!-- /page two -->


<!-- Start of third page: #timings -->
<div data-role="page" id="timings">
	<div data-role="header" data-theme="e">
		<h1>Train Timings</h1>
	</div><!-- /header -->

	<div data-role="content" data-theme="d">	
		MMTS train timings goes here
	</div><!-- /content -->
	
		<%@ include file="footer.jsp"%>
</div><!-- /page timings -->

<!-- Start of fourth page: #animation -->
<div data-role="page" id="currentLocationGPS">
	<div data-role="header" data-theme="e">
		<h1>Current Location through GPS</h1>
	</div><!-- /header -->

	<div data-role="content" data-theme="d">	
		<script>  
		/*
	        jQuery(window).ready(function(){  
	            jQuery("#findlocbtn").click(initiate_geolocation);  
	        });  
	        function initiate_geolocation() {  
	            navigator.geolocation.getCurrentPosition(handle_geolocation_query,handle_errors);  
	        }  
	        function handle_errors(error)  
	        {  
	            switch(error.code)  
	            {  
	                case error.PERMISSION_DENIED: alert("user did not share geolocation data");  
	                break;  
	                case error.POSITION_UNAVAILABLE: alert("could not detect current position");  
	                break;  
	                case error.TIMEOUT: alert("retrieving position timed out");  
	                break;  
	                default: alert("unknown error");  
	                break;  
	            }  
	        }  
	        function handle_geolocation_query(position)  
	        {  
	            var image_url = "http://maps.google.com/maps/api/staticmap?sensor=false&center=" + position.coords.latitude + "," +  
	                            position.coords.longitude + "&zoom=14&size=300x400&markers=color:blue|label:S|" +  
	                            position.coords.latitude + ',' + position.coords.longitude;  
	            jQuery("#map").remove();  
	            jQuery(document.body).append(  
	                jQuery(document.createElement("img")).attr("src", image_url).attr('id','map')  
	            );  
	        }  
	        */
   	 	</script>  
	</div><!-- /content -->
	
		<%@ include file="footer.jsp"%>
</div><!-- /page timings -->



</body>
</html>