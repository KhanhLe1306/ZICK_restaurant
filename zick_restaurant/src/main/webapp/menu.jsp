<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>
	<div class="menu_container">
		<h1 class="menu_header">Menu</h1>
		<form action="Cart" method="post">
			<div class="product__container">
				<c:forEach var="product" items="${productList}">
					<div class="product">
						<input type="hidden" name="${product.productCode}"
							value="${product.productCode}" /> <input type="hidden"
							name="${product.productCode}_name" value="${product.name}" /> <input
							type="hidden" name="${product.productCode}_price"
							value="${product.price}" /> <input type="hidden"
							name="${product.productCode}_description"
							value="${product.description}" />
						<div class="product_code">${product.productCode}</div>
						<div class="product_heading">
							<p class="product_name">${product.name}</p>
							<p class="product_price">$${product.price}</p>
							<p class="product_description">${product.description}</p>
						</div> 
						<div class="select">
						<select
							name="${product.productCode}_quantity">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>
						</div>
					</div>
				</c:forEach>
			</div>
			<button style="margin-top: 20px;" type="submit">Add to cart</button>
		</form>
	</div>
	<div class="menu__bg"></div>
</body>

</html>