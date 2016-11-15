<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
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
		<div data-ng-controller="BookController" data-ng-init="getBookList()">

			Search: <input type="text" data-ng-model="searchCondition">

			<H1>List of Books</H1>

			<table width=100% border=1px>
				<thead>
					<tr>
						<th>Image</th>
						<th>ISBN</th>
						<th>TITLE</th>
						<th>AUTHOR</th>
						<th>PUBLISHER</th>
						<th>PRICE</th>
						<th>CATEGORY</th>
						<th>DELETE</th>
						<th>EDIT</th>
					</tr>
				</thead>
				<tbody>

					<tr data-ng-repeat="b in books | filter:searchCondition">

						<c:url value="/resources/images/{{b.isbn}}.png" var="src" />
						<td><img src="${src}" width="40%" /></td>

						<td><a href="getBookByIsbn/{{b.isbn}}">{{b.isbn}}</a></td>
						<td>{{b.title }}</td>
						<td>{{b.author }}</td>
						<td>{{b.publication}}</td>
						<td>{{b.price }}</td>
						<td>{{b.category.categoryName }}</td>
						<td><a href="delete/{{b.isbn }}"><span
								class="glyphicon glyphicon-trash"></span></a></td>
						<td><a href="admin/book/editBook/{{b.isbn }}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
					</tr>
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>