<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${appName}</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
Welcome to surfing! 
<br />
<form method="post" action="surfing"> 
<select name="slct" id="slct">
<option value="Science">Science</option>
<option value="Fiction">Fiction</option>
<option value="Engineering">Engineering</option>
<option value="All">All Category</option>
</select>
<input type="text" name="search" id="search"/> <button id="srchBtn">Search</button> </form>
<br />
${Er}
<br />
<!-- use c:for each to fill the table -->
<table>
  <tr>
    <th>Item</th>
    <th>Description</th>
    <th>Price</th>
    <th>Category</th>
    <th>Quantity</th>
    <th>Details</th>
    <th>Add</th>
  </tr>
  <c:forEach var="book" items="${hash}">
  <tr>
    <td>${book.bid}</td>
    <td>${book.title}</td>
    <td>${book.price}</td>
    <td>${book.category}</td>
    <td>${book.quantity}</td>
    <td><a href="./Details.jsp">View More</a></td>
    <td>
    	<form action="#">
    		<button>Add to cart</button>
    	</form>
    </td>
  </tr>
  </c:forEach>
</table>
</body>
</html>