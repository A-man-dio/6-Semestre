package analisador;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Derby Cândido
 */
public class AnalisadorL1 {

    public static final Pattern identificador = Pattern.compile("([A-Z a-z]|[0-9]?)");

    public static ArrayList<String> palavrasReservadas = new ArrayList();


    private static void Analex(String texto, int linha) {

        Matcher matcher; // Cria um objeto Matcher para procurar a expressão regular no texto

       AutomatoNumero numero = new AutomatoNumero();
       AtomatoOperador operadores = new AtomatoOperador();
       AutomatoPonto ponto = new AutomatoPonto();
        
       if(texto.charAt(0) == '-' && texto.length() > 1){
           numero.q46(texto, 1, linha);
        
           return;
       }else if(texto.charAt(0) == '1' || texto.charAt(0) == '2' || texto.charAt(0) == '3' || texto.charAt(0) == '4' || texto.charAt(0) == '5' || texto.charAt(0) == '6' || texto.charAt(0) == '7' || texto.charAt(0) == '8' || texto.charAt(0) == '9' || texto.charAt(0) == '0'){
           numero.q3(texto, 1, linha);
           return;
           
       }else if(texto.charAt(0) == '-' && texto.length() >=1){
        
           operadores.q17(texto, 1, linha);
       
           return;
           
       }else if(texto.charAt(0) == '/' && texto.length() >=1){
        
           ponto.q7(texto, 1, linha);
           
           return;
        
       }else if(texto.charAt(0) == '}' && texto.length() ==1){
        
           ponto.q62(texto, 1, linha);
           
           return;
        
       }else if(texto.charAt(0) == '{' && texto.length() ==1){
        
           ponto.q45(texto, 1, linha);
           
           return;
        
       }else if(texto.charAt(0) == '[' && texto.length() ==1){
        
           ponto.q53(texto, 1, linha);
           
           return;
        
       }else if(texto.charAt(0) == ']' && texto.length() ==1){
        
           ponto.q49(texto, 1, linha);
           
           return;
        
       }else if(texto.charAt(0) == ';' && texto.length() ==1){
        
           ponto.q39(texto, 1, linha);
           
           return;
        
       }else if(texto.charAt(0) == ')' && texto.length() ==1){
        
           ponto.q64(texto, 1, linha);
           
           return;
        
       }else if(texto.charAt(0) == '(' && texto.length() ==1){
        
           ponto.q43(texto, 1, linha);
           
           return;
        
       }else if(texto.charAt(0) == '+' && texto.length() >=1){
        
           operadores.q13(texto, 1, linha);
       
           return;
           
       }else if(texto.charAt(0) == '/' && texto.length() >=1 && texto.endsWith("outro")){
       
           operadores.q36(texto.replace("outro",""), 1, linha);
       
           return;
       
        }else if(texto.charAt(0) == '*' && texto.length() >=1){
        
            operadores.q24(texto, 1, linha);
       
            return;
        
        }else if(texto.charAt(0) == '=' && texto.length() >=1){
        
            operadores.q21(texto, 1, linha);

            return;
        
        }else if(texto.charAt(0) == '?' && texto.length() == 1){
           
            operadores.q58(texto, 1, linha);

            return;
            
        }else if(texto.charAt(0) == '!' && texto.length() >=1){
         
            operadores.q36(texto, 1, linha);
       
            return;
            
        }else if(texto.charAt(0) == '>' && texto.length() >=1){
         
            operadores.q30(texto, 1, linha);
       
            return;
            
        }else if(texto.charAt(0) == '<' && texto.length() >=1){
        
            operadores.q33(texto, 1, linha);
       
            return;
        
        }else if(texto.charAt(0) == '&' && texto.length() >=1){
        
            operadores.q47(texto, 1, linha);
       
            return;
        
        }else if(texto.charAt(0) == '|' && texto.length() >=1){
        
            operadores.q51(texto, 1, linha);
       
            return;
       
        }else{
            
            if(palavrasReservadas.contains(texto)){
                
                System.out.println("keyword\t\t|" + texto + "\t\t\t|" + linha);
                return;
            }
            else{
                
                 matcher = identificador.matcher(texto);

                while (matcher.find()) { // Itera sobre cada correspondência encontrada
                    String correspondencia = matcher.group(); // Obtém a correspondência encontrada

                    if (!palavrasReservadas.contains(correspondencia)) {
                        System.out.println("Identificador\t\t|" + correspondencia + "\t\t\t|" + linha);
                    }

                return;
                }
                
            } 
            
        }
       return;
    }

    private static void Ler_caractere() {

        File arquivo = new File("C:/Users/Derby Cândido/Documents/NetBeansProjects/AnalisadorLexicoP/src/analisador/codigofonte.txt");

        try {

            FileReader leitorArquivo = new FileReader(arquivo);
            BufferedReader leitorLinha = new BufferedReader(leitorArquivo);

            int linha = 1;
            String texto;

            while ((texto = leitorLinha.readLine()) != null) {

                StringTokenizer token = new StringTokenizer(texto);
                while (token.hasMoreTokens()) {
                    Analex(token.nextToken(), linha);
                }
                linha++;
            }

            leitorArquivo.close();
            leitorLinha.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {

        System.out.println("Token\t\t\t|Lexema\t\t\t|Linha|");
        Ler_caractere();

        palavrasReservadas.add("abstract");
        palavrasReservadas.add("assert");
        palavrasReservadas.add("boolean");
        palavrasReservadas.add("break");
        palavrasReservadas.add("byte");
        palavrasReservadas.add("case");
        palavrasReservadas.add("catch");
        palavrasReservadas.add("char");
        palavrasReservadas.add("class");
        palavrasReservadas.add("const");
        palavrasReservadas.add("continue");
        palavrasReservadas.add("default");
        palavrasReservadas.add("do");
        palavrasReservadas.add("double");
        palavrasReservadas.add("else");
        palavrasReservadas.add("enum");
        palavrasReservadas.add("extends");
        palavrasReservadas.add("final");
        palavrasReservadas.add("finally");
        palavrasReservadas.add("float");
        palavrasReservadas.add("for");
        palavrasReservadas.add("goto");
        palavrasReservadas.add("if");
        palavrasReservadas.add("implements");
        palavrasReservadas.add("import");
        palavrasReservadas.add("instanceof");
        palavrasReservadas.add("int");
        palavrasReservadas.add("interface");
        palavrasReservadas.add("long");
        palavrasReservadas.add("native");
        palavrasReservadas.add("new");
        palavrasReservadas.add("package");
        palavrasReservadas.add("private");
        palavrasReservadas.add("protected");
        palavrasReservadas.add("public");
        palavrasReservadas.add("return");
        palavrasReservadas.add("short");
        palavrasReservadas.add("static");
        palavrasReservadas.add("strictfp");
        palavrasReservadas.add("String");
        palavrasReservadas.add("super");
        palavrasReservadas.add("switch");
        palavrasReservadas.add("synchronized");
        palavrasReservadas.add("this");
        palavrasReservadas.add("throw");
        palavrasReservadas.add("throws");
        palavrasReservadas.add("transient");
        palavrasReservadas.add("try");
        palavrasReservadas.add("void");
        palavrasReservadas.add("volatile");
        palavrasReservadas.add("while");

    }

}
