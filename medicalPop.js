let del = document.getElementById("del");
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