<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/styles.css">

</head>

<body>
	<div class="image__container">
		<img src="assets/food1.jpg"/>
	</div>
	<a class="view-menu__button" href="/zick_restaurant/Menu"><button>View Menu</button></a>
	
	<%
		if(session.getAttribute("adminId") != null){%>
			<a href="/zick_restaurant/Admin"><button>View all Customers</button></a>	
		<%}
	%>
</body>

</html>