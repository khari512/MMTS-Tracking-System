<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="meta.jsp"%>

<script>
    $('[data-role=page]').live('pageshow', function (event, ui) {
      console.info("live('pageshow') event handler in home page .");
      console.info("current url ="+location.href);
      console.info("current url path="+location.href.pathname);
      var path=location.href.pathname;
      //var split=path.split("/");
      //var isHomePage=path.match(/home/gi);
      //console.info("isHomePage "+isHomePage);
      //var regexp="/home.*"
      
        try {
           _gaq.push(['_setAccount', 'UA-38352173-1']);   
           hash = location.hash;
           console.info(" page(hash)="+location.hash);
           if (hash) {
                _gaq.push(['_trackPageview', hash.substr(1)]);
            } else {
                _gaq.push(['_trackPageview']);
            }
        } catch(err) {

        }

    });


    
</script>
</head>

<body>

<div data-role="page" id="home">
  <div data-role="header">
    <img src="images/train-icon1.png"  alt="flyingrail" class="ui-btn-left" width="35" height="35"/>
    <h1>FlyingRail (Under Development)</h1>
    <a href="#" data-iconpos="notext" data-icon="search" class="ui-btn-right" data-theme="c">Search</a>
  </div>
  <div data-role="content">     
      <ul data-role="listview">
        <li>
          <a href="/sharetrain/" >           
            <img src='images/share_icon.png'/>
            <h2>Share MMTS Location </h2>
            <p>Share your mmts current location.</p>
            <p class="ui-li-aside"><span class="ui-li-count" style="color:red;top:25%;right:20px;">0 shares</span></p>
          </a>
        </li>
        <li><a href="/traintracker?allActiveTrains=${activeTrackerCount}" >      
          <img src='images/train-icon1.png'/>
          <h2>Track MMTS Trains</h2>
          <p>Track the current locations of MMTS trains.<span class="ui-li-count" style="color:red;top:25%;right:20px;">${activeTrackerCount} trains </span></p>
        </a></li>
        <li><a href="/searchtraintimings">
          <img src='images/timer.png'/>
          <h2>MMTS Time Table</h2>
          <p>Get the timings of all hyderabad mmts trains.</p>
        </a></li>
        <li><a href="/fareandroute" >
          <img src='images/question.png'/>
          <h2>Fare &amp; Stations Details</h2>
          <p>Get the fare details between stations and route details of a train.</p>
        </a></li>
        <li><a href="/suggestions/" data-ajax="false">
          <img src='images/customer_feedback.png'/>
          <h2>Suggestions/Complaints</h2>
          <p>Please let us know your suggestions/complaints to improve our services.</p>
        </a></li>
        
      </ul>           
  
  </div>
  <div data-role="footer">
   <h4>&copy; 2013 FlyingRail</h4>
  </div>
  

</div>


</body>
</html>
