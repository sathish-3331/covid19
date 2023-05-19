let toggle=document.querySelector('.toggle');
let navigation=document.querySelector('.navigation');
let main=document.querySelector('.main');
toggle.onclick=function(){
    navigation.classList.toggle('active');
    main.classList.toggle('active');
}
//and Hovered Class In Selected
let list = document.querySelectorAll('.navigation li');
function activelink() {
	list.forEach((item) => item.classList.remove('hovered')); item.classList.add('hovered');
}
list.forEach((item)=>item.addEventListener('mouseover',activeLink));
