<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
<!-- reference our style sheet  -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="content">
			<h2>List of Products</h2>
			<!-- put a button to add products  -->

			<input type="button" value="Add product"
				onclick="window.location.href='productAddForm'; return false;"
				class = "add-button"/>

			<!-- add our html table here -->

			<div id=container>
				<div id=content>
					<table>
						<tr>
							<th>S.No</th>
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Size</th>
							<th>Category</th>
							<th>Price</th>
							<th>Quantity Available</th>
						</tr>
						<%int sno = 1;%>
						<!-- loop over and print out customers  -->
						<c:forEach var="tempProduct" items="${products}">
							<tr>
								<td><%=sno++%></td>
								<td>${tempProduct.id}</td>
								<td>${tempProduct.name}</td>
								<td>${tempProduct.size}</td>
								<td>${tempProduct.category}</td>
								<td>Rs. ${tempProduct.price}</td>
								<td>${tempProduct.quantityAvailable}</td>

							</tr>

						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>





</body>
</html>