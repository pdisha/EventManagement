<%@page import="edu.csueb.data.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/navigation.js" />"></script>

<title>Manage Events</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/navigation.js" />"></script>
</head>
<%
	String resmsg =null;
	if(request.getAttribute("response")!=null){
		 resmsg= String.valueOf(request.getAttribute("response"));
		 System.out.print(resmsg);
} %>
<body background='<c:url value="/resources/images/pins.jpg"></c:url>' >


<script type="text/javascript">
	
	window.onload= function(){
		var msg = '<%=resmsg%>';
		if(msg!='null'){
			alert(msg);
		}
	}
	</script>
<script type="text/javascript">

	
	function create(){
		document.getElementById('action').value = 'Create';
		document.getElementById('opForm').submit();
	}

</script>
<%@include file="static.jsp" %> 
<h3 style="margin-left:150px">Create Event:</h3>
<form action="event" method="post" id="opForm">
<input type="hidden" name="action" id="action"  />
<div style="margin-left: 150px">
<table>
<tr>
			<td>Name </td>
			<td><input type="text" class="txt" id="name" name="name" autofocus="on"/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><input type="text" class="txt" id="description" name="description"/></td>
		</tr>
		<tr>
			<td>Location</td>
			<td><input type="text" class="txt" id="location" name="location"/></td>
		</tr>
		<tr>
			<td>Time</td>
			<td><input type="date" id="time" name="time"/></td>
		</tr>
		<tr>
			<td>Total Seats</td>
			<td><input type="number" id="totalseats" class="txt" name="totalseats"/></td>
		</tr>
		
	</table>
	<input type="button" class="btn" value="Create" name="Create" onclick="create();"/>
	<input type="button" class="btn" value="Back" name="Back"  onclick="redirectSearch();"/>
	</div>
	</form> 
</body>
</html>
