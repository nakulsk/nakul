<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Products</title>
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
	
</head>
<body>
	<div data-ng-app="myapp">
		<div data-ng-controller="BookController" data-ng-init="getBookList()">

			<div class="search" >Search: <input type="text" data-ng-model="searchCondition"></div>

			<H1>ALL PRODUCTS</H1>

			<table width=100% border=1px>
				<thead>
					<tr>
						<th>IMAGE</th>
						<th>Product Number</th>
						<th>Made For</th>
						<th>PRICE</th>
						<th>MANUFACTURER</th>
						<th>CATEGORY</th>
						<th>EDIT</th>
					</tr>
				</thead>
				<tbody>

					<tr data-ng-repeat="b in books | filter:searchCondition">

						<c:url value="/resources/images/{{b.productNumber}}.png" var="src" />
						<td><img src="${src }" width="40%" /></td>
						<td><a href="getProductByproductNumber/{{b.productNumber}}">{{b.productNumber}}</a></td>
						<td>{{b.madeFor }}</td>
						<td>{{b.price }}</td>
						<td>{{b.manufacturer }}</td>
						<td>{{b.category.cid }}</td>
						<td><a href="delete/{{b.productNumber }}"><span
								class="glyphicon glyphicon-trash"></span></a></td>
						<td><a href="admin/book/editBook/{{b.productNumber }}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
					</tr>
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>