<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>

	<h2 style="color: red;">This is Home page</h2>
	<h1 style="color: blue;"> Hello I am here CJAI </h1>
	<button> Hello, Izzi is Here</button>
	
	
	 
	
	
	
	<a href="/zick_restaurant/Menu"><button>View Menu</button></a>
	
	<%
		if(session.getAttribute("adminId") != null){%>
			<a href="/zick_restaurant/Admin"><button>View all Customers</button></a>	
		<%}
	%>
</body>

</html>