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
	
	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	
	
	
</head>
<body>
<!-- Optional JavaScript; choose one of the two! -->
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>

<%@include file="customer-menu.jsp"%>


	<div id="wrapper">
		<div id="content">
			
			<!-- add our html table here -->

			<div id=container>
				<div id=content>
					<table>
						<tr>
							<th>S.No</th>
							<th>Product Name</th>
							<th>Size</th>
							<th>Category</th>
							<th>Price</th>
							<th>Action</th>
						</tr>
						<%int sno = 1;%>
						
						<!-- loop over and print out products-->
						<c:forEach var="tempProduct" items="${products}">
							
							<!--Construct an update link with product id  -->
							<c:url var="buyLink" value= "/product/buy">
								<c:param name="productID" value = "${tempProduct.id}"/>
								<c:param name="userID" value = "<%if(u1!=null){%>${u1.getId()}<%}%>"/>
							</c:url>

					<%-- 	<form>
						<input type = "hidden" name ="purchaseByUserId" value="<%=u1.getId() %>"/>
						</form>
						 --%>


							
							
							<tr>
							
							<form action = "${pageContext.request.contextPath}/user/purchaseProduct" method ="POST">
								<input type = "hidden" name ="purchaseByUserId" value="<%if(u1!=null){%><%=u1.getId()%><%}%>"/>
								<input type = "hidden" name ="purchaseProductId" value="${tempProduct.id}"/>
								
								<td><%=sno++%></td>
								<td>${tempProduct.name}</td>
								<td>${tempProduct.size}</td>
								<td>${tempProduct.category}</td>
								<td>Rs. ${tempProduct.price}</td>
							
								
								<td>
								<!--Display the update Link  -->
								<button class="btn btn-outline-primary" onClick="if(!(confirm('Are you sure you want to buy this product?'))) return false">Buy</button>
								</td>
								</form>
							</tr>

						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>