<!DOCTYPE html> 
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<title>MMTS train tracking system</title> 
	<!-- old links
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
	-->
	<link class="jsbin" href="http://code.jquery.com/mobile/1.0b2/jquery.mobile-1.0b2.min.css" rel="stylesheet" type="text/css" />	
	<script class="jsbin" src="http://code.jquery.com/jquery-1.6.2.min.js"></script>	
	<script class="jsbin" src="https://github.com/downloads/aliok/jquery-mobile/jquery.mobile_selectmenu_filter_01.js"></script>
	<script type="text/javascript" src="http://jindo.dev.naver.com/collie/deploy/collie.min.js"></script>
	
	
</head> 
	
<body> 

<!-- Start of first page: #one -->
<div data-role="page" id="shareMMTS">
	<div data-role="header" data-theme="a" data-add-back-btn="true">
		<h1>Share MMTS train location</h1>
		<a href="#shareMMTS" data-icon="home" >Home</a>
		<a href="index.html" data-icon="back"  data-rel="back">back</a>	
	</div><!-- /header -->

	<div data-role="content" data-theme="a">
	 <form action="submitTrainLocation.html" method="post" class="">
		<fieldset>
			<div data-role="fieldcontain">	
				<label for="currLoc" class="select" >Current MMTS Location:</label>
				<select name="currLoc" id="currLoc"  data-theme="b" force-dialog="true" data-native-menu="false" data-filter="true">
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
			<div data-role="fieldcontain">
    			<fieldset data-role="controlgroup" data-mini="true" >
    					<legend>Choose Destination:</legend>		
				    	<input type="radio" name="destination" id="radio-mini-1" value="lin" checked="checked" data-theme="b"/>
				    	<label for="radio-mini-1">Lingampally</label>		
						<input type="radio" name="destination" id="radio-mini-2" value="nam" data-theme="b" />
				    	<label for="radio-mini-2">Nampally/Hyderabad</label>		    	
				    	<input type="radio" name="destination" id="radio-mini-3" value="fal" data-theme="b" />
				    	<label for="radio-mini-3">Secunderabad/Falaknuma</label>			    	
				</fieldset>
			</div>
			<button type="submit" data-theme="e" name="submit" value="submit-value">Submit</button>
			
		</fieldset>
	</form>
	</div><!-- /content -->
	
	<div data-role="footer" data-theme="d" data-id="commontoolbar" data-position="fixed">
		<div  data-role="navbar">
			<ul>
				<li><a href="#shareMMTS" class="ui-btn-active ui-state-persist">Share MMTS Location</a></li>
				<li><a href="#trackMMTS" >Track MMTS locations</a></li>
			</ul>
		</div>
	</div><!-- /footer -->
</div><!-- /page one -->


<!-- Start of second page: #two -->
<div data-role="page" id="trackMMTS" data-theme="a">

	<div data-role="header">
		<h1>Current MMTS train locations</h1>
	</div><!-- /header -->

	<div data-role="content" data-theme="a">	
		<div id="container" class="container"></div>
		<script type="text/javascript">
		    var layer = new collie.Layer({
		        width : 300,
		        height : 300
		    });
		     
		    collie.ImageManager.add({
		        "ground" : "http://jindo.dev.naver.com/collie/img/small/ground.png",
		        "sky" : "http://jindo.dev.naver.com/collie/img/small/sky.png"
		    });
		     
		    var oBackground = new collie.DisplayObject({
		        x : 0,
		        y : 0,
		        width : 300,
		        height : 300,
		        backgroundRepeat : "repeat", // Repeat X-Axis
		        backgroundImage : "sky"
		    }).addTo(layer);
		     
		    var oGround = new collie.MovableObject({
		        x : 0,
		        width : 320 * 2, // Using Double width for continuously horizontal move.
		        height : 88,
		        velocityX : -80,
		        backgroundRepeat : "repeat-x", // Repeat X-Axis
		        rangeX : [-320, 0], // This object can move from first position to second position.
		        positionRepeat : true, // This object move the other side when It's on one end of the edge.
		        backgroundImage : "ground"
		    }).bottom(0).addTo(layer);
		     
		    collie.Renderer.addLayer(layer);
		    collie.Renderer.load(document.getElementById("container"));
		    collie.Renderer.start();
		</script>
		<label for="slider-mini">Input slider:</label>
		<input type="range" name="slider-mini" id="slider-mini" value="lin" min="0" max="100" data-highlight="true" data-mini="true" />
		<p><a href="#one" data-direction="reverse" data-role="button" data-theme="b">Back to page "one"</a></p>	
		
	</div><!-- /content -->
	
	<div data-role="footer" data-theme="d" data-id="commontoolbar" data-position="fixed">
		<div  data-role="navbar">
			<ul>
				<li><a href="#shareMMTS" >Share MMTS Location</a></li>
				<li><a href="#trackMMTS" class="ui-btn-active ui-state-persist">Track MMTS locations</a></li>
			</ul>
		</div>
	</div><!-- /footer -->
</div><!-- /page two -->


<!-- Start of third page: #popup -->
<div data-role="page" id="popup">

	<div data-role="header" data-theme="e">
		<h1>Dialog</h1>
	</div><!-- /header -->

	<div data-role="content" data-theme="d">	
		<h2>Popup</h2>
		<p>I have an id of "popup" on my page container and only look like a dialog because the link to me had a <code>data-rel="dialog"</code> attribute which gives me this inset look and a <code>data-transition="pop"</code> attribute to change the transition to pop. Without this, I'd be styled as a normal page.</p>		
		<p><a href="#one" data-rel="back" data-role="button" data-inline="true" data-icon="back">Back to page "one"</a></p>	
	</div><!-- /content -->
	
	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page popup -->

</body>
</html>