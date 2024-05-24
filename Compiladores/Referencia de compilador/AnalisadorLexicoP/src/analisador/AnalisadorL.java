package analisador;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
        
/**
 *
 * @author Derby Cândido
 */
public class AnalisadorL {
    
    public static final Pattern palavras_reservadas = Pattern.compile("\\b(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|d\n" +
"o|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|nati\n" +
"ve|new|package|private|protected|public|return|short|static|String|super|switch|this|throw|throws|try|void|while)");
    
    public static final Pattern identificador = Pattern.compile("\\b([a-zA-Z_][a-zA-Z0-9_]*)\\b");
    
    public static final Pattern numero = Pattern.compile("\\d+(,\\d+)?");
    
    public static final Pattern operadores = Pattern.compile("[+\\-*/%=<>?|&:^~]=?|\\|\\||&&");
    
    public static final Pattern simbolos = Pattern.compile("[^\\w\\s\\.]");

    public static ArrayList <String> Tokens = new ArrayList();
    
    public static ArrayList<String> palavrasReservadas = new ArrayList();
 
    
    
    private static void Gravar_Token_Lexema(ArrayList Tokens){
        
        try (BufferedWriter escritaLinha = new BufferedWriter(new FileWriter(new File("C:/Users/Derby Cândido/Documents/NetBeansProjects/AnalisadorLexicoP/src/analisador/Tabela.txt")))){
            
            String TokensnoArray = String.join(" ", Tokens);
            for (int i = 0; i != TokensnoArray.length(); i++) {
                if(TokensnoArray.charAt(i) == 'O')
                    escritaLinha.newLine();
                else
                    escritaLinha.write(TokensnoArray.charAt(i));
            }
                        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
    
    private static void ver_ficheiro(ArrayList Tokens,String correspondencia){

        File arquivo = new File("C:/Users/Derby Cândido/Documents/NetBeansProjects/AnalisadorLexicoP/src/analisador/Tokens.txt");
        
        try{    
            FileReader leitorArquivo = new FileReader(arquivo);
            BufferedReader leitorLinha = new BufferedReader(leitorArquivo);
            String texto = "";
            
            while((texto = leitorLinha.readLine()) != null){
                
                if(texto.contains(correspondencia)){
                    Tokens.add(texto);
                    
                    return;
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private static void ver_ID(ArrayList Tokens,String correspondencia){

        File arquivo = new File("C:/Users/Derby Cândido/Documents/NetBeansProjects/AnalisadorLexicoP/src/analisador/Tokens.txt");
        
        try{    
            FileReader leitorArquivo = new FileReader(arquivo);
            BufferedReader leitorLinha = new BufferedReader(leitorArquivo);
            String texto = "";
            
            while((texto = leitorLinha.readLine()) != null){
                
                if(texto.contains(correspondencia)){
                    return;
                }
               
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        Tokens.add(correspondencia+"|    ID   |");
        
        
    }
    
    
    
    private static void Analex(ArrayList Tokens, String texto,int linha){
        
        
                Matcher matcher ; // Cria um objeto Matcher para procurar a expressão regular no texto


                
                
                matcher = numero.matcher(texto);

                
                
                while (matcher.find()) { // Itera sobre cada correspondência encontrada
                    String correspondencia = matcher.group(); // Obtém a correspondência encontrada
                    Tokens.add("    numero   "+"    "+correspondencia+"   "+linha);
                    Tokens.add("O");
                
                }

                matcher = palavras_reservadas.matcher(texto);

                while (matcher.find()) { // Itera sobre cada correspondência encontrada
                    String correspondencia = matcher.group(); // Obtém a correspondência encontrada
                    ver_ficheiro(Tokens, correspondencia);
                    Tokens.add("        "+linha);
                    Tokens.add("O");
                    
                }

                matcher = operadores.matcher(texto);

                while (matcher.find()) { // Itera sobre cada correspondência encontrada
                    String correspondencia = matcher.group(); // Obtém a correspondência encontrada
                    ver_ficheiro(Tokens, correspondencia);
                    Tokens.add("        "+linha);
                    Tokens.add("O");
                
                }

                matcher = identificador.matcher(texto);

                while (matcher.find()) { // Itera sobre cada correspondência encontrada
                    String correspondencia = matcher.group(); // Obtém a correspondência encontrada
                    ver_ID(Tokens, correspondencia);
                    Tokens.add("    "+linha);
                    Tokens.add("O");
                   
                }               
                matcher = simbolos.matcher(texto);

                while (matcher.find()) { // Itera sobre cada correspondência encontrada
                    String correspondencia = matcher.group(); // Obtém a correspondência encontrada
                    ver_ficheiro(Tokens, correspondencia);
                    Tokens.add("        "+linha);
                    Tokens.add("O");
                   
                }  
        
        
        
    }
    
    private static void Ler_caractere(ArrayList Tokens ){
        
        File arquivo = new File("C:/Users/Derby Cândido/Documents/NetBeansProjects/AnalisadorLexicoP/src/analisador/codigofonte.txt");
        
        try {
            
            FileReader leitorArquivo = new FileReader(arquivo);
            BufferedReader leitorLinha = new BufferedReader(leitorArquivo);
            
            int linha = 1;
            String texto;
         
            while((texto = leitorLinha.readLine())!= null){
                
                Analex(Tokens, texto,linha);
              
                linha++;
           }
                
           leitorArquivo.close();
           leitorLinha.close();
           Gravar_Token_Lexema(Tokens);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void main(String[] args) {
                
    Tokens.add("       Token               |               Lexema                    |             Linha                      O");
    
    Ler_caractere(Tokens);
    
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
