package chandra;

public class ListaOfChar
{
    protected Nodo head;
    protected int length;

    //PROF.
    //manca toString!
    
    public ListaOfChar(){
        head = null;
        length = 0;
    }
    
    public ListaOfChar(char[] charArray){
        head = null;
        length = 0;
        
        for(int i = 0; i < charArray.length; i++){
            this.append(charArray[i]);
        }
    }
    
    public ListaOfChar(ListaOfChar lista1, ListaOfChar lista2){
        if(lista1.length >= lista2.length){
            int maggiore = 1;
            int lengthMaggiore = lista1.length;
            int lengthMinore = lista2.length;
        }else{
            int maggiore = 2;
            int lengthMaggiore = lista2.length;
            int lengthminore = lista1.length;
        }
    }
    
    private Nodo moveToLast(){
        Nodo tempNodo = head;
        while(tempNodo.next != null){
            tempNodo = tempNodo.next;
        }
        
        return tempNodo;
    }
    
    private Nodo moveTo(int pos){
        if(pos < 0 || pos > length) throw new ListaOutOfBounds();
        
        Nodo nodoTemp = head;
        for(int i = 0; i < pos; i++){
            nodoTemp = nodoTemp.next;
        }
        
        return nodoTemp;
    }
    
    public ListaOfChar append(char o){
        if(length == 0){
            head = new Nodo(o);
            length++;
            return this;
        }
        
        Nodo tempNodo = moveToLast();
        tempNodo.next = new Nodo(o);
        length++;
        
        return this;
    }
    
    public int beforeC1(char c1, char c2){
        if(length == 0){
            head = new Nodo(c2);
            length++;
            return 0;
        }
        
        int lastPosition = -1;
        int thisPosition = 0;
        Nodo nodoToFind = new Nodo(c1);
        Nodo lastNodo = null;
        Nodo tempNodo = head;
        
        if(tempNodo.compareTo(nodoToFind) == 0){
            lastPosition = thisPosition;
        }
        
        while(tempNodo.next != null){
            thisPosition++;
            if(tempNodo.next.compareTo(nodoToFind) == 0){
                lastPosition = thisPosition;
                lastNodo = tempNodo;
            }
            
            tempNodo= tempNodo.next;
        }
        
        if(lastPosition == -1){
            this.append(c2);
            length++;
            return length;
        }
        
        if(lastPosition == 0){
            head = new Nodo(c2, head);
            length++;
            return 0;
        }
        
        lastNodo.next = new Nodo(c2, lastNodo.next);
        length++;
        return lastPosition;
    }
    
    public ListaOfChar shuffle(int from, int to){
        if(to <= 0){
            head = new Nodo(moveTo(from).info, head);
            moveTo(from).next = moveTo(from).next.next;
            
            return this;
        }
        
        if(to >= length){
            append(moveTo(from).info);
            length--;
            moveTo(from).next = moveTo(from).next.next;
            
            return this;
        }
        
        Nodo fromNodo = moveTo(from);
        Nodo toNodo = moveTo(to);
        char tempChar = fromNodo.info;
        
        System.out.println(tempChar);
        
        fromNodo.info = toNodo.info;
        toNodo.info = tempChar;
        
        return this;
    }
    //PROF.
    public class Nodo implements Comparable
{
    public char info; //PROF.
    public Nodo next; //PROF.
    
    public Nodo(char info){
        this.info = info;
        next = null;
    }
    
    public Nodo(char info, Nodo next){
        this.info = info;
        this.next = next;
    }
    
    @Override
    public int compareTo(Object o){
        Nodo newNodo = (Nodo)o;
        if(this.info < newNodo.info) return -1;
        if(this.info == newNodo.info) return 0;
        return 1;
    }
}
}



class ListaOutOfBounds extends RuntimeException{
    
}
