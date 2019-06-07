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
<div data-role="page" id="" data-title="Time Table" data-url="#timings/">
	<div data-role="header" data-theme="e" data-add-back-btn="true">
		<h1>Train Timings</h1>
		<a href="/home" data-icon="home" >Home</a>
		<a href="/home"data-direction="reverse"  data-icon="back"  data-rel="back">back</a>	
	</div><!-- /header -->

<div data-role="content" data-theme="d" id="">	
	<div class="ui-grid-c">
			<div class="ui-block-a">Train Number</div>
			<div class="ui-block-b">Time</div>
			<div class="ui-block-c">Exp. Time</div>
			<div class="ui-block-d">Current Location</div>
	</div><!-- /grid-b -->
	<div class="ui-grid-c">
		<c:forEach var="e" items="${timingsList}">		
			<div class="ui-block-a"><p>${f:h(e.trainNumber)}</p></div>
			<div class="ui-block-b"><p><fmt:formatNumber type="number" 
            value="${f:h(e.time)}" pattern="00.00"/></p></div>
			<div class="ui-block-c"><p><fmt:formatNumber type="number" 
            value="${f:h(e.time)}" pattern="00.00"/></p></div>
			<div class="ui-block-d"><p>coming soon..</p></div>
			
		</c:forEach>
		
	</div><!-- /grid-b -->		
</div><!-- /content -->
	<%@ include file="../footer.jsp"%>
</div>

</body>
</html>