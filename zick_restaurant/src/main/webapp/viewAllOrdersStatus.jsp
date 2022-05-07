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

	<h2>View All Orders Page</h2>
	
	
	<%
		List<OrderInfo> allOrdersInfo = (List<OrderInfo>) request.getAttribute("allOrdersInfo");
		List<Product> products;	
	%>
	
	<% for(OrderInfo order : allOrdersInfo) { products = order.getProducts();%>
		<div>
			<span>Customer name: <%= order.getFirstName() %> | </span>
			<span>Order id: <%= order.getOrderId() %> | </span>
			<span>Order status: <%= order.getStatus() %> | </span>
			<span>Order details: </span>
		<%
			for(Product p : products ){%>
				<span><%= p.getName() %> | </span>
			<%}
		%>
		</div>
	<%}%>
	

	
</body>

</html>