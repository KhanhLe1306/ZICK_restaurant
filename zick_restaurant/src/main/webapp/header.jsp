<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>
	<h1 style="display: inline-block; margin-right: 4rem;">Hello ZICK restaurant!</h1>
	<%
		if(session.getAttribute("customerId") == null && session.getAttribute("adminId") == null){%>
			<a href="login.jsp"><button>Log in</button></a>
			<a href="signup.jsp"><button>Sign up</button></a>	
		<%}else{%>
			<a href="Logout"><button>Log out</button></a>		
		<%}
	%>
</body>

</html>