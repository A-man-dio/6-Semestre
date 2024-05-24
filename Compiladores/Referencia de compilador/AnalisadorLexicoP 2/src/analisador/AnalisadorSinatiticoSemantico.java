package analisador;

import static analisador.AnalisadorL1.TOKENS;
import java.util.ArrayList;

/**
 *
 * @author Derby Cândido
 */
public class AnalisadorSinatiticoSemantico {

    int i = 0;
    int ContaErros = 0;

    public static final String orign = "\033[0m";
    public static final String vermelho = "\033[0;31m";
    
    ArrayList<String> operadoresA =  new ArrayList<>();
    ArrayList<String> operadoresL = new ArrayList<>();
    ArrayList<String> operadoresC = new ArrayList<>();

   
    
    private void adicionarOperadoresAritm() {
        this.operadoresA.add("+");
        this.operadoresA.add("-");
        this.operadoresA.add("/");
        this.operadoresA.add("*");
        this.operadoresA.add("++");
        this.operadoresA.add("--");
        
    }

    private void adicionarOperadoresIf() {
        this.operadoresL.add("&&");
        this.operadoresL.add("&");
        this.operadoresL.add("|");
        this.operadoresL.add("||");
    }

    private void adicionarOperadoresComp() {
        this.operadoresC.add(">");
        this.operadoresC.add("<");
        this.operadoresC.add(">=");
        this.operadoresC.add("<=");
        this.operadoresC.add("==");
        this.operadoresC.add("!=");
    }

    public void analisador() {
        adicionarOperadoresAritm();
        adicionarOperadoresComp();
        adicionarOperadoresIf();
        
        packageVerify();
        System.out.println("Total de erros " + ContaErros);
    }

    private void tipoErro(String tipo) {

        if (tipo.equals(";")) {
            System.out.println(vermelho+"Esperava encontrar ; na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("ID")) {
            System.out.println(vermelho+"Esperava encontrar ID na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("{")) {
            System.out.println(vermelho+"Esperava encontrar { na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("}")) {
            System.out.println(vermelho+"Esperava encontrar } na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("atribuicao")) {
            System.out.println(vermelho+"Esperava encontrar atribuicao valida na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals(")")) {
            System.out.println(vermelho+"Esperava encontrar ) na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("(")) {
            System.out.println(vermelho+"Esperava encontrar ( na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("package")) {
            System.out.println(vermelho+"Esperava encontrar package na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals(",")) {
            System.out.println(vermelho+"Esperava encontrar , na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals(". ;")) {
            System.out.println(vermelho+"Esperava encontrar . ou ; na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("class")) {
            System.out.println(vermelho+"Esperava encontrar class na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("TipoDado")) {
            System.out.println(vermelho+"Esperava encontrar um TipoDado na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("'")) {
            System.out.println(vermelho+"Esperava encontrar ' na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("[")) {
            System.out.println(vermelho+"Esperava encontrar [ na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.charAt(0) == '"') {
            System.out.println(vermelho+"Esperava encontrar '' na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("]")) {
            System.out.println(vermelho+"Esperava encontrar ] na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("break")) {
            System.out.println(vermelho+"Esperava encontrar break na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals(":")) {
            System.out.println(vermelho+"Esperava encontrar : na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("modacesso")) {
            System.out.println(vermelho+"Esperava encontrar =,( ou ; na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("ID numero")) {
            System.out.println(vermelho+"Esperava encontrar ID ou numero na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("args")) {
            System.out.println(vermelho+"Esperava encontrar args na linha " + TOKENS.get(i).linha + orign);
        } else if (tipo.equals("main")) {
            System.out.println(vermelho+"Esperava encontrar main na linha " + TOKENS.get(i).linha + orign);
        }else if (tipo.equals("( }")) {
            System.out.println(vermelho+"Esperava encontrar main na linha " + TOKENS.get(i).linha + orign);
        }else if (tipo.equals("main")) {
            System.out.println(vermelho+"Esperava encontrar main na linha " + TOKENS.get(i).linha + orign);
        }else {
            System.out.println(vermelho+"Erro ainda não declarado na linha " + TOKENS.get(i).linha + orign);
        }
        
        ContaErros++;
    }

    //verificar se o programa possui uma package
    private void packageVerify() {

        if (TOKENS.get(i).token.equals("package")) {
            i++;
            if (TOKENS.get(i).tipo.equals("ID")) {
                i++;
                if (TOKENS.get(i).token.equals(";")) {
                    i++;
                } else {
                    tipoErro(";");
                }
            } else {
                tipoErro("ID");
            }
        } else {
            tipoErro("package");
        }
        System.out.println("K");
        importVerify();
    }

    //verificar se o programa possui import
    private void importVerify() {

        if (TOKENS.get(i).token.equals("import")) {
            i++;
            auxImport();
        }
        System.out.println("A");
        typeClass();
    }

    //import auxiliar
    private void auxImport() {

        boolean verificador = true;

        while (verificador) {

            if (TOKENS.get(i).tipo.equals("ID")) {
                i++;
                if (TOKENS.get(i).token.equals(".")) {
                    i++;
                } else if (TOKENS.get(i).token.equals(";")) {
                    i++;
                    verificador = false;
                } else {
                    tipoErro(". ;");
                }
            } else {
                tipoErro("ID");
            }
        }

    }

    //verificando classes (class e public class ) 
    private void typeClass() {

        if (TOKENS.get(i).token.equals("public")) {
            i++;
            if (TOKENS.get(i).token.equals("class")) {
                i++;
                classDeclaration();
            } else {
                tipoErro("class");
            }
        } else if (TOKENS.get(i).token.equals("class")) {
            i++;
            classDeclaration();
        } else {
            tipoErro("class ");
        }

    }

    //declaração de classes
    private void classDeclaration() {

        if(TOKENS.get(i).tipo.equals("ID")){
            i++;
            if (TOKENS.get(i).token.equals("{")) {
                i++;
                corpoClasse();
                if(TOKENS.get(i).token.equals("}")){
                    i++;
                }else
                    tipoErro("}");
            }else if (TOKENS.get(i).token.equals("static")) {
                i++;
                classeMain();
                if(TOKENS.get(i).token.equals("}")){
                    i++;
                }else
                    tipoErro("}");

            }else {
                tipoErro("{");
            }
        }else
            tipoErro("ID");
    }

    //corpo da classe (funções e declaraçao de variáveis)
    private void corpoClasse() {

        if ((TOKENS.get(i).token.equals("public") && !TOKENS.get(i + 1).token.equals("static")) || TOKENS.get(i).token.equals("protected") || TOKENS.get(i).token.equals("private")) {
            i++;
            if (TOKENS.get(i).tipo.equals("TipoDado")) {
                String tipo = TOKENS.get(i).token;
                i++;
                if (TOKENS.get(i).tipo.equals("ID")) {
                    i++;
                    if (TOKENS.get(i).token.equals("=")) {
                        i++;
                        atribuicaoVariavel(tipo);
                    } else if (TOKENS.get(i).token.equals(";")) {
                        i++;
                    } else if (TOKENS.get(i).token.equals("(")) {
                        i++;
                        funcaoVerify();
                    } else {
                        tipoErro("modacesso");
                    }
                } else {
                    tipoErro("ID");
                }
            } else if (TOKENS.get(i).token.equals("void")) {
                i++;
                funcaoVerify();
            }

        } else if (TOKENS.get(i).tipo.equals("TipoDado")) {
            String tipo = TOKENS.get(i).token;
            i++;
            if (TOKENS.get(i).tipo.equals("ID")) {
                i++;
                if (TOKENS.get(i).token.equals("=")) {
                    i++;
                    atribuicaoVariavel(tipo);
                } else if (TOKENS.get(i).token.equals(";")) {
                    i++;
                } else {
                    tipoErro("= ;");
                }
            } else {
                tipoErro("ID");
            }
        }else if(TOKENS.get(i).token.equals("{") && TOKENS.get(i+1).token.equals("public") && TOKENS.get(i + 2).token.equals("static")) {
            i += 3;
            classeMain();
        }
        
    }

    //verificador de funções
    private void funcaoVerify() {

        if (TOKENS.get(i).tipo.equals("ID")) {
            i++;
            if (TOKENS.get(i).token.equals("(")) {
                i++;
                verParametros();
            }
        }
        corpoPrograma();
        if (TOKENS.get(i).token.equals("}")) {
            i++;
        } else {
            tipoErro("}");
        }

    }

    //verifica parâmetros
    private void verParametros() {

        if (TOKENS.get(i).tipo.equals("TipoDado")) {
            i++;
            if (TOKENS.get(i).tipo.equals("ID")) {
                i++;
                if (TOKENS.get(i).token.equals(",")) {
                    i++;
                    verParametros();
                } else if (TOKENS.get(i).token.equals(")")) {
                    i++;
                } else {
                    tipoErro(")");
                }
            } else {
                tipoErro("ID");
            }

        } else if (TOKENS.get(i).token.equals(")")) {
            i++;
            if (TOKENS.get(i).token.equals("{")) {
                i++;
            } else {
                tipoErro("{");
            }
        } else {
            tipoErro("TipoDado");
        }

    }

    //atribuição de variáveis
    private void atribuicaoVariavel(String tipo) {

        if (tipo.equals("char")) {
            if (TOKENS.get(i).token.equals("'")) {
                i++;
                if (TOKENS.get(i).tipo.equals("ID")) {
                    i++;
                    if (TOKENS.get(i).equals("'")) {
                        i++;
                        if (TOKENS.get(i).token.equals(";")) {
                            i++;
                        } else {
                            tipoErro(";");
                        }
                    } else {
                        tipoErro("'");
                    }
                } else {
                    tipoErro("ID");
                }
            } else {
                tipoErro("'");
            }

        } else if (TOKENS.get(i).token.equals("new")) {
            i++;
            if (TOKENS.get(i).token.equals(tipo)) {
                i++;
                if (TOKENS.get(i).token.equals(";")) {
                    i++;
                } else {
                    tipoErro(";");
                }
            } else {
                tipoErro("atribuicao");
            }
        } else if (TOKENS.get(i).token.charAt(0) == '"') {
            i++;
            if (TOKENS.get(i).tipo.equals("ID") || TOKENS.get(i).tipo.equals("numero")) {
                i++;
                if (TOKENS.get(i).token.charAt(0) == '"') {
                    i++;
                    if (TOKENS.get(i).token.equals(";")) {
                        i++;
                    } else {
                        tipoErro(";");
                    }
                } else {

                    char teste = '"';
                    String a = "";
                    a += teste;
                    tipoErro(a);
                    System.out.println("Esperava '' na linha " + TOKENS.get(i).linha);
                }
            } else {
                tipoErro("atribuicao");
            }
        } else if (tipo.equals("int") || tipo.equals("float") || tipo.equals("double")) {
            i++;
            if (TOKENS.get(i).tipo.equals("numero")) {
                i++;
                if (TOKENS.get(i).token.equals(";")) {
                    i++;
                } else {
                    tipoErro(";");
                }
            } else {
                tipoErro("numero");
            }
        } else {
            tipoErro("atribuicao");
        }
    }

    String aux = "";
    //corpo do programa
    private void corpoPrograma() {

        if (TOKENS.get(i).token.equals("if")){
            i++;
            ifVerify();
        }if(TOKENS.get(i).token.equals("switch")){
            i++;
            switchVerify();
        }if(TOKENS.get(i).token.equals("do")){
            i++;
            doWhile();
        }if(TOKENS.get(i).token.equals("while")){
            i++;
            whileVerify();
        } if(TOKENS.get(i).tipo.equals("TipoDado")){
            aux = TOKENS.get(i).token;
            i++;
            corpoPrograma();
        } if(TOKENS.get(i).token.equals("ID")){
            i++;
            if (TOKENS.get(i).tipo.equals("ID")) {
                i++;
                if (TOKENS.get(i).token.equals("=")) {
                    i++;
                    atribuicaoVariavel(aux);
                }else if (TOKENS.get(i).token.equals(";")) {
                    i++;
                }else if(TOKENS.get(i).token.equals("(")){
                    i++;
                    verParametros();
                    if(TOKENS.get(i).token.equals(";"))
                        i++;
                    else
                        tipoErro(";");
                
                }else if(operadoresA.contains(TOKENS.get(i).token)){
                    i++;
                    if(TOKENS.get(i).tipo.equals("ID")){
                        i++;
                        if(TOKENS.get(i).token.equals(";"))
                            i++;
                        else
                            tipoErro(";");
                    }else
                        tipoErro("ID");
                }else
                    tipoErro("= ; (");
            } else
                tipoErro("ID");
            
        }
    }

    private void classeMain() {
        //public static void main(String[] args)
        if (TOKENS.get(i).token.equals("void")) {
            i++;
            if (TOKENS.get(i).token.equals("main")) {
                i++;
                if (TOKENS.get(i).token.equals("(")) {
                    i++;
                    if (TOKENS.get(i).token.equals("String")) {
                        i++;
                        if (TOKENS.get(i).token.equals("[")) {
                            i++;
                            if (TOKENS.get(i).token.equals("]")) {
                                i++;
                                if (TOKENS.get(i).token.equals("args")) {
                                    i++;
                                    if (TOKENS.get(i).token.equals(")")) {
                                        i++;

                                        if (TOKENS.get(i).token.equals("{")) {
                                            i++;
                                            corpoPrograma();
                                            if (TOKENS.get(i).token.equals("}")) {
                                                i++;
                                            } else {
                                                tipoErro("}");
                                            }
                                        } else {
                                            tipoErro("{");
                                        }
                                    } else {
                                        tipoErro(")");
                                    }
                                } else {
                                    tipoErro("args");
                                }
                            } else {
                                tipoErro("]");
                            }
                        } else {
                            tipoErro("{");
                        }
                    } else {
                        tipoErro("String");
                    }
                } else {
                    tipoErro("(");
                }
            } else {
                tipoErro("main");
            }
        } else {
            tipoErro("void");
        }
    }

    

    //estruturas de seleção
    
    private void switchVerify(){
        
        if(TOKENS.get(i).token.equals("(")){
            i++;
            if(TOKENS.get(i).tipo.equals("ID")){
                i++;
                if(TOKENS.get(i).token.equals(")")){
                    i++;
                    if(TOKENS.get(i).token.equals("{")){
                        i++;
                        switchAux();
                       
                    }else
                        tipoErro("{");
                }else
                    tipoErro(")");
            }else
                tipoErro("ID");
        }else if(TOKENS.get(i).token.equals("default")){
            i++;
            
        }else
            tipoErro("(");
    }
    
    private void switchAux(){
        
        if(TOKENS.get(i).token.equals("case")){
            i++;
            if(TOKENS.get(i).tipo.equals("numero")){
                i++;
                if(TOKENS.get(i).token.equals(":")){
                    i++;
                    corpoPrograma();
                    if(TOKENS.get(i).token.equals("break")){
                        i++;
                        if(TOKENS.get(i).token.equals(";")){
                            i++;
                            if(TOKENS.get(i).token.equals("case"))
                                switchAux();
                        }else
                            tipoErro(";");
                    }else
                        tipoErro("break");
                }else
                    tipoErro(":");
            }else
                tipoErro("numero");
        }else
            tipoErro("case");
    }
    
    
    private void ifVerify() {

        if (TOKENS.get(i).token.equals("(")) {
            i++;
            ifAux();
        }else{
            tipoErro("(");
            
        }

    }
    
    private void ifAux(){
        
        if(TOKENS.get(i).tipo.equals("ID") || TOKENS.get(i).tipo.equals("numero")){
            i++;
            if(operadoresC.contains(TOKENS.get(i).token)){
                i++;
                if(TOKENS.get(i).tipo.equals("ID") || TOKENS.get(i).tipo.equals("numero")){
                    i++;
                    if(operadoresL.contains(TOKENS.get(i).token)){
                        i++;
                        ifAux();
                    }else if(TOKENS.get(i).token.equals(")")){
                        i++;
                        if(TOKENS.get(i).token.equals("{")){
                            i++;
                            corpoPrograma();
                            if(TOKENS.get(i).token.equals("}"))
                                i++;
                            else
                                tipoErro("}");
                        }else{
                            tipoErro("{");
                        }
                    }else{
                        tipoErro("{ )");
                    }
                }else{
                    tipoErro("ID numero");
                }
            }else{
                tipoErro("operador");
            }
        }else if(TOKENS.get(i).token.equals("else")){
            i++;
            if(TOKENS.get(i).token.equals("if")){
                i++;
                ifVerify();
            }else if(TOKENS.get(i).token.equals("{")){
                i++;
                corpoPrograma();
                if(TOKENS.get(i).token.equals("}"))
                    i++;
                else
                    tipoErro("}");
            }
        
        }else if(TOKENS.get(i).token.equals(")")){
            i++;
        }else{
            tipoErro("ID numero");
        }
    }
    
    //estruturas de repetição
    
    private void doWhile(){
        
        if(TOKENS.get(i).token.equals("{")){
            i++;
            auxDo();
        }else
            tipoErro("}");
    }
    
    private void auxDo(){
        
                if(!TOKENS.get(i).token.equals("}")){
                    corpoPrograma();i++;
                }else if(TOKENS.get(i).token.equals("}")){
                    i++;
                    if(TOKENS.get(i).token.equals("while")){
                        i++;
                        if(TOKENS.get(i).token.equals("(")){
                            i++;
                            if (TOKENS.get(i).tipo.equals("ID") || TOKENS.get(i).tipo.equals("numero")) {
                                i++;
                                if (operadoresC.contains(TOKENS.get(i).token)) {
                                    i++;
                                    if (TOKENS.get(i).tipo.equals("ID") || TOKENS.get(i).tipo.equals("numero")) {
                                        i++;
                                        }if (TOKENS.get(i).token.equals(")")) {
                                            i++;
                                        }else
                                            tipoErro(")");
                                    }else
                                    tipoErro("operador");
                                }else
                                    tipoErro("ID numerp");
                            }else tipoErro("(");
                        }else
                        tipoErro("while");
                    }else
                        tipoErro("}");                                
    
    }
        
    private void whileVerify(){
        
        if(TOKENS.get(i).token.equals("(")){
            i++;
            whileAux();
        }
        
        
    }
        
    private void whileAux(){
        
        if(TOKENS.get(i).token.equals("(")){
            i++;
            if (TOKENS.get(i).tipo.equals("ID") || TOKENS.get(i).tipo.equals("numero")) {
                i++;
                if (operadoresC.contains(TOKENS.get(i).token)) {
                    i++;
                    if (TOKENS.get(i).tipo.equals("ID") || TOKENS.get(i).tipo.equals("numero")) {
                        i++;
                    }
                    if (TOKENS.get(i).token.equals(")")) {
                        i++;
                        if(TOKENS.get(i).token.equals("{")){
                            i++;
                            corpoPrograma();
                    } else {
                        tipoErro(")");
                    }
                } else {
                    tipoErro("operador");
                }
            } else {
                tipoErro("ID numerp");
            }
        }else if(TOKENS.get(i).token.equals("}")){
            i++;
            if(TOKENS.get(i).token.equals(";"))
                i++;
            else
                tipoErro(";");
         }else
            tipoErro("( }");
            
        }   
    }
    
   
    
    
    }
    

