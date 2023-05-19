var nameError = document.getElementById("sname-error");
var mobileNoError = document.getElementById("mobile-error");
var userMailError = document.getElementById("mailId-error");
var passwordError = document.getElementById("pass-error");
var submitError = document.getElementById("submit-error");
var text;

function nameValidation() {
    var uName = document.getElementById('name').value;
    var nameValidate = '[a-z .A-Z]+';
    if (uName.length === 0) {
        text = "Name is required";
        nameError.innerHTML = text;
        return false;
    }
    if (uName < 3) {
        text = "Name should be greater than 3 characters";
        nameError.innerHTML = text;
        return false;
    }
    if (!uName.match(nameValidate)) {
        text = 'Name must contain uppercase and lowecase';
        nameError.innerHTML = text;
        return false;
    }
    nameError.innerHTML = '<em class="fa-regular fa-circle-check"></em>';
    return true;
}

function mailValidation() {
    var mailv = document.getElementById('email').value;
    var mailValidate = /^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$/;
    if (mailv.length === 0) {
        text = "MailId is required";
        userMailError.innerHTML = text;
        return false;
    }
    if (mailv < 6) {
        text = "Mail should be greater than 6 characters";
        userMailError.innerHTML = text;
        return false;
    }
    if (!mailv.match(mailValidate)) {
        text = 'MailId must contain @';
        userMailError.innerHTML = text;
        return false;
    }
    userMailError.innerHTML = '<em class="fa-regular fa-circle-check"></em>';
    return true;
}
function passwordvalidation() {
    var pass = document.getElementById('password').value;
    var password = '.[A-Za-z0-9]{1,}[@#$!%^&?><]{1,}.*';
    if (pass == null || pass.trim() === "") {
        text = "Password is required";
        passwordError.innerHTML = text;
        return false;
    }
    if (!pass.match(password)) {
        text = "Password Should be more than 6 characters";
        passwordError.innerHTML = text;
        return false;

    }
    passwordError.innerHTML = '<em class="fa-regular fa-circle-check"></em>';
    return true;

}

function mobileNoValidation() {
    var mobileNumber = document.getElementById('mobileNumber').value;
    var mobileNoValidate = /^[0-9]{10}$/;
    if (mobileNumber.length === 0) {
        text = 'Mobile Number is required';
        mobileNoError.innerHTML = text;
        return false;
    }
    if (mobileNumber.length !== 10) {
        text = 'Mobile Number should be 10 digits';
        mobileNoError.innerHTML = text;
        return false;
    }
    if (!mobileNumber.match(mobileNoValidate)) {
        text = 'Mobile Number is required';
        mobileNoError.innerHTML = text;
        return false;
    }
    mobileNoError.innerHTML = '<em class="fa-regular fa-circle-check"></em>';
    return true;

}
