var nameError=document.getElementById("name-error");
var mobileNoError=document.getElementById("mobileNo-error");
var passwordError=document.getElementById("password-error");
var aadharNoError=document.getElementById("aadhar-error");
var mailIdError=document.getElementById("mail-error");
var addressError=document.getElementById("address-error");
var postCodeError=document.getElementById("post-error");
var ageError=document.getElementById("age-error");
function nameValid(){
	var Name=document.getElementById("name").value;
	var nameValid='[A-Aa-z]*$';
	if(Name===0  || Name.trim === ""){
   let text='Name cannot be Empty';
	nameError.innerHTML=text;
	return false;
}
if(Name.length<4){
	let text='Name Must Contain Greater Than 4 Characters';
	nameError.innerHTML=text;
	return false;
}
if(!Name.match(nameValid)){
	let text='Invalid name';
	nameError.innerHTML=text;
	return false;
}
nameError.innerHTML='<i class="fa-regular fa-circle-check"></i>';
return true;

}
function mobileNoValid(){
	var mobileNo=document.getElementById("mobileNo").value;
	var mobileNoValid="[6-9][0-9]{9}";
	if(mobileNo===0){
	let text='MobileNo cannot be Empty';
	mobileNoError.innerHTML=text;
	return false;
}
if(mobileNo.length<10 || mobileNo.length>10){
	let text='Mobile No Must Contain 10 Digits';
	mobileNoError.innerHTML=text;
	return false;
}
if(!mobileNo.match(mobileNoValid)){
	let text='Invalid Mobile No';
	mobileNoError.innerHTML=text;
	return false;
}
mobileNoError.innerHTML='<i class="fa-regular fa-circle-check"></i>';
return true;

}
function passwordValidation() {
    var password = document.getElementById('password').value;
    let passwordValidation = '.[A-Za-z0-9]{1,}[@#$!%^&?><]{1,}.*';
    if (password === null || password.trim() === "") {
       let text = "Password cannot Empty";
        passwordError.innerHTML = text;
        return false;
    }
    if (!password.match(passwordValidation)) {
        let text = "Password Should be more than 6 characters";
        passwordError.innerHTML = text;
        return false;
    }
    passwordError.innerHTML = '<i class="fa-regular fa-circle-check"></i>';
    return true;
}
function aadharNoValidation() {
    var aadharNo = document.getElementById("aadharNumber").value;
    let aadharNoValidation = /^[^0-1]\d{11}$/;
    if(aadharNo === 0){
       let text = 'Aadhar Number Cannot Be Empty';
        aadharNoError.innerHTML = text;
        return false;
         }
    
    if(!aadharNo .match(aadharNoValidation)){
        let text = 'Invalid Aadhar Number';
        aadharNoError.innerHTML = text;
        return false;
    }
    aadharNoError.innerHTML = '<i class="fa-regular fa-circle-check"></i>';
        return true;
}
function addressValidation1() {
    var address = document.getElementById("zoneAreaName").value;
    let  addressValidation1= "^(.+){10,500}[a-z,.-A-Z0-9\s]";
    if(address === 0){
        let text = ' Address Cannot Be Empty and Must Include  ,.-numbers,a-zA-Z ';
        addressError.innerHTML = text;
        return false;
        }
    if(address . length < 10 || address. length > 500){
       let text = ' Address  Must Conatin minimum 10 and maximum 500 Characters';
        addressError.innerHTML = text;
        return false;
    }
    if(!address .match(addressValidation1)){
       let text = 'Invalid Address';
        addressError.innerHTML = text;
        return false;
    }
    addressError.innerHTML = '<i class="fa-regular fa-circle-check"></i>';
        return true;
}
function postCostValid(){
	var post=document.getElementById("postcode").value;
	var postCostValid='\\d{6}';
	if(post === 0  || post.trim === ""){
	let text='post code cannot be Empty';
	postCodeError.innerHTML=text;
	return false;
}
if(post . length < 6 || post. length >6){
	let text=' Must Contain 6 Digits';
	postCodeError.innerHTML=text;
	return false;
}
if(!post.match(postCostValid)){
	let text='Invalid Post Code';
	postCodeError.innerHTML=text;
	return false;
}
postCodeError.innerHTML='<i class="fa-regular fa-circle-check"></i>';
return true;

}
function ageValid(){
	var Age=document.getElementById("age").value;
	var ageValid="\\d{2}";
	if(Age===0){
	let text='Age cannot be Empty';
	ageError.innerHTML=text;
	return false;
}
if(Age>0 && Age>110){
	let text=' Age Not contain 110 values';
    ageError.innerHTML=text;
	return false;
}
if(!Age.match(ageValid)){
	let text='Invalid age ';
	ageError.innerHTML=text;
	return false;
}
ageError.innerHTML='<i class="fa-regular fa-circle-check"></i>';
return true;
}


