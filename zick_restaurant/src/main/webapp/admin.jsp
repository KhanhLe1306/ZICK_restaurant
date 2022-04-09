<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="components/partials/header.jsp" %>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>
	<h2>This is Admin page</h2>
	
	<c:forEach var="customer" items="${customerList}">
		<li> ${customer.firstName} </li>
	</c:forEach>
</body>

</html>