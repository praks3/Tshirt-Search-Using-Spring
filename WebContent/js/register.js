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
