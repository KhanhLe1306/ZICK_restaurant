<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="admin_background">
	<h1>This is CJai here</h1>
	<h2>This is Admin page</h2>
	
	<c:forEach var="customer" items="${customerList}">
		<li> ${customer.firstName} </li>
	</c:forEach>
</div>
</body>


</html>