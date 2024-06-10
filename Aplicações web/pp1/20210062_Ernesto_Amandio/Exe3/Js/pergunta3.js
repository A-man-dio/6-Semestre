function calcular(){
    var sal = document.getElementById('dado').value;
    var nSal;
    var per;
    var txt =  document.getElementById('form');
    
    if(sal == "" ){
        txt.innerHTML += " <span id='aviso'>* campo obrigatorio </span>";
    }else 
    if(sal < 1 ||isNaN(sal)){
        txt.innerHTML += " <span id='aviso'>* insira um salário válido </span>";
    }
    else{

        if(sal <= 100000){
            //+20%
            nSal= Number.parseInt( sal + sal*0.20);
            per="20";
        }
        else if(sal > 100000 && sal <= 200000){
            //+15% 
            nSal= Number.parseInt(sal + sal*0.15);
            per="15";
        }
        else if(sal > 200000 && sal <= 350000){
            //+10% 
            nSal= Number.parseInt(sal + sal*0.1);
            per="10";
        }
        else{
            //+5% 
            nSal= Number.parseInt(sal + sal*0.05);
            per="5";
        }

        document.getElementById('p1').innerHTML += " "+ Number.parseInt(sal);
        document.getElementById('p2').innerHTML += " "+ per + "%";
        document.getElementById('p3').innerHTML += " "+ sal* Number.parseInt(per)/100;
        document.getElementById('p4').innerHTML += Number.parseInt(nSal);


    }  
    
}