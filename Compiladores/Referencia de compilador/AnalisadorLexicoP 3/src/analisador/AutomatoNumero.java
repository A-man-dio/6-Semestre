package analisador;

/**
 *
 * @author Derby Cândido
 */
public class AutomatoNumero {
    
    public void q3(String numero, int i,int linha){

        
        while(( i!= numero.length() ) && (numero.charAt(i) == '0' || numero.charAt(i) == '1' || numero.charAt(i) == '2' || numero.charAt(i) == '3' || numero.charAt(i) == '4' || numero.charAt(i) == '5' || numero.charAt(i) == '6' || numero.charAt(i) == '7' || numero.charAt(i) == '8' || '9' == numero.charAt(i))){
            i++;
        }
        if(i == numero.length()){
            System.out.println("Numero\t\t\t|" + numero + "\t\t\t|" + linha);
        
        }else if(i != numero.length() && numero.charAt(i)== '.'){
            q5(numero, i,linha);
            
        }else{    
            return ;
        }
        return;
        
    }

    public void q46(String numero,int i, int linha){
        
        
        if((i != numero.length() ) && numero.charAt(i) == '0' || numero.charAt(i) == '1' || numero.charAt(i) == '2' || numero.charAt(i) == '3' || numero.charAt(i) == '4' || numero.charAt(i) == '5' || numero.charAt(i) == '6' || numero.charAt(i) == '7' || numero.charAt(i) == '8' || '9' == numero.charAt(i))
            q3(numero, i++, linha);
        
        else
            return;
        
    }
    
    private void q5(String numero, int i,int linha){
        
        i++;
        if(i != numero.length() && numero.charAt(i) == '0' || numero.charAt(i) == '1' || numero.charAt(i) == '2' || numero.charAt(i) == '3' || numero.charAt(i) == '4' || numero.charAt(i) == '5' || numero.charAt(i) == '6' || numero.charAt(i) == '7' || numero.charAt(i) == '8' || '9' == numero.charAt(i))
            q6(numero, i++, linha);
        
        else{
            return ;
        }
        return;
    
    }
 
    private void q6(String numero, int i,int linha){

        
        while(( i!= numero.length() ) && (numero.charAt(i) == '0' || numero.charAt(i) == '1' || numero.charAt(i) == '2' || numero.charAt(i) == '3' || numero.charAt(i) == '4' || numero.charAt(i) == '5' || numero.charAt(i) == '6' || numero.charAt(i) == '7' || numero.charAt(i) == '8' || '9' == numero.charAt(i))){
            i++;
        }        
        
        if(i == numero.length()){
            System.out.println("Numero\t\t\t|" + numero + "\t\t\t|" + linha);
        
        }else{ 
            return;
        }
        return;
        
    }
    
}