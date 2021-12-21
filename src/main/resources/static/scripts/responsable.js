var conges=document.getElementsByTagName("tr");

var select =document.getElementById("select");
var search = document.getElementById("search");
console.log(conges[1].getAttribute("data-etat"));
for(var i=1;i<conges.length;i++){
	if(conges[i].getAttribute("data")!==select.value){
		conges[i].hidden=true;
	}else{
		conges[i].hidden=false;
	}
}
/*search.addEventListener("onchange",onChange);*/

select.addEventListener("click",onselect);
function onselect(){
	
		for(var i=1;i<conges.length;i++){
			if(conges[i].getAttribute("data")!==select.value){
				conges[i].hidden=true;
				//conges[i].style.display="none";
			}else{
				conges[i].hidden=false;
				//conges[i].style.display="inline";
				
	}
}
}

/*function onChange(){
	for(var i=1;i<conges.length;i++){
			if(conges[i].getAttribute("nom").indexOf(search.value)<0  || conges[i].getAttribute("data")!==select.value){
				conges[i].hidden=true;
				//conges[i].style.display="none";
			}else{
				conges[i].hidden=false;
				//conges[i].style.display="inline";
				}
	
			}
	}*/