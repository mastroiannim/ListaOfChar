package volpis;

public class ListOfChar{
    protected Node head;        //PROF.
    protected int length = 0;   //PROF.


    //PROF.
    public ListOfChar(){
    }

    //PROF.
    public ListOfChar(ListOfChar a, ListOfChar b){
    }
    public ListOfChar(char[] caratteri) {
        for (int i=0; i<caratteri.length; i++) {
            this.append(caratteri[i]);
        }
    }

    public ListOfChar append(char n){
        if (head == null) {
            head = new Node(n);
            length++;
            return this;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(n);
        length++;
        return this;
    }

    public ListOfChar(char[] caratteri, boolean o){
            if(o){
            for (int i = 0; i < caratteri.length; i++) {

                
            }
        }
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

    //beforeC1
    public int beforeC1(char c1, char c2){
        Node nodo1 = new Node(c2);
        int pos = 0;
        
        if(length == 0){
            head = nodo1;
            return pos;
        }
        

        Node current = head;
        int conta = 0;
        while (current != null) {
            if (c1 == current.info) {
                conta++;
                break;
            }
            current = current.next;
            pos++;
        }

        if(conta == 0){
            this.append(c2);
            return this.length;
        }

        Node current1 = head;
        int count = 0;
        while (current1 != null) {
            if (count == conta) {
                nodo1.next = current1.next;
                current1.next = nodo1;
            }
            current1 = current1.next;
            count++;
        }
        length++;
        return pos;
    }

    public ListOfChar shuffle(int pos1 /*from*/, int pos2 /*to*/){
        if(pos2 >= length){
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            this.append(current.info);
            return this;
        }

        if(pos2 <= 0){
            insertHead(head.info);
            return this;
        }
        

        Node current = head;
        char preso = 'o';
        int cont = 0;
        while(current != null){
            if(cont == pos1){
                preso = current.info;
            }
            current = current.next;
            cont++;
        }
        this.insertAt(pos2, preso);
        current = head;
        cont = 0;
        while(current.next != null){
            if(cont == pos1-1){
                current.next = current.next.next;
            }
            current = current.next;
            cont++;
        }
        return this;
    }

    public ListOfChar insertAt(int pos, char info) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > length) {
            throw new IndexOutOfBoundsException("Posizione fuori dal range");
        }

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

    //insertHead
    public ListOfChar insertHead(char n) {
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
        length++;
        return this;
    }

    //

    //Node class
    class Node{
        //String info;
        public char info;           //PROF.
        public Node next = null;    //PROF.

        public Node(char info) {
            this.info = info;
        }
    }
    
}