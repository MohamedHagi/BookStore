<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>CheckOut</title>
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
                  <a class="nav-link" href="/BookStore/adminLogin.jsp">Admin Login</a>
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
                <h1 class="h2 text-uppercase mb-0">Check Out</h1>
              </div>
          
            </div>
          </div>
        </section>



 <section class="py-5">

<br/>
${noItem}
<br/>
<div class="row">
            <div class="col-lg-12">
   <h2 class="h5 text-uppercase mb-4">Cart Details: <label class="h5 text-uppercase mb-4" for="cart">cart (${size})</label> ${removed}</h2>
<!-- use c:for each to fill the table this is the cart -->

<c:if test="${size > 0}">	 
<table class="table">
  <tr>
    <th scope="row">Title</th>
    <th scope="row">Price</th>
    <th scope="row">ProductID</th>
    <th scope="row">Remove from cart</th>
  </tr>
  <c:forEach var="book" items="${la}">
  <tr>
    <td>${book.price}</td>
    <td>${book.bookTittle}</td>
    <td>${book.productID}</td>
    <td>${book.category}</td>
    <td>
    	<form method="post" action="Profile" id="removeCart">
    	 <input type="hidden" name="productID" value="${book.productID}"/>
    	 <input type="hidden" name="tittle" value="${book.bookTittle}"/>
    	 <input type="hidden" name="addID" value="${book.addID}" />
    	 <input type="hidden" name="price" value="${book.price}"/>
    	 <input type="hidden" name="category" value="${book.category}"/>
    	 <button name="rmBtn" id="rmBtn">Remove</button>
    	</form>
    </td>
  </tr>
  </c:forEach>
</table>
<br/>
<!-- Add a total from the servlet using EL -->
   <ul class="list-unstyled small d-inline-block">
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">Cart Total: </strong><a class="reset-anchor ml-2" href="#">${tot}</a></li>

<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">Taxes: </strong><a class="reset-anchor ml-2" href="#">${tax}</a></li>

<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">Tarrifs: </strong><a class="reset-anchor ml-2" href="#">${tar}</a></li>


<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">Shipping and Handling <small class="text-muted" >(If applicable)</small> : </strong> <a class="reset-anchor ml-2" href="#">${shipping}</a></li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">Order Total:</strong><a class="reset-anchor ml-2" href="#">${orderTot}</a></li>

<hr>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${add}</strong> </li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${conf}</strong> </li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${stNum}</strong> </li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${unitNo}</strong> </li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${stName}</strong> </li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${pcode}</strong> </li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${city}</strong> </li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${state}</strong> </li>
<li class="px-3 py-2 mb-1 bg-white text-muted"><strong class="text-uppercase text-dark">${cont}</strong> </li>

</ul>
${notDone}
${emp}
<c:if test="${count == 1}"> 
<div class="col-lg-6 form-group">
     <div class="custom-control custom-checkbox">
<form action="Profile" method="get">
<input class= "custom-control-input" type="checkbox" name="check" id="check"/>
<label class="custom-control-label text-small text-uppercase" for="check" id="labelCheck">Use Stored Address and Card Information: <button class="btn btn-outline-dark text-small text-uppercase" name="payBtn" id="payBtn">Pay</button></label>


</form>
</div>
<br/>
</div>

<div class="col-lg-6 form-group">
                    <div class="custom-control custom-checkbox">
                      <input class="custom-control-input" id="alternateAddressCheckbox" type="checkbox">
                      <label class="custom-control-label text-small text-uppercase" for="alternateAddressCheckbox">Or use a new address and new card information</label>
                   
                    </div>
                  </div>
                  <div class="col-lg-12">
                      
                    <div class="row d-none" id="alternateAddress">
                      <div class="col-12 mt-4">
                      
                   <form action="Profile" method="post">
                        <h2 class="h4 text-uppercase mb-4">Update New address</h2>
                                    
                    <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="streetNumber">Street Number</label>
                    <input class="form-control form-control-lg" id="streetNumber" name = "streetNumber" type="text" placeholder="e.g. 47">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="streetName">Street Name</label>
                    <input class="form-control form-control-lg" id="streetName" name="streetName" type="text" placeholder="Your Street name">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="unitNo">Unit Number</label>
                    <input class="form-control form-control-lg" id="unitNo" name="unitNo" type="text" placeholder="House/Unit number">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="postcode">Postal Code</label>
                    <input class="form-control form-control-lg" id="postcode" name="postcode" type="text" placeholder="Enter Postal Code">
                  </div>
                   <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="country">Country</label>
                    <select class="selectpicker country" id="country" name = "country" data-width="fit" data-style="form-control form-control-lg" data-title="Select your country"></select>
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="state">State/County</label>
                    <input class="form-control form-control-lg" id="state" name="state" type="text" placeholder="e.g. Ontario">
                  </div>
                  <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="city">Town/City</label>
                    <input class="form-control form-control-lg" id="city" name="city" type="text" placeholder="e.g. Toronto">
                  </div>
                  <br>
              
                      <button class="btn btn-outline-dark text-small text-uppercase" name="updateAdd">Update</button>
                      </form>
                     </div>
                
                   
                      <hr/>
                      <br>
             <div class="col-12 mt-4">
                   
                   <h2 class="h5 text-uppercase mb-4">Add New Credit Card </h2>
                   <form action="Profile" method="get">
                     <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="cNumber">Credit Card Number</label>
                    <input class="form-control form-control-lg" id="cNumber" name="cNumber" type="text" placeholder="e.g. 1111-1111-1111-1111">
                 </input>
                 </div>
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
                    <div class="col-lg-12 form-group">
                    <label class="text-small text-uppercase" for="expdate">Exipry Date</label>
                    <input class="form-control form-control-lg" id="expdate" name="expdate" type="date" placeholder="Enter Expiry Date">
                  </div>
               
               			<button class="btn btn-outline-dark text-small text-uppercase" name="payNow" id="payNow">Pay</button>
               			
                 </form>
                
                 </div>
                   
               
                  </div>
                 
                  </div>
 
<!-- <form action="Profile" method="post"> -->

<!-- <label class="text-small text-uppercase" for="streetNumber">Street Number: </label> -->
<!-- <input id="streetNumber" name = "streetNumber" type="text" placeholder="e.g. 47"/> -->
     
<!--  <br/>             -->
<!-- <label class="text-small text-uppercase" for="streetName">Street Name: </label> -->
<!-- <input id="streetName" name="streetName" type="text" placeholder="Your Street name"/> -->
 
<!-- <br/>               -->
<!-- <label class="text-small text-uppercase" for="unitNo">Unit Number: </label> -->
<!-- <input id="unitNo" name="unitNo" type="text" placeholder="House/Unit number"/> -->

<!-- <br/> -->
<!-- <label for="postcode">Postal Code: </label> -->
<!-- <input id="postcode" name="postcode" type="text" placeholder="Enter Postal Code"/> -->

<!-- <br/>               -->
<!-- <label for="country">Country: </label> -->
<!-- <input id="country" name="country" type="text" placeholder="Country"/> -->
<!-- <br/>             -->
<!-- <label for="state">State/County: </label> -->
<!-- <input id="state" name="state" type="text" placeholder="e.g. Ontario"/> -->

<!-- <br/> -->
<!-- <label for="city">Town/City: </label> -->
<!-- <input id="city" name="city" type="text" placeholder="e.g. Toronto" /> -->
<!-- <br /> -->
<!-- <button name="updateAdd">Update</button> -->
<!-- </form> -->


<%-- ${Error} --%>
<!-- <form action="Profile" method="get"> -->
<!-- <label for="Inp" id="labl">Card Number: </label> -->
<!-- <input type="text" name="Inp" id="Inp"/> -->
<!-- <br /> -->
<!-- <label for="cvv" id="labl">CVV: </label> -->
<!-- <input type="text" name="cvv" id="Inp"/> -->
<!-- <br /> -->
<!-- <label for="name" id="labl">Name on card: </label> -->
<!-- <input type="text" name="name" id="name"/> -->
<!-- <br /> -->
<!-- <label for="expdate">Expiry date:</label> -->
<!-- <input type="date" name="expdate" id="expdate"></input> -->
<!-- <br/> -->
<!-- <button name="payNow" id="payNow">Pay</button> -->
<!-- </form> -->
</c:if>



</c:if>

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