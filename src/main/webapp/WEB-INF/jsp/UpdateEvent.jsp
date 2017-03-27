<%@page import="edu.csueb.data.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/navigation.js" />"></script>
<title>Update Details</title>
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

<%@include file="static.jsp" %> 

<h4 style="margin-left:150px">Please update your Event details:</h4>

<div  style="margin-left: 150px">
<form action="event" method="post" id="opForm">
<input type="hidden" name="action" id="action"  />
<input type="hidden" name="eventid" id="eventid" value="${event.eventid}" />
<input type="hidden" name =response id ="updateResponse"/>
<table>
		<tr>
			<td>Name </td>
			<td><input type="text" id="name" name="name" autofocus="on" value="${event.name}"/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><input type="text" id="description" name="description" value="${event.description}"/></td>
		</tr>
		<tr>
			<td>Location</td>
			<td><input type="text" id="location" name="location" value="${event.location}"/></td>
		</tr>
		<tr>
			<td>Time</td>
			<td><input type="date" id="time" name="time" value="${event.time}"/></td>
		</tr>
		<tr>
			<td>Total Seats</td>
			<td><input type="number" id="totalseats" name="totalseats" value="${event.totalseats}" /></td>
		</tr>
	</table>
	<input type="button" class="btn" value="Update" name="Update" onclick="update()"/>
	<input type="button" class="btn" value="Back" name="back"  onclick="redirectSearch()"/>
	</form> 
	</div>
</body>
</html>