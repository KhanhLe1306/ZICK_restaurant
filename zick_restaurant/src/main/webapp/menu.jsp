<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>

	<h2>Menu page</h2>
	<form action="Cart" method="post">
		<c:forEach var="product" items="${productList}">
			<div style="border-bottom: 2px solid pink;">
				<input type="hidden" name="${product.productCode}" value="${product.productCode}" />
				<input type="hidden" name="${product.productCode}_name" value="${product.name}" />
				<input type="hidden" name="${product.productCode}_price" value="${product.price}" />
				<input type="hidden" name="${product.productCode}_description" value="${product.description}" />
				<h3>${product.productCode} - ${product.name} - $${product.price}</h3>
				<span>${product.description}</span>
				<select name="${product.productCode}_quantity">
  					<option value="0">0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
				</select>
			</div>
		</c:forEach>
		
		<button style="margin-top: 20px;" type="submit">Add to cart</button>
	</form>
</body>

</html>