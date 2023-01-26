package bonacinag;

public class ListaOfChar
{
    public Nodo head;
    private int length;

    //PROF.
    //manca toString!

    //PROF.
    public ListaOfChar(ListaOfChar a, ListaOfChar b){
    }
    
    public ListaOfChar()
    {
       this.head = null;
       this.length = 0;
    }
    
    //PROF.
    public /* void */ListaOfChar(char[] cartteri){
        for(int i = this.length; i<cartteri.length; i++){
            this.append(cartteri[i]);
        }
    }
    
    
    public int beforeC1(char c1, char c2){
        int posizione = 0;
        Nodo nuovoNodo = new Nodo(c2);
        if(this.head == null){
            this.head = nuovoNodo;
            return posizione;
        }else{
            Nodo cercato = this.head;    
            for(int i = 0; i < length; i++){
                if(cercato.info == c1){
                    System.out.println(cercato.info);
                    posizione = i;
                }
                cercato = cercato.nodoNext;
            }    
        }
        
        Nodo cercato = this.head;
        for(int i = 0; i < (posizione-2); i++){
            cercato = cercato.nodoNext;
        }
        
        nuovoNodo.nodoNext =  cercato.nodoNext.nodoNext;
        cercato.nodoNext = nuovoNodo;
        
        return posizione;
    }
    
    public void shuffle(int from, int to) throws FuoriLimitiException
    {
        Nodo cercato = this.head;  
        Nodo nuovoNodo = new Nodo('1');
        
        for(int i = 0; i < from; i++){
            cercato = cercato.nodoNext;
        }
        
        if(to <= 0){
           insertAt(0,cercato);
        }else{
        if(to >= this.length)
           insertAt((this.length-1),cercato);
        }
    }
    
    public void insertAt(int y, Nodo e) throws FuoriLimitiException
    {
        Nodo c = this.head;  
        Nodo nuovoNodo = new Nodo(e.info);
        nuovoNodo.nodoNext = e.nodoNext;
        
        
        if(y == 0){
            if(this.head.nodoNext == null){
                this.head = null;
            }else{
                nuovoNodo.nodoNext = this.head.nodoNext;
                this.head = nuovoNodo;
            }
        }else{
            for(int i = 1; i < (y-1); i++){
                c = c.nodoNext;
            }
            nuovoNodo.nodoNext = c.nodoNext;
            c.nodoNext = nuovoNodo;
        }
    }
    
    public void append(char e)
    {
        if(this.head != null){
            Nodo c = this.head;
            for(int i = 0; i < length; i++){
                if(c.nodoNext == null){
                    c.nodoNext = new Nodo(e);
                    length++;
                }else{
                    c = c.nodoNext;
                }
            }
        }else{
            this.head = new Nodo(e);
            length++;
        }
    }
    
    class FuoriLimitiException extends RuntimeException{}
}
