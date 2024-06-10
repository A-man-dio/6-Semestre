

var mudar = document.querySelector("body");
var tam = document.querySelector(".borda");

function mudarBranco(){
    
    mudar.style.backgroundColor = "#FFF";
}

function mudarVerde(){
    mudar.style.backgroundColor = "#3b9527";
}

function mudarLaranja(){
    mudar.style.backgroundColor = "#ffac12";
}

function mudarBege(){
    mudar.style.backgroundColor = "#b67725a9";
}

function mudarTam(){
    event.preventDefault();
    if(tam.style.width == "200px")
        tam.style.width = "auto";
    else
        tam.style.width = "200px";

}

//function restaurar(){
    //tam.style.width = "auto";
//}

