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
<div data-role="page" id="fareAndRouteHome">
  <div data-role="header">
    <h2>Fare and Route Details</h2>
    <a href="/" data-role="button" data-icon="home" >Home</a>
    <a href="#" data-role="button" data-icon="back" data-rel="back">Back</a>
    
  </div>
  <div data-role="content">
  	<p><a href="#" data-icon="alert" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong style='color:red'>Not implemented yet.</strong></p>
    <ul data-role="listview" data-inset="false">
      	<li><a href="#">Fare Details</a></li>
    	<li><a href="#">Route Details</a></li>
    	<li><a href="#">Train Enquiry and Complaints</a></li>
    	
   </ul>
   </div>
  <div data-role="footer" data-position="fixed">
   <h4>&copy; 2013 FlyingRail</h4>
  </div>
  
    <script>
  
      
    $("#fareAndRouteHome").on('pageinit',function(){
        console.log('fareAndRouteHome page initialization');

	   
    });  
   
  
    </script>

</div>

</body>
</html>
