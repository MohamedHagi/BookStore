<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${profileName}</title>
<style>
.wrapper {
	width: 860px;
	margin: 0 auto;
}

.wrapper ul {
	list-style: none;
	margin-top: 2%;
}

.wrapper ul li {
	background: #262626;
	width: 170px;
	border: 1px solid #fff;
	height: 50px;
	line-height: 50px;
	text-align: center;
	float: left;
	color: #fff;
	font-size: 16px;
	position: relative;
	font-family: poppins;
	text-transform: uppercase;
	font-weight: bold;
}

.wrapper ul li:hover {
	background: crimson;
}

.wrapper ul ul {
	display: none;
}

.wrapper ul li:hover>ul {
	display: block;
}

.wrapper ul ul ul {
	margin-left: 170px;
	top: 0;
	position: absolute;
}
</style>
</head>
<body>
	${profileName}
	<br>
	<label for="cart">Your cart:</label>
	<div class="wrapper">
		<ul>
			<li>Cart
				<!-- use C: foreach loop to genearte more items -->
				<ul>
					<li>Book1</li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>