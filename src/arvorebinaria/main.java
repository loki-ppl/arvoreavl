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
         
         
        arvore.insere(10);
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        
        arvore.insere(9);
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
        
        arvore.insere(8);
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0);   
        
        arvore.insere(7);
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0);   
        
        System.out.println(arvore.achaNode(9));
        
        arvore.removeNode(9);
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0); 
                
        arvore.removeNode(10);
        System.out.println("\n/-----/ Arvore /-----/");
        arvore.printBinaryTree(arvore.getRaiz(), 0);  
        
        System.out.println(arvore.achaNode(8));
        System.out.println(arvore.achaNode(55));
         
        

    }    
}
