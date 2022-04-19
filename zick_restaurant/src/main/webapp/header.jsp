<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/styles.css">

</head>

<body>
	<nav>
		<h1 class="logo_name">Hello ZICK restaurant!</h1>
		<div class="nav__buttons">
			<%
			if (session.getAttribute("customerId") == null && session.getAttribute("adminId") == null) {
			%>
			<a href="login.jsp"><button>Log in</button></a> 
			<a href="signup.jsp"><button>Sign up</button></a>
			<%
			} else {
			%>
			<a href="Logout"><button>Log out</button></a>
			<%
			}
			%>
		</div>
	</nav>
</body>

</html>