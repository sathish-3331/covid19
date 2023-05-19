   async function mailIdCheck() {
            
        	    var mailId = document.getElementById("email").value;
        	    var regex="^[^\\s@.]+@gmail\\.com$";
        	    if(mailId !="" && mailId.match(regex)){
        	    var condition= document.getElementById('mail-error').value;
        		let response = await fetch("http://localhost:8080/AppoinmentRequest?mailId="+mailId,{ method: "POST" });
        		var personDetails = await fetchDetails(response);
        	        return true;
         }
        	
        	function fetchDetails(response) {
        		return new Promise((resolve, reject) => {
        			response.text().then((data) => {
        	    mailIdError.innerHTML = data;
        				/* alert(data); */
        	       if(data==("Your MailId is Verifed")){
	            
        	    	   console.log("Your Appointment is Booking");
        	    	   return true;
        	       }else{
        	    	   console.log("Invalid Maild");
        	    	   return false;
        	       }
        			})
        		})
}
   }     	
  function  validateForm(){
        var name = document.forms["submitform"]["name"].value;
        var email = document.forms["submitform"]["email"].value;
        var regex="^[^\\s@.]+@gmail\\.com$";
        var Age=document.forms["submitform"]["age"].value;
        var mobileNo=document.forms["submitform"]["mobileNo"].value;
        var password=document.forms["submitform"]["password"].value;
        var aadharNumber=document.forms["submitform"]["aadharNumber"].value;
        
         var date=document.forms["submitform"]["date_picker"].value;
       var dateValue=  new Date(date);
        var post=document.forms["submitform"]["postcode"].value;
        var mail=document.getElementById('mail-error').innerText;
     	var ageValid="\\d{2}";
     	var mobileNoValid="[6-9][0-9]{9}";
     	var  passwordValidation = '.[A-Za-z0-9]{1,}[@#$!%^&?><]{1,}.*';
     	var aadharNoValidation=/^[^0-1]\d{11}$/;
     	var postCodeValid="\\d{6}";
     	var mailvalid="Your MailId is Verifed";
        var submit = true;

        if (name == null || name == "") {
            alert("Name Should be must filled")
            submit = false;
        }

        else if (Age == null || Age == "") {
            alert("Age Should be must filled")
            submit = false;
        }
        else if(Age>0 && Age>110){
        	alert(' Age Not contain Negative values');
            submit= false;
        }
        else  if(!Age.match(ageValid)){
            alert("Invalid Age only 3 Digits");
        	submit= false;
        }
        else if (email == null || email == "") {
        	 alert("EmailId Should be must filled")
            submit = false;
        }

        else if(!email.match(regex)){
        	alert("Maild Must have @gmail.com And Not Inclucd(Starting Any Special Characters) ")
        	submit = false;
        }
        else if(!mail.match(mailvalid)){
    		alert("This maild Already Exit!")
    		submit= false;
    	}
        else if (password === null || password.trim() === "") {
            alert("Password Cannot be Empty")
             submit= false;
         }
        else if(!password.match(passwordValidation)){
        	alert("Password Contain 6 digits and Special Characters")
        	submit= false;
        }
        else if (post == null || post == "") {
       	 alert("PinCode Should be must filled")
           submit = false;
       }

        else if(post . length < 6 || post. length >6){
    		alert("Pin Code Must Contain 6 Digits");
    		submit= false;
    	}
 
       else if (aadharNumber == null || aadharNumber == "") {
                alert("aadharNumber Should be must filled")
                submit = false;
            }
        else if(aadharNumber === 0){
                alert( "Aadhar Number Cannot Be Empty");
                 submit= false;
        }          
       else   if(!aadharNumber .match(aadharNoValidation)){
                 alert ("Invalid Aadhar Number");
                 submit= false;
             }
            
      else if (mobileNo == null || mobileNo == "") {
            alert("mobileNo Should be must filled")
              submit= false;
        }
      else if(!mobileNo.match(mobileNoValid)){
            	alert("Invalid MobileNumber")
            	submit= false;
            }
 /*if(date!=null){
	//date.attr('value', '');
    date.each(function(){
        $.datepicker._clearDate(date_picker);
    });
}*/  
else if(submit==true){
	location.reload();
    document.getElementById('submitform').reset();
          
    }
 }   