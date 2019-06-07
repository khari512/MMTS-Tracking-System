<!DOCTYPE html>  
<html>  
 <head>
	<%@ include file="meta.jsp"%>	

    <script>  

	//google maps code 
/*
var geocoder;
var map;

function initialize() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(17.385044,78.486671);
  var mapOptions = {
    zoom: 8,
    center: latlng,
    mapTypeId: 'roadmap'
  }
  map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
}


		function showAddress(response) {
		  
		    if (!response || response.Status.code != 200) {
		      alert("Status Code:" + response.Status.code);
		    } else {
			      place = response.Placemark[0];
			      point = new GLatLng(place.Point.coordinates[1],
			                          place.Point.coordinates[0]);     
			
				$("#info").html(   '<b>orig latlng:</b>' + response.name + '<br/>' +
				        '<b>latlng:</b>' + place.Point.coordinates[1] + "," + place.Point.coordinates[0] + '<br>' +
				        '<b>Status Code:</b>' + response.Status.code + '<br>' +
				        '<b>Status Request:</b>' + response.Status.request + '<br>' +
				        '<b>Address:</b>' + place.address + '<br>' +
				        '<b>Accuracy:</b>' + place.AddressDetails.Accuracy + '<br>' +
				        '<b>Country code:</b> ' + place.AddressDetails.Country.CountryNameCode);
			}
		}
        jQuery(window).ready(function(){  
            jQuery("#btnInit").click(initiate_watchlocation);  
            jQuery("#btnStop").click(stop_watchlocation);  
        });  
        
        var watchProcess = null;  
        function initiate_watchlocation() {  
        	
			if (watchProcess == null) {  
				watchProcess = navigator.geolocation.watchPosition(handle_geolocation_query, handle_errors);  
			}  
		}   
        function stop_watchlocation() {  
			if (watchProcess != null)  
			{  
				navigator.geolocation.clearWatch(watchProcess);  
				watchProcess = null;  
			}  
		}  
        function handle_errors(error)  
        {  
            switch(error.code)  
            {  
                case error.PERMISSION_DENIED: alert("user did not share geolocation data");  
                break;  
                case error.POSITION_UNAVAILABLE: alert("could not detect current position");  
                break;  
                case error.TIMEOUT: alert("retrieving position timedout");  
                break;  
                default: alert("unknown error");  
                break;  
            }  
        }  
         function handle_geolocation_query(position) {              
			var text = "Latitude: "  + position.coords.latitude  + "<br/>" +  
					   "Longitude: " + position.coords.longitude + "<br/>" +  
					   "Accuracy: "  + position.coords.accuracy  + "<br/>" +  
					   "Time: " + new Date(position.timestamp);  
		    var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
		    geocoder.geocode({'latLng': latlng}, function(results, status) {
		      if (status == google.maps.GeocoderStatus.OK) {
		        if (results[1]) {		         
		         $("#info").html(results[1].formatted_address);		          
		        } else {
		          alert('No results found');
		        }
		      } else {
		        alert('Geocoder failed due to: ' + status);
		      }
		    });
			
		}  
*/

    </script>  
  </head>  
  <body onload="initialize()">  
    <div>  
      <input type="button" id="btnInit" value="Monitor my location"/>  
       <input type="button" id="btnStop" value="Stop monitoring"/>  
    </div>  
    <div id="info" style="width:200px;height:200px;color:#fff;"></div> 
   <div id="map_canvas" style="width:200px;height:200px;">  </div>
  </body>  
</html> 