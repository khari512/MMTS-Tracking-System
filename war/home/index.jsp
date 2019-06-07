<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../meta.jsp"%>
<script>

function onSuccess(data, status)
{
    data = $.trim(data);
    var $page=$("#timings");
 	// Get the header for the page.
 	//$page.html(data);
 	console.info("----"+$("#result").children( ":jqmData(role=content)" ));
 	 $page.children(":jqmData(role=content)").html(data).trigger( 'create' );
	//$header = $page.children( ":jqmData(role=header)" );

	// Get the content area element for the page.
	//$content = $page.children( ":jqmData(role=content)" );
	// Find the h1 element in our header and inject the name of
	// the category into it.
//	$header.find( "h1" ).html();

	// Inject the category items markup into the content element.
	//$content.html( markup );

	// Pages are lazily enhanced. We call page() on the page
	// element to make sure it is always enhanced before we
	// attempt to enhance the listview markup we just injected.
	// Subsequent calls to page() are ignored since a page/widget
	// can only be enhanced once.
	//$page.page();
	
   	console.info("Timings results "+data);
}

function onError(data, status)
{
    // handle an error
}       

$(document).ready(function() {
	$('form[id="timingsForm"]').submit(function() {
		console.info("timingsForm submitted");
        var formData = $("#timingsForm").serialize();
        /*
        $.mobile.changePage( "/timetable/GetTimings", {
    		type: "post",
    		data: $("form#timingsForm").serialize(),
    		changeHash:false
    	});
        */
/*
        $.ajax({
            type: "POST",
            url: "/timetable/GetTimings",
            cache: false,
            data: formData,
            success: onSuccess,
            error: onError
        }); */

        return true;
    });
});

$(document).bind('pagebeforechange',function(e,data){
	console.info("pagebeforechange");
	var $page = $( "#result" );

	// Get the header for the page.
	$header = $page.children( ":jqmData(role=header)" );

	// Get the content area element for the page.
	$content = $page.children( ":jqmData(role=content)" );
  
	});
</script>

<script>
$(document).bind('pagebeforechange',function(e,data){
	console.info("pagebeforechange");
	var $page = $( "#result" );

	// Get the header for the page.
	$header = $page.children( ":jqmData(role=header)" );

	// Get the content area element for the page.
	$content = $page.children( ":jqmData(role=content)" );
  
});
</script>
<script>
    $('[data-role=page]').live('pageshow', function (event, ui) {
    	console.info("in live('pageshow') event handler");
    	//console.info( 'This page was just hidden: '+ ui.prevPage.html());
    	console.info("current url ="+location.href);
    	console.info("current url path="+location.href.pathname);
    	var path=location.href.pathname;
    	//var split=path.split("/");
    	//var isHomePage=path.match(/home/gi);
    	//console.info("isHomePage "+isHomePage);
    	//var regexp="/home.*"
    	
    		// $.mobile.changePage(location.hash);
    	
    	
        try {
        	 _gaq.push(['_setAccount', 'UA-38352173-1']); 	
        	 hash = location.hash;
        	 console.info(" page(hash)="+location.hash);
       		//console.info("curr Url ="+location.href+" page(hash)="+location.hash+" active page"+$.mobile.activePage.children(":jqmData(role=header)").find("h1").html());

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

<%@ include file="../shareMMTSLocation.jsp"%>
<%@ include file="../trackMMTSLocation.jsp"%>
<%@ include file="../timings.jsp"%>
<div data-role="page" id="result" data-theme="d">
	<div data-role="header">
		<h1>Your Results</h1>
	</div>
	<div data-role="content">
	</div>

</div>

</body>
</html>
