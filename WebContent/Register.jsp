<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${appName}</title>
</head>
<body>
Registration Page!
<form method="post" action="Reg" id="logFrm">
	<fieldset>
		<legend>Register</legend>
		<small>${Err}</small>
		<br>
		<label for="FirstName">FirstName:</label>
		<br />
		<input type="text" id="fname" name="fname"/>
		<br>
		<label for="LastName">LastName:</label>
		<br />
		<input type="text" id="lname" name="lname"/>
		<br>
		<label for="id">ID:</label>
		<br />
		<input type="email" id="id" name="id"/>
		<br />
		<label for="pass">Password: </label>
		<br />
		<input type="password" id="pass" name="pass"/>
		<br/>
		<label for="passr">Retype Password: </label>
		<br />
		<input type="password" id="passr" name="passr"/>
		<br/>
		<button name="btnRegister">Register</button>
	</fieldset>
</form>
</body>
</html>