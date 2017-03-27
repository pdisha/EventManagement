<%@page import="edu.csueb.data.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/navigation.js" />"></script>

<title>Update Details</title>
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
<%@include file="static.jsp" %> 

<h4 style="margin-left:150px">Please update your details here:</h4>
<form method="post" action="userUpdate" id="opForm">
<%
	User user =(User) request.getAttribute("user");
%>
<input type="hidden" name="action" id="action" value="Edit" />
<input type="hidden" name="userid" id="userid" value="<%=user.getUserId() %>" />
<input type="hidden" name =response id ="updateResponse"/>
<div  style="margin-left: 150px">
<table>
<tr>
			<td>First Name </td>
			<td><input type="text" id="fName" name="fName" autofocus="on" value="<%=user.getfName()%>"/></td>
		</tr>
		<tr>
			<td>Last Name </td>
			<td><input type="text" id="lName" name="lName" value="<%=user.getLastName()%>"/></td>
		</tr>
		<tr>
			<td>Username </td>
			<td><input type="text" id="uName" name="uName" value="<%=user.getUsername()%>"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" id="email" name="email" value="<%=user.getEmail()%>"/></td>
		</tr>
		<tr>
			<td>Old Password</td>
			<td><input type="text" id="psw" name="psw" value=""/></td>
		</tr>
		<tr>
			<td>New Password</td>
			<td><input type="text" id="newPsw" name="newPsw" value=""/></td>
		</tr>
	</table>
	<input type="button" class="btn" value="Update" name="Update" onclick="update()";/>
	<input type="button" class="btn" value="Back" name="back"  onclick="redirectSearch();"/>
	</div>
	</form> 
	</div>
</body>
</html>