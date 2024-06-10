/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

/**
 *
 * @author ernestoamandio
 */
import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String id;
    private ArrayList<Aresta> arestas;

    
    public Vertice() {
        
    }
    
    public Vertice(String id) {
        this.id = id;
        this.arestas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void adicionarAresta(Aresta aresta) {
        arestas.add(aresta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertice vertice = (Vertice) obj;
        return id.equals(vertice.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }
}
