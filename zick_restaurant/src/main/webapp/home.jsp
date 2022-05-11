<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>

	<div class="home__body">
		<div class="intro">
			<p>Serving great food for more than 18 years!</p>
		<a href="/zick_restaurant/Menu"><button>View Menu</button></a>
		
		<%
			if(session.getAttribute("adminId") != null){%>
				<a href="/zick_restaurant/Admin"><button class="home_button">View all Customers</button></a>	
			<%}
		%>
		</div>
	</div>
	
	<div class="image">
	</div>
</body>

</html>