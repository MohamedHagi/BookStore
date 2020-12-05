<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${Error}
<form action="Analytics" method="post">
<label for="email" id="email">Enter Email: </label>
<input type="email" name="email" id="email"/>
<br />
<label for="passwor" id="passwor">Password: </label>
<input type="password" name="passwor" id="passwor">
<br/>
<button name="submit" id="submitBtn">Login</button>
</form>
</body>
</html>