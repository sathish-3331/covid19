let DB;
let form = document.querySelector('form');
let Aadharnumber=document.querySelector('#Aadharnumber');
let patientname = document.querySelector('#patientname');
let mobileNumber = document.querySelector('#mobileNumber');
let date = document.querySelector('#date');
let consultations = document.querySelector('#consultations');
let services = document.querySelector('#services');
let MuniciPalityId = document.querySelector('#MuniciPalityId');
let patientage=document.querySelector('#patientage');
let gender=document.querySelector('#gender');
let sympotoms1=document.querySelector('#sympotoms1');
let sympotoms2=document.querySelector('#sympotoms2');
let sympotoms3=document.querySelector('#sympotoms3');
let sympotoms4=document.querySelector('#sympotoms4');
let sympotoms5=document.querySelector('#sympotoms5');
var listArray=[];
let personDetails ;
document.addEventListener('DOMContentLoaded', () => {
     // create the database
     let ScheduleDB = window.indexedDB.open('consultations', 1);

     // if there's an error
     ScheduleDB.onerror = function() {
          console.log('error');
     }
     ScheduleDB.onsuccess = function() {
          // console.log('Database Ready');
          DB = ScheduleDB.result;
          showConsultations();
     }
	ScheduleDB.onupgradeneeded = function(e) {
		let db = e.target.result;
        let objectStore = db.createObjectStore('consultations', { keyPath: 'key', autoIncrement: true });
        objectStore.createIndex('Aadharnumber', 'Aadharnumber', { unique: false });
		objectStore.createIndex('patientname', 'patientname', { unique: false });
		objectStore.createIndex('mobileNumber', 'mobileNumber', { unique: false });
		objectStore.createIndex('date', 'date', { unique: false });
		objectStore.createIndex('MuniciPalityId', 'MuniciPalityId', { unique: false });
		objectStore.createIndex('patientage', 'patientage', { unique: false });
		objectStore.createIndex('gender', 'gender', { unique: false });
		objectStore.createIndex('sympotoms1', 'sympotoms1', { unique: false });
		objectStore.createIndex('sympotoms2', 'sympotoms2', { unique: false });
		objectStore.createIndex('sympotoms3', 'sympotoms3', { unique: false });
		objectStore.createIndex('sympotoms4', 'sympotoms4', { unique: false });
		objectStore.createIndex('sympotoms5', 'sympotoms5', { unique: false });
	}
       form.addEventListener('submit', addConsultations);
       function addConsultations(e) {
		e.preventDefault();
		let newConsultation = {
			Aadharnumber: Aadharnumber.value,
			patientname: patientname.value,
            mobileNumber: mobileNumber.value,
			date: date.value,
			MuniciPalityId: MuniciPalityId.value,
			patientage: patientage.value,
			gender: gender.value,
			sympotoms1: sympotoms1.value,
			sympotoms2: sympotoms2.value,
			sympotoms3: sympotoms3.value,
			sympotoms4: sympotoms4.value,
			sympotoms5: sympotoms5.value,
}
          let transaction = DB.transaction(['consultations'], 'readwrite');
          let objectStore = transaction.objectStore('consultations');
          let request = objectStore.add(newConsultation);
                    request.onsuccess = () => {
               form.reset();
          }
          transaction.oncomplete = () => {
               showConsultations();
          }
          transaction.onerror = () => {
              console.log("SorryNotFound");
          }
}
     function showConsultations() {
      while(consultations.firstChild) {
            consultations.removeChild(consultations.firstChild);
          }
         let objectStore = DB.transaction('consultations').objectStore('consultations');
           objectStore.openCursor().onsuccess = function(e) {
              let cursor = e.target.result;
               if(cursor) {
                    let ConsultationHTML = document.createElement('li');
                    ConsultationHTML.setAttribute('data-consultation-id', cursor.value.key);
                    ConsultationHTML.classList.add('list-group-item');
                    ConsultationHTML.innerHTML = `  
                         <p class="font-weight-bold">PatientAadharnumber:  <span class="font-weight-normal">${cursor.value.Aadharnumber}<span></p>
                         <p class="font-weight-bold">Patient Name:  <span class="font-weight-normal">${cursor.value.patientname}<span></p>
                          <p class="font-weight-bold">Contact:  <span class="font-weight-normal">${cursor.value.mobileNumber}<span></p>
                         <p class="font-weight-bold">Date:  <span class="font-weight-normal">${cursor.value.date}<span></p>
                           <p class="font-weight-bold">MuniciPalityId:  <span class="font-weight-normal">${cursor.value.MuniciPalityId}<span></p>
                           <p class="font-weight-bold">age:  <span class="font-weight-normal">${cursor.value.patientage}<span></p>
                           <p class="font-weight-bold">gender:  <span class="font-weight-normal">${cursor.value.gender}<span></p>
                           <p class="font-weight-bold">FeverOrChills:  <span class="font-weight-normal">${cursor.value.sympotoms1}<span></p>
                           <p class="font-weight-bold">Cough:  <span class="font-weight-normal">${cursor.value.sympotoms2}<span></p>
                           <p class="font-weight-bold">ThoratPain:  <span class="font-weight-normal">${cursor.value.sympotoms3}<span></p>
                             <p class="font-weight-bold">Fatigue:  <span class="font-weight-normal">${cursor.value.sympotoms4}<span></p>
                               <p class="font-weight-bold">MuscleOrBodyAches:  <span class="font-weight-normal">${cursor.value.sympotoms5}<span></p>
                    `;
                    const cancelBtn = document.createElement('button');
                    cancelBtn.classList.add('btn', 'btn-danger');
                    cancelBtn.innerHTML = 'Cancel';
                    cancelBtn.onclick = removeConsultation;
                   ConsultationHTML.appendChild(cancelBtn);
                    consultations.appendChild(ConsultationHTML);
                    cursor.continue();
               } else {
                    if(!consultations.firstChild) {
                        services.textContent = 'Change your visiting hours';
                         let noSchedule = document.createElement('p');
                         noSchedule.classList.add('text-center');
                         noSchedule.textContent = 'No results Found';
                      consultations.appendChild(noSchedule);
                    } else {
                        services.textContent = 'Cancel Your consultations'
                    }
               }
          }
     }
          function removeConsultation(e) {
          let scheduleID = Number( e.target.parentElement.getAttribute('data-consultation-id') );
          let transaction = DB.transaction(['consultations'], 'readwrite');
          let objectStore = transaction.objectStore('consultations');
          objectStore.delete(scheduleID);
          transaction.oncomplete = () => {
          e.target.parentElement.parentElement.removeChild( e.target.parentElement );
          if(!consultations.firstChild) {
          services.textContent = 'Change your visiting hours';
          let noSchedule = document.createElement('p');
          noSchedule.classList.add('text-center');
          noSchedule.textContent = 'No results Found';
          consultations.appendChild(noSchedule);
               } else {
                   services.textContent = 'Cancel your Consultation'
               }
          }
     }
});
  document.getElementById("listBox").addEventListener("change", (event) => {
  console.log(event.target.value);
  personDetail(event.target.value);
    });
async function personDetail(list1){
	let response= await fetch("http://localhost:8080/ListTest?aadharNumber="+list1, {method:"POST"});
    await fetchDetails(response);
	}
function fetchDetails(response) {
	return new Promise((resolve, reject) => {
		response.text().then((data) => {
			resolve(data);
			let jsonVal = JSON.parse(data);
			let Name = jsonVal.userName;
			let AadharNumber = jsonVal.AadharNumber;
			var age = jsonVal.age;
			var gender = jsonVal.gender;
			var mobilenumber = jsonVal.mobilenumber;
			document.getElementById('patientname').value = Name;
			document.getElementById('Aadharnumber').value = AadharNumber;
			document.getElementById('patientage').value = age;
			document.getElementById('gender').value = gender;
			document.getElementById('mobileNumber').value = mobilenumber;
			document.getElementById('sympotoms1').value = jsonVal.FeverOrChills;
			document.getElementById('sympotoms2').value = jsonVal.Cough;
			document.getElementById('sympotoms3').value = jsonVal.ThoratPain;
			document.getElementById('sympotoms4').value = jsonVal.Fatigue
			document.getElementById('sympotoms5').value = jsonVal.MuscleOrBodyAches;
			document.getElementById('StateName').value  =jsonVal.StateName;
		});
	})
}
var list = document.getElementById("listAddharNumber").value;
JSON.parse(list);
var list1 = JSON.parse(list);
for(let i = 0 ; i < list1.length; i++){
	var options = document.createElement('option')
	options.innerHTML = list1[i];
	options.value = list1[i];
	document.querySelectorAll(".selectBox")[0].children[0].append(options);
	}


async function InsertFunction(){
	let aadharNumber=document.getElementById('Aadharnumber').value;
	let name=document.getElementById('patientname').value;
	let contact=document.getElementById('mobileNumber').value;
	let date=document.getElementById('date').value;
	let Patientage=document.getElementById('patientage').value;
    let gender=document.getElementById('gender').value;
     let trackId=document.getElementById('trackId').value;
     let zoneName=document.getElementById('zoneName').value;
     let MuniciPalityName=document.getElementById('MunicipalityName').value;
     let result=document.getElementById('Result').value;
     let statName=document.getElementById('StateName').value;
	 let response3= await fetch("http://localhost:8080/InsertPositiveNegative?patientName="+name+"&addharNumber="+aadharNumber+"&mobileNumber="+contact+"&Testdate="+date+"&Patientage="+Patientage+"&gender="+gender+"&trackId="+trackId+"&zoneName="+zoneName+"&MuniciPalityName="+MuniciPalityName+"&result="+result+"&stateName="+statName,{method:"POST"});
    await insert(response3);
	}
	       	function insert(response1){
       		return new Promise((resolve,reject)=>{
       			response1.text().then((data2) => {
       				resolve(data2);
   				alert('success');
            })
         })}
