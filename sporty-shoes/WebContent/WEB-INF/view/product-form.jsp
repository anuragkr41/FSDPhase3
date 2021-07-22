<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product form</title>

<!-- reference our style sheet  -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<!-- reference our style sheet for the form  -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-user-style.css" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Product Addition to the database</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Product</h3>
		<form:form action="saveProduct" modelAttribute="product" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>

					</tr>
					<tr>
						<td><label>Size:</label></td>
						<td><form:input path="size" /></td>

					</tr>
					<tr>
						<td><label>Category:</label></td>
						<td><form:input path="category" /></td>

					</tr>
					<tr>
						<td><label>Price:</label></td>
						<td><form:input path="price" /></td>

					</tr>
					<tr>
						<td><label>Stock Quantity:</label></td>
						<td><form:input path="quantityAvailable" /></td>

					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class = "save"/></td>

					</tr> 


				</tbody>

			</table>

		</form:form>
		
		<div style="clear; both;"></div>
		<p>
		<a href="${pageContext.request.contextPath}/product/list">Back to product list</a>
		</p>





	</div>

</body>
</html>