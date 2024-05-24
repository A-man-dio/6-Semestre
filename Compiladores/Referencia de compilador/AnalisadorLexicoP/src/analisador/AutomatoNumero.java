package analisador;

/**
 *
 * @author Derby Cândido
 */
public class AutomatoNumero {
    
    TOKEN tkn = new TOKEN();
    
    public void q3(String numero, int i,int linha){

        
        while(( i!= numero.length() ) && (numero.charAt(i) == '0' || numero.charAt(i) == '1' || numero.charAt(i) == '2' || numero.charAt(i) == '3' || numero.charAt(i) == '4' || numero.charAt(i) == '5' || numero.charAt(i) == '6' || numero.charAt(i) == '7' || numero.charAt(i) == '8' || '9' == numero.charAt(i))){
            i++;
        }
        if(i == numero.length()){
            System.out.println("Numero\t\t\t|" + numero + "\t\t\t|" + linha);
            tkn.linha = linha;
            tkn.tipo = "Int";
            tkn.token = numero;
            AnalisadorL1.TOKENS.add(tkn);
            
        }else if(i != numero.length() && numero.charAt(i)== '.'){
            q5(numero, i,linha);
            
        }else{   
            System.out.println("Numero\t\t\t|"+numero.substring(0, i)+"\t\t\t"+linha);
            tkn.linha = linha;
            tkn.tipo = "Int";
            tkn.token = numero.substring(0, i);
            AnalisadorL1.TOKENS.add(tkn);
         }
        
        
    }
 
    private void q5(String numero, int i,int linha){
        
        i++;
        
        if(i != numero.length() && numero.charAt(i) == '0' || numero.charAt(i) == '1' || numero.charAt(i) == '2' || numero.charAt(i) == '3' || numero.charAt(i) == '4' || numero.charAt(i) == '5' || numero.charAt(i) == '6' || numero.charAt(i) == '7' || numero.charAt(i) == '8' || '9' == numero.charAt(i))
            q6(numero, i++, linha);
        
        else{
            System.out.println("Numero\t\t\t|"+numero.substring(0, i)+"\t\t\t"+linha);
            tkn.linha = linha;
            tkn.tipo = "Int";
            tkn.token = numero.substring(0, i);
            AnalisadorL1.TOKENS.add(tkn);
       }
        
     
    }
 
    private void q6(String numero, int i,int linha){

        
        while(( i!= numero.length() ) && (numero.charAt(i) == '0' || numero.charAt(i) == '1' || numero.charAt(i) == '2' || numero.charAt(i) == '3' || numero.charAt(i) == '4' || numero.charAt(i) == '5' || numero.charAt(i) == '6' || numero.charAt(i) == '7' || numero.charAt(i) == '8' || '9' == numero.charAt(i))){
            i++;
        }        
        
        if(i == numero.length()){
            tkn.linha = linha;
            tkn.tipo = "Int";
            tkn.token = numero;
            AnalisadorL1.TOKENS.add(tkn);

        }else{
            tkn.linha = linha;
            tkn.tipo = "Int";
            tkn.token = numero.substring(0, i);
            AnalisadorL1.TOKENS.add(tkn);

        }         
        

    }
    
}