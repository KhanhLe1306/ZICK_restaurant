<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>
	<h2>This is Login page</h2>
	
	<form action="Login" method="post">
		<label for="username">Username</label>
		<input type="text" name="username"/>
		<label for="password">Password</label>
		<input type="password" name="password"/>
		
		<button type="submit">Log in</button>
	</form>
</body>

</html>