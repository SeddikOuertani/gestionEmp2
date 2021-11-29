inpList = document.getElementById("tbodyPermList").children;


for(i = 0; i<inpList.length; i++){
    if(inpList[i].id == "true"){
        inpList[i].style.backgroundColor = "#c6d6cc";
    }else{
        inpList[i].style.backgroundColor = "#d6c6c6";
    }
}