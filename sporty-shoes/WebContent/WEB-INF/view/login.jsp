<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <!-- Custom CSS  -->
    <style><%@include file="/resources/css/signin.css"%></style>
    <title>Sporty Shoes Log in</title>
  </head>
  <body class="text-center">

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JSs -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdeldivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    -->
    
    <main class="form-signin">
    
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
    <img class="mb-4" src="${pageContext.request.contextPath}/resources/images/Logo.png" alt="Main logo" width="75" height="75">
    
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    
    <!-- Check for the login error -->
    <c:if test="${param.error !=null }">
    	<div class="alert alert-danger col-xs-offset-1 col-xs-10">
    	Invalid username and password
    	</div>
    
    </c:if>
  
  
      <div class="form-floating">
        <input type="text" name ="username" class="form-control" id="floatingInput" placeholder="username">
        <label for="floatingInput">Username</label>
      </div>
      <div class="form-floating">
        <input type="password" name = "password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
      </div>
  
  		<span id="loginError"></span>
  
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
     <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
     <button class="w-100 btn btn-lg btn-secondary" style='margin-top: 20px' type="submit">Register New User</button>
      <p class="mt-5 mb-3 text-muted"> Made by Anurag Kumar</p>
    
    </form:form>
      
    </main>
  </body>
</html>