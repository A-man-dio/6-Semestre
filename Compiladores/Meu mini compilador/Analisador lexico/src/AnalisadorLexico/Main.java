package AnalisadorLexico;


import AnalisadorSintatico.Sintatico;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernestoamandio
 */

public class Main {
     
    private static String nomeFicheiro = "src/teste.txt";
    
    public static void main(String[] args) {
        
        for(Lexema lexema : Main.analex()){
            System.out.println("TOKEN : "+lexema.getToken()+"\nLEXEMA: "+lexema.getLexema()+"\nLINHA : "+lexema.getLinha()+"\n\n");
        }
        
        Sintatico sintax = new Sintatico();
        sintax.analisador();
        System.out.println(sintax.toString());
        
        
    }
    
    public static ArrayList<Lexema> analex(){
        int estado = 0;
        boolean ver=false;
        int linha = 1;
        String aux = "";
        ArrayList<Lexema> lexemas = new ArrayList<>();
        char[] ficheiro = Main.lerSimbolo().toCharArray();
        char simbolo;
        int tam = ficheiro.length;
        
        for(int i=0; i < tam ;i++){ 
            
            simbolo = ficheiro[i];
            
            switch (estado){   
                case 0:
                {
                    if(simbolo == '/'){
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_BARD.getValor(),"/",linha));
                        else
                            estado = 3;
                    }
                    //int
                    else if(simbolo == 'i' && i+1 != tam){ 
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if(simbolo == 'n' && i+1 != tam){
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if(simbolo == 't'){
                                aux += simbolo;
                                if(i+1!=tam){
                                    if(ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n'){
                                        lexemas.add(new Lexema(EnumTokens.TOKEN_INT.getValor(),aux,linha));
                                        aux="";  
                                        ver=true;
                                    }
                                    else
                                    {
                                        ver=true;
                                        estado=1;
                                    }
                                }else {
                                    lexemas.add(new Lexema(EnumTokens.TOKEN_INT.getValor(),aux,linha));
                                    ver=true;
                                }
                            }
                        }else if (simbolo == 'f') {
                                    aux += simbolo;
                                    if (i + 1 != tam) {
                                        if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n'|| ficheiro[i + 1] == ')') {
                                            lexemas.add(new Lexema(EnumTokens.TOKEN_IF.getValor(), aux, linha));
                                            aux = "";
                                            ver=true;
                                        } else {
                                            estado = 1;
                                            ver=true;
                                        }
                                    } else {
                                        lexemas.add(new Lexema(EnumTokens.TOKEN_IF.getValor(), aux, linha));
                                        ver=true;
                                    }
                                }
                        if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
                    //float
                    else if (simbolo == 'f' && i + 1 != tam) {
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if (simbolo == 'l' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'o' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'a' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 't') {
                                        aux += simbolo;
                                        if (i + 1 != tam) {
                                            if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_FLOAT.getValor(), aux, linha));
                                                aux = "";
                                                ver=true;
                                            } else {
                                                estado = 1;
                                                ver=true;
                                            }
                                        } else {
                                            lexemas.add(new Lexema(EnumTokens.TOKEN_FLOAT.getValor(), aux, linha));
                                            ver=true;
                                        }
                                    } 
                                }
                            }
                        }
                        if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
                    // double
                    else if (simbolo == 'd' && i + 1 != tam) {
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if (simbolo == 'o' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if(simbolo == ' ' || simbolo == '\n'){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_DO.getValor(), aux, linha));
                                aux = "";
                                ver=true;
                            }
                            else
                            if (simbolo == 'u' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'b' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 'l' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'e') {
                                            aux += simbolo;
                                            if (i + 1 != tam) {
                                                if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                                    lexemas.add(new Lexema(EnumTokens.TOKEN_DOUBLE.getValor(), aux, linha));
                                                    aux = "";
                                                    ver=true;
                                                } else {
                                                    estado = 1;
                                                    ver=true;
                                                }
                                            } else {
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_DOUBLE.getValor(), aux, linha));
                                                ver=true;
                                            }
                                        } 
                                    }
                                }
                            }
                        }
                        else if (simbolo == 'e' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'f' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 'a' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'u' && i + 1 != tam) {
                                            i++;
                                            aux += simbolo;
                                            simbolo = ficheiro[i];
                                            if (simbolo == 'l' && i + 1 != tam) {
                                                i++;
                                                aux += simbolo;
                                                simbolo = ficheiro[i];
                                                if (simbolo == 't') {
                                                    aux += simbolo;
                                                    if (i + 1 != tam) {
                                                        if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                                            lexemas.add(new Lexema(EnumTokens.TOKEN_DEFAULT.getValor(), aux, linha));
                                                            aux = "";
                                                            ver=true;
                                                        } else {
                                                            estado = 1;
                                                            ver=true;
                                                        }
                                                    } else {
                                                        lexemas.add(new Lexema(EnumTokens.TOKEN_DEFAULT.getValor(), aux, linha));
                                                        ver=true;
                                                    }
                                                } 
                                            }
                                        }
                                    }
                                    
                                    else if (simbolo == 'i' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 'n' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'e') {
                                            aux += simbolo;
                                            if (i + 1 != tam) {
                                                if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                                    lexemas.add(new Lexema(EnumTokens.TOKEN_DEFINE.getValor(), aux, linha));
                                                    aux = "";
                                                } else {
                                                    estado = 1;
                                                }
                                            } else {
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_DEFINE.getValor(), aux, linha));
                                            }
                                        } else {
                                            aux += simbolo;
                                            if (i + 1 == tam)
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(), aux, linha));
                                            estado = 1;
                                        }
                                    }
                                }
                                }    
                            }
                        
                        if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
                    else if (simbolo == 'i' && i + 1 != tam) {
                    i++;
                    aux += simbolo;
                    simbolo = ficheiro[i];
                    if (simbolo == 'n' && i + 1 != tam) {
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if (simbolo == 'c' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'l' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'u' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 'd' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'e') {
                                            aux += simbolo;
                                            if (i + 1 != tam) {
                                                if (ficheiro[i + 1] == ' '|| ficheiro[i+1]=='\n') {
                                                    lexemas.add(new Lexema(EnumTokens.TOKEN_INCLUDE.getValor(), aux, linha));
                                                    aux = "";
                                                    ver=true;
                                                } else {
                                                    estado = 1;
                                                    ver=true;
                                                }
                                            } else {
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_INCLUDE.getValor(), aux, linha));
                                                ver=true;
                                            }
                                        } 
                                    }
                                }
                            }
                        }
                    }
                    if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                }
                    else if (simbolo == 'e' && i + 1 != tam) {
                    i++;
                    aux += simbolo;
                    simbolo = ficheiro[i];
                    if (simbolo == 'l' && i + 1 != tam) {
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if (simbolo == 's' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'e') {
                                aux += simbolo;
                                if (i + 1 != tam) {
                                    if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                        lexemas.add(new Lexema(EnumTokens.TOKEN_ELSE.getValor(), aux, linha));
                                        aux = "";
                                        ver=true;
                                    } else {
                                        estado = 1;
                                        ver=true;
                                    }
                                } else {
                                    lexemas.add(new Lexema(EnumTokens.TOKEN_ELSE.getValor(), aux, linha));
                                    ver=true;
                                }
                            } 
                        }
                    }
                    if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
                    
                    else if (simbolo == 'g' && i + 1 != tam) {
                    i++;
                    aux += simbolo;
                    simbolo = ficheiro[i];
                    if (simbolo == 'o' && i + 1 != tam) {
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if (simbolo == 't' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'o') {
                                aux += simbolo;
                                if (i + 1 != tam) {
                                    if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                        lexemas.add(new Lexema(EnumTokens.TOKEN_GOTO.getValor(), aux, linha));
                                        aux = "";
                                        ver=true;
                                    } else {
                                        estado = 1;
                                        ver=true;
                                    }
                                } else {
                                    lexemas.add(new Lexema(EnumTokens.TOKEN_GOTO.getValor(), aux, linha));
                                    ver=true;
                                }
                            } 
                        }
                    }
                    if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
                    
                    else if (simbolo == 'v' && i + 1 != tam) {
                    i++;
                    aux += simbolo;
                    simbolo = ficheiro[i];
                    if (simbolo == 'o' && i + 1 != tam) {
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if (simbolo == 'i' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'd') {
                                aux += simbolo;
                                if (i + 1 != tam) {
                                    if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                        lexemas.add(new Lexema(EnumTokens.TOKEN_VOID.getValor(), aux, linha));
                                        aux = "";
                                        ver=true;
                                    } else {
                                        estado = 1;
                                        ver=true;
                                    }
                                } else {
                                    lexemas.add(new Lexema(EnumTokens.TOKEN_VOID.getValor(), aux, linha));
                                    ver=true;
                                }
                            } 
                        }
                    }
                    if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
                    
                    else if (simbolo == 'e' && i + 1 != tam) {
                    i++;
                    aux += simbolo;
                    simbolo = ficheiro[i];
                    if (simbolo == 'l' && i + 1 != tam) {
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if (simbolo == 's' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'e') {
                                aux += simbolo;
                                if (i + 1 != tam) {
                                    if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                        lexemas.add(new Lexema(EnumTokens.TOKEN_ELSE.getValor(), aux, linha));
                                        aux = "";
                                        ver=true;
                                    } else {
                                        estado = 1;
                                        ver=true;
                                    }
                                } else {
                                    lexemas.add(new Lexema(EnumTokens.TOKEN_ELSE.getValor(), aux, linha));
                                    ver=true;
                                }
                            } 
                        }
                    }
                    if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
                    //char
                    else if (simbolo == 'c' && i + 1 != tam) {
                        i++;
                        aux += simbolo;
                        simbolo = ficheiro[i];
                        if (simbolo == 'h' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'a' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'r') {
                                    aux += simbolo;
                                    if (i + 1 != tam) {
                                        if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                            lexemas.add(new Lexema(EnumTokens.TOKEN_CHAR.getValor(), aux, linha));
                                            aux = "";
                                            ver=true;
                                        } else {
                                            estado = 1;
                                            ver=true;
                                        }
                                    } else {
                                        lexemas.add(new Lexema(EnumTokens.TOKEN_CHAR.getValor(), aux, linha));
                                        ver=true;
                                    }
                                } 
                           }
                        } else if (simbolo == 'a' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 's' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'e') {
                                    System.out.println("testee");
                                    aux += simbolo;
                                    if (i + 1 != tam) {
                                        if (ficheiro[i + 1] == ' ' || ficheiro[i + 1] == '\n') {
                                            lexemas.add(new Lexema(EnumTokens.TOKEN_CASE.getValor(), aux, linha));
                                            aux = "";
                                            ver=true;
                                        } else {
                                            estado = 1;
                                            ver=true;
                                        }
                                    } else {
                                        lexemas.add(new Lexema(EnumTokens.TOKEN_CASE.getValor(), aux, linha));
                                        ver=true;
                                    }
                                } 
                            }
                        }
                        else if (simbolo == 'o' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'n' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 't' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'i' && i + 1 != tam) {
                                            i++;
                                            aux += simbolo;
                                            simbolo = ficheiro[i];
                                            if (simbolo == 'n' && i + 1 != tam) {
                                                i++;
                                                aux += simbolo;
                                                simbolo = ficheiro[i];
                                                if (simbolo == 'u' && i + 1 != tam) {
                                                    i++;
                                                    aux += simbolo;
                                                    simbolo = ficheiro[i];
                                                    if (simbolo == 'e') {
                                                        aux += simbolo;
                                                        if (i + 1 != tam) {
                                                            if (ficheiro[i + 1] == ' ') {
                                                                lexemas.add(new Lexema(EnumTokens.TOKEN_CONTINUE.getValor(), aux, linha));
                                                                aux = "";
                                                                ver=true;
                                                            } else {
                                                                estado = 1;
                                                                ver=true;
                                                            }
                                                        } else {
                                                            lexemas.add(new Lexema(EnumTokens.TOKEN_CONTINUE.getValor(), aux, linha));
                                                            ver=true;
                                                        }
                                                    } 
                                                }
                                            }
                                        }
                                    }else if (simbolo == 's' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 't') {
                                        aux += simbolo;
                                        if (i + 1 != tam) {
                                            if (ficheiro[i + 1] == ' ') {
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_CONST.getValor(), aux, linha));
                                                aux = "";
                                                ver=true;
                                            } else {
                                                estado = 1;
                                                ver=true;
                                            }
                                        } else {
                                            lexemas.add(new Lexema(EnumTokens.TOKEN_CONST.getValor(), aux, linha));
                                            ver=true;
                                        }
                                    } 
                                }
                                }
                            }
                        if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
                    
                    else if (simbolo == 'w' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'h' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'i' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 'l' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'e') {
                                            aux += simbolo;
                                            if (i + 1 != tam) {
                                                if (ficheiro[i + 1] == ' ') {
                                                    lexemas.add(new Lexema(EnumTokens.TOKEN_WHILE.getValor(), aux, linha));
                                                    aux = "";
                                                    ver=true;
                                                } else {
                                                    estado = 1;
                                                    ver = true;
                                                }
                                            } else {
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_WHILE.getValor(), aux, linha));
                                                ver=true;
                                            }
                                        }
                                    }
                                }
                            }
                             if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                        }
                    
                    //break
                      
                        else if (simbolo == 'b' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'r' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'e' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 'a' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'k') {
                                            aux += simbolo;
                                            if (i + 1 != tam) {
                                                if (ficheiro[i + 1] == ' ') {
                                                    lexemas.add(new Lexema(EnumTokens.TOKEN_BREAK.getValor(), aux, linha));
                                                    aux = "";
                                                    ver=true;
                                                } else {
                                                    estado = 1;
                                                    ver = true;
                                                }
                                            } else {
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_BREAK.getValor(), aux, linha));
                                                ver=true;
                                            }
                                        }
                                    }
                                }
                            }
                             if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                        }
                        
                        else if (simbolo == 's' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'w' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 'i' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 't' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'c' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'h') {
                                            aux += simbolo;
                                            if (i + 1 != tam) {
                                                if (ficheiro[i + 1] == ' ') {
                                                    lexemas.add(new Lexema(EnumTokens.TOKEN_SWITCH.getValor(), aux, linha));
                                                    aux = "";
                                                    ver=true;
                                                } else {
                                                    estado = 1;
                                                    ver = true;
                                                }
                                            } else {
                                                lexemas.add(new Lexema(EnumTokens.TOKEN_SWITCH.getValor(), aux, linha));
                                                ver=true;
                                            }
                                        }
                                        }
                                    }
                                }
                            }
                             if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                        }
                        
                        else if (simbolo == 'r' && i + 1 != tam) {
                            i++;
                            aux += simbolo;
                            simbolo = ficheiro[i];
                            if (simbolo == 'e' && i + 1 != tam) {
                                i++;
                                aux += simbolo;
                                simbolo = ficheiro[i];
                                if (simbolo == 't' && i + 1 != tam) {
                                    i++;
                                    aux += simbolo;
                                    simbolo = ficheiro[i];
                                    if (simbolo == 'u' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                        if (simbolo == 'r' && i + 1 != tam) {
                                        i++;
                                        aux += simbolo;
                                        simbolo = ficheiro[i];
                                            if (simbolo == 'n') {
                                                aux += simbolo;
                                                if (i + 1 != tam) {
                                                    if (ficheiro[i + 1] == ' ') {
                                                        lexemas.add(new Lexema(EnumTokens.TOKEN_RETURN.getValor(), aux, linha));
                                                        aux = "";
                                                        ver=true;
                                                    } else {
                                                        estado = 1;
                                                        ver = true;
                                                    }
                                                } else {
                                                    lexemas.add(new Lexema(EnumTokens.TOKEN_RETURN.getValor(), aux, linha));
                                                    ver=true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                             if(!ver){
                            if(simbolo==' '){
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                                aux="";
                            }else{
                            aux+=simbolo;
                            if(i+1 == tam)
                                lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                            estado=1;
                            }
                        }
                        ver=false;
                    }
               
                    else if(Pattern.matches("[0-9]", Character.toString(simbolo))){
                        aux += (char) simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_NUI.getValor(),aux,linha));
                        estado = 7;
                    }
                    else if(simbolo == '='){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_EQ.getValor(),aux,linha));
                        else{
                        estado = 13;
                        }
                    }
                    else if(simbolo == '+'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_MAS.getValor(),aux,linha));
                        else{
                        estado = 16;
                        }
                    }
                    else if(simbolo == '-'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_MEN.getValor(),aux,linha));
                        else{
                        estado = 19;
                        }
                    }
                    else if(simbolo == '*'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_AST.getValor(),aux,linha));
                        else{
                        estado = 22;
                        }
                    }
                    
                    else if(simbolo == '!'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_EXCL.getValor(),aux,linha));
                        else{
                        estado = 25;
                        }
                    }
                    
                    else if(simbolo == '<'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_MENR.getValor(),aux,linha));
                        else{
                        estado = 31;
                        }
                    }    
                    
                    else if(simbolo == '>')
                        {
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_MAR.getValor(),aux,linha));
                        else{
                        estado = 34;
                        }
                    }    
                        
                    
                    else if(simbolo == '%'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_POR.getValor(),aux,linha));
                        else{
                        estado = 38;
                        }
                    }
                        
                    
                    else if(simbolo == '&'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_ECM.getValor(),aux,linha));
                        else{
                        estado = 41;
                        }
                    }
                        
                    
                    else if(simbolo == '?'){
                        //ESTADO 49
                        lexemas.add(new Lexema(EnumTokens.TOKEN_QUEST.getValor(),"?",linha));
                    }
                    
                    else if(simbolo == ';'){
                        //ESTADO 59
                        lexemas.add(new Lexema(EnumTokens.TOKEN_PTVG.getValor(),";",linha));
                    }
                    
                    else if(simbolo == '#'){
                        //ESTADO 51
                        lexemas.add(new Lexema(EnumTokens.TOKEN_TAG.getValor(),"#",linha));
                    }
                    
                    else if(simbolo == '"'){
                        estado = 52;
                    }
                    
                    else if(simbolo == '\''){
                        if(i+1 != tam){
                        if(ficheiro[i+1] != '\'')
                            estado = 54;
                        else System.out.println("Deve colocar ao menos um símbolo entre \'\'\n");
                        }else System.out.println("Ao abrir aspas altas ('), também deve fechar\n");
                    }
                        
                    
                    else if(simbolo == '^'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_CIRC.getValor(),aux,linha));
                        else{
                        estado = 58;
                        }
                    }
                    
                    else if(simbolo == ':'){
                        //ESTADO 59
                        lexemas.add(new Lexema(EnumTokens.TOKEN_DPT.getValor(),":",linha));
                    }
                    
                    else if(simbolo == '|'){
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_BAR.getValor(),aux,linha));
                        else{
                        estado = 62;
                        }
                    }
                    
                    else if(simbolo == '.'){
                        //ESTADO 67
                        lexemas.add(new Lexema(EnumTokens.TOKEN_DOT.getValor(),".",linha));
                    }
                    
                    else if(Pattern.matches("[a-zA-Z]|_", Character.toString(simbolo))) { 
                        aux += simbolo;
                        if(i+1 == tam)
                            lexemas.add(new Lexema(EnumTokens.TOKEN_ID.getValor(),aux,linha));
                        estado = 1;
                    }
                    
                    else if(simbolo == '('){
                        //ESTADO 68
                        lexemas.add(new Lexema(EnumTokens.TOKEN_APT.getValor(),"(",linha));
                    }
                        
                    else if(simbolo == ')'){
                        //ESTADO 69
                        lexemas.add(new Lexema(EnumTokens.TOKEN_FPT.getValor(),")",linha));
                    }                       
                    
                    else if(simbolo == '['){
                        //ESTADO 70
                        lexemas.add(new Lexema(EnumTokens.TOKEN_APTR.getValor(),"[",linha));
                    }
                    
                    else if(simbolo == ']'){
                        //ESTADO 71
                        lexemas.add(new Lexema(EnumTokens.TOKEN_FPTR.getValor(),"]",linha));
                    }
                    
                    else if(simbolo == '{'){
                        //ESTADO 72
                        lexemas.add(new Lexema(EnumTokens.TOKEN_ACHV.getValor(),"{",linha));
                    }
                    
                    else if(simbolo == '}'){
                        //ESTADO 73
                        lexemas.add(new Lexema(EnumTokens.TOKEN_FCHV.getValor(),"}",linha));
                    }
                    
                    else if(simbolo == ','){
                        //ESTADO 57
                        lexemas.add(new Lexema(EnumTokens.TOKEN_VG.getValor(),",",linha));
                    }   
                    break;
                }
                
                case 1:{ 
                    if(i+1 == tam && Pattern.matches("[a-zA-Z]|_|[0-9]", Character.toString(simbolo)) ){
                        aux += (char) simbolo;
                        lexemas.add(new Lexema (EnumTokens.TOKEN_ID.getValor(),aux,linha));
                        estado = 0;
                        aux="";
                    }
                    else if(Pattern.matches("[a-zA-Z]|_|[0-9]", Character.toString(simbolo))){
                        aux += simbolo;
                    }
                    else{
                        i--;
                        lexemas.add(new Lexema (EnumTokens.TOKEN_ID.getValor(),aux,linha));
                        estado = 0;
                        aux="";
                        continue; 
                    }
                    break;    
                }
                // '/'?
                case 3:
                {
                    if(simbolo == '='){
                        //ESTADO 28
                        lexemas.add(new Lexema(EnumTokens.TOKEN_BARDEQ.getValor(),"/=",linha));
                        estado = 0;
                    }
                    else if (simbolo == '*'){
                        lexemas.add(new Lexema(EnumTokens.TOKEN_ICMTP.getValor(),"/*",linha));
                        estado = 4;
                    }
                    else if (simbolo == '/'){
                        lexemas.add(new Lexema(EnumTokens.TOKEN_CMTL.getValor(),"//",linha));
                        estado = 11;
                    }
                    else{
                        //ESTADO 29
                        i--;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_BARD.getValor(),"/",linha));
                        estado = 0; 
                        continue;
                    }
                    break;
                }
                // "/*"
                case 4:
                {   
                    if(simbolo == '*'){
                        aux += (char) simbolo;
                        estado = 5;
                    }
                    else{
                        aux += simbolo;
                    }
                        
                    break;
                }
                
                case 5:
                {
                    if(simbolo == '*'){
                        aux += (char) simbolo;
                    }
                    else if(simbolo == '/'){
                        aux = aux.substring(0, aux.length()-1);
                        lexemas.add(new Lexema (EnumTokens.TOKEN_CMT.getValor(),aux,linha));
                        lexemas.add(new Lexema (EnumTokens.TOKEN_FCMTP.getValor(),"*/",linha));
                        estado = 0;
                        aux="";
                        
                    }
                    else{
                        aux += (char) simbolo;
                        estado = 4;  
                    }
                    break;
                }
                
                case 7:{
                    if(i+1 == tam && Pattern.matches("[0-9]", Character.toString(simbolo)) ){
                        aux += (char) simbolo;
                        lexemas.add(new Lexema (EnumTokens.TOKEN_NUI.getValor(),aux,linha));
                        estado = 0;
                        aux="";
                    }
                           
                    else if(Pattern.matches("[0-9]", Character.toString(simbolo))){
                        aux += (char) simbolo;
                    }    
                    else if(simbolo == '.'){
                        aux += (char) simbolo;
                        if(i+1 != tam){
                            if(Pattern.matches("[0-9]", Character.toString(ficheiro[i+1])))
                                estado = 9;
                            else{
                                estado = 0;
                                System.out.println("NOTA: \""+aux+"\" Deve inserir um número a seguir ao '.' para formar um número decimal\n");
                                aux="";                        
                            }
                        } else 
                            System.out.println("Deve inserir um número a seguir ao '.' para formar um número decimal\n");
                    }
                    else {
                        i--;
                        lexemas.add(new Lexema (EnumTokens.TOKEN_NUI.getValor(),aux,linha));
                        estado = 0;
                        aux="";
                        continue;
                    }
                    break;
                    }
                
                case 9:{
                    if(Pattern.matches("[0-9]", Character.toString(simbolo))){
                        aux += (char) simbolo;
                        if(i+1 == tam){
                            lexemas.add(new Lexema (EnumTokens.TOKEN_NUD.getValor(),aux,linha));
                            estado = 0;
                            aux="";
                        } 
                        else estado = 10;
                    }
                    break; 
                }
                
                case 10:{
                    if(Pattern.matches("[0-9]", Character.toString(simbolo))){
                        aux += (char) simbolo;
                        if(i+1 == tam){
                            lexemas.add(new Lexema (EnumTokens.TOKEN_NUD.getValor(),aux,linha));
                            estado = 0;
                            aux="";
                        } 
                    }else {
                        i--; 
                        lexemas.add(new Lexema (EnumTokens.TOKEN_NUD.getValor(),aux,linha));
                        estado = 0;
                        aux="";
                        continue;
                    }
                    break;
                }
                case 11:{
                    if(simbolo =='\n'){
                        if( i+1 == tam)
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_CMT.getValor(), aux, linha));
                        estado = 0;
                        aux = "";
                    }
                    else
                        aux += simbolo;
                    break;
                }
                case 13:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_EQEQ.getValor(), aux, linha));
                        
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_EQ.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                case 16:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MASEQ.getValor(), aux, linha));
                    }
                    else if(simbolo == '+'){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MASMAS.getValor(), aux, linha));
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_MAS.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                case 19:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MENEQ.getValor(), aux, linha));
                    }
                    else if(simbolo == '-'){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MENMEN.getValor(), aux, linha));
                    }
                    else if(simbolo == '>'){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MENMR.getValor(), aux, linha));
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_MEN.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                case 22:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_ASTEQ.getValor(), aux, linha));
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_AST.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                case 25:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_EXCLEQ.getValor(), aux, linha));
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_EXCL.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                case 31:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MENREQ.getValor(), aux, linha));
                        aux="";
                    estado = 0;
                    }
                    else if(simbolo == '<'){
                        aux += simbolo;
                        if(i+1 == tam)
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MENRMENR.getValor(), aux, linha));
                        else{
                            estado = 45;
                        }
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_MENR.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    
                    break;
                }
                case 34:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MAREQ.getValor(), aux, linha));
                        aux="";
                    estado = 0;
                    }
                    else if(simbolo == '>'){
                        aux += simbolo;
                        if(i+1 == tam)
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MARMAR.getValor(), aux, linha));
                        else{
                            estado = 46;
                        }
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_MAR.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    
                    break;
                }
                
                case 38:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_POREQ.getValor(), aux, linha));
                        
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_POR.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                
                case 41:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_ECMEQ.getValor(), aux, linha));
                    }
                    else if(simbolo == '&'){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_ECMECM.getValor(), aux, linha));
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_ECM.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                
                case 45:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MENRMENREQ.getValor(), aux, linha));
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_MENRMENR.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                    
                }
                
                case 46:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_MARMAREQ.getValor(), aux, linha));
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_MARMAR.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                
                case 52:{
                    
                    if(simbolo == '"'){
                        lexemas.add(new Lexema(EnumTokens.TOKEN_CHARCC.getValor(), aux, linha)); 
                        estado = 0;
                        aux = "";
                    }
                    else
                        aux += simbolo;
                    
                    break;
                }
                
                case 54:{
                    if(i+1 != tam){
                    if(ficheiro[i+1] == '\''){
                        i++;
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_LCHAR.getValor(),aux,linha));
                    }
                    else System.out.println("Ao abrir aspas altas ('), também deve fechar, e deve conter apenas um símbolo entre '' \n");
                    }
                    aux = "";
                    estado = 0;
                    break;    
                }
                
                case 58: {
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_CIRCEQ.getValor(), aux, linha));
                        
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_CIRC.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }
                
                case 62:{
                    if(simbolo == '='){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_BAREQ.getValor(), aux, linha));
                    }
                    else if(simbolo == '|'){
                        aux += simbolo;
                        lexemas.add(new Lexema(EnumTokens.TOKEN_BARBAR.getValor(), aux, linha));
                    }
                    else{
                       i--;
                       lexemas.add(new Lexema(EnumTokens.TOKEN_BAR.getValor(), aux, linha));
                       aux="";
                       estado = 0;
                       continue;
                    }
                    aux="";
                    estado = 0;
                    break;
                }   
                
                } //fim switch-----------------------------------------------------------
            if(simbolo == '\n' )
            {
                linha++;
            }       
        }
        
         if(estado ==52)
             System.out.println("Ao abrir vírgulas altas(\"), também deve fechar para reconhecer\n");
         if(estado == 4 ||estado == 5)
             System.out.println("Deve fechar o comentário de várias linhas para reconhecer\n");
        return lexemas;
        
    }
    
    public static String lerSimbolo() {
        String conteudo = "";

        try {
            File file = new File(nomeFicheiro);
            
            
            if (!file.exists()) {
            System.err.println("O arquivo " + nomeFicheiro + " não existe."+"\n"+file.getPath());
            return conteudo;
        }
            FileInputStream fis = new FileInputStream(file);

            int caracter;
            
            while ((caracter = fis.read()) != -1) {
                //if (!Character.isWhitespace(caracter))
                
                conteudo += (char) caracter  ;   
            }        
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conteudo;
    }
    
}
