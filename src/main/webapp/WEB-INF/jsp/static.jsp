<%@include file="header.jsp" %> 
<script type="text/javascript">
	function Redirect(e)
	{
		document.getElementById('action').value =e.id; 
		document.getElementById('opForm').action="home";
		document.getElementById('opForm').submit();
	}
</script>
<div id="mySidenav" class="sidenav" >
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#" onclick="Redirect(this)" id="Home">Home</a>
  <a href="#" onclick="Redirect(this)" id="Search" >Administrator</a>
  <a href="#" onclick="Redirect(this)" id="Event">Manage Events</a>
  <a href="#" onclick="Redirect(this)" id="MyEvents">My Events</a>
  <a href="/temp">Logout</a>
</div>

<div id="main" align="left" style="margin-left: 150px;margin-top: 0px">

  <h1> <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>&nbsp;&nbsp;Hi, ${user.username} !!</h1>

   Thank you for choosing us. You can create your own event, see other events and register as well.

  <br>
  <br>
