<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information Form</title>
</head>
<body>
	${Error} 
	<form method="post" action="AddInfo">
	<fieldset>
		<legend>Enter Email</legend>
		<label for="email" id="label">Email:</label> <br>
		<input type="email" id="email" name="email">
	</fieldset> <br>
		<fieldset>
			<legend>Address Information</legend>
			<label for="streetNumber" id="label">Street Number:</label> <br>
			<input type="text" id="streetNumber" name="streetNumber"> <br>
			<label for="streetName" id="label">Street Name:</label> <br> 
			<input type="text" id="streetName" name="streetName"> <br> 
			<label for="unitNo" id="label">Unit Number:</label> <br> 
			<input type="text" id="unitNo" name="unitNo"> <br> 
			<label for="postcode" id="label">Postal Code:</label> <br> 
			<input type="text" id="postcode" name="postcode"> <br> 
			<label for="city" id="label">City:</label> <br> 
			<input type="text" id="city" name="city"> <br> 
			<label for="state" id="label">State:</label> <br> 
			<input type="text" id="state" name="state"> <br> 
			<label for="country" id="label">Country:</label><br> 
			<input type="text" id="country" name="country"> <br>
		</fieldset>
		<br>
		<fieldset>
			<legend>Credit Card Info</legend>
			<label for="cNumber" id="label">Card Number:</label> <br> 
			<input type="text" id="cNumber" name="cNumber"> <br> 
			<label for="country" id="label">CSV:</label> <br> 
			<input type="text" id="csv" name="csv"> <br> 
			<label for="fname" id="label">First Name:</label> <br> 
			<input type="text" id="fname" name="fname"> <br> 
			<label for="lname" id="label">Last Name:</label> <br>
			<input type="text" id="lname" name="lname"> <br> 
			<label for="expdate" id="label">Expiry Date</label> <br> 
			<input type="date" id="expdate" name="expdate"> <br>
		</fieldset>
		<br>
		<button id="ccinfo" name="ccinfo">Add Information</button>
	</form>
</body>
</html>