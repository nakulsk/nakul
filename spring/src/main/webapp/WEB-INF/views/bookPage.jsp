<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
<%@ page isELIgnored="false" %>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js">

</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>
<div data-ng-app="myapp">
<c:url var="url" value="/resources/images/${bookObj.isbn}.png"></c:url>
		<img src="${url }"/><br>
ISBN : ${bookObj.isbn } <br>
TITLE : ${bookObj.title } <br>
Price : ${bookObj.price } <br>
<c:url value="/cart/add/${bookObj.isbn }" var="url"></c:url>
<div data-ng-controller="bookController">
<security:authorize access="hasRole('ROLE_USER')">
<a href="${url}"  class="btn btn-warning btn-large"><span class="glyphicon glyphicon-shopping-cart"></span></a>
</security:authorize>
<a href="<c:url value="/getAllBooks"></c:url>">Back</a>
</div>
</div>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
</body>
</html>
