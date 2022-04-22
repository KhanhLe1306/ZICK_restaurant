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
	
	<div class="signup_headerimg">
		</div>
	
	<div class="signup_container">
	
		
		<form action="Login" method="post">
		<table>
			<tr>
				<td align="right"><label class="signup_lable" for="username">Username:</label></td>
				<td align="left"><input type="text" class="signup_input" name="username"/></td>
			</tr>
			
			<tr>
				<td align="right"><label class="signup_lable" for="password">Password:</label></td>
				<td align="left"><input type="text" class="signup_input"  name="password"/></td>
		</table>
			<button class="login_button" type="submit">Login</button>
		</form>
	</div>
	
</body>

</html>
