<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body style= "background-color: black">
<div class = "indv_containerl">
<div class = "indv_image">
<div class = "indv_image"><img src="assets/logo.jpg" class="admin_image"></img>
</div>
<div class = "individual_container">

	<h1 class = "indv_text">Customer sign in</h1>
	<h2>This is Individual page where a customer or admin can edit their information</h2>
	<form action="Edit" method="post">
		<table>
			<tr>
				<td align="right"><label class="signup_label" for="firstname">First Name:</label></td>
				<td align="left"><input type="text" class="signup_input" name="firstname"/></td>
			</tr>
			
			<tr>
				<td align="right"><label class="signup_label" for="lastname">Last Name:</label></td>
				<td align="left"><input type="text" class="indv_input"  name="lastname"/></td>
			</tr>
			<tr>
				<td align="right"><label class="indv_label" for="username">Username:</label></td>
				<td align="left"><input type="text" class="indv_input" id="username" name="username"/></td>
			</tr>
			<tr>
				<td align="right"><label class="signup_label" for="password">Password:</label></td>
				<td align="left"><input type="password" class="indv_input" name="password"/></td>
			</tr>
		</table>
			<button class="signup_button" type="submit">Sign Up</button>
			</form>
	</div>
	</div>
	</div>
</body>


</html>