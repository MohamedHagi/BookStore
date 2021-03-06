<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Product Details</title>
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
   <div class="page-holder bg-light">
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
              <a class="nav-link" href="/BookStore/adminLogin.jsp">Admin Login</a>
                </li>
                
                </ul>
                    <ul class="navbar-nav ml-auto">               
                
	
						<li class="nav-item">
						<form action="Profile" method="post">
						<button class ="nav-link" name="viewProfile">Profile</button>
						</form>
						</li>
							<li class="nav-item">
							<form action="surfing" method="post">
							<button class="nav-link" name="btnForCart">
							<i class="fas fa-shopping-cart mr-1 text-gray"></i>Cart
							</button>
							</form>
							</li>
                
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
                <h1 class="h2 text-uppercase mb-0">Product Details</h1>
              </div>
          
            </div>
          </div>
        </section>
        
        

      <section class="py-5">
        <div class="container">
          <div class="row mb-5">
            <div class="col-lg-6">
       
              <div class="row m-sm-0">
          
                <div class="col-sm-10 order-1 order-sm-2">
                  <div class="owl-carousel product-slider" data-slider-id="1"><a class="d-block" href="img/book-1.jpg" data-lightbox="product" title="Product item 1"><img class="img-fluid" src="img/book-1.jpg" alt="..."></a><a class="d-block" href="img/book-1.jpg" data-lightbox="product" title="Product item 2"><img class="img-fluid" src="img/book-1.jpg" alt="..."></a><a class="d-block" href="img/book-1.jpg" data-lightbox="product" title="Product item 3"><img class="img-fluid" src="img/book-1.jpg" alt="..."></a><a class="d-block" href="img/book-1.jpg" data-lightbox="product" title="Product item 4"><img class="img-fluid" src="img/book-1.jpg" alt="..."></a></div>
                </div>
              </div>
            </div>
            <div class="col-lg-6">
              <ul class="list-inline mb-2">
                <li class="list-inline-item m-0"><i class="fas fa-star small text-warning"></i></li>
                <li class="list-inline-item m-0"><i class="fas fa-star small text-warning"></i></li>
                <li class="list-inline-item m-0"><i class="fas fa-star small text-warning"></i></li>
                <li class="list-inline-item m-0"><i class="fas fa-star small text-warning"></i></li>
                <li class="list-inline-item m-0"><i class="fas fa-star small text-warning"></i></li>
              </ul>
              <h1>${bookTittle}</h1>

              <ul class="list-unstyled small d-inline-block">
              <li class="px-3 py-2 mb-1 bg-white"><strong class="text-uppercase">Genre:</strong><span class="ml-2 text-muted">${categ}</span></li>  
              <li class="px-3 py-2 mb-1 bg-white"><strong class="text-uppercase">Product ID:</strong><span class="ml-2 text-muted">${productID}</span></li>  
              <li class="px-3 py-2 mb-1 bg-white"><strong class="text-uppercase">Price:</strong><span class="ml-2 text-muted">${price}</span></li>
                
              </ul>
                <div class="col-sm-5 pl-sm-0">
                	<form action="surfing" method="get">
                	<input type="hidden" name="productID" value="${productID}" /> <input
															type="hidden" name="bookTittle" value="${bookTittle}" /> <input
															type="hidden" name="price" value="${price}" />
														<input type="hidden" name="categ"
															value="${categ}" />
                	
                	
                	
                	<button class="btn btn-dark btn-sm" name="addToCartFromDetails">Add to cart</button> </form>
                </div>
                <hr>
                  <h2 class="h5 text-uppercase mb-4" style="text-align:center">Reviews</h2>
                  <br>
                <table class="table">
  <tr>
    <th scope="row">Review</th>
    <th scope="row">Date</th>
  </tr>
  <c:forEach var="rev" items="${review}">
  <tr>
    <td>${rev.review}</td>
    <td>${rev.date}</td>
  </tr>
  </c:forEach>
</table>


${success}

${login}
<form action="surfing" method="post">
<label for="textArea">Add a Review:</label>
<textarea id="textArea" name="textArea" rows="4" cols="50">
Max size 150 words!
  </textarea>
  <br/>
  <input type="hidden" name="bid" value="${productID}" />
  <input type="hidden" name="hidVal" value="${bookTittle}"/>
  <input type="hidden" name="price" value="${price}" /> 
  <input type="hidden" name="quantity" value="${book.quantity}" />
  <input type="hidden" name="category" value="${categ}" />
  <button class ="btn btn-dark btn-sm" name="reviewInsert">Submit</button>
</form>
            </div>
          </div>
</div>
</section>




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
              </div>
</body>
</html>											 

                  
       