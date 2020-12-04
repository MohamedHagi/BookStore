<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CheckOut</title>
</head>
<body>
Checkout Page!
<br/>
<!-- use c:for each to fill the table this is the cart -->
${noItem}
<label for="cart">cart (${size})</label> ${removed}
	
<table>
  <tr>
    <th>Tittle</th>
    <th>Price</th>
    <th>ProductID</th>
    <th>Remove from cart</th>
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
Cart Total: ${tot}
<br/>
Taxes: ${tax}
<br/>
Tariffs: ${tar}
<br/>
<small>If applicable</small>
<br/>
Shipping and Handling: ${shipping}
<br/>
Order Total: ${orderTot}
<br/>
<!-- Add the pay add the payment link here -->
<form action="Profile" method="get">
<label for="check" id="labelCheck">Use Stored Address and Card Information</label>
<input type="checkbox" name="check" id="check"/>
<br />
<button name="payBtn" id="payBtn">Pay</button>
</form>

${Error}
<form action="Profile" method="get">
<label for="Inp" id="labl">Card Number: </label>
<input type="text" name="Inp" id="Inp"/>
<br />
<label for="cvv" id="labl">CVV: </label>
<input type="text" name="cvv" id="Inp"/>
<br />
<label for="name" id="labl">Name on card: </label>
<input type="text" name="name" id="name"/>
<br />
<label for="expdate">Expiry date:</label>
<input type="date" name="expdate" id="expdate"></input>
<br/>
<button name="payNow" id="payNow">Pay</button>
</form>


</body>
</html>