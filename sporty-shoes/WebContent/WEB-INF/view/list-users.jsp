<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
<!-- reference our style sheet  -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	
</head>
<body>

<!-- Optional JavaScript; choose one of the two! -->
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>
  
  <%@include file="admin-menu.jsp"%>
  
	
	<div id="wrapper">
		<div id="content">
		<!--  add a search box -->
            <form:form action="search" method="GET" style="margin: 20px">
                Search customer: <input type="text" name="theSearchName" />       
                <input type="submit" value="Search" class="add-button" />
            </form:form>
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