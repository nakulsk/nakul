<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="resources/css/home.css"></c:url>" />
</head>
<body>

	<!--  http://localhost:8080/welcomehelloworld/admin/book/addBook -->
	<c:url value="/admin/book/addBook" var="url"></c:url>
	<form:form method="post" action="${url}" commandName="bookFormObj"
		enctype="multipart/form-data">


		<table>
			<tr>
				<td><form:label path="productNumber"></form:label></td>
				<td><form:hidden path="productNumber" /></td>
			</tr>



			<tr>
				<td><form:label path="madeFor">Made For</form:label></td>
				<td><form:input path="madeFor"></form:input></td>
				<td><form:errors path="madeFor"></form:errors></td>

			</tr>
			<tr>
				<td><form:label path="material">Material</form:label></td>
				<td><form:input path="material"></form:input></td>
				<td><form:errors path="material"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="price">PRICE</form:label></td>
				<td><form:input path="price"></form:input></td>
				<td><form:errors path="price"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="manufacturer">Manufacturer</form:label></td>
				<td><form:input path="manufacturer"></form:input></td>
				<td><form:errors path="manufacturer"></form:errors></td>
			</tr>

			<tr>
				<td><form:label path="category">CATEGORY</form:label></td>
				<td><form:radiobutton path="category.cid" value="1" />Winter
					Wear <form:radiobutton path="category.cid" value="2" />Biker Wear
					<form:radiobutton path="category.cid" value="3" />Denim Wear <form:radiobutton
						path="category.cid" value="4" />Coats</td>
			</tr>
			<tr>

				<td><form:input path="image" type="file" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Book"></td>
			</tr>

		</table>
	</form:form>


</body>
</html>
