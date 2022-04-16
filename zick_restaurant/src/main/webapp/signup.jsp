<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<h2>This is Signup page</h2>
	
	<form action="Signup" method="post">
	<div>
		<label for="firstname">First name</label>
		<input type="text" name="firstname"/>
	</div>
	<div>
		<label for="lastname">Last name</label>
		<input type="text" name="lastname"/>
	</div>
	<div>
		<label for="username">Username</label>
		<input type="text" name="username"/>
	</div>
	<div>
		<label for="password">Password</label>
		<input type="password" name="password"/>
	</div>
		<button type="submit">Sign up</button>
	</form>
</body>

</html>
