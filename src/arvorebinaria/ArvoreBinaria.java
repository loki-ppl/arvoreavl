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
    
       // percorrer menor valor da arvore
    public Node minValueNode(Node node)  
    {  
        Node temp = node;    
        // loop ate menor folha
        while (temp.getEsquerda() != null)  
        temp = temp.getEsquerda(); 
  
        return temp;  
    }  
     
    public boolean achaNode(int info) {		
		Node temp = raiz;

		while (temp.getInfo() != info) {			
			if (info < temp.getInfo()) {
				// menor que raiz
                                temp = temp.getEsquerda();				
			} else {
				// maior que raiz
                                temp = temp.getDireita();				
			}
			// nao achou
			if (temp == null)
				return false;
		}
		return true;
	}   
    
    public Node removeNode2(Node node, int info){
     
    if (node == null)  
        return node;  
  
    // se info a ser deletada é menor que a raiz, entao estara no lado esquerdo
    if ( info < node.getInfo() )  
        node.setEsquerda(removeNode2(node.getEsquerda(),info));        
  
    // se info a ser deletada é maior que a raiz, entao estara no lado direito
    else if( info > node.getInfo() )         
         node.setDireita(removeNode2(node.getDireita(),info));
    
    else
    {        
        // node com apenas um filho ou 0
        if((node.getEsquerda() == null) || (node.getDireita() == null) )
        {
                Node temp = null;  
                //node filho esquerda ou direita
                if (temp == node.getEsquerda())  
                    temp = node.getDireita();  
                else
                    temp = node.getEsquerda();  
  
                // sem filho  
                if (temp == null)  
                { 
                    System.out.println("\nnode "+node.getInfo()+" sem filhos");
                    System.out.println("node "+node.getInfo()+" removido");
                    temp = node;  
                    node = null;  
                }  
                else // um filho 
                {
                    System.out.println("\nnode "+node.getInfo()+" possui um filho");
                    node = temp;  
                    System.out.println("node "+node.getInfo()+" movido para nova posicao");
                }
            }  
        else
            {    
                // dois filhos
                // menor da direita
                System.out.println("\nnode "+node.getInfo()+" possui dois filhos");
                System.out.println("esquerda: "+ node.getEsquerda().getInfo());
                System.out.println("direita: "+ node.getDireita().getInfo());
                Node temp = minValueNode(node.getDireita());  
                
                System.out.println("pegando menor valor a direita: "+temp.getInfo());
  
                // copia o menor valor para node atual
                node.setInfo(temp.getInfo());  
                System.out.println("setando menor valor para node");
  
                // deleta o menor 
                System.out.println("node menor deletada");
                node.setDireita(removeNode2(node.getDireita(),temp.getInfo()));                
            }  
        }  

        if (node == null)  
            return node;  
        
        // se node estiver desbalanceado
        int balance = checkBalance(node); 
        System.out.println("balance node "+node.getInfo()+": "+balance);
         
        // direita  
        if (balance > 1 && checkBalance(node.getDireita()) >= 0) {
            System.out.println("gira direita");
            return girarDireita(node);  }
  
        // esquerda 2x 
        if (balance > 1 && checkBalance(node.getEsquerda()) < 0)  
        {  
            System.out.println("gira esquerda 2x");
            node.setEsquerda(girarEsquerda(node.getEsquerda()));             
            return girarEsquerda(node);  
        }  
  
        // esquerda 
        if (balance < -1 && checkBalance(node.getDireita()) <= 0)  {
            System.out.println("gira esquerda");
            return girarEsquerda(node);
        }
  
        // direita 2x 
        if (balance < -1 && checkBalance(node.getDireita()) > 0)  
        {              
            System.out.println("gira direita 2x");
            node.setDireita(girarDireita(node.getDireita()));             
            return girarEsquerda(node);  

        }   
        return node;  
    }     
        
     public int altura(Node no) {
        if (no == null) {
            return -1;
        }
        if (altura(no.getEsquerda()) < altura(no.getDireita())) {
            return 1 + altura(no.getDireita());
        }
        return 1 + altura(no.getEsquerda());
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
            System.out.println("\ninseriu " +info);
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
        System.out.println("\nbalance node "+node.getInfo()+": "+balance);
        
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
            System.out.println("gira direita2x");
            node.setEsquerda(girarEsquerda(node.getEsquerda())); 
            return girarDireita(node); 
        } 
  
        // esquerda direita 
        if (balance < -1 && info < node.getDireita().getInfo()) { 
            System.out.println("gira esquerda2x");
            node.setDireita(girarDireita(node.getDireita()));             
            return girarEsquerda(node); 
        }   

        return node;            
    }     
    
    public Node girarEsquerda(Node raiz){
        Node temp1 = raiz.getDireita();  
        raiz.setDireita(temp1.getEsquerda());
        temp1.setEsquerda(raiz);                
        return temp1;        
    }     
    
    public Node girarDireita(Node raiz){
        Node temp2 = raiz.getEsquerda();
        raiz.setEsquerda(temp2.getDireita());
        temp2.setDireita(raiz);
        return temp2;        
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

    
  
 
