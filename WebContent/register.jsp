<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="images/icon.png" type="image/png">
<!-- <script src="js/register.js" ></script>
 --><style>
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
	margin-top: 60px;
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
<title>Sign Up</title>
</head>
<body>
	<nav>
		<div class="navbar-center">
			<h2>Tshirt Search<h2>
		</div>
	</nav>
	<form id="Register" action="register" method="post">
		<h1>Register</h1>
		
		<input type="text" name="fullName" id="fullName" onkeyup="validateFullname()" placeholder="Full Name" required><br>
			<span id="fullnameError" style="color: red;"></span><br> 
			
		<input type="text" name="username" id="username" onkeyup="validateUsername()" placeholder="Username" required><br>
			<span id="usernameError" style="color: red;"></span><br> 
			
		<input type="text" name="email" id="email" onkeyup="validateEmail()" placeholder="Email" required><br>
			<span id="emailError" style="color: red;"></span><br> 
			
		<input type="password" name="password" id="password" placeholder="Password" onkeyup="validatePassword()" required><br> 
			<span id="passwordError" style="color: red;"></span><br> 
			
		<input type="submit" value="Login">
		<p>
			Already have an account? <a href="Login.jsp">Login Here</a>
		</p>
	</form>
<script type="text/javascript">
function validateFullname() {
	var fullName = document.getElementById("fullName").value;
	var fullNameRegex = /^[a-zA-Z ]+$/;

	if (fullName == "") {
		document.getElementById("fullnameError").innerHTML = "Full Name must be filled out";
	} else if (!fullNameRegex.test(fullName)) {
		document.getElementById("fullnameError").innerHTML = "Full Name must contain only letters and spaces";
	} else {
		document.getElementById("fullnameError").innerHTML = "";
	}
}

function validateUsername() {
	var username = document.getElementById("username").value;
	var usernameRegex = /^[a-zA-Z0-9]+$/;

	if (username == "") {
		document.getElementById("usernameError").innerHTML = "Username must be filled out";
	} else if (username.length < 5 || username.length > 50) {
		document.getElementById("usernameError").innerHTML = "Username must be between 5 and 50 characters ";
	} else if (!usernameRegex.test(username)) {
		document.getElementById("usernameError").innerHTML = "Username must contain only letters and numbers";
	} else {
		document.getElementById("usernameError").innerHTML = "";
	}
}


function validateEmail() {
	var email = document.getElementById("email").value;
	var emailRegex = /\S+@\S+\.\S+/;
	if (email == "") {
		document.getElementById("emailError").innerHTML = "Email must be filled out";
	} else if (!emailRegex.test(email)) {
		document.getElementById("emailError").innerHTML = "Invalid Email format";
	} else {
		document.getElementById("emailError").innerHTML = "";
	}
}

function validatePassword() {
	var password = document.getElementById("password").value;

	if (password.length < 5 || password.length > 50) {
		document.getElementById("passwordError").innerHTML = "Password must be between 5 and 50 characters";
	} else {
		document.getElementById("passwordError").innerHTML = "";
	}
}

</script>
</body>
</html>