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

</style>
</head>

<body>
	<h1>Update Order Status</h1>
	
	
	<%
		OrderInfo order = (OrderInfo) request.getAttribute("orderInfo");
		List<Product> products = order.getProducts();	
	%>
	
		
		<form action="UpdateOrderStatus" method="get">
		<div>
			<input type="hidden" name="orderId" value="<%= order.getOrderId() %>" />
			<span>Customer name: <%= order.getFirstName() %> | </span>
			<span>Order id: <%= order.getOrderId() %> | </span>
			<span>Order status: <%= order.getStatus() %> | </span>
			<select name="status">
				<option <% if (order.getStatus() == "order") {%> selected  <%}%> value="ordered">ordered</option>
				<option <% if (order.getStatus() == "inprogress") {%> selected  <%}%> value="inprogress">in progress</option>
				<option <% if (order.getStatus() == "done") {%> selected  <%}%> value="done">done</option>
			</select>
			<span>Order details: </span>
		<%
			for(Product p : products ){%>
				<span><%= p.getName() %> | </span>
			<%}
		%>
		<button type="submit">Update</button>
		</div>
		</form>

</body>

</html>