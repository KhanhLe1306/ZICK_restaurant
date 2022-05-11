<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>


<body style= "background-color: black">
<div class = "admin_containerf">
<div class = "admin_image">
<img src="assets/logo.jpg" class="admin_image"></img>
</div>
<div class = "admin_container">


<h1 class = "admin_text"> Customer List</h1>

	
	<c:forEach var="customer" items="${customerList}">
		<li> ${customer.firstName} </li>
	</c:forEach>
</div>

</div>

</body>


</html>