package analisador;

/**
 *
 * @author Derby Cândido
 */
public class AtomatoOperador {
    
    //& e &&
    public void q47(String operador,int i, int linha){
        
        if( i != operador.length())
            q48(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("e bit a bit\t\t|" + operador + "\t|" + linha);
        else
            return;
        
    }
    
    private void q48(String operador, int i,int linha){
        
        int aux = i++;
        
        if(operador.charAt(1) == '&' && 2 == operador.length())
            System.out.println("e\t\t|" + operador + "\t|" + linha);

        else
            return;
    }
    
//Fim &
    
    
//| e ||
    public void q51(String operador,int i, int linha){
        
        if( i != operador.length())
            q52(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("ou bit a bit\t\t|" + operador + "\t|" + linha);
        else
            return;
        
    }
    
    private void q52(String operador, int i,int linha){
        
        int aux = i++;
        
        if(operador.charAt(1) == '|' && 2 == operador.length())
            System.out.println("ou\t\t\t|" + operador + "\t\t|" + linha);
        else
            return;
    }
    
 //Fim ||
    
    
//= e ==
    public void q21(String operador,int i, int linha){
        
        if( i != operador.length())
            q22(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("atribuicao\t\t|" + operador + "\t|" + linha);
        else
            return;
        
    }
    
    private void q22(String operador, int i,int linha){
        
        if(operador.charAt(1) == '=' && 2 == operador.length())
            System.out.println("igualdade\t\t|" + operador + "\t|" + linha);
        else
            return;
    }
    
//Fim = 
   
//? 
    public void q58(String operador,int i, int linha){
        
        if( i != operador.length())
            System.out.println("operador ternario\t\t|" + operador + "\t|" + linha);
        
        else
            return;
        
    }
    
 //Fim ?

    
//* e *=
    public void q24(String operador,int i, int linha){
        
        if( i != operador.length())
            q26(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("multiplicacao\t\t|" + operador + "\t|" + linha);
        else
            return;
        
    }
    
    private void q26(String operador, int i,int linha){
        
        int aux = i++;
        
        if(operador.charAt(1) == '=' && 2 == operador.length())
            System.out.println("mutiplicacao_atribuicao\t\t\t|" + operador + "\t\t|" + linha);
        else
            return;
    }
    
 //Fim *
 
    
//+, ++ e +=
    public void q13(String operador,int i, int linha){
        
        
        if( i != operador.length() && operador.charAt(i) == '+')
            q16(operador, i, linha);
        
        else if( i != operador.length() && operador.charAt(i) == '=')
            q15(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("soma\t\t|" + operador + "\t|" + linha);
        
        else
            return;
        
    }
    
    private void q16(String operador, int i,int linha){
        
        if(operador.charAt(1) == '+' && 2 == operador.length())
            System.out.println("incremento\t\t\t|" + operador + "\t\t|" + linha);
        else
            return;
    }
    
    private void q15(String operador, int i,int linha){
        
        int aux = i++;
        
        if(operador.charAt(1) == '=' && 2 == operador.length())
            System.out.println("soma_atribuicao\t\t\t|" + operador + "\t\t|" + linha);
        else
            return;
    }
    
 //Fim +
    
//-, -- e -=
    public void q17(String operador,int i, int linha){
        
        
        if( i != operador.length() && operador.charAt(i) == '+')
            q18(operador, i, linha);
        
        else if( i != operador.length() && operador.charAt(i) == '=')
            q20(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("subtracao\t\t|" + operador + "\t|" + linha);
        
        else
            return;
        
    }
    
    private void q18(String operador, int i,int linha){
        
        if(operador.charAt(1) == '-' && 2 == operador.length())
            System.out.println("decremento\t\t\t|" + operador + "\t\t|" + linha);
        else
            return;
    }
    
    private void q20(String operador, int i,int linha){
        
        int aux = i++;
        
        if(operador.charAt(1) == '=' && 2 == operador.length())
            System.out.println("subtracao_atribuicao\t\t\t|" + operador + "\t\t|" + linha);
        else
            return;
    }
    
 //Fim -
  
//"/" e /=
    public void q27(String operador,int i, int linha){
        
        if( i != operador.length())
            q29(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("divisao\t\t|" + operador + "\t|" + linha);
        else
            return;
        
    }
    
    private void q29(String operador, int i,int linha){
                
        if(operador.charAt(1) == '=' && 2 == operador.length())
            System.out.println("divisao_atribuicao\t\t|" + operador + "\t\t\t|" + linha);
        else
            return;
    }
    
 //Fim /
    
 //! e !=
    public void q36(String operador,int i, int linha){
        
        if( i != operador.length())
            q37(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("negacao\t\t|" + operador + "\t|" + linha);
        else
            return;
        
    }
    
    private void q37(String operador, int i,int linha){
                
        if(operador.charAt(1) == '=' && 2 == operador.length())
            System.out.println("diferente\t\t|" + operador + "\t|" + linha);
        else
            return;
    }
    
 //Fim !
    
 //< e <=
    public void q33(String operador,int i, int linha){
        
        if( i != operador.length())
            q34(operador, i, linha);
        
        else if(i == operador.length())
            System.out.println("menor\t\t\t|" + operador + "\t\t\t|" + linha);
        else
            return;
        
    }
    
    private void q34(String operador, int i,int linha){
        
        if(operador.charAt(1) == '=' && 2 == operador.length())
            System.out.println("menor_igual\t\t|" + operador + "\t|" + linha);
        else
            return;
    }
    
 //Fim <   
    
 //> e >=
    public void q30(String operador,int i, int linha){
        
        int aux = i+1;
        
        if( i != operador.length())
            q31(operador, aux, linha);
        
        else if(i == operador.length())
            System.out.println("maior\t\t\t|" + operador + "\t\t|" + linha);
        else
            return;
        
    }
    
    private void q31(String operador, int i,int linha){
        
        
        if(operador.charAt(1) == '=' && i == operador.length())
            System.out.println("maior_igual\t\t|" + operador + "\t\t\t|" + linha);
        else
            return;
    }
    
 //Fim >   
    
    
    
    
    
}
