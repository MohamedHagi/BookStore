<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${appName}</title>
</head>
<body>
Welcome to Login Page!
<form method="post" action="Profile" id="logFrm">
	<fieldset>
		<legend>Guest Login</legend>
		<small>${Err}</small>
		<br>
		<label for="id">ID:</label>
		<br />
		<input type="email" id="id" name="id"/>
		<br />
		<label for="pass">Password: </label>
		<br />
		<input type="password" id="pass" name="pass"/>
		<br/>
		<button name="btnSignin">Login</button>
	</fieldset>
</form>
</body>
</html>