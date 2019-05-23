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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
       
        ArvoreBinaria arvore = new ArvoreBinaria();   

        arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),120));
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 

        arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),130));    
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 

        arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),140));
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 

        arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),200));
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 

        arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),1000));
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 

        arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),10));
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        
        /*
        arvore.removeNode(120);
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 

        arvore.removeNode(110);
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        
        arvore.removeNode(10);
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        
                arvore.removeNode(140);
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        */
       
        arvore.removeNode2(arvore.getRaiz(), 130);
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        
        arvore.removeNode2(arvore.getRaiz(), 120);
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        
        arvore.removeNode2(arvore.getRaiz(), 10);
        System.out.println("\n-- Arvore --");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        
        
    }    
}
