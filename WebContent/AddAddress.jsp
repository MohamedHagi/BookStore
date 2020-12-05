<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information Form</title>
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
                <h1 class="h2 text-uppercase mb-0">Add Information</h1>
              </div>
	<section class="py-5">
      
          <h2 class="h5 text-uppercase mb-4">Address details</h2>
          <div class="row">
            <div class="col-lg-8">
              <form action="AddInfo" method="post">
                <div class="row">
                  <div class="col-lg-6 form-group">
                    <label class="text-small text-uppercase" for="email">Email address</label>
                    <input class="form-control form-control-lg" id="email" name="email" type="email" placeholder="e.g. Abdul@example.com">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="streetNumber">Street Number</label>
                    <input class="form-control form-control-lg" id="streetNumber" name = "streetNumber" type="text" placeholder="e.g. 47">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="streetName">Street Name</label>
                    <input class="form-control form-control-lg" id="streetName" name="streetName" type="text" placeholder="Your Street name">
                  </div>
                  <div class="col-lg-6 form-group">
                    <label class="text-small text-uppercase" for="unitNo">Unit Number</label>
                    <input class="form-control form-control-lg" id="unitNo" name="unitNo" type="text" placeholder="House/Unit number">
                  </div>
                  <div class="col-lg-6 form-group">
                    <label class="text-small text-uppercase" for="postcode">Postal Code</label>
                    <input class="form-control form-control-lg" id="postcode" name="postcode" type="text" placeholder="Enter Postal Code">
                  </div>
                   <div class="col-lg-6 form-group">
                    <label class="text-small text-uppercase" for="country">Country</label>
<<<<<<< HEAD
                    <input class="form-control form-control-lg" id="country" name="country" type="text" placeholder="Enter Postal Code">
=======
                    <select class="selectpicker country" id="country" name = "country" data-width="fit" data-style="form-control form-control-lg" data-title="Select your country"></select>
>>>>>>> e42fa23931fbab0e0c6d4043febdb08c135adf4d
                  </div>
                  <div class="col-lg-6 form-group">
                    <label class="text-small text-uppercase" for="state">State/County</label>
                    <input class="form-control form-control-lg" id="state" name="state" type="text" placeholder="e.g. Ontario">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="city">Town/City</label>
                    <input class="form-control form-control-lg" id="city" name="city" type="text" placeholder="e.g. Toronto">
                  </div>
<<<<<<< HEAD
                  
                    <h2 class="h5 text-uppercase mb-4">Creditcard details</h2>
                    
                    
                     <div class="row">
=======
                  <br>
                   <h2 class="h5 text-uppercase mb-4">Creditcard details</h2>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="cNumber">Credit Card Number</label>
                    <input class="form-control form-control-lg" id="cNumber" name="cNumber" type="text" placeholder="e.g. 1111-1111-1111-1111">
                  </div>
>>>>>>> e42fa23931fbab0e0c6d4043febdb08c135adf4d
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="fname">First Name</label>
                    <input class="form-control form-control-lg" id="fname" name="fname" type="text" placeholder="e.g. John">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="lname">Last Name</label>
                    <input class="form-control form-control-lg" id="lname" name="lname" type="text" placeholder="e.g. Jordan">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="csv">CVV</label>
                    <input class="form-control form-control-lg" id="csv" name="csv" type="text" placeholder="e.g. 000">
                  </div>
<<<<<<< HEAD
                  <div class="col-lg-6 form-group">
                    <label class="text-small text-uppercase" for="csv">CVV</label>
                    <input class="form-control form-control-lg" id="csv" name="csv" type="text" placeholder="Enter your 3 digit CSV">
                  </div>
                  <div class="col-lg-6 form-group">
                    <label class="text-small text-uppercase" for="expdate">Expiry Date</label>
                    <input class="form-control form-control-lg" id="expdate" name="expdate" type="date" placeholder="Enter Expiry Date">
                  </div>
                  		<button name="ccinfo" id="btn btn-outline-dark">Submit</button>
                  </div>
                    
                  
                  
=======
                    <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="expdate">Exipry Date</label>
                    <input class="form-control form-control-lg" id="expdate" name="expdate" type="date" placeholder="Enter Expiry Date">
                  </div>
                  <button name= "ccinfo" class ="btn btn-outline-dark"> Submit</button>
>>>>>>> e42fa23931fbab0e0c6d4043febdb08c135adf4d
                  </div>
                  </form>
                  </div>
                  </div>
                  </section>
<<<<<<< HEAD
                    
=======
>>>>>>> e42fa23931fbab0e0c6d4043febdb08c135adf4d
                  </div>
                  </div>
                  </section>
                  </div>
                  </div>
                  
                  
                  
                   <script src="vendor/jquery/jquery.min.js"></script>
      <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="vendor/lightbox2/js/lightbox.min.js"></script>
      <script src="vendor/nouislider/nouislider.min.js"></script>
      <script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
      <script src="vendor/owl.carousel2/owl.carousel.min.js"></script>
      <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
      <script src="js/front.js"></script>
        
        
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
                  
                  
</body>
</html>