package Montanelli;
public class ListOfChar
{
  
    private Node head;
    private int length;
    public ListOfChar()
    {
   
    }
    //costruttore classe a partire da un array di caratteri
     public ListOfChar(char []param)
    {
       head=new Node(param[0]);
       Node current =head;
       Node appoggio=null;
        for (int j=1;j<param.length;j++){
            appoggio=new Node(param[j]);
            current.next=appoggio;
            current=current.next;
       }
    }
        public ListOfChar insertAt(int pos, char info) throws IndexOutOfBoundsException {
        /*
            if (pos < 0 || pos > length) {
            throw new IndexOutOfBoundsException("hai inserito una posizione negativa o maggiore della lunghezza");
        }
        */
        

        Node newNode = new Node(info);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        }

        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == pos - 1) {
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
            count++;
        }
        length++;
        return this;
    }
    //ritorna l'indice del elemento se esiste, altrimenti -1
        public int indexOf(char c){
        Node current = head;
        int contains = 0;
        while (current!= null){
            if (current.info==c) {
                return contains;
            }
            contains++;
            current = current.next;
        }
        return -1;
    }
    //inserico un elemento prima della prima occorrenza del primo
    /*
     * Implementare un metodo Java beforeC1 per la classe ListaOfChar che accettati 
     * come parametri due caratteri c1 e c2, crei un nuovo nodo che ha come 
     * informazione c2 e lo inserisca prima dell’ultima occorrenza di c1 nella lista.
     * Se la lista è vuota il nuovo nodo viene inserito in testa, 
     * se invece c1 non esiste il nuovo nodo viene inserito in coda. 
     * La lista in oggetto ha i nodi di tipo (char info, Nodo next) e 
     * riferimento iniziale head. Il metodo ritorna un intero relativo 
     * alla posizione in cui è stato inserito il nuovo nodo. (2 pt.)

     */
    public int beforeC1(char cerca, char information){
        int indice=0;
        Node info=new Node(information);
        Node current=head;
        Node prev=null;
        if (head==null){
            head=info;
            return 0;
        }
        if (indexOf(cerca)==-1){
            int count=0;
             while (current.next!= null){   
                current = current.next;
                count++;
            }
            current.next=info;
            return count;
        }
       insertAt(indexOf(cerca), information);
        return indice;
    }
     public ListOfChar insertAtHead(char c) {
        Node nHead = new Node(c);
        nHead.next = head;
        head = nHead;
        length++;
        return this;
    }
    /*
     * Implementare un metodo Java shuffle per la classe ListaOfChar che 
     * ricevendo come parametri due valori interi from e to, 
     * sposti l’elemento di posizione from nella posizione to. 
     * Se to è minore o uguale a zero, 
     * l’elemento deve essere posto nella prima posizione della lista, 
     * mentre se to è maggiore o uguale al numero di elementi nella lista 
     * deve essere posto in ultima posizione. (2 pt.)

     */
    public ListOfChar shuffle(int from, int to){
       
        Node current = head;
        Node prev1 = null;
        Node prev2 = null;
        Node node1 = null;
        Node node2 = null;
         Node prevp1 = null;
        Node prevp2 = null;
        int i = 0;
        while (current != null) {
            //salvo i nodi delle posizioni a cui devo spostare e dei precedenti
            if (i == from) 
            {
                node1 = current;
            } else if (i == to) 
            {
                node2 = current;
            } else if (i == from - 1) 
            {
                prev1 = current;
            } else if (i == to - 1) 
            {
                prev2 = current;
            }
            else if (i == from - 2) 
            {
                prevp1 = current;
            } else if (i == to - 2) 
            {
                prevp2 = current;
            }
            current = current.next;
            i++;
        }
        /*//se sto cercando di inserire in una posizione minore o uguale di 0 inserisco in test 
        if (to<=0){
            insertAtHead(node1.info);
            prev1.next=node2;
        }
        //se sto cercand di inserire in posizione maggiore o uguale alla lunghezza allora lo metto in coda
        if (to>=length){
            append(node1.info);
            prev1.next=node2;
        }
        */
    
        if (prev1 != null) {
            prev1.next = node2;
        } else if(prev1==null/*||prevp1==null*/) {
            head = node2;
        }
    
        if (prev2 != null) {
            prev2.next = node1;
        } else if (prev2==null/*||prevp2==null*/){
            head = node1;
        }
       
        Node appoggio = node1.next;
         node1.next = node2.next;
          node2.next = appoggio;
        
        return this;
    }

        
     public ListOfChar append(char information){
        if (head == null) {
            head = new Node(information);
            length++;
            return this;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(information);
        length++;
        return this;
    }

     @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.info).append(" ");
            current = current.next;
        }
        return result.toString();
    }  
    class Node {
        //String info;
        private char info;
        private Node next = null;

        public Node(char info) {
            this.info = info;
        }
        public char getInfo(){
            return this.info;
        }
        public void setInfo(char insert){
            this.info=insert;
        }
    }
}
