<!-- Start of first page: #one -->
<div data-role="page" id="shareMMTSLocation" data-title="Share Your MMTS">
	<div data-role="header" data-theme="e" data-add-back-btn="true">
		<h1>Share MMTS train location</h1>
		<a href="/home" data-icon="home" >Home</a>
		<a href="/home" data-direction="reverse" data-icon="back"  data-rel="back">back</a>	
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