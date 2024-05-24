package analisador;

/**
 *
 * @author Derby Cândido
 */
public class AutomatoPonto {
    
    //Comentários
    public void q7(String entrada,int i, int linha){
        
        if(i != entrada.length() && entrada.charAt(i)=='*')
            q8(entrada, i++, linha);
        else if(i != entrada.length() && entrada.charAt(i)=='/')
            q11(entrada, i++, linha);
        else
            return;
        
    }
    
    private void q11(String entrada, int i, int linha){
        
        if(i+1 != entrada.length() && entrada.charAt(i) != '/' && entrada.charAt(i++) != 'n' )
            q11(entrada, i, linha);
        
        else if(i+2 == entrada.length() && entrada.charAt(i) == '/' && entrada.charAt(i++) == 'n' )
            q12(entrada, i, linha);
        else 
            return;
        
    } 
    
    private void q12(String entrada, int i, int linha){
        
        if(i == entrada.length() && entrada.endsWith("\n"))
            System.out.println("comentario_curto\t\t|"+entrada+"\t|"+linha);
        else
            return;
        
    }
    
    private void q8(String entrada , int i, int linha){
        
        if(entrada.charAt(i)!= '*' && i != entrada.length() )
            q8(entrada, i++, linha);
        
        else if(entrada.charAt(i)== '*' && i != entrada.length() )
            q8(entrada, i++, linha);
        
        else return;
        
    }
    
    private void q9(String entrada, int i, int linha){
        
        if(entrada.charAt(i)== '*' && i != entrada.length() )
            q9(entrada, i++, linha);
        
        else if(i+2 != entrada.length() && entrada.charAt(i)!= '*' && entrada.charAt(i++) != '/' )
            q8(entrada, i, linha);
        
        else if(entrada.charAt(i) == '/' && i++ == entrada.length())
            q10(entrada, i, linha);
        else
            return;
    }
    
    private void q10(String entrada, int i, int linha){
        
        if(i == entrada.length())
            System.out.println("comentario_longo\t\t|"+entrada+"\t|"+linha);
        else
            return;
        
    }
    
    //Fim coentário
    
    //(
    public void q43(String entrada, int i, int linha){
        
        if(i == entrada.length())
            System.out.println("parentesis_aberto\t\t|"+entrada+"\t|"+linha);
        
       else
            return;
        
    }
    
    //)
    public void q64(String entrada, int i, int linha){
        
        if(i == entrada.length())
            System.out.println("parentesis_fechado\t\t|"+entrada+"\t|"+linha);
        
       else
            return;
       
    }
    
    //;
    public void q39(String entrada, int i, int linha){
        
        if(i == entrada.length())
            System.out.println("ponto_virgula\t\t|"+entrada+"\t|"+linha);
        
       else
            return;
       
    }
    
    //]
    public void q49(String entrada, int i, int linha){
        
        if(i == entrada.length())
            System.out.println("parentesis_retoa_fechado\t\t|"+entrada+"\t|"+linha);
        
       else
            return;
       
    }
    
    //[
    public void q53(String entrada, int i, int linha){
        
        if(i == entrada.length())
            System.out.println("parentesis_retos_abertos\t\t|"+entrada+"\t|"+linha);
        
       else
            return;
       
    }
    
    //{
    public void q45(String entrada, int i, int linha){
        
        if(i == entrada.length())
            System.out.println("chaveta_aberta\t\t|"+entrada+"\t|"+linha);
        
       else
            return;
       
    }
    
    //}
    public void q62(String entrada, int i, int linha){
        
        if(i == entrada.length())
            System.out.println("chaveta_fechada\t\t|"+entrada+"\t|"+linha);
        
       else
            return;
       
    }
    
}
