<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>

<head>
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/js/navigation.js" />"></script>
 <title>Plans4U</title>
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
<script>
	function submitUser(element){
		document.getElementById("action").value= element.name;
		document.getElementById("mainForm").submit(); 
		
	}
	function validate(){
		return true;
	}
</script>

<%@include file="header.jsp" %> 

<P style="margin-left: 50px">  Plans4U is the place where you can brows events which are going to be happen in near future. You can get all 
information about the event and can register for the same, too. !!</p>
<p style="margin-left: 50px"> So, Hurry Up !! Don't miss the moments with your friends and beloved ones.  
</P>
<div>
<form id="mainForm" method="post" action="home" >

<input type="hidden" name="action" id="action" value=""/>
<div style="color:red" >
<%-- <c:if test="${errormsg!=null}">
	<c:out value="${errormsg}" ></c:out>
</c:if> --%>
</div> 
<div align="right" style="color:#800000">
<div id="loginDiv">
	Username &nbsp;
	<input type="text" class="txt" id="loginUName" name ="loginUName"/> &nbsp;&nbsp;&nbsp;
	 Password <input type="password" class="txt" id="loginPsw" name="loginPsw"/>&nbsp;&nbsp;&nbsp;
	 <input type="button" class="btn" value="Login" name="login" onClick="submitUser(this)" />&nbsp;&nbsp;&nbsp;
</div>
<br><br>
<div id="newUserDiv">
	<table border="0px" style="width:500px;color:#800000" align="right">
		<tr>
		<th colspan="2" style="font-size:20pt">Sign Up</th>
		</tr>
		<tr>
			<td><input type="text" name="fName" title="First Name" class="txt" value="First Name" onfocus="inputFocus(this)" onblur="inputBlur(this)" /></td>
			<td><input type="text" name="lName" title="Last Name" class="txt" value="Last Name" onfocus="inputFocus(this)" onblur="inputBlur(this)" /></td>
		</tr>
		<tr>
			<td><input type="text" name="uName" id="uName" title="Username" class="txt" value="Username" onfocus="inputFocus(this)" onblur="inputBlur(this)" /></td>
			<td><input type="text" name="email" id="email" title="Email" class="txt" value="Email" onfocus="inputFocus(this)" onblur="inputBlur(this)" /></td>
			
		</tr>
		<tr>
			<td><input type="text" name="psw" id="psw" title="Password" class="txt" value="Password" onfocus="inputFocus(this)" onblur="inputBlur(this)" /></td>
			<td><input type="text" name="repsw" id="rePsw" title="Re-Password" class="txt" value="Retype Password" onfocus="inputFocus(this)" onblur="inputBlur(this)" /></td>
		</tr>
		<tr>
		<td rowspan="2" colspan="2" align="center"><input type="button" class="btn" value="Submit" name="signup" onClick="submitUser(this);" /> </td>
		</tr>
	</table>
</div>
</div>
</form>
</div>
</body>

</html>
