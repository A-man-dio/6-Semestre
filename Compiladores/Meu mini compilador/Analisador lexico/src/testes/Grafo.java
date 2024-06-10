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

public class Grafo {
    private ArrayList<Vertice> vertices;
    private Vertice atualV;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.atualV = new Vertice();
    }

    public Vertice getAtualV() {
        return atualV;
    }

    public boolean setAtualV(String id) {
        this.atualV = this.getVertice(id);
        
        if(this.atualV != null)
            return true;
        else return false;
    }
    
    public boolean alcancarV(String id) {
        //retorna true se do vertice atual consegue alcancar vertice id
        //nas arestas 
        Vertice destino = this.getVertice(id);
        
        if(destino != null)
        {
            for(Aresta aresta : this.atualV.getArestas()){
                if(aresta.getDestino().getId() == destino.getId() )
                {   
                    this.atualV = destino;
                    return true;
                }
            } 
        }
        return false;
    }
    

    public void adicionarVertice(Vertice vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add(vertice);
        }
    }

    public void adicionarAresta(Vertice origem, Vertice destino) {
        if (vertices.contains(origem) && vertices.contains(destino)) {
            Aresta aresta = new Aresta(origem, destino);
            origem.adicionarAresta(aresta);
        } else {
            throw new IllegalArgumentException("Ambos os vértices devem estar no grafo");
        }
    }

    public Vertice getVertice(String id) {
        for (Vertice v : vertices) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public void mostrarGrafo() {
        System.out.println("\n\n");
        for (Vertice vertice : vertices) {
            if(vertice.getId() != "~"){
                //
                System.out.print(vertice);
                if(!vertice.getArestas().isEmpty())
                {
                    //comentar abaixo e descomentar resto
                    //System.out.print(vertice);
                    System.out.print(" -> ");
                }
                else
                System.out.print(" ---- TERMINAL ");
                //continue
            }
            for (Aresta aresta : vertice.getArestas()) {
                System.out.print(aresta.getDestino().getId().replace("~", "/"));
                if(aresta != vertice.getArestas().get(vertice.getArestas().size()-1)){
                    System.out.print("  ");
                }
            }
            System.out.println("\n");
        }
    }
}
