<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tables.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/navigation.js" />"></script>
</head>
<body background='<c:url value="/resources/images/pins.jpg"></c:url>' >
<script type="text/javascript">
	
	var listSize = ${size};
	
	function updateRedirect(){
		
		var str = getSelectedItem();
		
		if(str!=''){
			document.getElementById('updateItem').value=str ;
			setValues('RedirectUpdate');
		}
	}
	
	function deleteRecords(){
		if (confirm("Are You sure to delete this record?") == true) {
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
<form id="opForm" name="opForm" method="post" action ="userUpdate">
<input type="hidden" id="deletedItems" name="deletedItems" />
<input type="hidden" id="updateItem" name="updateItem" />
<input type="hidden" id="action" name="action" />
<%
int i =1; 
%>

<table>
<th><input type="radio" id="all" value="all"/></th>
<th>Sr.No</th>
<th>Username</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>

<c:forEach items="${userList}" var="user">

	<tr style="border: 1px solid black;">
		<td><input type="radio" id="<%=i %>" value="${user.userId}"/></td>
		<td><c:out value="${user.userId}"> </c:out></td>
		<td><c:out value="${user.username}"> </c:out></td>
		<td><c:out value="${user.fName}"> </c:out></td>
		<td><c:out value="${user.lastName}"> </c:out></td>
		<td><c:out value="${user.email}"> </c:out></td>
	</tr>
	<%i++; %>
</c:forEach>
</table>
<br>
<br>
<div style="margin-left: 200px">
<input type="button" class="btn" name="edit" value="Edit" onclick="updateRedirect()"/>&nbsp;&nbsp;
<input type="button" class="btn" name="Delete" value="Delete" onClick="deleteRecords()"/>
</div>
</form>
</div>
</body>
</html>

