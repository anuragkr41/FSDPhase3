<%@page import="com.anurag.sportyshoes.entity.User"%>
<% User u1=(User)request.getSession(false).getAttribute("user_customer");
		if(u1==null) {
			response.sendRedirect(request.getContextPath()+"/showMyLoginPage");
		} else if(u1.getUserType() == 1) {
		  /* response.sendRedirect("Not Authenticated Page"); */
			out.println("<h1>Admin Not Authenticated for this Page</h1><br><h3>Go Back to <a href='product/list'>Home</a> Page</h3>");
		}
			%>
<div class="container.fluid">
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  
        <a class="navbar-brand" style="padding-left: 1em;" href="<%=request.getContextPath()%>/admin_dashboard.jsp"><img src="<%=request.getContextPath()%>/resources/images/logo-white.png" height="30px" >   Sporty Shoes</a>
        <!-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button> -->
  
  
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
  
  
        <div class="collapse navbar-collapse" id="PrimaryMenu">
          <ul class="navbar-nav" style="margin-left: auto; padding-right: 1em;">
            <li class="nav-item">
              <a class="nav-link active px-3" aria-current="page" href="<%=request.getContextPath()%>/admin_dashboard.jsp">Home</a>
            </li>
  
           
            <a href = "<%=request.getContextPath()%>/logout" class="btn btn-outline-light me-2">Logout</a>
          </ul>
  
        </div>
  
      </nav>
    </div>
