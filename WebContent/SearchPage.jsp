<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
/* response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
 */String username = (String) session.getAttribute("username");
if (username == null) {
	response.sendRedirect("Login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Search Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	background-color: #f2f2f2;
}

nav {
	background-color: black;
	display: flex;
	justify-content: space-between;
	align-items: center;
	height: 60px;
	padding: 0 20px;
}

.navbar-center {
	color: white;
	text-align: center;
}

.navbar-right {
	text-align: right;
}

.navbar-right a {
	color: white;
	text-decoration: none;
	font-size: 16px;
	font-weight: bold;
}

#form1 {
	width: 400px;
	margin-top: 20px;
	font-family: Arial, sans-serif;
}

label, select, #btn1 {
	display: block;
	margin-bottom: 10px;
}

input[type="text"], select {
	width: 100%;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

#btn1 {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

#btn1:hover {
	background-color: #45a049;
}
</style>


</head>

<body>
	<nav>
		<div class="navbar-center">
			<h1>Search T-shirt</h1>
		</div>

		<div class="navbar-right">
			<a href="logout">Logout</a>
		</div>
	</nav>

	<form method="post" id="form1" action="search">
		<label for="color">Enter color:</label> <input type="text" id="color"
			name="color" required><br>
		<%
			session.setAttribute("username", username);
		%>

		<br> <label for="size">Select size:</label> <select id="size"
			name="size" required>
			<option value=""></option>
			<option value="s">S</option>
			<option value="m">M</option>
			<option value="l">L</option>
			<option value="xl">XL</option>
			<option value="xxl">XXL</option>
		</select><br> <label for="gender">Select Gender:</label> <select
			id="gender" name="gender" required>
			<option value=""></option>
			<option value="M">Male</option>
			<option value="F">Female</option>
		</select><br> <label for="outputPref">Select Preference:</label> <select
			id="outputPref" name="outputPref" required>
			<option value=""></option>
			<option value="Price">Sort by Price</option>
			<option value="Rating">Sort by Rating</option>
			<option value="Both">Sort by Both</option>
		</select><br> <input type="submit" id="btn1" value="Search">
	</form>

</body>

</html>