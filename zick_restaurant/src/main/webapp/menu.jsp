<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>
		<h1 class="menu_header">Menu</h1>
		<form action="Cart" method="post">
			<div class="menu_container">
				<div class="product_container">
					<h2 class="section_header">Appetizers</h2>
					<c:forEach var="product" items="${productList}" begin="0" end="3">
						<input type="hidden" name="${product.productCode}" value="${product.productCode}" /> 
						<input type="hidden"name="${product.productCode}_name" value="${product.name}" />
					    <input type="hidden" name="${product.productCode}_price" value="${product.price}" /> 
						<input type="hidden" name="${product.productCode}_description" value="${product.description}" />
						<table>
							<tr>
								<td align="left" class="product_name">${product.name}</td>
								<td align="center" class="product_price">$${product.price}</td>
								<td class="select">
									<select
										name="${product.productCode}_quantity">
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="product_description">${product.description}</td>
							</tr>
						</table>
					</c:forEach>
				</div>
					
				<div class="product_container">
					<h2 class="section_header">Steaks</h2>
					<c:forEach var="product" items="${productList}" begin="16" end="20">
							<input type="hidden" name="${product.productCode}" value="${product.productCode}" /> 
							<input type="hidden"name="${product.productCode}_name" value="${product.name}" />
						    <input type="hidden" name="${product.productCode}_price" value="${product.price}" /> 
						    <input type="hidden" name="${product.productCode}_description" value="${product.description}" />
							    <table>
								<tr>
									<td align="left" class="product_name">${product.name}</td>
									<td align="center" class="product_price">$${product.price}</td>
									<td align="right" class="select">
										<select
											name="${product.productCode}_quantity">
											<option value="0">0</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
										</select>
									</td>
								</tr>
								<tr>
									<td class="product_description">${product.description}</td>
								</tr>
								</table>
						</c:forEach>
					</div>
				    <div class="product_container">
						<h2 class="section_header">Seafood</h2>
						<c:forEach var="product" items="${productList}" begin="12" end="15">
							<input type="hidden" name="${product.productCode}" value="${product.productCode}" /> 
							<input type="hidden"name="${product.productCode}_name" value="${product.name}" />
						    <input type="hidden" name="${product.productCode}_price" value="${product.price}" /> 
						    <input type="hidden" name="${product.productCode}_description" value="${product.description}" />
							<table>
							<tr>
								<td align="left" class="product_name">${product.name}</td>
								<td align="center" class="product_price">$${product.price}</td>
								<td align="right" class="select">
									<select
										name="${product.productCode}_quantity">
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="product_description">${product.description}</td>
							</tr>
							</table>
						</c:forEach>
					</div>
				<div class="product_container">
					<h2 class="section_header">Specialty Entres</h2>
					<c:forEach var="product" items="${productList}" begin="21" end="23">
						<input type="hidden" name="${product.productCode}" value="${product.productCode}" /> 
							<input type="hidden"name="${product.productCode}_name" value="${product.name}" />
						    <input type="hidden" name="${product.productCode}_price" value="${product.price}" /> 
						    <input type="hidden" name="${product.productCode}_description" value="${product.description}" />
							<table>
							<tr>
								<td align="left" class="product_name">${product.name}</td>
								<td align="center" class="product_price">$${product.price}</td>
								<td align="right" class="select">
									<select
										name="${product.productCode}_quantity">
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="product_description">${product.description}</td>
							</tr>
							</table>
						</c:forEach>
					</div>
				<div class="product_container">
				<h2 class="section_header">Sides</h2>
				<c:forEach var="product" items="${productList}" begin="7" end="11">
						<input type="hidden" name="${product.productCode}"
							value="${product.productCode}" /> <input type="hidden"
							name="${product.productCode}_name" value="${product.name}" /> <input
							type="hidden" name="${product.productCode}_price"
							value="${product.price}" /> <input type="hidden"
							name="${product.productCode}_description"
							value="${product.description}" />
							<table>
							<tr>
								<td align="left" class="product_name">${product.name}</td>
								<td align="center" class="product_price">$${product.price}</td>
								<td align="right" class="select">
									<select
										name="${product.productCode}_quantity">
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="product_description">${product.description}</td>
							</tr>
							</table>
						</c:forEach>
				</div>
			    <div class="product_container">
				<h2 class="section_header">Desserts</h2>
				<c:forEach var="product" items="${productList}" begin="4" end="6">
						<input type="hidden" name="${product.productCode}"
							value="${product.productCode}" /> <input type="hidden"
							name="${product.productCode}_name" value="${product.name}" /> <input
							type="hidden" name="${product.productCode}_price"
							value="${product.price}" /> <input type="hidden"
							name="${product.productCode}_description"
							value="${product.description}" />
							<table>
							<tr>
								<td align="left" class="product_name">${product.name}</td>
								<td align="center" class="product_price">$${product.price}</td>
								<td align="right" class="select">
									<select
										name="${product.productCode}_quantity">
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="product_description">${product.description}</td>
							</tr>
							</table>
						</c:forEach>
					</div>
				</div>
			<button class="menu_button" type="submit">Add to Cart</button>
		</form>
</body>

</html>