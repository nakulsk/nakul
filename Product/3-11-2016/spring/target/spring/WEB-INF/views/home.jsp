<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<link rel="stylesheet" href="<c:url value="resources/css/home.css"></c:url>" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file="header.jsp"%>
	<div class="container-fluid">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="<c:url value="/resources/css/1.jpg"></c:url>" alt="C1">
					<div class="carousel-caption">
						<a href="getProductByCategory/${1}"><h3>Men's Leather Collection</h3></a>
					</div>
				</div>

				<div class="item">
					<img src="<c:url value="/resources/css/2.jpg"></c:url>" alt="c2" >
					<div class="carousel-caption">
						<h3>Women's Leather Collection</h3>
					</div>
				</div>

				<div class="item">
					<img src="<c:url value="/resources/css/3.jpg"></c:url>" alt="c3">
					<div class="carousel-caption">
						<h3>Men's Denim Wear</h3>
					</div>
				</div>

				<div class="item">
					<img src="<c:url value="/resources/css/4.jpg"></c:url>" alt="c4">
					<div class="carousel-caption">
						<h3>Women's Denim Wear</h3>
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</body>
</html>