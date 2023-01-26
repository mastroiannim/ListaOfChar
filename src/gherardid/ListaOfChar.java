package gherardid;


public class ListaOfChar
{
    private int items;
    private Nodo last;
    protected Nodo head; //PROF.

    //PROF.
    //manca toString!
    
    //PROF.
    public ListaOfChar(ListaOfChar a, ListaOfChar b){}

    //PROF.
    public int beforeC1(char c1, char c2){
        return beforec1(c1, c2);
    }

    public ListaOfChar(){
        head=null;
        items=0;
    }
    
    public ListaOfChar(char[] array){
        //head=null;
        items=0;
        for(int i = 0; i < array.length; i++){
            append(array[i]);
        }
    }
    
    public ListaOfChar(char[] arr1, char[] arr2){
        int i1=0;
        int i2=0;
        while(items<=arr1.length+arr2.length){
            if((int)arr1[i1]>(int)arr2[i2]){
                append(arr2[i2]);
                if(i2++<arr2.length-1)
                    i2++;
            }else{
                append(arr1[i1]);
                if(i1++<arr1.length-1)
                    i1++;
            }
        }
    }
    
    public void append(char o){
        Nodo nuovo = new Nodo(o);
        if(head==null){
            head=nuovo;
            last=head;
        }else{
            last.setNext(nuovo);
            last=last.getNext();
        }
        items++;
    }
    
    public int beforec1(char c1, char c2){
        Nodo nuovo = new Nodo(c2);
        int pos=0;
        if(head==null){
            head=nuovo;
            items++;
            return 0;
        }
        if(items==1){
            if(head.getInfo()==c1){
                Nodo appoggio=head;
                head=nuovo;
                head.setNext(appoggio);
                last=head.getNext();
                items++;
                return 0;
            }else{
                append(c2);
                return 1;
            }
        }
        Nodo corrente=head;
        Nodo precedente=null;
        Nodo ultimoPrecedente=null;
        for(int i = 0; i < items; i++){
            if(corrente.getInfo()==c1){
                ultimoPrecedente=precedente;
                pos=i;
            }
            precedente=corrente;
            corrente=corrente.getNext();
        }
        if(ultimoPrecedente!=null){
            Nodo appoggio=ultimoPrecedente.getNext();
            ultimoPrecedente.setNext(nuovo);
            ultimoPrecedente.getNext().setNext(appoggio);
            items++;
        }else{
            append(c2);
            return items-1;
        }
        
        return pos;
    }
    
    public void shuffle(int from, int to){
        if(from<0 | from >= items)
            throw new IndexOutOfBound();
        Nodo spostato=getAt(from);
        removeAt(from);
        /*if(to>items){
            last.setNext(spostato);
            return;
        }*/
        insertAt(to, spostato);
    }
    
    private Nodo getAt(int pos){
        if(items==0)
            throw new inexistentList();
        if(pos<0){
            throw new IndexOutOfBound();
        }
        int i=0;
        Nodo corrente=head;
        while(i!=pos){
            corrente=corrente.getNext();
            i++;
        }
        return corrente;
    }
    
    
    private void removeAt(int pos){
        if(items==0)
            throw new inexistentList();
        if(pos<0){
            throw new IndexOutOfBound();
        }
        int i=0;
        Nodo precedente = null;
        Nodo corrente=head;
        if(pos==0){
            head=head.getNext();
        }else{
            while(i!=pos){
                precedente=corrente;
                corrente=corrente.getNext();
                i++;
            }
            precedente.setNext(corrente.getNext());
        }
        if(pos==items-1)
            last=precedente;
        items--;
    }
    
    private void insertAt(int pos, Nodo nuovo){
        if(pos<0){
            throw new IndexOutOfBound();
        }
        if(pos>items)
            pos=items;
        int i=0;
        Nodo precedente = null;
        Nodo corrente=head;
        if(pos==items)
            last=nuovo;
        while(i!=pos){
            precedente=corrente;
            corrente=corrente.getNext();
            i++;
        }
        if(precedente!=null){
            precedente.setNext(nuovo);
        }
        nuovo.setNext(corrente);
        if(pos==0)
            head=nuovo;
        items++;
    }
    
    
    public class Nodo
    {
        public char info;  //PROF.
        public Nodo next;  //PROF.
        public Nodo(char info){
            this.info=info;
            this.next=null;
        }
        
        public Nodo getNext(){
            return next;
        }
        
        public void setNext(Nodo next){
            this.next=next;
        }
        
        public char getInfo(){
            return info;
        }
    }
    
    public class IndexOutOfBound extends RuntimeException{
        
    }
    
    public class inexistentList extends RuntimeException{
        
    }
}
