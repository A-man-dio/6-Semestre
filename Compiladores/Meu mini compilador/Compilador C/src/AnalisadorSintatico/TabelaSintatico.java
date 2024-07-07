/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisadorSintatico;

import java.util.ArrayList;

/**
 *
 * @author ernestoamandio
 */
public class TabelaSintatico {
    
    private Funcao funcao;
    private boolean isVar;
    private Variavel variavel;
    

    public TabelaSintatico() {
     
        this.funcao = new Funcao();
        this.variavel = new Variavel();
        
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Variavel getVariavel() {
        return variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }

    public boolean isVar() {
        return isVar;
    }

    public void setIsVar(boolean isVar) {
        this.isVar = isVar;
    }

    
  
}
