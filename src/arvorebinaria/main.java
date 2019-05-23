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
         /*
        arvore.newNode(50);
        arvore.newNode(40);   
        arvore.newNode(30);  
        arvore.newNode(85);  
        arvore.newNode(80);  
        arvore.newNode(35); 
        arvore.newNode(81);
        arvore.newNode(82);
        arvore.newNode(83);
        arvore.newNode(84);
        
        System.out.println("in order");
        arvore.inOrder(arvore.getRaiz());
        
        System.out.println("pre order");
        arvore.preOrder(arvore.getRaiz());
        
        System.out.println("post order");
        arvore.postOrder(arvore.getRaiz());  

       
        arvore.removeNode(30);
        System.out.println("remove 30 pre order");
        arvore.preOrder(arvore.getRaiz());
        
        arvore.removeNode(50);
        System.out.println("remove 50 pre order");
        arvore.preOrder(arvore.getRaiz());
        

        System.out.println("\n");
        arvore.printBinaryTree(arvore.getRaiz(), 0);
        
        System.out.println("\n");
        arvore.removeMenor();
        System.out.println("remove menor pre order");        
	arvore.printBinaryTree(arvore.getRaiz(), 0);
        
        System.out.println("\n");
        arvore.removeMaior();
        System.out.println("remove maior pre order");        
	arvore.printBinaryTree(arvore.getRaiz(), 0);
        
        System.out.println(arvore.altura(arvore.getRaiz()));
        
        */             
   

    arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),120));
    System.out.println("\n-- Arvore --");
    arvore.printBinaryTree(arvore.getRaiz(), 0); 
    
    arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),130));    
    System.out.println("\n-- Arvore --");
    arvore.printBinaryTree(arvore.getRaiz(), 0); 
    
    arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),140));
    System.out.println("\n-- Arvore --");
    arvore.printBinaryTree(arvore.getRaiz(), 0); 
    
    arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),140));
        System.out.println("\n-- Arvore --");
    arvore.printBinaryTree(arvore.getRaiz(), 0); 
    
    arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),120));
    
        System.out.println("\n-- Arvore --");
    arvore.printBinaryTree(arvore.getRaiz(), 0); 
    
    arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),110));
    arvore.setRaiz(arvore.newNodeAVL(arvore.getRaiz(),10));
        System.out.println("\n-- Arvore --");
    arvore.printBinaryTree(arvore.getRaiz(), 0); 


    }    
}
