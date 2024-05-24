package analisador;

/**
 *
 * @author Derby Cândido
 */
public class AtomatoOperador {

    
    TOKEN tkn = new TOKEN();

    //& e &&
    public void q47(String operador, int i, int linha) {

        if (i != operador.length()) {
            q48(operador, i, linha);
        } else {
            tkn.linha = linha;
            tkn.tipo = "selecaooperador";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

    private void q48(String operador, int i, int linha) {

        if (operador.charAt(1) == '&' && 2 == operador.length()) {
            tkn.linha = linha;
            tkn.tipo = "selecaooperador";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        } else if (operador.charAt(1) == '&' && operador.length() > 2) {
            tkn.linha = linha;
            tkn.tipo = "selecaooperador";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), 0, linha);
        }
    }

//Fim &
//| e ||
    public void q51(String operador, int i, int linha) {

        if (i != operador.length()) {
            q52(operador, i++, linha);
        } else {
            tkn.linha = linha;
            tkn.tipo = "selecaooperador";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

    private void q52(String operador, int i, int linha) {

        if (operador.charAt(1) == '|' && 2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "selecaooperador";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        } else if (operador.charAt(1) == '&' && operador.length() > 2) {

            tkn.linha = linha;
            tkn.tipo = "selecaooperador";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), 0, linha);
        }
    }

    //Fim ||
//= e ==
    public void q21(String operador, int i, int linha) {

        if (i != operador.length()) {
            q22(operador, i++, linha);
        } else {

            tkn.linha = linha;
            tkn.tipo = "atribuicao";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

    private void q22(String operador, int i, int linha) {

        if (operador.charAt(1) == '=' && 2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "igualdade";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);

        } else if (operador.charAt(1) == '=' && 2 != operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "igualdade";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), 0, linha);

            AnalisadorL1.Analex(operador.substring(2), i, linha);

        } else if (operador.charAt(1) != '=') {

            tkn.linha = linha;
            tkn.tipo = "atribuicao";
            tkn.token = operador.substring(0, 1);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(1), 0, linha);

            System.out.println("atribuicao\t\t|" + operador.substring(0, 1) + "\t|" + linha);
            AnalisadorL1.Analex(operador.substring(1), i, linha);

        } else {

            tkn.linha = linha;
            tkn.tipo = "atribuicao";
            tkn.token = operador.substring(0, 1);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(1), 0, linha);

        }
    }

//Fim = 
//? 
    public void q58(String operador, int i, int linha) {

        if (i != operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "operador";
            tkn.token = operador.substring(0, 1);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(1), 0, linha);

        } else {

            tkn.linha = linha;
            tkn.tipo = "operador";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

    //Fim ?
//* e *=
    public void q24(String operador, int i, int linha) {

        if (i != operador.length()) {
            q26(operador, i, linha);
        } else {

            tkn.linha = linha;
            tkn.tipo = "multiplicacao";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        }

    }

    private void q26(String operador, int i, int linha) {

        if (operador.charAt(1) == '=' && 2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "atribuicao_multiplicacao";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        } else if (operador.charAt(1) == '=' && 2 != operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "atribuicao_multiplicacao";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);

        } else if (operador.charAt(1) != '=') {

            tkn.linha = linha;
            tkn.tipo = "multiplicacao";
            tkn.token = operador.substring(0, 1);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(1), i, linha);

        }
    }

    //Fim *
//+, ++ e +=
    public void q13(String operador, int i, int linha) {

        if (i != operador.length() && operador.charAt(i) == '+') {
            q16(operador, i, linha);
        } else if (i != operador.length() && operador.charAt(i) == '=') {
            q15(operador, i, linha);
        } else if (1 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "soma";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        }

    }

    private void q16(String operador, int i, int linha) {

        if (2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "incremento";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        } else {
            tkn.linha = linha;
            tkn.tipo = "incremento";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);
        }
    }

    private void q15(String operador, int i, int linha) {

        if (2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "atribuicao_soma";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        } else {

            tkn.linha = linha;
            tkn.tipo = "atribuicao soma";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);
        }
    }
    //Fim +

//-, -- e -=
    public void q17(String operador, int i, int linha) {

        if (i != operador.length() && operador.charAt(i) == '-') {
            q20(operador, i, linha);
        } else if (i != operador.length() && operador.charAt(i) == '=') {
            q18(operador, i, linha);
        } else if (i == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "subtracao";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        }
    }

    private void q18(String operador, int i, int linha) {

        if (2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "atribuicao_subtracao";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        } else {

            tkn.linha = linha;
            tkn.tipo = "atribuicao_subtracao";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);
        }

    }

    private void q20(String operador, int i, int linha) {

        if (2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "decremento";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        } else {

            tkn.linha = linha;
            tkn.tipo = "decremento";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);
        }
    }
    //Fim -

// / e /=
    public void q27(String operador, int i, int linha) {

        if (i != operador.length()) {
            q29(operador, i, linha);
        } else {

            tkn.linha = linha;
            tkn.tipo = "divisao";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

    private void q29(String operador, int i, int linha) {

        if (operador.charAt(1) == '=' && 2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "atribuicao_divisao";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        } else if (operador.charAt(1) == '=' && 2 != operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "atribuicao_divisao";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);

        } else if (operador.charAt(1) != '=') {

            tkn.linha = linha;
            tkn.tipo = "divisao";
            tkn.token = operador.substring(0, 1);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(1), i, linha);
        }
    }

    //Fim /
    //! e !=
    public void q36(String operador, int i, int linha) {

        if (i != operador.length()) {
            q37(operador, i, linha);
        } else {
            tkn.linha = linha;
            tkn.tipo = "negacao";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

    private void q37(String operador, int i, int linha) {

        if (operador.charAt(1) == '=' && 2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "diferente";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        } else if (operador.charAt(1) == '=' && 2 != operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "diferente";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);

        } else if (operador.charAt(1) != '=') {

            tkn.linha = linha;
            tkn.tipo = "negacao";
            tkn.token = operador.substring(0, 1);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(1), i, linha);

        }
    }

    //Fim !
    //< e <=
    public void q33(String operador, int i, int linha) {

        if (i != operador.length()) {
            q34(operador, i, linha);
        } else {

            tkn.linha = linha;
            tkn.tipo = "menor";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

    private void q34(String operador, int i, int linha) {

        if (operador.charAt(1) == '=' && 2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "menor_igual";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        } else if (operador.charAt(1) == '=' && 2 != operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "menor_igual";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);

        } else if (operador.charAt(1) != '=') {

            tkn.linha = linha;
            tkn.tipo = "menor";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(1), i, linha);
        }
    }

    //Fim <   
    //> e >=
    public void q30(String operador, int i, int linha) {

        int aux = i + 1;

        if (i != operador.length()) {
            q31(operador, aux, linha);
        } else {

            tkn.linha = linha;
            tkn.tipo = "menor_igual";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

    private void q31(String operador, int i, int linha) {

        if (operador.charAt(1) == '=' && 2 == operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "maior_igual";
            tkn.token = operador;
            AnalisadorL1.TOKENS.add(tkn);

        } else if (operador.charAt(1) == '=' && 2 != operador.length()) {

            tkn.linha = linha;
            tkn.tipo = "maior_igual";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(2), i, linha);

        } else if (operador.charAt(1) != '=') {

            tkn.linha = linha;
            tkn.tipo = "maior";
            tkn.token = operador.substring(0, 2);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(operador.substring(1), i, linha);
        }

    }

    //Fim >   
}
