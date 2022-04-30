<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="models.CartProduct" %>
<%@ page import="models.Customer" %>
<%@ page import="models.OrderInfo" %>
<%@ page import="models.Product" %>


<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">
<style type="text/css">

	div{
		margin-bottom: 15px;
	}
</style>
</head>

<body>

	<h2>View Order Page</h2>
	
	<%
		Customer customer = (Customer) session.getAttribute("customer");
	%>
	
	<div> Customer name: <%= customer.getFirstName() %></div>
	
	<%-- <%
		List<CartProduct> cart = (List<CartProduct>) session.getAttribute("cart");

		for ( CartProduct obj : cart){%>
		<div>
			<%= obj.getName() %> x <%= obj.getQuantity() %>
		</div>
		<%}
	%> --%>
	
	<%
		OrderInfo orderInfo = (OrderInfo) request.getAttribute("orderInfo");
		List<Product> products = orderInfo.getProducts();
	%>
	
	<div>Order status: <%= orderInfo.getStatus() %></div>
	
	<div>Order details: </div>
	<%
		for(Product p : products ){%>
			<div><%= p.getName() %></div>
		<%}
	%>
	
</body>

</html>