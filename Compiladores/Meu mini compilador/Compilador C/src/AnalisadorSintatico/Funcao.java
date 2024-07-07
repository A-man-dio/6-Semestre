package AnalisadorSintatico;

/**
 *
 * @author ernestoamandio
 */
import java.util.ArrayList;
import java.util.List;
    

public class Funcao {
    
    private String nome;
    private String tipo;
    private ArrayList<Variavel> parametro;
    private int escopo;
    
    public Funcao (){
        this.parametro = new ArrayList<>();
    }

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

    public ArrayList<Variavel> getParametro() {
        return parametro;
    }

    public void addParametro(Variavel parametro) {
        this.parametro.add(parametro);
    }

    public int getEscopo() {
        return escopo;
    }

    public void setEscopo(int escopo) {
        this.escopo = escopo;
    }
    
    
   
}
