<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>



<body>

<%
	if(request.getAttribute("message") != null){%>
		<h1>${message}</h1>
	<%}
%>
	<div class="signup_image">
	</div>
	
	<div class="signup_imgcon">
		<div class="signup_headerimg">
			<img src="assets/logo.jpg">
		</div>
	</div>
		
	<div class="signup_container">
		
		
		<h2 class ="signup_header">Sign Up for Free Rewards Today!</h2>
		<form action="Signup" method="post">
		<table>
			<tr>
				<td align="right"><label class="signup_lable" for="firstname">First Name:</label></td>
				<td align="left"><input type="text" class="signup_input" name="firstname"/></td>
			</tr>
			
			<tr>
				<td align="right"><label class="signup_lable" for="lastname">Last Name:</label></td>
				<td align="left"><input type="text" class="signup_input"  name="lastname"/></td>
			</tr>
			<tr>
				<td align="right"><label class="signup_lable" for="username">Username:</label></td>
				<td align="left"><input type="text" class="signup_input" id="username" name="username"/></td>
			</tr>
			<tr>
				<td align="right"><label class="signup_lable" for="password">Password:</label></td>
				<td align="left"><input type="password" class="signup_input" name="password"/></td>
			</tr>
		</table>
			<button class="signup_button" type="submit">Sign Up</button>
		</form>
	</div>
	
	
</body>

</html>
