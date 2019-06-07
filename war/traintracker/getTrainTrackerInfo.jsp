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
<div data-role="page" id="trainTrackerList" data-title="Train Tracker Info" >
	<div data-role="header" >
		<h1>Train Tracker Info</h1>
		<a href="/" data-icon="home" >Home</a>
		<a href="/traintracker"  data-icon="back"  >back</a>	
	</div><!-- /header -->
	<div data-role="content">
	<p id="resultMesg" style="display:none"><a href="#" data-icon="check" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong id='resultText'>Successfully inserted.</strong></p>
		<c:choose>
			<c:when test="${empty trackingInfoList}">
			       <div class="ui-grid-solo">
						<div class="ui-block-a"><p><a href="#" data-icon="alert" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong>There are no active trains currently.please try after some time.</strong></p></div>
						<script>
							console.info("There are no active trains to track.");							
						</script>
					</div>
			</c:when>				
	      	<c:otherwise>
	      	<p style="float:left;display:inline;">FlyingRail found statuses of ${fn:length(trackingInfoList)} trains.</p>
			     <table data-role="table" id="" data-mode="columntoggle" class="ui-body-d ui-shadow ui-responsive table-stripe" data-mini="true" data-column-btn-text="More details..">
					<thead><tr class="ui-bar-d">
						<th data-priority="1">Train number</th>
						<th>Exp Loc</th>						
						<th>Last know loc</th>
						<th>Last know time</th>
					</tr>
					</thead>
					<tbody>
					
					<c:forEach var="e" items="${trackingInfoList}">	
						<tr>
						
							<td>								
								<p><c:choose><c:when test="${e.trainNo==222 || e.trainNo==111 }">unknown</c:when><c:otherwise>${e.trainNo}</c:otherwise></c:choose>	</p>
							</td>
							<td><p>unknown</p></td>
							<td>	<p>${e.currentLocation}</p></td>
							<td><p><fmt:formatNumber type="number" 
		           				 value="${f:h(e.time)}" pattern="00.00"/></p>
		           			</td>							
							
							
						</tr>	
					
					</c:forEach>
				
					</tbody>
				</table>
				
		</c:otherwise>
	</c:choose>
	</div>
	<div data-role="footer" data-position="fixed">
	   <h4>&copy; 2013 FlyingRail</h4>
	 </div>
	 <script>
		 $("#trainTrackerList").on('pageinit',function(){
	        console.log('List of tracked trains page initialization');	   
	       
	    }); 
	 </script>
	 
</div><!-- /page -->



<%@ include file="../footer.jsp"%>

</body>
</html>