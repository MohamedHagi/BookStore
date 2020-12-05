<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Analytics</title>
</head>
<body>
	
<table>
  <tr>
    <th>Book Tittle</th>
    <th>Sold</th>
  </tr>
  <c:forEach var="TopTen" items="${still}">
  <tr>
    <td>${TopTen.bookTittle}</td>
    <td>${TopTen.total}</td>
  </tr>
  </c:forEach>
</table>
<br/>

</body>
</html>