login = document.getElementById("login");
pwd = document.getElementById("mdp");

[login,pwd].map((elem, i)=>{
    errTextList = document.getElementsByClassName('text-err');
    elem.addEventListener('blur',()=>{
        if(elem.value == ""){
            if(i == 0){
                errTextList[0].innerText = "Nom d'utilisateur doit être saisie !";
            }else{
                errTextList[1].innerText = "Mot de passe doit être saisie !";
            }
            elem.classList.add('inp-danger');
            return false;
        }else{
            errTextList[i].innerText = "Valid !";
            errTextList[i].style.color = "rgb(67, 253, 83)";
            elem.classList.add('inp-success');
            return true;
        }
    })
})