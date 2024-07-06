/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisadorSintatico;

import AnalisadorLexico.EnumTokens;
import AnalisadorLexico.Lexema;
import AnalisadorLexico.Main;
import java.util.ArrayList;

/**
 *
 * @author ernestoamandio
 */
public class Sintatico {
    
    private ArrayList<String> erros;
    private ArrayList<Lexema> inputLexemas;
    private ArrayList<TabelaSintatico> tabela;
    private boolean inside;
    private String auxTp,auxId;
    private int i,j;
    private Lexema lexema;
    
    public Sintatico(){
        this.inputLexemas = Main.analex();
        this.tabela = new ArrayList<TabelaSintatico>();
        this.erros = new ArrayList<String>();
        this.i = 0;
        this.j = 0;
        lexema = inputLexemas.get(i);

        programa();
    }
    
    public boolean incrementeI(){
        if(i<this.inputLexemas.size()-1){
            i++;
            
            lexema = inputLexemas.get(i);
            return true;
        }
        return false;
    }
    
    public void programa(){
        decl_list();
    } 
    
    public void decl_list(){
        decl();
    } 
    
    public void decl(){
        if(type_spec()){
            //verificar incremento
            this.incrementeI();
            
            if(lexema.getToken() == EnumTokens.TOKEN_ID.getValor()){
                auxId = lexema.getLexema();
                //verificar incremento
                
                this.incrementeI();
                //int a ?
                decl_1();
            }
            else erros.add("esperava encontrar um ID na linha:" + lexema.getLinha());
            //---------------------------goto avancar
        }
    }
    
    public boolean type_spec(){
        
        if(lexema.getToken() == EnumTokens.TOKEN_INT.getValor() 
            || lexema.getToken() == EnumTokens.TOKEN_FLOAT.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_DOUBLE.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_VOID.getValor()){
                //armazena o tipo
                auxTp = lexema.getToken();
                
                return true;
            }
        
        return false;
    }
    
    public void decl_1(){
        if(lexema.getToken() == EnumTokens.TOKEN_APT.getValor() )
        {
            func_decl();
        }
        else if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_APTR.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_EQ.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_VG.getValor())
        {
            var_decl();
        }
        else {
            erros.add("declaração incompleta na linha:" + lexema.getLinha());
        }
    }
    
    public void func_decl(){
        Funcao fun = new Funcao();
        TabelaSintatico a = new TabelaSintatico();
        a.setIsVar(false);
        fun.setNome(auxId);
        fun.setTipo(auxTp);
        
        
    }
    
    public void var_decl(){
        Variavel var = new Variavel();
        TabelaSintatico a = new TabelaSintatico();
        a.setIsVar(true);
        var.setNome(auxId);
        var.setTipo(auxTp);
        
        if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor()){
            a.setVariavel(var);
            this.tabela.add(a);
        }
        else if(lexema.getToken() == EnumTokens.TOKEN_EQ.getValor()){
            //verificar incremento
            incrementeI();
            if(lexema.getToken() == EnumTokens.TOKEN_NUD.getValor()
              ||lexema.getToken() == EnumTokens.TOKEN_NUI.getValor()
              ||lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
              ||lexema.getToken() == EnumTokens.TOKEN_CHARCC.getValor()
              ){
                var.setValor(lexema.getLexema());
            a.setVariavel(var);
            this.tabela.add(a);
            //verificar incremento
            incrementeI();
            if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor())
            {
                
            }
            else erros.add("Esperava um ; na linha: "+lexema.getLinha());
            //else avancar pro erro--------------------------------------
            }else erros.add("Esperava um valor na linha: "+lexema.getLinha());//receber um id            
        }
        else if (lexema.getToken() == EnumTokens.TOKEN_VG.getValor()){
            //verificar incremento
            incrementeI();
            if(lexema.getToken() == EnumTokens.TOKEN_ID.getValor()){
                auxId =lexema.getLexema();
                if(incrementeI())
                var_decl();
                else erros.add("declaração de variaveis multiplas incompleta na linha: "+lexema.getLinha()+" esperava um ;");
            }
            else erros.add("esperava encontrar um id na linha: "+lexema.getLinha());
        }
        else erros.add("declaração incompleta na linha:"+lexema.getLinha());
    }
    
    public void analisador(){
        
        
        for(; this.i < this.inputLexemas.size();this.i++){
            
            lexema = inputLexemas.get(i);
            //verifica se tem declaração
            if(lexema.getToken() == EnumTokens.TOKEN_INT.getValor() 
            || lexema.getToken() == EnumTokens.TOKEN_FLOAT.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_DOUBLE.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_VOID.getValor()){
                //armazena o tipo
                auxTp = lexema.getToken();
                decl(lexema);
            }
        }  
    }
    
    public void decl(Lexema lexema){
        
            incrementeI();
            lexema=inputLexemas.get(i);
            //a seguir deve ter um id
            if(lexema.getToken() == EnumTokens.TOKEN_ID.getValor()){
                //armazena id
                auxId=lexema.getLexema();
                
               decl_1(lexema);
            } else System.out.println("esperava por um ID na linha:" + lexema.getLinha());
        
    }
    
    public void decl_1(Lexema lexema){
        
        incrementeI();
        lexema=inputLexemas.get(i);
        //verifica se é pra declarar função ou variavel
            if(lexema.getToken() == EnumTokens.TOKEN_APT.getValor()){
               
                if(!inside){
                    incrementeI();
                    fun_decl(lexema);
                }else System.out.println("Não é possivel declarar uma função dentro de outra função");
//else declarar funcao dentro de outra funcao
            }
            else if((lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor() //cria a var
                 || lexema.getToken() == EnumTokens.TOKEN_APTR.getValor() //cria vetor
                 || lexema.getToken() == EnumTokens.TOKEN_EQ.getValor()   //cria com atribuicao
                 || lexema.getToken() == EnumTokens.TOKEN_VG.getValor())){ //criação multipla
               
                var_decl(lexema);
               
            }
            else System.out.println("Esperava \"(\" ou \";\" ou \"[\" ou \"=\" ou \",\" na linha:"+ lexema.getLinha());
        
    }
    
    public void fun_decl(Lexema lexema){
        lexema = this.inputLexemas.get(i);
        TabelaSintatico element = new TabelaSintatico();
        
        element.getFuncao().setNome(auxId);
        element.getFuncao().setTipo(auxTp);
        
        //pegar os parametros da funcao
        if(lexema.getToken() == EnumTokens.TOKEN_INT.getValor() 
            || lexema.getToken() == EnumTokens.TOKEN_FLOAT.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_DOUBLE.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_VOID.getValor())
        {   
            Variavel var = new Variavel();
            while(lexema.getToken() != EnumTokens.TOKEN_FPT.getValor()){
               //dentro de () pega o tipo do parametro 
            if(lexema.getToken() == EnumTokens.TOKEN_INT.getValor() 
            || lexema.getToken() == EnumTokens.TOKEN_FLOAT.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_DOUBLE.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_VOID.getValor()){
                auxTp=lexema.getToken();
                incrementeI();
                lexema = this.inputLexemas.get(i);
                
                //pegar o id do parametro
                if(lexema.getToken() == EnumTokens.TOKEN_ID.getValor()){
                    auxId = lexema.getLexema();
                    incrementeI();
                    lexema = this.inputLexemas.get(i);
                    //ver se tem mais ou acabou a lista de parametros
                    if(lexema.getToken() == EnumTokens.TOKEN_VG.getValor()){
                        var.setNome(auxId);
                        var.setTipo(auxTp);
                        
                        element.getFuncao().addParametro(var);
                        incrementeI();
                        lexema = this.inputLexemas.get(i);
                        
                    } else if(lexema.getToken() == EnumTokens.TOKEN_FPT.getValor()){
                        tabela.add(element);
                        j++;
                        incrementeI();
                        lexema = this.inputLexemas.get(i);
                    } //else erro , entre decs
                }//erro de ter um numero no inicio do id
            }   //erro n tem um tipo esperado   
            }
            element.setIsVar(false);
            
            tabela.add(element);
            j++;     
        }//if int calc()-------
        else if (lexema.getToken() == EnumTokens.TOKEN_FPT.getValor()){
            tabela.add(element);
            j++;
            incrementeI();
            lexema = this.inputLexemas.get(i);
        } //else erro
        
        if(lexema.getToken() == EnumTokens.TOKEN_ACHV.getValor()){
            inside=true;
            body(lexema);
        } // else funct sem corpo
        
        
        
    }
    
    public void var_decl(Lexema lexema){
        Variavel var = new Variavel();
        TabelaSintatico element = new TabelaSintatico();
        element.setIsVar(true);
        if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor()){
            var.setNome(auxId);
            var.setTipo(auxTp);
            
            element.setVariavel(var);
            tabela.add(element);
        }
        else if(lexema.getToken() == EnumTokens.TOKEN_APTR.getValor()){
            incrementeI();
            lexema = inputLexemas.get(i);
            if(lexema.getToken() == EnumTokens.TOKEN_APTR.getValor()){
                
            }
        }
        else if (lexema.getToken() == EnumTokens.TOKEN_EQ.getValor()){
            if(auxTp == EnumTokens.TOKEN_INT.getValor()){
                incrementeI();
                
                lexema = inputLexemas.get(i);
                if(lexema.getToken() == EnumTokens.TOKEN_NUI.getValor()){
                    var.setNome(auxId);
                    var.setTipo(auxTp);
                    var.setValor(lexema.getLexema());
                    
                } //else erro de receber valor invalido
            } else if(auxTp == EnumTokens.TOKEN_FLOAT.getValor() || auxTp == EnumTokens.TOKEN_DOUBLE.getValor() ){
                incrementeI();
                lexema = inputLexemas.get(i);
                if(lexema.getToken() == EnumTokens.TOKEN_NUD.getValor()){
                    var.setNome(auxId);
                    var.setTipo(auxTp);
                    var.setValor(lexema.getLexema());
                }//else erro de receber valor invalido
            } else if(auxTp == EnumTokens.TOKEN_CHAR.getValor()){
                incrementeI();
                lexema = inputLexemas.get(i);
                if(lexema.getToken() == EnumTokens.TOKEN_LCHAR.getValor()){
                    var.setNome(auxId);
                    var.setTipo(auxTp);
                    var.setValor(lexema.getLexema());
                }//else erro de receber valor invalido
            }else if(auxTp == EnumTokens.TOKEN_VETOR+" "+EnumTokens.TOKEN_CHAR.getValor()){
                incrementeI();
                lexema = inputLexemas.get(i);
                if(lexema.getToken() == EnumTokens.TOKEN_CHARCC.getValor()){
                    var.setNome(auxId);
                    var.setTipo(auxTp);
                    var.setValor(lexema.getLexema());
                }//else erro de receber valor invalido
            }
        }
        else if(lexema.getToken() == EnumTokens.TOKEN_VG.getValor()){
            element.setVariavel(var);
            tabela.add(element);
            decl(lexema);
        
        }
        incrementeI();
        lexema = inputLexemas.get(i);
        if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor()){
            element.setVariavel(var);
            
            tabela.add(element);
            analisador();
        }
    }
    
    public void body(Lexema lexema){
        inside = true;
        for(;lexema.getToken() != EnumTokens.TOKEN_FCHV.getValor(); i++){
            //declaraçoes locais
            if(lexema.getToken() == EnumTokens.TOKEN_INT.getValor() 
            || lexema.getToken() == EnumTokens.TOKEN_FLOAT.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_DOUBLE.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
            || lexema.getToken() == EnumTokens.TOKEN_VOID.getValor()){
                var_decl(lexema);
            }
        }
        inside = false;
        
    }
    
    public void avancar(){
        
    }
    
    @Override
    public String toString(){
        Variavel var;
        Funcao funct;
        String answer = "";
        for(TabelaSintatico element : this.tabela){
            if(element.isVar()){
                var = element.getVariavel();
                answer= answer + "Nome da Variavel: "+ var.getNome()+ "\nTipo da variavel: "+ var.getTipo()+"\nValor: "+var.getValor()+"\n\n";
            }else{
                funct = element.getFuncao();
                answer= "Nome da função: "+ funct.getNome()+ "\nTipo de retorno: "+ funct.getTipo()+"\nParametros: ";
                for(Variavel aux : funct.getParametro()){
                    answer = aux.getNome()+ ":" + aux.getTipo()+":"+"   ";
                }
                answer = "\n\n";
            }
        }
        
        return answer;
    }

    public ArrayList<String> getErros() {
        return erros;
    }
    
}
