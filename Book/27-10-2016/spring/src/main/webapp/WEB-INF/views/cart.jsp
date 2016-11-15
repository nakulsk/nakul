<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js">
	
</script>
<script src="<c:url value="/resources/js/controller.js"></c:url>"></script>
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
	<div class="container-wrapper">
		<div class="container">
			<section>
			<div class="jumbotron">
				<div class="container">
					<h3>Cart</h3>
					<p>All the selected books in your shopping cart</p>
				</div>
			</div>
			</section>
			<div data-ng-app="myapp" data-ng-controller="BookController">

				<div data-ng-init="getCart(${cartId})">
					<br> List of books purchased
					<div>
						<a class="btn btn-danger pull-left" data-ng-click="clearCart()"> <span
							class="glyphicon glyphicon-remove-sign"> </span> Clear Cart
						</a>
					</div>
					<table class="table table-hover">
						<thead>

							<tr>
								<th>TITLE</th>
								<th>QUANTITY</th>
								<th>Price</th>
								<th>TOTAL PRICE</th>
							</tr>
						</thead>
						<tr data-ng-repeat="cartitem in cart.cartItem">
							<td>{{cartitem.book.title}}</td>
							<td>{{cartitem.quantity}}</td>
							<td>{{cartitem.book.price}}</td>
							<td>{{cartitem.totalprice}}</td>
							<td><a href="#" class="label label-danger"
								data-ng-click="removeFromCart(cartitem.cartItemId)"> <span
									class="glyphicon glyphicon-remove"></span>remove
							</a></td>
						</tr>

					</table>
					GrandTotal Price {{calculateGrandTotal()}}
				</div>
				<c:url value="/getAllBooks" var="url"></c:url>
				<a href="${url }" class="btn btn-default">Continue shopping</a>
			</div>
		</div>
	</div>

</body>
</html>
