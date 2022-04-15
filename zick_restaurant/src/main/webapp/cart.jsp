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
		for ( CartProduct obj : (List<CartProduct>) request.getAttribute("cart")){%>
			<li> <%= obj.getName() %></li>
			<li> <%= obj.getQuantity() %></li>
		<%}
	%>
	
	<%-- <c:forEach var="item" items="${cart}">
		<span> ${item.name} </span> x <span> ${item.quantity} </span> Total: <span> </span>
	</c:forEach> --%>
	
	<h1>lqk1306 just made some changes here! HOLA</h1>
</body>

</html>