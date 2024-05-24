// script da calculadora

var historico = []; // Array para armazenar o histórico de cálculos

var erro;
function addToDisplay(value) {
    //document.getElementById('display').value += value;
    if(erro){
        clearDisplay();
        erro = false;
    }
    document.getElementById('display').value += value;
}

//---------------------------------------
function convertTemperatura(){

    

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
        document.getElementById('display').value = result;
        historico.push(expression + ' = ' + result); // Adiciona a expressão e o resultado ao histórico
    } catch (error) {
        erro = true;
        document.getElementById('display').value = 'Erro';
    }
}

function showHistorico() {
    var historicoStr = historico.join('\n'); // Concatena os itens do histórico separados por quebra de linha
    alert('Histórico de Cálculos:\n\n' + historicoStr); // Exibe o histórico em um alerta
}

function calcularSeno() {
    var valor = parseFloat(document.getElementById('display').value);
    var resultado = Math.sin((valor * Math.PI) / 180); // Converter graus para radianos
    document.getElementById('display').value = resultado.toFixed(8); // Limitar o número de casas decimais
}

function calcularCosseno() {
    var valor = parseFloat(document.getElementById('display').value);
    var resultado = Math.cos(valor * Math.PI / 180); // Converte para radianos e calcula o cosseno
    document.getElementById('display').value = resultado.toFixed(8); // Limita o número de casas decimais
}

function calcularTangente() {
    var valor = parseFloat(document.getElementById('display').value);
    var resultado = Math.sin((valor * Math.PI) / 180) / Math.cos(valor * Math.PI / 180); // Calcula a tangente com a fórmula sen/cos
    document.getElementById('display').value = resultado.toFixed(8); // Limita o número de casas decimais
}

function calcularLog() {
    var valor = parseFloat(document.getElementById('display').value);
    if (valor > 0) {
        var resultado = Math.log10(valor); // Calcula o logaritmo na base 10
        document.getElementById('display').value = resultado.toFixed(8); // Limita o número de casas decimais
    } else {
        erro = true;
        document.getElementById('display').value = "Erro"; // Exibe "Erro" se o valor for inválido para o logaritmo
    }
}

function calcularRaizQuadrada() {
    var valor = parseFloat(document.getElementById('display').value);
    if (valor >= 0) {
        var resultado = Math.sqrt(valor); // Calcula a raiz quadrada
        document.getElementById('display').value = resultado.toFixed(8); // Limita o número de casas decimais
    } else {
        erro = true;
        document.getElementById('display').value = "Erro"; // Exibe "Erro" se o valor for negativo para a raiz quadrada
    }
}

/*
function calcularPotencia(event) {
    event.preventDefault(); // Impede o comportamento padrão do formulário
    
    var expressao = document.getElementById('display').value;
    
    // Verificar se a expressão contém o operador "^"
    if (expressao.includes('^')) {
        var partes = expressao.split('^');
        
        // Verificar se a expressão contém dois operandos para a potência
        if (partes.length === 2) {
            var base = parseFloat(partes[0]);
            var expoente = parseFloat(partes[1]);
            var resultado = Math.pow(base, expoente); // Calcular a potência
            document.getElementById('display').value = resultado.toFixed(8); // Exibir o resultado no campo de entrada
        } else {
            document.getElementById('display').value = "Erro"; // Exibir "Erro" se a expressão estiver incorreta
        }
    } else {
        document.getElementById('display').value = "Erro"; // Exibir "Erro" se o operador "^" não estiver presente na expressão
    }
}
*/