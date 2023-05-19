document.getElementById('approvedList').onclick = function() {  
  var markedCheckbox = document.getElementsByName('checkName');
  var inputField= document.getElementById('appointRegIdList');
  var value=[];
  for (var checkbox of markedCheckbox) {  
    if (checkbox.checked){
    	value.push(checkbox.value);
    }
  }  
    	inputField.value=value;
    	 var inputField= document.getElementById('appointRegIdList').value;
         if(inputField == ""){
     		        alert('Please select the appointment')
     		        return false;
     	}else{
     	   let del = document.getElementById("approvedList");
     	   let popWin = document.querySelector(".global-container");
     	   let cancelButton = document.querySelector(".cancel");

     	   del.addEventListener("click",popIt);
     	   function popIt(){
     	     popWin.classList.remove("unpop");
     	     popWin.classList.add("pop");
     	   }

     	   cancelButton.addEventListener("click",unPopIt);
     	   function unPopIt(){
     	     popWin.classList.remove("pop");
     	     popWin.classList.add("unpop");
     	   }

     	   popWin.addEventListener("click",outWin);
     	   function outWin(e){
     	     if (e.target.id === "global"){
     	       unPopIt();
     	     }
     	   }     
     	return true;
     	}
}		 
 
       document.getElementById('rejectList').onclick = function() {  
	   var markedCheckbox = document.getElementsByName('checkName');
	   var inputField= document.getElementById('appointRegIdList');
	   var value=[];
	   for (var checkbox of markedCheckbox) {  
	     if (checkbox.checked){
	     	
	     	value.push(checkbox.value);
	     }
	   }  
	     	inputField.value=value;
	     	 var inputField= document.getElementById('appointRegIdList').value;
             if(inputField == ""){
         		        alert('Please select the appointment')
         		        return false;
         	}else{
     	   let del = document.getElementById("rejectList");
     	   let popWin = document.querySelector(".global-containerRej");
     	   let cancelButton = document.querySelector(".cancelRej");

     	   del.addEventListener("click",popIt);
     	   function popIt(){
     	     popWin.classList.remove("unpop");
     	     popWin.classList.add("pop");
     	   }

     	   cancelButton.addEventListener("click",unPopIt);
     	   function unPopIt(){
     	     popWin.classList.remove("pop");
     	     popWin.classList.add("unpop");
     	   }

     	   popWin.addEventListener("click",outWin);
     	   function outWin(e){
     	     if (e.target.id === "global"){
     	       unPopIt();
     	     }
     	   }    
         		
         	return true;
	     	   }   
}
