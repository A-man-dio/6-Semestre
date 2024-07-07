package AnalisadorSintatico;

/**
 *
 * @author ernestoamandio
 */

import java.util.ArrayList;

public class Variavel {
    
    private String nome;
    private String tipo;
    private String valor;
    private int escopo;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getEscopo() {
        return escopo;
    }

    public void setEscopo(int escopo) {
        this.escopo = escopo;
    }
    
}
