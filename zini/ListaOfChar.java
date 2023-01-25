package zini;

public class ListaOfChar extends Exception{
    Node head;
    int length;
    public ListaOfChar(){
        head = null;
        length = 0;
    }
    public ListaOfChar(char[] charles){
        head = new Node(charles[0]);
        Node i = head;
        length = charles.length;
        for(int j = 1; j < length ;j++){
            i.next = new Node(charles[j]);
            i = i.next;
        }
    }
    public ListaOfChar append(char c){
        Node n=new Node(c);
        Node i=head;
        if(head==null){
            head=n;
            length++;
            return this;
        }
        while(i.next!=null){
                i=i.next;
            }
            i.next=n;
            length++;
        return this;
    }
    public String toString(){
        Node i=head;
        String out = "";
        for(int j = 0; j < length; j++){
            out+=i.info;
            i=i.next;
        }
        return out;
    }
    public Node getNodeAt(int index){
        if(index < 0 || index >= length)
            throw new IndexOutOfBoundsException();
        
        Node i = head;
        for(int j=0; j < index; j++){
            i = i.next;
        }
        return i;
    }
    //inserisci C2 prima dell'ultima occorrenza di c1
    public int beforeC1(char c1, char c2){
        Node i = head;
        Node c = new Node(c2);
        Node prev = null;
        if(head == null){
            head = c;
            length++;
            return 0;
        }
        if(head.info == c1){
            head = c;
            head.next = i;
            length++;
            return 0;
        }
        int j;
        for(j = 0; j < length; j++){
            if(i.info == c1){
                prev.next = c;
                c.next = i;
                break;
            }
            prev = i;
            i = i.next;
        }
        this.append(c2);
        return j;
    }
    public char getInfo(Node n){
        return n.info;
    }
    public void shuffle(int from, int to){
        Node n = getNodeAt(from);
        Node i = head;
        for(int j = 0; j < length; j++){
            if(i.next.info == n.info){
                i.next = n.next; //rimosso dalla lista
                length--;
                break;
            }
            i = i.next;
        }
        if(to <= 0){
            head = n;
            n.next = i;
            length++;
            return;
        }
        if(to >= length-1){
            append(n.info);
            return;
        }
        i = head;
        Node prev = null;
        for(int j = 0; j < to; j++){
            prev = i;
            i = i.next;
        }
        prev.next = n;
        n.next = i;
        length++;
    }
    class Node {
        private char info;
        private Node next;

        Node(char info){
            this.info = info;
        }
    }
}