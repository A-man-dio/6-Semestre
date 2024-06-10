

   
function calcular(){
    var num = prompt("um numero");
    var p;
    p = document.getElementById(result);

    for(var pos = 1; pos < num; i++){
        for(var i=1; i<= num;i++){
            
            document.write("<span style ='color:red'>" + i + "</span> <br/>");
        }
        
        /*if(i%2 == 0)
            document.write("<span style ='color:red'>" +  i + "</span> <br/>");
        else
            document.write("<span style ='color:green'>" +  i + "</span> <br/>");
        */
        //for(var j = 1; j <= 10; j++){        }   

    }
}
/*
<body>
    <p id ="paragrafo">
    Eu sou um paragrafo por definição
    </p>
    <input type="submit" onclick="mudar()" value="Clica-me"/>
</body>

function mudar(){

    var t = document.getElementById("paragrafo");
    t.style.color = "#60c289";
    t.style.fontSize = "25px";
    t.innerHTML = "Textoo";
}
*/

/*
var myArray = [25,25,9,41];
myArray.sort(function(a,b) {alert("A:"+a); alert("B:"+b); return a-b});

for(var i=0; i<myArray.length ; i++){
document.write(myArray[i]);
document.write("<br/>");
document.write("<hr>");

}
*/