package gavocid;

public class listaGavoci
{
    public Nodo head;
    public int lunghezza;
    char[] caratteri = new char[4];

    //PROF.
    public listaGavoci(){
    }

    //PROF.
    public listaGavoci(char[] c){
    }

    //PROF.
    public listaGavoci(listaGavoci a, listaGavoci b){
    }
    
    public listaGavoci(char a, char b, char c, char d){
        head = null;
        lunghezza = 0;
        caratteri[0] = a;
        caratteri[1] = b;
        caratteri[2] = c;
        caratteri[3] = d;
        for(int i=0;i<caratteri.length;i++){
            this.append(caratteri[i]);
        }
    }
    
    public void append(char o){
        Nodo x =  new Nodo(o);
        Nodo a = head;
        Nodo indice = head;
        if(a==null){
            head = x;
        }else{
            while(indice.succ != null){
                indice=indice.succ;
            }
            indice.succ = x;
        }
        lunghezza++;
        return;
    }
    
    public void insertAt(char o, int posizione) throws notComparisonPositionException
    {
        if(posizione > lunghezza || posizione<0){
            throw new notComparisonPositionException();
        }
        Nodo nuovo = new Nodo(o);
        if (posizione==0) {
            nuovo.succ=head;
            head=nuovo;
            lunghezza++;
            return;
        }
        Nodo indice = head;
        for (int i=0; i<posizione-1; i++) {
            indice = indice.succ;
        }
        nuovo.succ=indice.succ;
        indice.succ=nuovo;
        lunghezza++;
    }
    
    public Object get(int posizione) throws notComparisonPositionException{
        Nodo x = head;
        if(posizione > lunghezza || posizione<0){
            throw new notComparisonPositionException();
        }
        
        for(int i=0;i<posizione;i++){
            x=x.succ;
        }
        return x.info;
    }
    
    public void remove(int posizione) throws notComparisonPositionException{
        if(posizione > lunghezza || posizione<0){
            throw new notComparisonPositionException();
        }
        Nodo x = head;
        Nodo indice = head;
        for(int i=0;i<posizione-1;i++){
            x=x.succ;
            }
        x.succ=x.succ.succ;  
        lunghezza--;
    }
    
    public int getLunghezza(){
        return lunghezza;
    }
    
    
    public void reverse() {
        Nodo indice=head;
        Nodo prec=null;
        Nodo succ=null;
        while (indice!=null) {
            succ=indice.succ;
            indice.succ=prec;
            prec=indice;
            indice=succ;
        }
        head=prec;
    }
    
    
    public String toString(){
        String stringa="";
        Nodo x=head;
        for(int i=0;i<lunghezza;i++){
            stringa+=""+x.info+", ";
            x=x.succ;
        }
        return stringa;
    }
    
    
    public void shuffle(int from, int to) {
        if (head == null) {
            return;
        }
        
        Nodo scambio = null;
        Nodo NodoAttuale = head;
        Nodo prev = head;
        int i = 0;
        
        while (NodoAttuale != null) {
            if (i == from) {
                scambio = NodoAttuale;
                prev.succ = NodoAttuale.succ;
                break;
            }
            prev = NodoAttuale;
            NodoAttuale = NodoAttuale.succ;
            i++;
        }
        
        if (to <= 0) {
            scambio.succ = head;
            head = scambio;
        } else {
            NodoAttuale = head;
            i = 0;
            while (NodoAttuale != null) {
                if (i == to - 1) {
                    scambio.succ = NodoAttuale.succ;
                    NodoAttuale.succ = scambio;
                    break;
                }
                NodoAttuale = NodoAttuale.succ;
                i++;
            }
        }
    }

     public void beforeC1(char c1, char c2) {
        Nodo x = new Nodo(c2);
        Nodo nodoAttuale = head;
        
        if (head == null) {
            head = x;
            return;
        }
        int i = 0;
        Nodo prev = null;
        while (nodoAttuale != null) {
            if (((char)nodoAttuale.info) == c1) {
                prev = nodoAttuale;
                i++;
            }
            nodoAttuale = nodoAttuale.succ;
        }
        
        
        if (prev == null) {
            x.succ = head;
            head = x;
        } else {
            x.succ = prev.succ;
            prev.succ = x;
        }
    }
    
    
    class notComparisonPositionException extends Exception{}
}
