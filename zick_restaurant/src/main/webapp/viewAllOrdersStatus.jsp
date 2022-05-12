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

<body style="background-color: black">

<div class="allorders_acontainer">
	<h2 class="allorders_header">All Orders</h2>
	
	
	<%
		List<OrderInfo> allOrdersInfo = (List<OrderInfo>) request.getAttribute("allOrdersInfo");
		List<Product> products;	
	%>
	<div class="allorders_container">
		<% for(OrderInfo order : allOrdersInfo) { products = order.getProducts();%>
		<form action="UpdateOrderStatus" method="post">
		<div class="allorders_pcontainer">
			<input type="hidden" name="orderId" value="<%= order.getOrderId() %>" />
			<div class="allorders_text">Customer Name: <%= order.getFirstName() %> </div>
			<div class="allorders_text">Order ID: <%= order.getOrderId() %> </div>
			<h3 class="allorders_text">Order Status: </h3>
			<div class="allorders_status"> <%= order.getStatus() %> </div>
			<div class="allorders_text">Order Details: </div>
		<%
			for(Product p : products ){%>
				<div class="allorders_details"><%= p.getName() %> </div>
			<%}
		%>
		<button type="submit" class="allorders_button">Update</button>
		</div>
		</form>
	<%}%>
	
	</div>
	<%-- <form action="UpdateOrderStatus" method="post">
		<c:forEach var="order" items="${allOrdersInfo}">
			 
		</c:forEach>
	</form> --%>
	

</div>
</body>

</html>