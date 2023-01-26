package arnoldi;
public class ListaOfChar
{
    protected Nodo head=null; //PROF.
    int length=0;
    char[] array={'a','b','c'};
    public ListaOfChar(ListaOfChar l)
    {
        for(int i=0;i<array.length;i++){
            l.beforeC1('z',array[i]);
        }
        
    }

    //PROF.
    //il metodo shuffle entra in loop infinito
    
    //PROF.
    //manca toString!

    //PROF.
    public ListaOfChar(){
    }

    //PROF.
    public ListaOfChar(char[] c){
    }

    //PROF.
    public ListaOfChar(ListaOfChar a, ListaOfChar b){
    }

    //PROF.
    public void append(char c){
        insertAt(length, new Nodo(c));
    }

    
    

    private int trova(char c1,char c){
        for(int i=length-1;i>=0;i--){
            if(c==c1){
                return i;
            }
        
        }
        return -1;
    }
    public int beforeC1(char c1,char c2)throws IllegalArgumentException {
        if(length<0){
            throw new IllegalArgumentException();
        }
        if (head == null) {
            head = new Nodo(c2);
            length++;
            return 0;
            
        }
        
        Nodo current = head;
        Nodo cc=new Nodo(c2);
        int i;
        while (current.next != null) {
            current = current.next;
        }
        i=trova(c1,current.info);
        if(i==-1){
            current.next = new Nodo(c2);
            length++; 
            return length-1;
        }else{
            current.next = cc.next;
            cc.next = current;
            length++;
            return i-1;

        }
        
    }
    private ListaOfChar insertAt(int pos, Nodo c) throws IllegalArgumentException, IndexOutOfBoundsException {
        Nodo newNode =c;
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            length++;
            return this;
        }

        Nodo current = head;
        int count = 0;
        while (current != null) {
            if (count == pos - 1) {
                newNode.next = current.next;
                current.next = newNode;
                length++;
                return this;
            }
            current = current.next;
            count++;
        }
        throw new IndexOutOfBoundsException("Posizione fuori dal range");
    }
    private ListaOfChar removeAt(int pos) throws IllegalArgumentException {
        if (pos < 0) {
            throw new IllegalArgumentException("Inserire un intero positivo");
        }

        if (head == null) {
            return this;
        }
        if (length == 1) {
            head = head.next;
            length--;
            return this;
        }

        Nodo current = head;
        while (current.next != null) {
            if (length == pos) {
                current.next = current.next.next;
                length--;
                return this;
            }
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Posizione fuori dal range");
    }
    public ListaOfChar shuffle(int from, int to) {
        Nodo cc=head;
        ListaOfChar l;
        for(int i=0;i<from;i++){
            cc=cc.next;
        }
        if(to<=0){
            return insertAt(0,cc);
        }else{
            if(to>=length){
                Nodo current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current=cc;
                return this;
            }else{
                l=insertAt(to,cc);
                l= removeAt(from);
                return l;
                
            }
        }
        
        
        
    }
}
