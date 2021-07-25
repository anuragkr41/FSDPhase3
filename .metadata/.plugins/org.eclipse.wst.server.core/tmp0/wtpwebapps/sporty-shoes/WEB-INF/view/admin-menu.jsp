<div class="container.fluid">
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  
        <a class="navbar-brand" style="padding-left: 1em;" href="/sporty-shoes/product/list"><img src="<%=request.getContextPath()%>/resources/images/logo-white.png" height="30px" >   Sporty Shoes</a>
        <!-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button> -->
  
  
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
  
  
        <div class="collapse navbar-collapse" id="PrimaryMenu">
          <ul class="navbar-nav" style="margin-left: auto; padding-right: 1em;">
            <li class="nav-item">
              <a class="nav-link active px-3" aria-current="page" href="/sporty-shoes/product/list">Home</a>
            </li>
  
            <li class="nav-item dropdown px-3">
              <a class="nav-link dropdown-toggle" href="teachers.jsp" id="dropdown03" data-bs-toggle="dropdown"
                aria-expanded="false">Users</a>
              <ul class="dropdown-menu" aria-labelledby="dropdown03">
                <li><a class="dropdown-item" href="/sporty-shoes/user/list">View Users</a></li>
                
  
              </ul>
            </li>
  
           
  
            <li class="nav-item dropdown mx-3">
              <a class="nav-link dropdown-toggle" href="subjects.jsp" id="dropdown03" data-bs-toggle="dropdown"
                aria-expanded="false">Products</a>
              <ul class="dropdown-menu" aria-labelledby="dropdown03">
                <li><a class="dropdown-item" href="/sporty-shoes/product/list">View Products</a></li>
                <li><a class="dropdown-item" href="/sporty-shoes/product/list">Update Products</a></li>
                <li><a class="dropdown-item" href="/sporty-shoes/product/list">Delete Products</a></li>
              </ul>
            </li>
            
            
            <a href = "<%=request.getContextPath()%>/logout" class="btn btn-light me-2">Change Password </a>
            <a href = "<%=request.getContextPath()%>/logout" class="btn btn-outline-light me-2">Logout</a>
          </ul>
  
        </div>
      </nav>
    </div>
