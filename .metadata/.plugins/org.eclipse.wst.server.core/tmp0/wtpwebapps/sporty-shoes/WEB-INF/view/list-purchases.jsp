<%@page import="com.anurag.sportyshoes.entity.Product"%>
<%@page import="com.anurag.sportyshoes.entity.PurchaseDetail"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase List</title>
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
			<h2>List of Purchases</h2>
			
			<!-- add our html table here -->

			<div id=container>
				<div id=content>
					<table>
						<tr>
							<th>S.No</th>
							<th>Product ID</th>
							<th>User Id</th>
							<th>User Name</th>
							<th>User Email</th>
							<th>pp Category</th>
							<th>pp Size</th>
							<th>pp Price</th>
							<th>pd Date of Purchase</th>
							
							
							
						</tr>
						<%int sno = 1;%>
						
						<%List<PurchaseDetail> pdlist=(List<PurchaseDetail>)request.getAttribute("purchaselist");%>
						<%List<User> ulist=(List<User>)request.getAttribute("userplist"); %>
						<%List<Product> plist=(List<Product>)request.getAttribute("prodlist");%>
						<%for(PurchaseDetail pd:pdlist) { %>
						<tr>
						<td><%=sno%></td>
						<td><%=pd.getPurchasedProductID()%></td>
						<td><%=pd.getPurchasedByUserID()%></td>
						<td><%=ulist.get(sno-1).getFirstName()%></td>
						<td><%=ulist.get(sno-1).getEmail()%></td>
						<td><%=plist.get(sno-1).getCategory()%></td>
						<td><%=plist.get(sno-1).getSize()%></td>
						<td><%=plist.get(sno-1).getPrice()%></td>
						<td><%=pd.getPurchaseDate()%></td>
						</tr>
						<% sno++;} %>
						
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>