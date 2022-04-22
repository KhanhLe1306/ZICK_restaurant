<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>



<body style="background-color: black">

<%
	if(request.getAttribute("message") != null){%>
		<h1>${message}</h1>
	<%}
%>
	
	<div class="aboutus_container">
		<div class="aboutus_image">
			<img src="assets/oldmarketpass.jpg">
		</div>
		<div class="aboutus_pcont">
		<h2 class="aboutus_header">About Us</h2>
			<br>
			<br>
			<p class="aboutus_p">
				ZICK Restaurant, a contemporary fine dining establishment, strives to integrate technology
				and the modern world into the restaurant environment. From a classy steak to fresh seafood and
				a warm lava cake to end your meal, ZICK's will satisfy all of your cravings. With options like 
				Omaha Steaks right around the corner we have access to high quality ingredients to ensure everyone
				leaves full and happy. 
			</p>
			<br>
			<p class="aboutus_p">
				ZICK's is located in the Old Market, the heat of Omaha. Take a stroll down the old brick roads past
				all the boutiques and shops full of local artists, you will find ZICK's as a perfect fit to this beautiful
				backdrop. We pride ourselves with being able to be a part of this welcoming community. We guarantee hospitality
				and a family friendly environment so that our guests can feel the same warmth that we have from this city. 
			</p>
		</div>
	</div>
	
	
	
</body>

</html>