var dateDebut = document.getElementById("dateDebut");
var dateFin = document.getElementById("dateFin");
var message2= document.getElementById("error2");
var message1=document.getElementById("error1");

var button=document.getElementById("submit");
var DateDebut =new Date();
var DateFin = new Date();
var form = document.getElementsByTagName("form")[0];


form.addEventListener("submit",(e)=>{
    DateDebut = new Date(dateDebut.value);
   	DateFin = new Date(dateFin.value); 
        console.log(DateDebut);
        console.log(dateFin.value);
        
        if(dateDebut.value==""){
			e.preventDefault();
            message1.innerHTML="remplir la champ date debut";
            dateDebut.classList.add("is-invalid");
	}
	else{
		dateDebut.classList.remove("is-invalid");
		dateDebut.classList.add("is-valid");
	}
	
 if(dateFin.value==""){
			e.preventDefault();
            message2.innerHTML="remplir la champ date fin";
            dateFin.classList.add("is-invalid");
}      else if(DateFin.getTime()<DateDebut.getTime()){
            e.preventDefault();
            message2.innerHTML="la date de fin doit etre superieur a la date de debut";
            dateFin.classList.add("is-invalid");
            dateFin.classList.remove("is-valid");   
        }
    else{
	dateFin.classList.remove("is-invalid");
	dateFin.classList.add("is-valid");
}
});


