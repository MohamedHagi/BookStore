<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
   <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Lightbox-->
    <link rel="stylesheet" href="vendor/lightbox2/css/lightbox.min.css">
    <!-- Range slider-->
    <link rel="stylesheet" href="vendor/nouislider/nouislider.min.css">
    <!-- Bootstrap select-->
    <link rel="stylesheet" href="vendor/bootstrap-select/css/bootstrap-select.min.css">
    <!-- Owl Carousel-->
    <link rel="stylesheet" href="vendor/owl.carousel2/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="vendor/owl.carousel2/assets/owl.theme.default.css">
    <!-- Google fonts-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Libre+Franklin:wght@300;400;700&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Martel+Sans:wght@300;400;800&amp;display=swap">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/bookstore.png">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
   <div class="page-holder">
 <header class="header bg-white">
 <div class="container px-0 px-lg-3">
 <nav class="navbar navbar-expand-lg navbar-light py-3 px-lg-0"><a class="navbar-brand" href="/BookStore/Main.jsp"><span class="font-weight-bold text-uppercase text-dark">BookStore</span></a>
 <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
 <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <!-- Link--><a class="nav-link active" href="/BookStore/Main.jsp">Home</a>
                </li>
                <li class="nav-item">
                  <!-- Link--><a class="nav-link" href="/BookStore/Surf.jsp">Shop</a>
                </li>
                
                </ul>
                    <ul class="navbar-nav ml-auto">               
                <li class="nav-item"><a class="nav-link" href="/BookStore/CheckOut.jsp"><i class="fas fa-shopping-cart mr-1 text-gray"></i>Cart</a></li>
                <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="/BookStore/Homeprof.jsp" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fas fa-user-alt mr-1 text-gray"></i>Your Account</a>
 <div class="dropdown-menu mt-3" aria-labelledby="pagesDropdown"><a class="dropdown-item border-0 transition-link" href="/BookStore/Login.jsp">Login</a><a class="dropdown-item border-0 transition-link" href="/BookStore/Register.jsp">Create a new account</a><div class="dropdown-divider"></div><a class="dropdown-item border-0 transition-link" href="/BookStore/Logout.jsp">Logout</a></div>
    
                
                
                </li>
                
     
              </ul>
              </div>
        
               
 </nav>

 </div>
</header> 

  <div class="container">

        <section class="py-5 bg-light">
          <div class="container">
            <div class="row px-4 px-lg-5 py-lg-4 align-items-center">
              <div class="col-lg-6">
                <h1 class="h2 text-uppercase mb-0">Login</h1>
              </div>
          
            </div>
          </div>
        </section>

<form method="post" action="Profile" id="logFrm">
	<fieldset>
		<small>${Err}</small>  
		<br>
		<label class="text-small text-uppercase" for="firstName">Email</label>
                    <input class="form-control form-control-lg" id="id" name="id" type="email" placeholder="Enter your email address">
	<br>
	<label class="text-small text-uppercase" for="firstName">Password</label>
                    <input class="form-control form-control-lg" id="pass" type="password" name = "pass" placeholder="Enter your password">
		<br/>
		<button class ="btn btn-outline-dark float-left text-small text-uppercase" name="btnSignin">Login</button>
		<br>
		<br>
		<a class = "register-link-dark" href="/BookStore/Register.jsp">Dont have an account? register with us today</a>
	</fieldset>
</form>







 <script src="vendor/jquery/jquery.min.js"></script>
      <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="vendor/lightbox2/js/lightbox.min.js"></script>
      <script src="vendor/nouislider/nouislider.min.js"></script>
      <script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
      <script src="vendor/owl.carousel2/owl.carousel.min.js"></script>
      <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
      <script src="js/front.js"></script>
        
        
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

</div>
</body>
</html>