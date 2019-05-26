/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    
    /*    
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
    }    */

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
                System.out.println("\n## Buscando por "+info);
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

    public void insere(int info) {
        raiz = insere(raiz,info);  
    }
    
    public Node insere(Node no, int info) {    
        if (no == null) {
            no = new Node(info);
        }
        else if( info<no.getInfo()) no.setEsquerda(insere(no.getEsquerda(),info));
        else if( info>no.getInfo()) no.setDireita(insere(no.getDireita(),info));  
        no = balanceamento(no);
        return no;
    }
    
    public void removeNode(int info) {
        raiz = removeNode(raiz,info);  
    }
    
    public Node removeNode(Node node, int info){     
    if (node == null)  
        return node;  
  
    // se info a ser deletada é menor que a raiz, entao estara no lado esquerdo
    if ( info < node.getInfo() )  
        node.setEsquerda(removeNode(node.getEsquerda(),info));        
  
    // se info a ser deletada é maior que a raiz, entao estara no lado direito
    else if( info > node.getInfo() )         
         node.setDireita(removeNode(node.getDireita(),info));
    
    else
    {        
        // node com apenas um filho ou 0
        if((node.getEsquerda() == null) || (node.getDireita() == null) )
        {
                Node temp = null;  
                //node filho esquerda ou direita
                if (temp == node.getEsquerda())  
                    temp = node.getDireita();  //node nulo a esquerda, filho a direita
                else
                    temp = node.getEsquerda(); //node nulo a direita, filho a esquerda
  
                // sem filho  
                if (temp == null)  
                { 
                    System.out.println("\n## Removendo node: "+node.getInfo());
                    System.out.println("\nnode "+node.getInfo()+" sem filhos");
                    System.out.println("node "+node.getInfo()+" removido");
                    temp = node;  
                    node = null;  
                }  
                else // um filho 
                {
                    System.out.println("\n## Removendo node: "+node.getInfo());
                    System.out.println("\nnode "+node.getInfo()+" possui um filho");
                    node = temp;  
                    System.out.println("node "+node.getInfo()+" movido para nova posicao");
                }
            }  
        else
            {    
                // dois filhos
                // menor da direita
                System.out.println("\n## Removendo node: "+node.getInfo());
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
                node.setDireita(removeNode(node.getDireita(),temp.getInfo()));                
            }  
        }  

        if (node == null)  
            return node;  
        
        // balancear node
        node = balanceamento(node);
        return node;
    }     
        
    private Node balanceamento(Node no) {         
        if (checkBalance(no) == 2) {
            //rotaçao direita
            if (checkBalance(no.getEsquerda()) > 0) { 
                System.out.println("\nbalanceado node: "+no.getInfo()+" : "+checkBalance(no));
                System.out.println("gira direita");
                no = girarDireita(no); 
            }
            else {
                // direita esquerda
                System.out.println("\n*caso especial pai 2 filho -1");
                System.out.println("balanceado node: "+no.getInfo()+" : "+checkBalance(no));
                System.out.println("balanceado node: "+no.getEsquerda().getInfo()+" : "+checkBalance(no.getEsquerda()));                 
                System.out.println("gira esquerda 2x");                
                no.setEsquerda(girarEsquerda(no.getEsquerda()));
                return girarDireita(no);   
            }           
 
        } else if (checkBalance(no) == -2) {
            //rotaçao esquerda
            if (checkBalance(no.getDireita()) < 0) { 
                System.out.println("\nbalanceado node: "+no.getInfo()+" : "+checkBalance(no));
                System.out.println("gira esquerda");
                no = girarEsquerda(no);                
            }
            else {
                // esquerda direita
                System.out.println("\n*caso especial pai -2 filho 1");
                System.out.println("balanceado node: "+no.getInfo()+" : "+checkBalance(no));
                System.out.println("balanceado node: "+no.getDireita().getInfo()+" : "+checkBalance(no.getDireita()));
                no.setDireita(girarDireita(no.getDireita()));             
                System.out.println("gira direita 2x");
                return girarEsquerda(no);  
            }
        }        
        return no;
    }
    
    public Node girarEsquerda(Node raiz){
        Node temp1 = raiz.getDireita();  //cria novo node com direita da raiz 
        raiz.setDireita(temp1.getEsquerda()); //seta direita da raiz com direita temp
        temp1.setEsquerda(raiz); // seta esquerda temp para raiz            
        return temp1; //retorna nova raiz       
    }    

    public Node girarDireita(Node raiz){
        Node temp2 = raiz.getEsquerda(); //cria novo node com esquerda da raiz           
        raiz.setEsquerda(temp2.getDireita());  //seta esquerda da raiz com direita temp     
        temp2.setDireita(raiz); //seta direta temp para raiz       
        return temp2; //retorna nova raiz         
    }    
        
    public void printBinaryTree(Node temp, int level){   //codigo por Anurag Agarwal - https://stackoverflow.com/a/17515532
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

    
  
 