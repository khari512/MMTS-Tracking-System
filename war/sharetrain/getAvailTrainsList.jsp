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
<div data-role="page" id="shareTrainsList" data-title="Train Timings" s>
	<div data-role="header" >
		<h1>Select one train</h1>
		<a href="/" data-icon="home" >Home</a>
		<a href="/sharetrain/"  data-icon="back"  >back</a>	
	</div><!-- /header -->
	<div data-role="content">
	<p id="resultMesg" style="display:none"><a href="#" data-icon="check" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong id='resultText'>Thank you very much for you input.</strong></p>
		<c:choose>
			<c:when test="${empty timingsList}">
			       <div class="ui-grid-solo">
						<div class="ui-block-a"><p><a href="#" data-icon="alert" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong>Thank you very much for your input.</strong></p></div>
						<script>
							console.info("There are no trains for your search criteria");							
						</script>
					</div>
			</c:when>				
	      	<c:otherwise>
	      	<p style="float:left;display:inline;">Please select one appropriate train.</p>
			     <table data-role="table" id="" data-mode="columntoggle" class="ui-body-d ui-shadow ui-responsive table-stripe" data-mini="true" data-column-btn-text="More details..">
					<thead><tr class="ui-bar-d">
						<th data-priority="1">Train number</th>
						<th>Time</th>						
						<th>Select</th>
					</tr>
					</thead>
					<tbody>
					
					<c:forEach var="e" items="${timingsList}">	
						<tr>
							<a href="#" >
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
						
							<td><p><a class='updateTracker' href="/sharetrain/UpdateTrackingInfo?currentStation=${requestScope.currentStation}&trainNo=${e.trainNumber}&time=${requestScope.time}&trainName=${requestScope.trainName}" data-role="button" data-icon="arrow-r" data-iconpos="notext" 
							destination="${requestScope.trainName}" currentStation="${requestScope.currentStation}" trainNo="${e.trainNumber}">&gt;</a></p></td>
							</a>
						</tr>	
					
					</c:forEach>
				
					</tbody>
				</table>
				
		</c:otherwise>
	</c:choose>
	</div>
	<div data-role="footer">
	   <h4>&copy; 2013 FlyingRail</h4>
	 </div>
	
	 <script>
		 $("#shareTrainsList").on('pageinit',function(){
	        console.log('shareTrain from avilable list of trains page initialization');	  
	        
	       /* commenting ajax submition as it is handling in anchor tag itself.
	       
	        $(".updateTracker").click(function(e){
	        	var destination=$(this).attr('destination'); 
	        	var currentStation=$(this).attr('currentStation'); 
				var trainNo=$(this).attr('trainNo');				
	        	var time="${requestScope.time}";
	        	var trainName="${requestScope.trainName}";
	        	$.ajax({url:'/sharetrain/UpdateTrackingInfo',type:'POST',data:{destination:destination,currentStation:currentStation,trainNo:trainNo,time:time,trainName:trainName}})
	        	.done(function(data){
	        		console.log("UpdateTrackingInfo submition successfully");
	        		$("#resultMesg").show(1000,function(){
	        			$("#resultMesg").delay(4000).hide(1000);
	        		});
	        		//$("#resultMesg").delay(5000).hide();
	        		
	        	})
	        	.fail(function(){
	        		console.log("UpdateTrackingInfo submition failed");
	        		$("#resultText").text("Problem occured.please try again.");
	        		$("#resultMesg .ui-icon").addClass("ui-icon-delete").removeClass("ui-icon-check");
	        		$("#resultMesg").css("color","red");
	        		$("#resultMesg").show(1000,function(){
	        			$("#resultMesg").delay(4000).hide(1000);
	        		});
	        	});
	        	
	        });
	       
	       */
	    }); 
	 </script>
	 
	 
</div><!-- /page -->



<%@ include file="../footer.jsp"%>

</body>
</html>