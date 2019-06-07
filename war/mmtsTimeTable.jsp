<!DOCTYPE html> 
<html>
<head>
		<%@ include file="meta.jsp"%>	
</head> 
	
<body> 

<!-- Start of third page: #timings -->
<div data-role="page" id="timings">
	<div data-role="header" data-theme="e">
		<h1>Train Timings</h1>
	</div><!-- /header -->

	<div data-role="content" data-theme="d">	
		<div data-role="fieldcontain">
                    <label for="selectmenu1">
                        From
                    </label>
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
                <div data-role="fieldcontain">
                    <label for="selectmenu2">
                        To:
                    </label>
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
                <div data-role="fieldcontain">
                    <fieldset data-role="controlgroup" data-type="horizontal">
                        <legend>
                            Quick Search
                        </legend>
                        <input id="radio1" name="" value="radio1" type="radio" />
                        <label for="radio1">
                            with in 1 hour
                        </label>
                        <input id="radio2" name="" value="radio2" type="radio" />
                        <label for="radio2">
                            with in 2 hours
                        </label>
                        <input id="radio3" name="" value="radio3" type="radio" />
                        <label for="radio3">
                            with in 3 hours
                        </label>
                    </fieldset>
                </div>
                <div data-role="fieldcontain">
                    <fieldset data-role="controlgroup" data-mini="true">
                        <label for="slider1">
                            Time range
                        </label>
                        <input name="slider" value="50" min="0" max="100" data-highlight="false" type="range" />
                    </fieldset>
                </div>
                <div data-role="fieldcontain">
                    <fieldset data-role="controlgroup">
                        <label for="slider2">
                            Time range
                        </label>
                        <input name="slider" value="50" min="0" max="100" data-highlight="false" type="range" />
                    </fieldset>
                </div>
            </div>
	</div><!-- /content -->
	
	<div data-role="footer" data-theme="d" data-id="commontoolbar" data-position="fixed">
		<div  data-role="navbar">
			<ul>
				<li><a href="mobileHome.jsp#shareMMTSLocation" >Share MMTS Location</a></li>
				<li><a href="mobileHome.jsp#trackMMTSLocation" >Track MMTS locations</a></li>
				<li><a href="#timings" class="ui-btn-active ui-state-persist">MMTS timings</a></li>
			</ul>
		</div>
	</div><!-- /footer -->
</div><!-- /page timings -->

<!-- Start of fourth page: #animation -->
<div data-role="page" id="animation">
	<div data-role="header" data-theme="e">
		<h1>Animation</h1>
	</div><!-- /header -->

	<div data-role="content" data-theme="d">	
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
	</div><!-- /content -->
	
	<div data-role="footer" data-theme="d" data-id="commontoolbar" data-position="fixed">
		<div  data-role="navbar">
			<ul>
				<li><a href="mobileHome.jsp#shareMMTSLocation" >Share MMTS Location</a></li>
				<li><a href="mobileHome.jsp#trackMMTSLocation" >Track MMTS locations</a></li>
				<li><a href="#timings" class="ui-btn-active ui-state-persist">MMTS timings</a></li>
			</ul>
		</div>
	</div><!-- /footer -->
</div><!-- /page timings -->

</body>
</html>