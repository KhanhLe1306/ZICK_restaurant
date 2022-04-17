<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="models.CartProduct" %>


<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>

	<h2>Cart page</h2>
	
	
	<%
		List<CartProduct> cart = (List<CartProduct>) session.getAttribute("cart");
		float total = 0;
		for ( CartProduct obj : cart){%>
		<% 
			float sum = Float.valueOf(obj.getPrice())*Integer.parseInt(obj.getQuantity()); 
			total += sum;
		%>
		<div>
			<%= obj.getName() %> x <%= obj.getQuantity() %> $<%= sum %>
		</div>
		<%}
	%>
	
	<div>
		Total: $<%= total  %>
	</div>
	
	<% session.setAttribute("total", total); %>
	
	
	<%
		if(session.getAttribute("customerId") != null || session.getAttribute("adminId") != null) {%>
			<a href="/zick_restaurant/PlaceOrder"><button>Order now!</button></a>
		<%} else {%>
			<a href="login.jsp">Please sign in to order!</a>
		<%}
	%>
	
	<%-- <c:forEach var="item" items="${cart}">
		<span> ${item.name} </span> x <span> ${item.quantity} </span> Total: <span> </span>
	</c:forEach> --%>
</body>

</html>