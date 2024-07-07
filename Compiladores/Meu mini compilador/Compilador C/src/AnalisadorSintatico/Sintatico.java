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
    private String auxTp,auxId, auxVar;
    private int i,j;
    private Lexema lexema;
    private Lexema lexemaAnt;
    private int escopo;
    
    public Sintatico(){
        this.inputLexemas = Main.analex();
        this.tabela = new ArrayList<TabelaSintatico>();
        this.erros = new ArrayList<String>();
        this.i = 0;
        this.j = 0;
        this.escopo=0;
        lexema = inputLexemas.get(i);

        programa();
    }
    
    public boolean incrementeI(){
        lexemaAnt = inputLexemas.get(i);
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
            else erros.add("esperava encontrar um ID na linha:" + lexemaAnt.getLinha());
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
            incrementeI();
            decl();
        }
        else if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_APTR.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_EQ.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_VG.getValor())
        {
            var_decl();
            incrementeI();
            decl();
        }
        else {
            erros.add("declaração incompleta na linha:" + lexemaAnt.getLinha());
        }
    }
    
    public void func_decl(){
        escopo++;
        Funcao fun = new Funcao();
        TabelaSintatico a = new TabelaSintatico();
        a.setIsVar(false);
        fun.setNome(auxId);
        fun.setTipo(auxTp);
        
        
        //verificar incremento
        this.incrementeI();
        //vazio
        if(lexema.getToken() == EnumTokens.TOKEN_FPT.getValor()){
            
            fun.setEscopo(escopo);
            a.setFuncao(fun);
            a.setIsVar(false);
            this.tabela.add(a);
            fun_decl1();
        }
        else if (lexema.getToken() == EnumTokens.TOKEN_INT.getValor() 
                || lexema.getToken() == EnumTokens.TOKEN_FLOAT.getValor()
                || lexema.getToken() == EnumTokens.TOKEN_DOUBLE.getValor()
                || lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
                || lexema.getToken() == EnumTokens.TOKEN_VOID.getValor()) {
            
            fun = param(fun);
            fun.setEscopo(escopo);
            a.setFuncao(fun);
            a.setIsVar(false);
            this.tabela.add(a);
            
            //fun tem todos os parametros, agr ir para o corpo, escopo já é 1
            
            fun_decl1();
        }else erros.add("Declaração de função invalida na linha: "+lexemaAnt.getLinha());
        
    }
    
    public Funcao param(Funcao fun){
        if(type_spec()){
            //verificar incremento
            this.incrementeI();
            if(lexema.getToken() == EnumTokens.TOKEN_ID.getValor()){
                auxId = lexema.getLexema();
                Variavel var = new Variavel();
                var.setEscopo(escopo);
                var.setNome(auxId);
                var.setTipo(auxTp);
                fun.addParametro(var);               
                //verificar incremento
                this.incrementeI();
                if(lexema.getToken() == EnumTokens.TOKEN_VG.getValor()){
                    //verificar incremento
                    this.incrementeI();
                    fun = param(fun);
                }
                else if(lexema.getToken() == EnumTokens.TOKEN_FPT.getValor())
                return fun;
                else erros.add("Esperava um ) na linha: "+lexemaAnt.getLinha());
            }else erros.add("esperava um ID nos parametros da linha:"+lexemaAnt.getLinha());
        }else erros.add("Declaração de parametros inválida na linha: "+lexemaAnt.getLinha());
        
        return fun;
    }
    
    public void fun_decl1(){
        com_stmt();
    }
    
    public void com_stmt(){
        //verificar incremento
        incrementeI();
        
        if(lexema.getToken() == EnumTokens.TOKEN_ACHV.getValor()){
            content();
        }
    }
    public Variavel verificarVariavel(String nome, int escopo){
        Variavel var;
        Funcao fun;
        
            for(TabelaSintatico tab : this.tabela){
                
                if(tab.isVar()){
                    var = tab.getVariavel();
                    
                    if(var.getNome().equals(nome) && var.getEscopo() == escopo)
                    {
                        return var;
                    }
                }
                else {
                    fun = tab.getFuncao(); 
                    for(Variavel v : fun.getParametro()){
                           if(v.getNome().equals(nome) && v.getEscopo() == escopo)
                           {
                               return v;
                           }
                     }
                }
            }
        return null;
    }
    
    public void content(){
        //verificar incremento
        incrementeI();
        if(type_spec()){
            //verificar incremento
            this.incrementeI();
            
            if(lexema.getToken() == EnumTokens.TOKEN_ID.getValor()){
                auxId = lexema.getLexema();
                //verificar incremento
                
                this.incrementeI();
                //int a ?
                if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_APTR.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_EQ.getValor()
                ||lexema.getToken() == EnumTokens.TOKEN_VG.getValor())
                {
                    var_decl();
                    
                }
                else {
                    erros.add("declaração incompleta na linha: " + lexemaAnt.getLinha());
                }
            }
            else erros.add("esperava encontrar um ID na linha: " + lexemaAnt.getLinha());
            //---------------------------goto avancar
        }
        else if(lexema.getToken() == EnumTokens.TOKEN_ID.getValor()){
            auxId = lexema.getLexema();
            if(verificarVariavel(lexema.getLexema(), escopo) != null){
                
                incrementeI();
                
                if(lexema.getToken() == EnumTokens.TOKEN_EQ.getValor()){
                    Variavel var = verificarVariavel(auxId, escopo);
                    incrementeI();
                    
                    if(lexema.getToken() == EnumTokens.TOKEN_NUD.getValor()
                    ||lexema.getToken() == EnumTokens.TOKEN_NUI.getValor()
                    ||lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
                    ||lexema.getToken() == EnumTokens.TOKEN_CHARCC.getValor()
                    ){
                        if(var.getTipo().equals("INTEIRO") && lexema.getToken().equals("NÚMERO_INTEIRO"))
                            var.setValor(lexema.getLexema());
                        else if((var.getTipo().equals("FLOAT")||var.getTipo().equals("DOUBLE")) && lexema.getToken().equals("NÚMERO_DECIMAL"))
                            var.setValor(lexema.getLexema());
                        else if(lexema.getToken().equals(var.getTipo()))
                            var.setValor(lexema.getLexema());
                        else erros.add("Atribuição inválida na linha: "+lexema.getLinha()+", insira um valor do tipo "+var.getTipo());

                        //verificar incremento
                        incrementeI();
                        if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor())
                        {

                        }
                        else erros.add("Esperava um ; na linha: "+lexemaAnt.getLinha());
                        //else avancar pro erro--------------------------------------
                    }else erros.add("Esperava um valor na linha: "+lexemaAnt.getLinha());//receber um id  
                    
                    
                    
                }
                else erros.add("chamada da variavel sem realizar operação na linha: "+lexemaAnt.getLinha());
            }else erros.add("Uso de variavel não declarada na linha: "+lexema.getLinha());
            
            
        }
        
        if(lexema.getToken() == EnumTokens.TOKEN_FCHV.getValor()){
            return;
        }
        else content();
    }
    
    public void atribuição(){
        
    }
    
    public void var_decl(){
        Variavel var = new Variavel();
        TabelaSintatico a = new TabelaSintatico();
        a.setIsVar(true);
        var.setNome(auxId);
        var.setTipo(auxTp);
        var.setEscopo(escopo);
        
        if(verificarVariavel(auxId, escopo) != null){
            erros.add("A variavel '"+lexemaAnt.getLexema()+ "' na linha: "+lexemaAnt.getLinha()+ ", já foi declarada");
            return;
            
        }
        
        if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor()){
            a.setVariavel(var);
            this.tabela.add(a);
        }
        else if(lexema.getToken() == EnumTokens.TOKEN_EQ.getValor()){
            //verificar incremento
            incrementeI();
            
            //---------------------------teste
                
            //---------------------------teste
            if(lexema.getToken() == EnumTokens.TOKEN_NUD.getValor()
              ||lexema.getToken() == EnumTokens.TOKEN_NUI.getValor()
              ||lexema.getToken() == EnumTokens.TOKEN_CHAR.getValor()
              ||lexema.getToken() == EnumTokens.TOKEN_CHARCC.getValor()
              ){
                
                if(auxTp.equals("INTEIRO") && lexema.getToken().equals("NÚMERO_INTEIRO"))
                    var.setValor(lexema.getLexema());
                else if((auxTp.equals("FLOAT")||auxTp.equals("DOUBLE")) && lexema.getToken().equals("NÚMERO_DECIMAL"))
                    var.setValor(lexema.getLexema());
                else if(lexema.getToken().equals(auxTp))
                    var.setValor(lexema.getLexema());
                else erros.add("Atribuição inválida na linha: "+lexema.getLinha()+", insira um valor do tipo "+var.getTipo());
                a.setVariavel(var);
                this.tabela.add(a);
                //verificar incremento
                incrementeI();
            if(lexema.getToken() == EnumTokens.TOKEN_PTVG.getValor())
            {
                
            }
            else erros.add("Esperava um ; na linha: "+lexemaAnt.getLinha());
            //else avancar pro erro--------------------------------------
            }else erros.add("Esperava um valor na linha: "+lexemaAnt.getLinha());//receber um id            
        }
        else if (lexema.getToken() == EnumTokens.TOKEN_VG.getValor()){
            a.setVariavel(var);
            this.tabela.add(a);
            //verificar incremento
            incrementeI();
            if(lexema.getToken() == EnumTokens.TOKEN_ID.getValor()){
                auxId =lexema.getLexema();
                if(incrementeI())
                var_decl();
                else erros.add("declaração de variaveis multiplas incompleta na linha: "+lexemaAnt.getLinha()+" esperava um ;");
            }
            else erros.add("esperava encontrar um id na linha: "+lexemaAnt.getLinha());
        }
        else erros.add("declaração incompleta na linha:"+lexemaAnt.getLinha());
    }
    
    @Override
    public String toString(){
        Variavel var;
        Funcao funct;
        String answer = "";
        String auxAn= "";
        for(TabelaSintatico element : this.tabela){
            
            if(element.isVar()){
                var = element.getVariavel();
                answer+= "Nome da Variavel: "+ var.getNome()+ "\nTipo da variavel: "+ var.getTipo()+"\nValor: "+var.getValor()+"\nEscopo:"+var.getEscopo()+"\n\n";
            }else{
                
                funct = element.getFuncao();
                answer+= "Nome da função: "+ funct.getNome()+ "\nTipo de retorno: "+ funct.getTipo()+"\nEscopo:"+funct.getEscopo()+"\nParametros: ";
                for(Variavel aux : funct.getParametro()){
                    answer += aux.getNome()+ ":" + aux.getTipo()+" ";
                    auxAn+= "\n\nNome da Variavel: "+ aux.getNome()+ "\nTipo da variavel: "+ aux.getTipo()+"\nValor: "+aux.getValor()+"\nEscopo:"+aux.getEscopo();
                }
                answer += auxAn+ "\n\n";
                auxAn= "";
            }
        }
        return answer;
    }

    public ArrayList<String> getErros() {
        return erros;
    }
    
}
