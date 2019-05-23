/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author lucas
 */
public class Node {
    
    private int info;
    private Node direita;
    private Node esquerda;
    
    
    public Node(int info){
        this.info = info;
    }

    public int getInfo() {
        return this.info;
    }

    public Node getDireita() {
        return this.direita;
    }

    public Node getEsquerda() {
        return this.esquerda;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }
    
    
    
}
