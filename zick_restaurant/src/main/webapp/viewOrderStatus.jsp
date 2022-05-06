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
	
	<%
		Customer customer = (Customer) session.getAttribute("customer");
	%>
	<div class="signup_image"></div>
	<div class="order_container">
		<div class="order_scontainer">
			<div class="order_heading">Name: <%= customer.getFirstName() %></div>
				
			<%
				OrderInfo orderInfo = (OrderInfo) request.getAttribute("orderInfo");
				List<Product> products = orderInfo.getProducts();
			%>
				
				<div class="order_heading"> Order Status: </div>
				<div class="orderstatus_container"><%= orderInfo.getStatus() %></div>
				
		</div>
		<div class="orderdetail_container">
			<div class="order_heading">Order details: </div>
			<%
				for(Product p : products ){%>
					<div class="orderdetail_text"><%= p.getName() %></div>
				<%}
			%>
		</div>
	</div>
</body>

</html>