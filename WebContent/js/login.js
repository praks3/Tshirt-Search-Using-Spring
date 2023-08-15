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
