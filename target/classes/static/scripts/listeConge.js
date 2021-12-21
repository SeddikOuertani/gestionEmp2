var congeRestant = Number(document.getElementById("congeRestant").textContent);
var button = document.getElementById("add");
var error=document.getElementById("error");
button.hidden =false;
error.hidden=true;
if(congeRestant<1){
button.hidden = true;
error.hidden=false;
}
