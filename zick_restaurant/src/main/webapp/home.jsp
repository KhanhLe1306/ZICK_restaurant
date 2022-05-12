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
		
			<div class="home_buttoncon">
			<a href="/zick_restaurant/Menu"><button class="home_button">View Menu</button></a>
			
			<%
				if(session.getAttribute("adminId") != null){%>
					<a href="/zick_restaurant/Admin"><button>View all Customers</button></a>	
					<a href="/zick_restaurant/ViewOrderStatus"><button>View all Orders</button></a>	
				<%}
			%>
			</div>
		</div>
	</div>
	
	<div class="image">
	</div>
	
</body>

</html>