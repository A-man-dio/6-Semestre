
var m1 = document.getElementById("mouseOverMe1");
var m2 = document.getElementById("mouseOverMe2");
var m3 = document.getElementById("mouseOverMe3");
var m4 =document.querySelector("#mouseOverMe4");
var numero = 0;
var numero1 = 0;
var numero2 = 0;
var num3 =0;


function onMouseMove(){
    ++numero;
    m1.innerHTML = numero;
    
}

function onMouseEnter(){
    ++numero1;
    m2.innerHTML = numero1;

}

function onMouseOver(){
    ++numero2;
    m3.innerHTML = numero2;

}
function onMouseLeave(){
    num3++;
    m4.innerHTML= num3;
}

