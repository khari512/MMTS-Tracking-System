<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>create timetable </title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(function() {
   
    $("#form").submit(function(){
        $.post(
            "Create",
            $('#form').serialize(),
            function(data,status){
                if(status == 'success'){
                    alert(data.title + ", " + data.content)
                }
            },
            'json'
        );
        return false;
    });
});
</script>
</head>
<body>
	<p>time table</p>
	<form method="post"  id="form">
		srcStation:
		<input type="text" ${f:text("boardingAt")} class="${f:errorClass('boardingAt', 'err')}"/>${f:h(errors.boardingAt)}<br /><br />
		trainName:
		<input type="text"  ${f:text("trainName")} class="${f:errorClass('trainName', 'err')}"/>${f:h(errors.trainName)}<br /><br />
		timimgsRawData:
		<textarea name="timingsRawData" class="${f:errorClass('timimgsRawData', 'err')}">${f:h(timimgsRawData)}</textarea>${f:h(errors.timimgsRawData)}<br /><br />
		timingsdelimeter:
		<input type="text"  ${f:text("timingsdelimeter")} /><br /><br />
			trainNumbersRawData:
		<textarea name="trainNumbersRawData" class="${f:errorClass('trainNumbersRawData', 'err')}">${f:h(trainNumbersRawData)}</textarea>${f:h(errors.trainNumbersRawData)}<br /><br />
		numberdelimeter:
		<input type="text"  ${f:text("numberdelimeter")}/><br /><br />
		noSundayTrainNo delimeter:
		<textarea name="sundayTrainDelimeter" class="${f:errorClass('sundayTrainDelimeter', 'err')}">${f:h(sundayTrainDelimeter)}</textarea>${f:h(errors.sundayTrainDelimeter)}<br /><br />
		validFromDate:
		<input type="text"  ${f:text("validFromDate")}/><br /><br />		
		validToDate:
		<input type="text"  ${f:text("validToDate")}/><br /><br />
		<input type="submit" value="submit"/>
	</form>
	
	<c:forEach var="e" items="${timingsList}">
		${f:h(e.trainNumber)}:${f:h(e.time)}
		<hr />
	</c:forEach>
</body>
</html>