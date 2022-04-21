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
	<h2>This is Login page</h2>
	
	<form action="Login" method="post">
	<div>
		<label for="username">Username</label>
		<input type="text" name="username"/>
	</div>
	<div>
		<label for="password">Password</label>
		<input type="password" name="password"/>
	</div>
		<button type="submit">Log in</button>
	</form>
</body>

</html>