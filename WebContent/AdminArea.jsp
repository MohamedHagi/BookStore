<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Admin Area</title>
<style>
					table, tr,td{
						padding-right:5px;
						border: 1px solid black;
					}
					
				</style>
</head>
<body>
<form action="Analytics" method="post">
<button name="ttbtn" id="btn">Top Ten</button>
</form>
<br/>
<form action="Analytics" method="post">
<fieldset>
<legend>Retrieve Order</legend>
<label for="poid" id="lbl">Poid</label>
<input type="text" id="poid" name="poid"/>
<br/>
<button name="pobtn">Submit</button>
<br/>
${custEmail} ${custID} ${custCard} ${custStatus}
</fieldset>
</form>
<br/>

<form action="Analytics" method="post">
<fieldset>
<legend>Report</legend>
<label for="month" id="lbl">Month</label>
<br/>
<small>Please enter month in numerical value</small>
<br/>
<input type="text" id="month" name="month" placeholder="1"/>
<br/>
<label for="year" id="lbl">Year</label>
<br/>
<input type="text" id="year" name="year" placeholder="2020"/>
<br/>
<button name="rptbtn">Report</button>
</fieldset>
</form>


<table>
  <tr>
    <th>Book id</th>
    <th>Tittle</th>
    <th>price</th>
  </tr>
  <c:forEach var="Book" items="${list}">
  <tr>
  	<td>${Book.bid}</td>
    <td>${Book.title}</td>
    <td>${Book.price}</td>
  </tr>
  </c:forEach>
</table>


</body>
</html>