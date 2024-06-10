/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import AnalisadorLexico.EnumTokens;
import AnalisadorLexico.Lexema;
import AnalisadorLexico.Main;
import java.util.ArrayList;

/**
 *
 * @author ernestoamandio
 */
public class AnalisadorSintatico {
    
    private Grafo grafo;
    private ArrayList<String> erros;
    private ArrayList<Lexema> inputLexemas;
    private String auxTp,auxId;
    private int i;

    
    public AnalisadorSintatico(){
        //lista de lexemas q eu li
        this.inputLexemas = Main.analex();
        //grafo com os simbolos da gramatica toda
        this.grafo = GramaticaGrafo.gerarGrafo();
        //add erros quando eu encontrar um
        this.erros = new ArrayList<>();
        this.i = 0;
        programa();
    }

    public ArrayList<String> getErros() {
        return erros;
    }
    
    private void programa(){
        grafo.setAtualV("programa");
        if(grafo.alcancarV("decl_list"))
            decl_list();
    }

    private boolean decl_list() {
            
            if(grafo.alcancarV("decl"))
            {
                decl();
                return true;
            }   
        
        return false;
        
    }
    
    //fazer função de incrementar i de acordo ao tamanho do arraylist input

    public boolean incrementarI(){
        if(i<this.inputLexemas.size()-1)
        {
            i++;
            return true;
        }
        return false;
    }
    
    private boolean decl() {
        
        if(grafo.setAtualV("type_spec")){
            if(type_spec())
                if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_ID.getValor())
                {   
                    if(this.incrementarI())
                    {
                        this.grafo.setAtualV("decl");
                        if(this.grafo.alcancarV("decl_1"))
                        {
                            decl_1();
                        }
                    }
                    else {
                        this.erros.add("esperava encontrar ';'  "
                        + "na linha: "+ this.inputLexemas.get(i).getLinha());  
                        programa();
                    }
                    
                }
                else {
                    this.erros.add("esperava encontrar um Identificador "
                    + "na linha: "+ this.inputLexemas.get(i-1).getLinha());
                    programa();
                }
        }
        else{ 
            return false;   
        }
        
        return false;  
    }

    private boolean type_spec() {
        
        /*if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_INT.getValor() 
            || this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_FLOAT.getValor()
            || this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_DOUBLE.getValor()
            || this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_CHAR.getValor()
            || this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_VOID.getValor())*/
        if(grafo.alcancarV(this.inputLexemas.get(i).getLexema()))
        {
            if(this.incrementarI())
            return true;
            else {
                System.out.println("esperava um identificador na linha: "
                        +this.inputLexemas.get(i).getLinha());
                return false;
            }
        }   
            this.erros.add("esperava encontrar 'int' ou 'void' ou 'float' ou 'char' ou 'double' "
                    + "na linha: "+ this.inputLexemas.get(i).getLinha());
            return false;
       
    }

    private boolean decl_1() {
        
        if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_APT.getValor()){
            if(this.grafo.alcancarV("fun_decl"))
            fun_decl();
            decl();
        }
        else {
            if(this.grafo.alcancarV("var_decl"))
            var_decl();
            if(this.incrementarI())
            decl();
        }
        
        return false;  
    }

    private boolean fun_decl() {
     
        return false;  
    }

    private boolean var_decl() {
        if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_PTVG.getValor()){
            this.incrementarI();
            this.grafo.setAtualV("decl_1");
            return true;
        }
        else if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_APTR.getValor())
        {    
            if(this.incrementarI())
            {
                if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_NUI.getValor())
                {   
                    if(this.incrementarI())
                    {
                        if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_FPTR.getValor())
                        {
                            if(this.incrementarI())
                            {
                                if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_PTVG.getValor())
                                {
                                    this.grafo.setAtualV("decl_1");
                                    return true;
                                }
                                else 
                                {
                                    this.erros.add("esperava encontrar ';' na linha: "
                                     +this.inputLexemas.get(i).getLinha());
                                    return false;
                                }
                            }
                            else 
                            {
                                this.erros.add("esperava encontrar ';' na linha: "
                                +this.inputLexemas.get(i).getLinha());
                                return false;
                            }
                        }
                        else 
                        {
                            this.erros.add("esperava encontrar um ']' após o numero inteiro na linha: "
                             +this.inputLexemas.get(i).getLinha());
                            return false;
                        }
                    }
                    else 
                    {
                        this.erros.add("esperava encontrar um ']' após o numero inteiro na linha: "
                         +this.inputLexemas.get(i).getLinha());
                        return false;
                    }
                    
                }
                else 
                {
                    this.erros.add("esperava encontrar um numero inteiro após '[' na linha: "
                     +this.inputLexemas.get(i).getLinha());
                    return false;
                }
                
            }
            else 
            {
                this.erros.add("esperava encontrar um numero inteiro após '[' na linha: "
                 +this.inputLexemas.get(i).getLinha());
                return false;
            }
        }
        else if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_EQ.getValor()){
            //-------------------------
            if(this.incrementarI()){
                if(exp()){
                if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_PTVG.getValor()){
                    return true;
                }else{
                    this.erros.add("esperava encontrar ';' na linha: "
                        +this.inputLexemas.get(i).getLinha());
                }
            }
            }else{
                this.erros.add("atribuição incompleta na linha: "
                        +this.inputLexemas.get(i).getLinha());
            }
            
            
            this.grafo.alcancarV("decl_1");
            return true;
        }
        else if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_VG.getValor()){
            if(this.incrementarI()){
                if(this.inputLexemas.get(i).getToken() == EnumTokens.TOKEN_ID.getValor()){
                    if(this.incrementarI()){
                        this.var_decl();
                    } 
                    else{
                        this.erros.add("esperava encontrar ';' na linha: "
                                +this.inputLexemas.get(i).getLinha());
                        return false;
                    }
                }
                else
                {
                    this.erros.add("esperava encontrar um ID após ',' na linha: "
                     +this.inputLexemas.get(i).getLinha());
                    return false;
                } 
            }
            else
            {
                this.erros.add("esperava encontrar um ID após ',' na linha: "
                 +this.inputLexemas.get(i).getLinha());
                return false;
            }
        }
        
        this.erros.add("esperava encontrar ';' ou '[' ou '=' ou ',' "
             + "na linha: "+ this.inputLexemas.get(i-1).getLinha());
        programa();
        return false;  
    }

    private boolean exp() {
        if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_ID.getValor())) {
            incrementarI();
            exp_1();
                return exp_3();

        } else if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MAS.getValor()) ||
                   inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MEN.getValor()) ||
                   inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_EXCL.getValor())) {
            incrementarI();
            exp();
                return exp_3();

        } else if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_NUD.getValor()) ||
                   inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_CHARCC.getValor()) ||
                   inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_NUI.getValor())) {
            incrementarI();
            return exp_3();
        }

        erros.add("Erro de sintaxe na linha: " + inputLexemas.get(i).getLinha());
        return false;
    }
    
    private boolean exp_1() {
        if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_APTR.getValor())){
            if(incrementarI())
            {
                if (exp()) {                
                    if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_FPTR.getValor())) {
                        incrementarI();
                        return exp_2();
                    } else {
                        erros.add("esperava ']' na linha: " + inputLexemas.get(i).getLinha());
                    }
                }
            }
        } else if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_DOT.getValor())) {
            incrementarI();
            if (inputLexemas.get(i).getToken().equals("sizeof")) {
                incrementarI();
                return true;
            } else {
                erros.add("esperava 'sizeof' na linha: " + inputLexemas.get(i).getLinha());
            }
        } else if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_APT.getValor())) {
            incrementarI();
            if (args()) {
                if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_FPT.getValor())) {
                    incrementarI();
                    return true;
                } else {
                    erros.add("esperava ')' na linha: " + inputLexemas.get(i).getLinha());
                }
            }
        } else if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MASMAS.getValor()) ||
                   inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MENMEN.getValor())) {
            
            if(incrementarI()){
                return true;
            }
            else {
                erros.add("esperava um id na atrubuição na linha: "
                        +this.inputLexemas.get(i).getLinha());
                return false;
            }
            
        }
            return true;
        
    }
    
    private boolean exp_2() {
        if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_EQ.getValor())) {
            incrementarI();
            return exp();
        } else {
            return true;
        }
    }

    private boolean exp_3() {
        
       
        if(this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_BARBAR.getValor())
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_EQ.getValor())
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_EQEQ.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MENREQ.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MENR.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MAR.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MAREQ.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_ECMECM.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MAS.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MEN.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_AST.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_BARD.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MASEQ.getValor())       
         ||this.inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_MENEQ.getValor())       
         )
        {
            incrementarI();
            if (exp()) {
                return exp_3();
            }
        }
            return true;        
    }
    private boolean args() {
        if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_ID.getValor()) ||
            inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_NUD.getValor()) ||
            inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_CHARCC.getValor()) ||
            inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_NUI.getValor())) {
            if (exp()) {
                return arg_list_1();
            }
        }
    return true;
    }
    
    private boolean arg_list_1() {
        if (inputLexemas.get(i).getToken().equals(EnumTokens.TOKEN_VG.getValor())) {
            incrementarI();
            if (exp()) {
                return arg_list_1();
            }
        }
        return true;
    }
    
}

