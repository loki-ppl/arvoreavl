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
        arvore.preOrder(arvore.getRaiz());
        arvore.inOrder(arvore.getRaiz());
        arvore.postOrder(arvore.getRaiz());        
        */
         
      
    arvore.insere(5);
        arvore.insere(4);
        arvore.insere(3);
        arvore.insere(2);
        arvore.insere(1);
        arvore.insere(7);
        arvore.insere(6);
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0);   
        arvore.removeNode(2);
        arvore.removeNode(6);
        
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0);   

        arvore.insere(2);
        
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0);   
        

    }    
}
