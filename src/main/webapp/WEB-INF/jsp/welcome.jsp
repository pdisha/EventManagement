<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/navigation.js" />"></script>

<title>Welcome to Plans4U</title>

</head>
<body background='<c:url value="/resources/images/pins.jpg"></c:url>' >

<form id="opForm" method="post" >
<input type="hidden" id="action" name="action"/>
</form>

<%@include file="static.jsp" %> 

</body>
</html>

