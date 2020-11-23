<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CheckOut</title>
</head>
<body>
Checkout Page!
<!-- use c:for each to fill the table this is the cart -->
<table>
  <tr>
    <th>Item</th>
    <th>Description</th>
    <th>Price</th>
    <th>Details</th>
  </tr>
  <tr>
    <td>Book1</td>
    <td>Awesome Book</td>
    <td>$100</td>
    <td><a href="./Details.jsp">View More</a></td>
  </tr>
</table>
<br>
<!-- Add a total from the servlet using EL -->
Total: 
<!-- Add the pay add the payment link here -->
Pay: <a href="#">Some payment Link </a>
</body>
</html>