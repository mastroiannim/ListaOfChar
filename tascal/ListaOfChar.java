package tascal;

public class ListaOfChar
{
    Node head;
    
    public ListaOfChar(char[] caratteri){
        caratteri = new char[10];
    }
    
    public int beforeC1(char c1, char c2) throws Exception{
        Node indice = head;
        Node prima = head;
        int a = 0;
        int length = 0;
        int conta = 0;
        int conta2 = 0;
        boolean verifica = true;
        
        if (head == null){
            head = new Node(c2);
            conta++;
        }
        do{
            if (indice.info != c1)
                conta2++;
            indice = indice.next;
            length++;
        }while(indice.next != null);
        if(conta2 == length){
            indice = head;
            while(indice.next != null)
                indice = indice.next;
            indice.next = new Node(c2);
        }
        else{
            conta = 0;
            indice = head;
            
            while(indice.next != null){
                indice = indice.next;
                conta++;
            }
            
            do{
                if (a > 1)
                    prima  = prima.next;
                indice = indice.next;
                a++;
            }while(a != conta);
            
            /*
            do{
                if (indice.info 
                if (conta > 1)
                    prima = prima.next;
                else{
                    conta++;
                    indice = indice.next;
                }
            }while(indice.next != null);
            prima.next = new Node(c2);
            prima.next.next = indice;*/
        }
        
        return conta;  
    }
}
 
