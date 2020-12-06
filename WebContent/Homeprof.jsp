<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${profileName}</title>
</head>
<body>
	${profileName}
	<br />
	${fname}, ${lname} 
	<br />
	Date Joined: ${date}
	<br />
	<form method="get" action="AddInfo">
		${add}
	</form>
	<br />
	${stNo} ${stName} ${prov} ${cont}
	<br />
	${cardNo}  ${csv}  ${cardfName} ${cardlName} ${expdate} 
	<form method="post" action="logout" id="frm">
	<button name="btnLogout">Logout</button>
	</form>
	<br />
	<form method="post" action="Profile" id="frm2">
	<button name="cartBtn">View Cart</button>
	<br />
	<button name="surfBtn">Surf</button>
	</form>
	<label for="cart">cart (${size}) Total:(${tot}):</label>
	
<table>
  <tr>
    <th>Tittle</th>
    <th>Price</th>
  </tr>
  <c:forEach var="book" items="${la}">
  <tr>
    <td>${book.price}</td>
    <td>${book.bookTittle}</td>
  </tr>
  </c:forEach>
</table>
	
</body>
</html>