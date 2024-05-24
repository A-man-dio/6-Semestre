package analisador;

/**
 *
 * @author Derby Cândido
 */
public class AutomatoPonto {
    
    TOKEN tkn = new TOKEN();

    
    //Comentários
    public void q7(String entrada,int i, int linha){
        
        if(i != entrada.length() && entrada.charAt(i)=='*')
            q8(entrada, i++, linha);
        else if(i != entrada.length() && entrada.charAt(i)=='/')
            q11(entrada, i++, linha);
        else
            AnalisadorL1.Analex(entrada.substring(i), 0, linha);
        
    }
    
    private void q11(String entrada, int i, int linha){
        
        while(i+1 != entrada.length() && entrada.charAt(i) != '/' && entrada.charAt(i+1) != 'n' ){
            i++;
        }
        
        if(i+2 == entrada.length() && entrada.charAt(i) == '/' && entrada.charAt(i+1) == 'n' )
            q12(entrada, i++, linha);
        else 
            AnalisadorL1.Analex(entrada.substring(i), 0, linha);
        
    } 
    
    private void q12(String entrada, int i, int linha){
        
        if(i == entrada.length() && entrada.endsWith("\n")){
         
            tkn.linha = linha;
            tkn.tipo = "Comentario";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);

        }else
            return;
        
    }
    
    private void q8(String entrada , int i, int linha){
        
        if(entrada.charAt(i)!= '*' && i != entrada.length() )
            q8(entrada, i++, linha);
        
        else if(entrada.charAt(i)== '*' && i != entrada.length() )
            q8(entrada, i++, linha);
        
        else 
            AnalisadorL1.Analex(entrada.substring(i), i, linha);
        
    }
    
    private void q9(String entrada, int i, int linha){
        
        if(entrada.charAt(i)== '*' && i != entrada.length() )
            q9(entrada, i++, linha);
        
        else if(i+2 != entrada.length() && entrada.charAt(i)!= '*' && entrada.charAt(i++) != '/' )
            q8(entrada, i, linha);
        
        else if(entrada.charAt(i) == '/')
            q10(entrada, i++, linha);
        else
            AnalisadorL1.Analex(entrada.substring(i), i, linha);
    }
    
    private void q10(String entrada, int i, int linha){
        
        if(i == entrada.length()){

            tkn.linha = linha;
            tkn.tipo = "Comentario";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);

        }else{
            
            tkn.linha = linha;
            tkn.tipo = "Comentario";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
            
            AnalisadorL1.Analex(entrada.substring(i), i, linha);
        }
    }
    
    //Fim coentário
    
    //(
    public void q43(String entrada, int i, int linha){
        
        if(i == entrada.length()){
            
            tkn.linha = linha;
            tkn.tipo = "parentesis_aberto";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
        
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "parentesis_aberto";
           tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
    //)
    public void q64(String entrada, int i, int linha){
        
        if(i == entrada.length()){
         
            
            tkn.linha = linha;
            tkn.tipo = "parentesis_fechado";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
            
        }else{

            tkn.linha = linha;
            tkn.tipo = "parentesis_aberto";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
    //;
    public void q39(String entrada, int i, int linha){
        
        if(i == entrada.length()){
         
            tkn.linha = linha;
            tkn.tipo = "ponto_virgula";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
            
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "ponto_virgula";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
    //]
    public void q49(String entrada, int i, int linha){
        
        if(i == entrada.length()){
            
            tkn.linha = linha;
            tkn.tipo = "parentesis_reto_fechado";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
            
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "parentesis_reto_fechado";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
       
    }
    
    //[
    public void q53(String entrada, int i, int linha){
        
        if(i == entrada.length()){
            
            tkn.linha = linha;
            tkn.tipo = "parentesis_reto_aberto";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
                    
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "parentesis_reto_aberto";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
    //{
    public void q45(String entrada, int i, int linha){
        
        if(i == entrada.length()){
            
            tkn.linha = linha;
            tkn.tipo = "chaveta_aberto";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "chaveta_aberto";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
    //}
    public void q62(String entrada, int i, int linha){
        
        if(i == entrada.length()){

            tkn.linha = linha;
            tkn.tipo = "chaveta_fechada";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);        
        
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "chaveta_aberto";
            tkn.token = entrada.substring(0, i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
  //"
    public void q100(String entrada, int i, int linha){
        
        if(i == entrada.length()){
            
            tkn.linha = linha;
            tkn.tipo = "virgula_alta";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "virgula_alta";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
      //,
    public void q101(String entrada, int i, int linha){
        
        if(i == entrada.length()){
            
            tkn.linha = linha;
            tkn.tipo = "virgula";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "virgula";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
      //.
    public void q102(String entrada, int i, int linha){
        
        if(i == entrada.length()){
            
            tkn.linha = linha;
            tkn.tipo = "ponto";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "ponto";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
      //'
    public void q103(String entrada, int i, int linha){
        
        if(i == entrada.length()){
            
            tkn.linha = linha;
            tkn.tipo = "plicas";
            tkn.token = entrada;
            AnalisadorL1.TOKENS.add(tkn);
        }else{
            
            tkn.linha = linha;
            tkn.tipo = "plicas";
            tkn.token = entrada.substring(0,i);
            AnalisadorL1.TOKENS.add(tkn);
            AnalisadorL1.Analex(entrada.substring(i+1), i, linha);
        }
    }
    
        
}
