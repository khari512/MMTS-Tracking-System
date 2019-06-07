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
<div data-role="page" id="" data-title="Suggestions" s>
	<div data-role="header" >
		<h1><c:choose><c:when test="${catageory}=='suggestion'">Suggestions</c:when>
				<c:otherwise> Complaints</c:otherwise>
			</c:choose>
		</h1>
		<a href="/" data-icon="home" >Home</a>
		<a href="/suggestions/"  data-icon="back"  >back</a>	
	</div><!-- /header -->
	<div data-role="content">
		<c:choose>
			<c:when test="${empty suggestionsList}">
			       <div class="ui-grid-solo">
						<div class="ui-block-a"><p><a href="#" data-icon="alert" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong>There are no ${catageory}s yet.</strong></p></div>
						<script>
							console.info("There are no ${catageory}s yet");
							//$.mobile.navigate("#dialogPage");
						</script>
					</div>
			</c:when>				
	      	<c:otherwise>
	      	<p style="float:left;display:inline;">${fn:length(suggestionsList)} ${catageory}s.</p>
	      	<ul data-role="listview" data-inset="false">
	      		<c:forEach var="e" items="${suggestionsList}">
	      			<li><a href=""><h2>${e.subject}</h2>
	      			<p>${e.suggestionString}</p>
	      			</a>
	      			</li>
	      		</c:forEach>
	      		
	      	</ul>
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