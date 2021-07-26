<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>

<!-- reference our style sheet  -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<!-- reference our style sheet for the form  -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-user-style.css" />
	
		<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	

</head>
<body>

<!-- Optional JavaScript; choose one of the two! -->
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>




	<div id="wrapper">
		<div id="header">
			<h2>Register new user</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save User</h3>
		<form:form action="${pageContext.request.contextPath}/user/saveUser" modelAttribute="user" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>

					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>

					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>

					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:password path="password" /></td>

					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class = "save"/></td>

					</tr> 
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		

	</div>

</body>
</html>