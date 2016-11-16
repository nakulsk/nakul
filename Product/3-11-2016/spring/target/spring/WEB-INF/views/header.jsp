<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"></c:url>">
	
</script>
<link rel="stylesheet"
	href="<c:url value="resources/css/home.css"></c:url>" />

<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">

		<div class="container-fluid lineo">

			<div class="navbar-header">
				<a class="navbar-brand" href="#"> <img alt="Brand"
					src="<c:url value="resources/images/logo1.png"></c:url>"
					height="50px">
				</a>
			</div>
		</div>

	</nav>
	<nav class="navbar navbar-inverse"
		style="display: flex; align-items: center; justify-content: center;">


		<ul class="nav navbar-nav">

			<li><a href="<c:url value="/home"/>">Home</a></li>
			<li><a href="<c:url value="/about"/>">About us</a></li>


			<c:if test="${pageContext.request.userPrincipal.name!=null }">

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="<c:url value="/admin/book/addBook"/>">Add New
							Product</a></li>
				</security:authorize>
				<li><a href="<c:url value="/booksListAngular"/>">All
						Products</a></li>
				<li><a>Welcome ${pageContext.request.userPrincipal.name }</a></li>
				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href="<c:url value="/cart/getCartId"/>"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></li>
				</security:authorize>
				<li><a href="<c:url value="/j_spring_security_logout"></c:url>">logout</a>
			</c:if>



			<c:if test="${pageContext.request.userPrincipal.name ==null }">
				<li><a href="<c:url value="/login"></c:url>">Login</a></li>
				<c:url value="/customer/registration" var="url"></c:url>
				<li><a href="${url }">Register</a></li>
			</c:if>


		</ul>

	</nav>

</body>
</html>
