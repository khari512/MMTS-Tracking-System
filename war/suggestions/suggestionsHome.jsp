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
<div data-role="page" id="suggestionsHome">
  <div data-role="header">
    <h2>Suggestions/Feedback</h2>
    <a href="/" data-role="button" data-icon="home" >Home</a>
    <a href="#" data-role="button" data-icon="back" data-rel="back">Back</a>
    
  </div>
  <div data-role="content">
  	 <ul data-role="listview" data-inset="false" data-divider-theme="b" data-count-theme="e">
    	<li data-role="list-divider">Suggestions<span class="ui-li-count">${suggCount}</span></li>
      	<li><a href="#suggestionsForm123">
      		<h2>Submit a suggestion</h2>
      		<p><strong>Your are welcome to submit a suggestion/feedback about FlyingRail to improve our services. </strong></p>
      		
      	</a></li>
      	<li><a href="#"  id="viewSuggAnchor">
      		<form action="GetSuggestions" method="post" style="display:none" id="viewSuggForm">
    			<input type="hidden" name="catageory" value="suggestion" id=""/>
    		</form>
    		<h2>View all suggestions</h2>
    		<p><strong>You can view all submitted suggestions by all users.</strong></p>
    		
    	</a></li>
    	<li data-role="list-divider">Complaints/Bugs<span class="ui-li-count">${compCount}</span></li>
    	<li><a href="#complaintForm">
    		<h2>Submit a complaint</h2>
    		<p><strong>Feel free to submit a complaint about any technical problems you faced with FlyingRail.You can also raise the bugs here.</strong></p>
    		
    	</a></li>
    	<li><a href="#" id="viewCompAnchor">    		
    		<form action="GetSuggestions" method="post" style="display:none" id="viewCompForm">
    			<input type="hidden" name="catageory" value="complaint" id=""/>
    		</form>
    		<h2>View complaints</h2>
    		<p><strong>List of all submited complaints/bugs by all users.</strong></p>
    		
    	</a></li>
    	
   </ul>
   </div>
  <div data-role="footer" data-position="fixed">
   <h4>&copy; 2013 FlyingRail</h4>
  </div>
  
    <script>
    $("#viewSuggAnchor").click(function(){
    	$("#viewSuggForm").submit();
    });
    $("#viewCompAnchor").click(function(){
    	$("#viewCompForm").submit();
    });
    
    $("#suggestionsHome").live('pageinit',function(){
        console.log('suggestionsHomes page initialization');	  
        
    });  
     
    </script>

</div>

<div data-role="page" id="suggestionsForm123">
	<div data-role="header">
		<h2>Submit a suggestion</h2>
		<a href="/" data-role="button" data-icon="home" >Home</a>
    	<a href="#" data-role="button" data-icon="back" data-rel="back">Back</a>
   	</div>
	<div data-role="content">
		<p id="resultMesg" style="display:none"><a href="#" data-icon="check" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong id='resultText'>Successfully inserted.</strong></p>
		<form action="InsertSuggestion" method="post" id="insertSuggestionForm">
			<ul data-role="listview" data-inset="true">
				<li data-role="fieldcontain">
					<label for="name">Name :</label>
					<input type="text" name="name" id="name"/>
				</li>
				<li data-role="fieldcontain">
					<label for="subject">Title :</label>
					<input type="text" name="subject" id="subject"/>
				</li>
				<li data-role="fieldcontain">
					<label for="suggestionString">Suggestion :</label>
					<textarea cols="40" rows="8"  name="suggestionString" id="suggestionString"></textarea>
					<input type="hidden" name="catageory" value="suggestion" id=""/>
				</li>
							
				<li data-role="fieldcontain" data-theme="d">
					<fieldset class="ui-grid-a" >
						<div class="ui-block-a"><input type="submit" id="" value="Submit"></div>
						<div class="ui-block-b"><input type="reset" value="Reset"/></div>
					</fieldset>
				</li>
			</ul>
		
		</form>	
	
	</div>
	<div data-role="footer" data-position="fixed">
		<h4>&copy; 2013 FlyingRail</h4>
	</div>
	
	 <script>
        
    $("#suggestionsForm123").live('pageinit',function(){
        console.log('suggestionsForm123 page initialization');	   
        $("#insertSuggestionForm").submit(function(){
        	var suggestionString=$("#suggestionString","#insertSuggestionForm").val();
        	var name=$("#name","#insertSuggestionForm").val();
        	var subject=$("#subject","#insertSuggestionForm").val();
        	if($.trim(name)=="" || $.trim(subject)=="" || $.trim(suggestionString)==""){
        		alert("please enter all the fields");
        		return false;
        	}
        	var serializedData = $(this).serialize();
        	$.ajax({url:'InsertSuggestion',type:'POST',data:serializedData})
        	.done(function(data){
        		console.log("insertSuggestionForm submition successfully");
        		$("#resultMesg","#suggestionsForm123").show();
        		
        	})
        	.fail(function(){
        		console.log("insertSuggestionForm submition failed");
        		$("#resultText","#suggestionsForm123").text("Problem occured.please try again.");
        		$("#resultMesg .ui-icon","#suggestionsForm123").addClass("ui-icon-delete").removeClass("ui-icon-check");
        		$("#resultMesg","#suggestionsForm123").show().css("color","red");
        	});
        	return false;
        });
    });  
     
    </script>
</div>

<div data-role="page" id="complaintForm">
	<div data-role="header">
		<h2>Submit a complaint</h2>
		<a href="/" data-role="button" data-icon="home" >Home</a>
    	<a href="#" data-role="button" data-icon="back" data-rel="back">Back</a>
   	</div>
	<div data-role="content">
	<p id="resultMesg" style="display:none"><a href="#" data-icon="check" data-role="button" data-theme="d" data-iconpos="notext" data-inline="true"></a><strong id='resultText'>Successfully inserted.</strong></p>
		<form action="InsertSuggestion" method="post" id="complaintFormId">
			<ul data-role="listview" data-inset="true">
				<li data-role="fieldcontain">
					<label for="name">Name :</label>
					<input type="text" name="name" id="name"/>
				</li>
				<li data-role="fieldcontain">
					<label for="subject">Problem :</label>
					<input type="text" name="subject" id="subject"/>
				</li>
				<li data-role="fieldcontain">
					<label for="suggestionString">Problem Description :</label>
					<textarea cols="40" rows="8"  name="suggestionString" id="suggestionString"></textarea>
					<input type="hidden" name="catageory" value="complaint" id=""/>
				</li>
							
				<li data-role="fieldcontain" data-theme="d">
					<fieldset class="ui-grid-a" >
						<div class="ui-block-a"><input type="submit" id="" value="Submit"></div>
						<div class="ui-block-b"><input type="reset" value="Reset"/></div>
					</fieldset>
				</li>
			</ul>
		
		</form>	
	
	</div>
	<div data-role="footer" data-position="fixed">
		<h4>&copy; 2013 FlyingRail</h4>
	</div>
	
	 <script>
        
    $("#complaintForm").live('pageinit',function(){
        console.log('complaintForm page initialization');	
        $("#complaintFormId").submit(function(){
        	console.log('in complaintFormId submit event');	
        	var suggestionString=$("#suggestionString","#complaintFormId").val();
        	var name=$("#name","#complaintFormId").val();
        	var subject=$("#subject","#complaintFormId").val();
        	if($.trim(name)=="" || $.trim(subject)=="" || $.trim(suggestionString)==""){
        		alert("please enter all the fields");
        		return false;
        	}
        	var serializedData = $(this).serialize();
        	$.ajax({url:'InsertSuggestion',type:'POST',data:serializedData})
        	.done(function(data){
        		console.log("complaintForm submition successfully");
        		$("#resultMesg","#complaintForm").show();
        	})
        	.fail(function(){
        		console.log("complaintForm submition failed");        		
        		$("#resultText","#complaintForm").text("Problem occured.please try again.");
        		$("#resultMesg .ui-icon","#complaintForm").addClass("ui-icon-delete").removeClass("ui-icon-check");
        		$("#resultMesg","#complaintForm").show().css("color","red");
        	});
        	return false;
        });
    });  
     
    </script>
</div>
<%@ include file="../footer.jsp"%>
</body>
</html>
