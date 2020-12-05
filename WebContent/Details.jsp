<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${appName}</title>
</head>
<body>
More details
<br/>
${productID} ${bookTittle} ${price} ${categ}


<table>
  <tr>
    <th>Review</th>
    <th>Date</th>
  </tr>
  <c:forEach var="rev" items="${review}">
  <tr>
    <td>${rev.review}</td>
    <td>${rev.date}</td>
  </tr>
  </c:forEach>
</table>

<br/>
${success}
<br/>
${login}
<form action="surfing" method="get">
<label for="textArea">Review</label>
<textarea id="textArea" name="textArea" rows="4" cols="50">
Max size 150 words!
  </textarea>
  <br/>
  <input type="hidden" name="hidVal" value="${bookTittle}"/>
  <button name="reviewInsert">Submit</button>
</form>


</body>
</html>