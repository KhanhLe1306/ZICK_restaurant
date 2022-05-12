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

<body style="background-color: black">
	<div class="update_container">
		<div class="update_imgcon">
			<div class="update_logo">
				<img src="assets/logo.jpg">
			</div>
		</div>
		
		<div class="update_acontainer">
			<h1 class="allorders_header">Update Order Status</h1>
		
		<%
			OrderInfo order = (OrderInfo) request.getAttribute("orderInfo");
			List<Product> products = order.getProducts();	
		%>
		
			
			<form action="UpdateOrderStatus" method="get">
			
				<input type="hidden" name="orderId" value="<%= order.getOrderId() %>" />
				<div class="update_bcontainer">
					<span class="update_text">Customer name: <%= order.getFirstName() %> </span>
					<span class="update_text">Order id: <%= order.getOrderId() %> </span>
					<h2 class="update_text">Order status:</h2>
					<div class="update_statuscontainer"><%= order.getStatus() %></div>
				</div>
				
				<div class="update_bcontainer">
					<h3 class="update_text">Change Order Status:</h3>
					<select name="status">
						<option <% if (order.getStatus() == "order") {%> selected  <%}%> value="ordered">ordered</option>
						<option <% if (order.getStatus() == "inprogress") {%> selected  <%}%> value="inprogress">in progress</option>
						<option <% if (order.getStatus() == "done") {%> selected  <%}%> value="done">done</option>
					</select>
				</div>
				
				<div class="update_bcontainer">
					<h4 class="update_text">Order details: </h4>
				<%
					for(Product p : products ){%>
						<span class="update_text"><%= p.getName() %> </span>
					<%}
				%>
				</div>
				<button type="submit" class="update_button">Update</button>
			</form>
		</div>
	</div>
</body>

</html>