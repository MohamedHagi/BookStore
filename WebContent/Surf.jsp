<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<!-- use c:for each to fill the table -->
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
</body>
</html>