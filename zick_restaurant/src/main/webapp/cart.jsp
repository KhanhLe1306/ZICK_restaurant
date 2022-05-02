<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="models.CartProduct" %>


<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body style="background-color: black">
	<div class="c_container">
		<div class="cart_logo">
				<img src="assets/logo.jpg">
		</div>
		<div class="cart_rcontainer">
			<h2>Your Order:</h2>
			<div>
			<% 
				List<CartProduct> cart = (List<CartProduct>) session.getAttribute("cart");
				float total = 0;
				for ( CartProduct obj : cart){%>
				<% 
					float sum = Float.valueOf(obj.getPrice())*Integer.parseInt(obj.getQuantity()); 
					total += sum;
				%>
				<table class="product_table">
				<tr>
					<td><%= obj.getName() %> x<%= obj.getQuantity() %></td>
					<td align="right"> $<%= sum %></td>
				</tr>
				</table>
				
				<%}
				%>Total: $<%= total %>
			
			<% session.setAttribute("total", total); %>
			</div>
			
			<%
				if(session.getAttribute("customerId") != null || session.getAttribute("adminId") != null) {%>
					<a href="/zick_restaurant/PlaceOrder"><button>Order now!</button></a>
					<a href="menu.jsp"><button>Change Order</button></a>
				<%} else {%>
					<a href="login.jsp">Please sign in to order!</a>
					<a href="signup.jsp">Don't have an account? Sign Up!</a>
				<%}
			%>
		</div>
		
		<div class="cart_imgcont">
			<div class="cart_img">
				<img src="assets/mushroom.jpg">
			</div>
			<div class="cart_img">
				<img src="assets/lavacake.jpg">
			</div>
			<div class="cart_img">
				<img src="assets/filetm.jpg">
			</div>
			<div class="cart_img">
				<img src="assets/lobster.jpg">
			</div>
		</div>
	</div>
</body>

</html>