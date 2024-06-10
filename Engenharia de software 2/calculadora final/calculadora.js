// script da calculadora


var historico = []; // Array para armazenar o histórico de cálculos
var erro;

window.onload = function () {
    var storedHistorico = sessionStorage.getItem('historico');
    if (storedHistorico) {
        historico = JSON.parse(storedHistorico);
    }
};



function addToDisplay(value) {
    //document.getElementById('display').value += value;
    if (erro) {
        clearDisplay();
        erro = false;
    }
    document.getElementById('display').value += value;
}

function clearDisplay() {
    document.getElementById('display').value = '';
}

function deleteLastChar() {
    var currentValue = document.getElementById('display').value;
    document.getElementById('display').value = currentValue.slice(0, -1);
}

function calculateResult() {
    var expression = document.getElementById('display').value;
    expression = expression.replace(/\^/g, '**');
    expression = expression.replace(/x/g, '*');
    try {
        var result = eval(expression); // Avalia a expressão
        result = ((result == Infinity) || (isNaN(result))) ? 'Erro' : result;
        document.getElementById('display').value = result;
        expression = expression.replace(/\*\*/g, '^');
        historico.push(expression + ' = ' + result); // Adiciona a expressão e o resultado ao histórico
        sessionStorage.setItem('historico', JSON.stringify(historico));
    } catch (error) {
        erro = true;
        document.getElementById('display').value = 'Erro';
    }
}

function showHistorico() {

    if (historico.length == 0) {
        var historicoStr = historico.join('\n'); // Concatena os itens do histórico separados por quebra de linha
        alert('Histórico de Cálculos:\n\n' + historicoStr); // Exibe o histórico em um alerta
    } else {
        var historicoStr = historico.join('\n'); // Concatena os itens do histórico separados por quebra de linha
        alert('Histórico de Cálculos:\n\n' + historicoStr); // Exibe o histórico em um alerta
    }



}

function calcularSeno() {
    
    var valor = parseFloat(document.getElementById('display').value);
    if(!valor == ''){
            var resultado = Math.sin((valor * Math.PI) / 180); // Converter graus para radianos
            document.getElementById('display').value = resultado.toFixed(3); // Limitar o número de casas decimais
            historico.push('Sen(' + valor + ') = ' + resultado); // Adiciona a expressão e o resultado ao histórico
            sessionStorage.setItem('historico', JSON.stringify(historico));
    }else{
        erro = true;
        document.getElementById('display').value = "Erro"; 
    }
}

function calcularCosseno() {
       
    var valor = parseFloat(document.getElementById('display').value);
    if(!valor == ''){     
            var resultado = Math.cos(valor * Math.PI / 180); // Converte para radianos e calcula o cosseno
            document.getElementById('display').value = resultado.toFixed(3); // Limita o número de casas decimais
            historico.push('Cos(' + valor + ') = ' + resultado); // Adiciona a expressão e o resultado ao histórico
            sessionStorage.setItem('historico', JSON.stringify(historico));
    }else{
        erro = true;
        document.getElementById('display').value = "Erro"; 
    } 
}

function calcularTangente() {
    
    var valor = parseFloat(document.getElementById('display').value);
    if(!valor == ''){
        var resultado = Math.sin((valor * Math.PI) / 180) / Math.cos(valor * Math.PI / 180); // Calcula a tangente com a fórmula sen/cos
        document.getElementById('display').value = resultado.toFixed(3); // Limita o número de casas decimais
        historico.push('Tag(' + valor + ') = ' + resultado); // Adiciona a expressão e o resultado ao histórico
        sessionStorage.setItem('historico', JSON.stringify(historico));
    }else{
        erro = true;
        document.getElementById('display').value = "Erro"; 
    }
}

function calcularLog() {
    
        var valor = parseFloat(document.getElementById('display').value);
    if(!valor == ''){
        if (valor > 0) {
            var resultado = Math.log10(valor); // Calcula o logaritmo na base 10
            document.getElementById('display').value = resultado.toFixed(3); // Limita o número de casas decimais
            historico.push('Log(' + valor + ') = ' + resultado); // Adiciona a expressão e o resultado ao histórico
            sessionStorage.setItem('historico', JSON.stringify(historico));
        } else {
            erro = true;
            document.getElementById('display').value = "Erro"; // Exibe "Erro" se o valor for inválido para o logaritmo
        }
    }else{
        erro = true;
        document.getElementById('display').value = "Erro"; 
    }
}

function calcularRaizQuadrada() {
    var valor = parseFloat(document.getElementById('display').value);
    if(!valor == ''){
        if (valor >= 0) {
            var resultado = Math.sqrt(valor); // Calcula a raiz quadrada
            document.getElementById('display').value = resultado.toFixed(1); // Limita o número de casas decimais
            historico.push('√' + valor + ' = ' + resultado); // Adiciona a expressão e o resultado ao histórico
            sessionStorage.setItem('historico', JSON.stringify(historico));
        } else {
            erro = true;
            document.getElementById('display').value = "Erro"; // Exibe "Erro" se o valor for negativo para a raiz quadrada
        }
    } else {
        erro = true;
        document.getElementById('display').value = "Erro"; 
    }
}


//Conversor

function calcularComprimento() {
    var expression = document.getElementById('display');
    var valor = document.getElementById('campoTexto');


    if (isNaN(valor.value)) {
        expression.value = 'Erro';
    } else {

        var opcaoInicial = document.getElementById('opcoesIniciais');
        var opcaoFinal = document.getElementById('opcoesFinais');

        const fatores = {
            'km': 1000,
            'hm': 100,
            'dam': 10,
            'm': 1,
            'dm': 0.1,
            'cm': 0.01,
            'mm': 0.001,
            //
            'kmi': 1000,
            'hmi': 100,
            'dami': 10,
            'mi': 1,
            'dmi': 0.1,
            'cmi': 0.01,
            'mmi': 0.001
        };


        const valorEmMetros = valor.value * fatores[opcaoInicial.value];

        // Converte para a unidade desejada
        const valorConvertido = valorEmMetros / fatores[opcaoFinal.value];

        expression.value = valorConvertido;
        historico.push(opcaoInicial.value + ' - ' + opcaoFinal.value + ' = ' + valorConvertido); // Adiciona a expressão e o resultado ao histórico
        sessionStorage.setItem('historico', JSON.stringify(historico));

    }
}



function calcularPeso() {
    var expression = document.getElementById('display');
    var valor = document.getElementById('campoTexto');


    if (isNaN(valor.value)) {
        expression.value = 'Erro';
    } else {

        var opcaoInicial = document.getElementById('opcoesIniciais');
        var opcaoFinal = document.getElementById('opcoesFinais');

        const fatores = {
            'kg': 1000,
            'hg': 100,
            'dag': 10,
            'g': 1,
            'dg': 0.1,
            'cg': 0.01,
            'mg': 0.001,
            //
            'kgi': 1000,
            'hgi': 100,
            'dagi': 10,
            'mgi': 1,
            'dgi': 0.1,
            'cgi': 0.01,
            'mgi': 0.001
        };


        const valorEmGramas = valor.value * fatores[opcaoInicial.value];

        // Converte para a unidade desejada
        const valorConvertido = valorEmGramas / fatores[opcaoFinal.value];

        expression.value = valorConvertido;
        historico.push(opcaoInicial.value + ' - ' + opcaoFinal.value + ' = ' + valorConvertido); // Adiciona a expressão e o resultado ao histórico
        sessionStorage.setItem('historico', JSON.stringify(historico));
    }
}

