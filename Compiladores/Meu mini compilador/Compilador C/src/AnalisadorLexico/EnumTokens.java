package AnalisadorLexico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernestoamandio
 */
public enum EnumTokens {
    //PALAVRAS RESERVADAS
    TOKEN_INT("INTEIRO"),
    TOKEN_FLOAT("FLOAT"),
    TOKEN_DOUBLE("DOUBLE"),
    TOKEN_CHAR("CARACTERE"),
    TOKEN_VETOR("VETOR"),
    
    TOKEN_DEFAULT("DEFAULT"),
    
    TOKEN_IF("IF"),
    TOKEN_DO("DO"),
    
    TOKEN_CONTINUE("CONTINUE"),
    TOKEN_CASE("CASE"),
    TOKEN_CONST("CONST"),
    TOKEN_BREAK("BREAK"),
    
    TOKEN_SWITCH("SWITCH"),
    
    TOKEN_DEFINE("DEFINE"),
    TOKEN_INCLUDE("INCLUDE"),
    
    TOKEN_GOTO("GOTO"),
    //falta
    TOKEN_ELSE("ELSE"),
    TOKEN_VOID("VOID"),
    TOKEN_RETURN("RETURN"),
    
    
    TOKEN_WHILE("WHILE"),
    TOKEN_FOR("FOR"),
    
    //
    TOKEN_BARD("BARRA_DIREITA"),
    TOKEN_BARDEQ ("BARRA_DIREITA_IGUAL"),
    
    TOKEN_ICMTP ("INICIO_COMENTÁRIO_VARIAS_LINHAS"),
    TOKEN_FCMTP ("FIM_COMENTÁRIO_VARIAS_LINHAS"),
    TOKEN_CMTL ("COMENTÁRIO_UMA_LINHA"),
    TOKEN_CMT ("COMENTARIO"),
    
    TOKEN_NUI ("NÚMERO_INTEIRO"),
    
    TOKEN_NUD ("NÚMERO_DECIMAL"),
    
    TOKEN_EQ ("IGUAL"),
    TOKEN_EQEQ ("IGUAL_IGUAL"),
    
    TOKEN_MAS ("MAIS"),
    TOKEN_MASMAS ("MAIS_MAIS"),
    TOKEN_MASEQ ("MAIS_IGUAL"),
    
    TOKEN_MEN ("MENOS"),
    TOKEN_MENMR ("MENOS_MAIOR"),
    TOKEN_MENMEN ("MENOS_MENOS"),
    TOKEN_MENEQ ("MENOS_IGUAL"),
    
    TOKEN_AST ("ASTERISTICO"),
    TOKEN_ASTEQ ("ASTERISTICO_IGUAL"),
    
    TOKEN_EXCL ("EXCLAMAÇÃO"),
    TOKEN_EXCLEQ ("EXCLAMAÇÃO_IGUAL"),
    
    TOKEN_MENR ("MENOR"),
    TOKEN_MENRMENR ("MENOR_MENOR"),
    TOKEN_MENRMENREQ ("MENOR_MENOR_IGUAL"),
    TOKEN_MENREQ ("MENOR_IGUAL"),
    
    TOKEN_MAR ("MAIOR"),
    TOKEN_MARMAR ("MAIOR_MAIOR"),
    TOKEN_MARMAREQ ("MAIOR_MAIOR_IGUAL"),
    TOKEN_MAREQ ("MAIOR_IGUAL"),
    
    TOKEN_POR ("PORCENTO"),
    TOKEN_POREQ ("PORCENTO_IGUAL"),
    
    TOKEN_ECM ("E_COMERCIAL"),
    TOKEN_ECMEQ ("E_COMERCIAL_IGUAL"),
    TOKEN_ECMECM ("E_COMERCIAL_E_COMERCIAL"),
    
    TOKEN_QUEST ("INTERROGAÇÃO"),
    
    TOKEN_PTVG ("PONTO_E_VÍRGULA"),
    
    TOKEN_TAG ("CARDINAL"),
    
    TOKEN_LCHAR ("CARACTERE"),
    TOKEN_CHARCC ("CADEIA_DE_CARACTERES"),
    
    TOKEN_CIRC ("XOR_BITWISE"),
    TOKEN_CIRCEQ ("XOR_BITWISE_IGUAL"),
    
    TOKEN_DPT ("DOIS_PONTOS"),
    
    TOKEN_BAR ("BARRA"),
    TOKEN_BARBAR ("BARRA_BARRA"),
    TOKEN_BAREQ ("BARRA_IGUAL"),
    
    TOKEN_DOT ("PONTO"),
    
    TOKEN_ID ("IDENTIFICADOR"),
    
    TOKEN_APT ("ABRE_PARENTESES"),
    TOKEN_FPT ("FECHA_PARENTESE"),
    
    TOKEN_APTR ("ABRE_PARENTESE_RETOS"),
    TOKEN_FPTR ("FECHA_PARENTESE_RETOS"),
    
    TOKEN_ACHV ("ABRE_CHAVETAS"),
    TOKEN_FCHV ("FECHA_CHAVETAS"),
    
    TOKEN_VG ("VÍRGULA");
    
    private final String valor;
    
    private EnumTokens(String valor){
        this.valor = valor;   
    }

    public String getValor() {
        return valor;
    }

}
