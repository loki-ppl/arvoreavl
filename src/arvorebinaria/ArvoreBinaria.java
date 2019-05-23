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
public class ArvoreBinaria  {
    
    private Node raiz;
    
    public Node getRaiz() {
        return raiz;
    }   

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }    
    
    public boolean checkVazia(){
        return raiz != null;
    }
    
    public void removeMenor(){
        Node temp = raiz;
        Node anterior = raiz;        
        if(checkVazia()){
            if (temp.getEsquerda() == null && temp.getDireita() == null){
                raiz = null;            
            } else 
                if (temp.getEsquerda() == null){            
                    raiz = temp.getDireita();
                } else
                    while(temp.getEsquerda() != null){
                        anterior = temp;
                        temp = temp.getEsquerda();
                        }
                        anterior.setEsquerda(null); 
                        if(temp.getDireita() != null){
                                anterior.setEsquerda(temp.getDireita());
                                }
            } else System.out.println("arvore vazia");
    }
    
    public void removeMaior(){
        Node temp = raiz;
        Node anterior = raiz;
        if(checkVazia()){
            if (temp.getDireita() == null && temp.getEsquerda() == null){
                raiz = null;            
            } else 
                if (temp.getDireita() == null){            
                    raiz = temp.getEsquerda();
                } else
                    while(temp.getDireita() != null){
                        anterior = temp;
                        temp = temp.getDireita();
                        }
                        anterior.setDireita(null);      
                        if(temp.getEsquerda() != null){
                            anterior.setDireita(temp.getEsquerda());
                        }
            } else System.out.println("arvore vazia");
    }
    
    /*
    public void newNode(int info){
        Node newNode = new Node(info);
        
        if(raiz == null){            
            raiz = newNode;
        } else {
            Node temp = raiz;
            Node pai;            
            while(true){                
                pai = temp;                
                if(info < temp.getInfo()){
                    temp = temp.getEsquerda();
                    
                    if(temp == null){
                    pai.setEsquerda(newNode);
                    return;
                    }                    
                    
                } else {                    
                    temp = temp.getDireita();
                    if(temp == null){
                        pai.setDireita(newNode);
                        return;
                    }
                }                
            }           
        }        
    } */
    
    public void inOrder(Node node){
        if(node != null){
            inOrder(node.getEsquerda());
            System.out.println(node.getInfo());
            inOrder(node.getDireita());
        }
    }    
    
    public void preOrder(Node node){
        if(node != null){
            System.out.println(node.getInfo());
            preOrder(node.getEsquerda());            
            preOrder(node.getDireita());
        } 
    }   
    
    public void postOrder(Node node){
        if(node != null){            
            postOrder(node.getEsquerda());            
            postOrder(node.getDireita());
            System.out.println(node.getInfo());
        } 
    }
    
    public boolean removeNode(int info){
        Node temp = raiz;
        Node pai = raiz;
        
        boolean esquerda = true;
        
        //Verificar se a node está esquerda ou direita
        while(temp.getInfo() != info){
            pai = temp;
            
            if(info < temp.getInfo()){
                esquerda = true;
                temp = temp.getEsquerda();
            } else {
                esquerda = false;
                temp = temp.getDireita();
            }
            
            if(temp == null)
                return false;
        }
        
        //Node raiz
        if(temp.getEsquerda() == null && temp.getDireita() == null){
            if(temp == raiz){
                raiz = null;
            } else if(esquerda){
                pai.setEsquerda(null);
            } else {
                pai.setDireita(null);
            }
        }
        
        //Node raiz nao possui direita        
        else if(temp.getDireita() == null){
            if(temp == raiz){
                raiz = temp.getEsquerda();
            } else if(esquerda)
                pai.setEsquerda(temp.getEsquerda());
            
            else pai.setDireita(temp.getEsquerda());
        }
        
        //Node raiz nao possui esquerda        
        else if(temp.getEsquerda() == null){
            if(temp == raiz)
                raiz = temp.getDireita();
            
            else if(esquerda){
                pai.setEsquerda(temp.getDireita());
            }            
            else pai.setDireita(temp.getDireita());
        }
        
        //Node centro (mover node direita para raiz e esquerda como filho direita)
        else {
            Node substituto = getNodeSubstituto(temp);
            
            if(temp == raiz)
                raiz = substituto;
            
            else if(esquerda)
                pai.setEsquerda(substituto);
            
            else
                pai.setDireita(substituto);
            
            substituto.setEsquerda(temp.getEsquerda());            
        }       
        return true;
    }    
    
    public Node getNodeSubstituto(Node temp){
        Node substitutoPai = temp;
        Node substituto = temp;        
        Node filhoDireita = substituto.getDireita();
        
        while (filhoDireita != null){
            substitutoPai = substituto; 
            substituto = filhoDireita; 
            filhoDireita = filhoDireita.getEsquerda(); 
        }   
        
        if(substituto != temp.getDireita()){
            substitutoPai.setEsquerda(substituto.getDireita());
            substituto.setDireita(temp.getDireita());
        }        
        return substituto;
    }
    
    public int altura(){        
        if (raiz == null)
            return 0;
        return altura(raiz) -1;
    }    
    
    public int altura(Node node){        
        if (node == null)
            return 0;
        int alturaEsquerda = altura(node.getEsquerda()) + 1;
        int alturaDireita = altura(node.getDireita()) + 1;
        
        if(alturaEsquerda > alturaDireita){            
            return alturaEsquerda; }
        else            
        return alturaDireita;
        }    
    
    public int checkBalance(Node node){   
        if (node == null)
            return 0;
        return (altura(node.getEsquerda()) - altura(node.getDireita()));             
    } 
    
    public Node newNodeAVL(Node node, int info){     
        System.out.println("\ninserindo node " +info);
        if(node == null){    
            System.out.println("node null");
            System.out.println("inseriu " +info);
            return (new Node(info));
        }
                if(info < node.getInfo()){
                    System.out.println("node menor que "+node.getInfo()+" verificando filho esquerda");
                    //node = newNodeAVL(node.getEsquerda(),info);  
                    node.setEsquerda(newNodeAVL(node.getEsquerda(),info));
                    }                      
                 else if (info > node.getInfo()){  
                    System.out.println("node maior que "+node.getInfo()+" verificando filho direita");
                    //node = newNodeAVL(node.getDireita(),info);  
                    node.setDireita(newNodeAVL(node.getDireita(),info));
                } else 
            return node;           
        
        // se node estiver desbalanceado
        int balance = checkBalance(node); 
        System.out.println("balance node "+node.getInfo()+": "+balance);
        
        // Girar direita
        if (balance > 1 && info < node.getEsquerda().getInfo())    
        {
            System.out.println("gira direita");
            return girarDireita(node); 
        }
        // Girar esquerda
        if (balance < -1 && info > node.getDireita().getInfo()) 
            {
            System.out.println("gira esquerda");
            return girarEsquerda(node); 
  }
        // direita esquerda
        if (balance > 1 && info > node.getEsquerda().getInfo()) { 
            System.out.println("gira direita2");
            node.setEsquerda(girarEsquerda(node.getEsquerda())); 
            return girarDireita(node); 
        } 
  
        // esquerda direita 
        if (balance < -1 && info < node.getDireita().getInfo()) { 
            System.out.println("gira esquerda2");
            node.setDireita(girarDireita(node.getDireita()));             
            return girarEsquerda(node); 
        }   

        return node;            
    }     
    
    public Node girarEsquerda(Node raiz){
        Node temp = raiz.getDireita();
        Node temp2 = temp.getEsquerda();        
        temp.setEsquerda(raiz);
        raiz.setDireita(temp2);        
        return temp;        
    }  
    
    public Node girarDireita(Node raiz){
        Node temp = raiz.getEsquerda();
        raiz.setEsquerda(temp.getDireita());
        temp.setDireita(raiz);
        return temp;        
    }    
    
    public void printBinaryTree(Node temp, int level){   
        if(temp == null)
             return;
        printBinaryTree(temp.getDireita(), level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
                System.out.println("|-------"+temp.getInfo());
        } else
            System.out.println(temp.getInfo());
        printBinaryTree(temp.getEsquerda(), level+1);
        }    
 
}

    
  
 
