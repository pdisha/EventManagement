<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manage Event</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tables.css" />" rel="stylesheet">
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
	var listSize = ${size};
	
	function viewit(element){
	}
	
	function abcd(){
		document.getElementById('opForm').action ="userUpdate";
		var str = getSelectedItem();
		
		if(str!=''){
			document.getElementById('updateItem').value=str ;
			setValues('Cancel');
		}
	}
	
	function sd(){
		document.getElementById('opForm').action ="userUpdate";
		var str = getSelectedItem();
		
		if(str!=''){
			document.getElementById('updateItem').value=str ;
			setValues('Register');
		}
	}
	
	function createRedirect(){
		setValues('RedirectCreate');
	}
	
	function updateRedirect(){
		
		var str = getSelectedItem();
		
		if(str!=''){
			document.getElementById('updateItem').value=str ;
			setValues('RedirectUpdate');
		}
	}
	
	function deleteRecords(){
		if (confirm("Are You sure to delete this event?") == true) {
			var str = getSelectedItem();
			if(str!=''){
				document.getElementById('deletedItems').value=str;
				setValues('Delete');
			}
		}
	}
	
	function setValues(action){
		document.getElementById('action').value= action;;
		document.getElementById('opForm').submit();
	}
	
	function getSelectedItem(){
		var i;
		var str='';
		for(i=1;i<=listSize;i++){
			if(document.getElementById(i).checked){
				var test = document.getElementById(i).value;
				str=test;
				break;
			}
		}
		if(str!=''){
			return str;
		}
		else{
			alert("Please select atleast one record.");
			return '';
		}
	}
	
</script>

<%@include file="static.jsp" %> 

<form id="opForm" name="opForm" method="post" action ="event">
<input type="hidden" id="deletedItems" name="deletedItems" />
<input type="hidden" id="updateItem" name="updateItem" />
<input type="hidden" id="action" name="action" />
<%
int i =1; 
%>

<table>
<th><input type="radio" id="all" value="all"/></th>
<th>Sr.No</th>
<th>Name</th>
<th>Location</th>
<th>Time</th>
<%
if(request.getAttribute("onlyMyEvents")==null){%>
	<th>Seats</th>
<%}%>
<th>View</th>

<c:forEach items="${eventList}" var="event">

	<tr style="border: 1px solid black;">
		<td><input type="radio" id="<%=i %>" value="${event.eventid}"/></td>
		<td><c:out value="<%=i %>"> </c:out></td>
		<td><c:out value="${event.name}"> </c:out></td>
		<td><c:out value="${event.location}"> </c:out></td>
		<td><c:out value="${event.time}"> </c:out></td>
		<%
			if(request.getAttribute("onlyMyEvents")==null){%>
				<td><c:out value="${event.regseats}"> </c:out></td>
		<%}%>
		<td><img alt="View" src="/resources/images/news.png" id="${event.eventid}" onclick="viewit(this);"></td>
	</tr>
	<%i++; %>
</c:forEach>
</table>
<br>
<br>
<div style="margin-left: 200px">
<%
if(request.getAttribute("onlyMyEvents")!=null){%>
		<input type="button" class="btn" name="cancel" value="Cancel" onclick="abcd();"/>&nbsp;&nbsp;
<%}
else{%>
	<input type="button" class="btn" name="create" value="Create" onclick="createRedirect();"/>&nbsp;&nbsp;
	<input type="button" class="btn" name="edit" value="Edit" onclick="updateRedirect();"/>&nbsp;&nbsp;
	<input type="button" class="btn" name="disha" value="Register" onclick="sd();"/>&nbsp;&nbsp;
	<input type="button" class="btn" name="Delete" value="Delete" onClick="deleteRecords();"/>
<%} %>
</div>
</form>
</div>
</body>
</html>