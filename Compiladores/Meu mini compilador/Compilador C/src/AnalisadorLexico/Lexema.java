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
public class Lexema {
    private String token;
    private String lexema;
    private int linha;

    public Lexema(String token, String lexema, int linha) {
        this.token = token;
        this.lexema = lexema;
        this.linha = linha;
        
    }

        public String getToken() {
            return token;
        }

        public String getLexema() {
            return lexema;
        }
      
        public int getLinha() {
            return linha;
        }

        public void setLinha(int linha) {
            this.linha = linha;
        }
    }
