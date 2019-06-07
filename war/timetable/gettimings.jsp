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
<div data-role="page" id="" data-title="Train Timings" s>
	<div data-role="header" >
		<h1>Train Timings</h1>
		<a href="/" data-icon="home" >Home</a>
		<a href="#" data-rel="back"  data-icon="back"  >back</a>	
	</div><!-- /header -->
	<div data-role="content">
		<c:choose>
			<c:when test="${empty timingsList}">
			       <div class="ui-grid-solo">
						<div class="ui-block-a"><p><a href="#" data-icon="alert" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong>There are no trains for your search.please change the search criteria.</strong></p></div>
						<script>
							console.info("There are no trains for your search criteria");
							$.mobile.navigate("#dialogPage");
						</script>
					</div>
			</c:when>				
	      	<c:otherwise>
	      	<p style="float:left;display:inline;">${fn:length(timingsList)} trains found.</p>
			     <table data-role="table" id="" data-mode="columntoggle" class="ui-body-d ui-shadow ui-responsive table-stripe" data-mini="true" data-column-btn-text="More details..">
					<thead><tr class="ui-bar-d">
						<th data-priority="4">Train number</th>
						<th>Time</th>
						<th data-priority="1">Exp. Time</th>
						<th data-priority="2">Current Location</th>
						<th data-priority="3">Track</th>
					</tr>
					</thead>
					<tbody>
					
					<c:forEach var="e" items="${timingsList}">	
						<tr>
							<td>
								<c:choose>
							      <c:when test="${e.notOnSundayFlag}">
							       <p style='color:red;'>
							      </c:when>				
							      <c:otherwise>
							       <p>
							      </c:otherwise>
								</c:choose>
								${f:h(e.trainNumber)}</p>
							</td>
						
							<td><p><fmt:formatNumber type="number" 
		           				 value="${f:h(e.time)}" pattern="00.00"/></p>
		           			</td>
						
							<td><p><fmt:formatNumber type="number" 
		            value="${f:h(e.time)}" pattern="00.00"/></p></td>
						
							<td><p>unknown</p></td>
						
							<td><p><a href="#" data-role="button" data-icon="arrow-r" data-iconpos="notext">&gt;</a></p></td>
					</tr>	
					
					</c:forEach>
				
					</tbody>
				</table>
		</c:otherwise>
	</c:choose>
	</div>
	<div data-role="footer">
	   <h4>&copy; 2013 Flyingrail</h4>
	 </div>
</div><!-- /page -->
<%@ include file="../footer.jsp"%>

</body>
</html>