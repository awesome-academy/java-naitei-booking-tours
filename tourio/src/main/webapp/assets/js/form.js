function validateRepeatPassword() {
    var password = document.getElementById("password").value;
    var repeatPassword = document.getElementById("repeatPassword").value;

    if (password !== repeatPassword) {
        alert("Passwords do not match.");
        return false;
    }
    return true;
}