<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
<!-- reference our style sheet  -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	
	<div id="wrapper">
		<div id="content">
			<h2>List of users</h2>
		</div>
	</div>


	<!-- add our html table here -->

	<div id=container>
		<div id=content>
			<table>
				<tr>
					<th>S.No</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<%
				int sno = 1;
				%>
				<!-- loop over and print out customers  -->
				<c:forEach var="tempUser" items="${users}">
					<tr>
						<td><%=sno++%></td>
						<td>${tempUser.firstName}</td>
						<td>${tempUser.lastName}</td>
						<td>${tempUser.email}</td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
	
	<a href="/sporty-shoes/product/list">Products List</a>



</body>
</html>