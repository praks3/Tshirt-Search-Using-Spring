<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Login Page</title>
<!-- <link rel="stylesheet" type="text/css" href="css/login.css">
 -->
<style>
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
}

body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
}

form {
	background-color: #fff;
	border-radius: 10px;
	padding: 20px;
	width: 400px;
	margin: 0 auto;
	margin-top: 100px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

input[type="text"], input[type="password"] {
	padding: 10px;
	width: 100%;
	border-radius: 5px;
	border: inset;
	margin-bottom: 10px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.2s ease;
}

input[type="submit"]:hover {
	background-color: #3e8e41;
}

h1 {
	text-align: center;
	color: #333;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>
	<nav>
		<div class="navbar-center">
			<h2>Search T-shirt</h2>
		</div>
	</nav>
	<form id="login" action="login" method="post">
		<h1>Login</h1>
		<input type="text" name="username" id="username" onkeyup="validateUsername()" placeholder="Username" required><br>
			<span id="usernameError" style="color:red;"></span><br>
			<input type="password" name="password" id="password" placeholder="Password" onkeyup="validatePassword()" required><br> 
			<span id="passwordError" style="color:red;"></span><br>
			<input type="submit" value="Register">
			<p>
			New User?<a href="register.jsp">Register Here</a>
		</p>
	</form>
</body>







<script type="text/javascript">
function validateUsername() {
    var username = document.getElementById("username").value;
    var error = document.getElementById("usernameError");
    if (username.length < 5 || username.length > 50) {
        error.innerHTML = "Username must be between 5 and 50 characters.";
    } else {
        error.innerHTML = "";
    }
}
function validatePassword() {
    var password = document.getElementById("password").value;
    var error = document.getElementById("passwordError");
    if (password.length < 5 || password.length > 50) {
        error.innerHTML = "Password must be between 5 and 50 characters.";
    } else {
        error.innerHTML = "";
    }
}

</script>
</html>