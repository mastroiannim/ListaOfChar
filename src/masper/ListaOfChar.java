package masper;

    public class ListaOfChar {
    protected Nodo head; //PROF.

    //PROF.
    //manca toString!

    //PROF.
    public ListaOfChar(){
        head = null;
    }

    //PROF.
    public void append(char info){
        if(head == null){
            head = new Nodo(info);
            return;
        }
        Nodo i = head;
        Nodo j = null;
        while(i != null){
            j = i;
            i = i.next;
        }
        i = new Nodo(info);
        j.next = i;
    }

    public int beforeC1(char c1, char c2) {
        Nodo nuovonodo = new Nodo(c2);
        int posizione = 0;
        if(head == null) {
            head = nuovonodo;
            return posizione;
        }
        Nodo corrente = head;
        Nodo precedente = null;
        while(corrente != null) {
            if(corrente.info == c1) {
                precedente = corrente;
                posizione++;
            }
            corrente = corrente.next;
        }
        if(precedente == null) {
            nuovonodo.next = head;
            head = nuovonodo;
        } else {
            nuovonodo.next = precedente.next;
            precedente.next = nuovonodo;
        }
        return posizione;
    }
    public void shuffle(int from, int to)throws posizioneNonPresente {
         if(from<0 || from>contaelementi()){
            throw new posizioneNonPresente(); 
         }
         if(to<=0){
             muoviallatesta(from);
         }
         if(to>=contaelementi()){
             muoviallacoda(from);
         }
         muoviallaposizione(from, to);
    }
    public ListaOfChar(char[] array){
        head = null;
        for (int a=0;a>array.length;a++) {
            Nodo nuovonodo = new Nodo(array[a]);
            nuovonodo.next = head;
            head = nuovonodo;
        }
        
    }
    public ListaOfChar(ListaOfChar lista1, ListaOfChar lista2){
        Nodo corrente1=lista1.head;
        Nodo corrente2=lista2.head;
        head=null;
        Nodo coda= null;
        while(corrente1!= null && corrente2!=null){
            if(corrente1.info<=corrente2.info){
                if(head==null){
                    head=corrente1;
                    coda=corrente1;
                }
                else{
                    
                }
                corrente1=corrente1.next;
                }else{
                    
                }
        }
    }
    private void muoviallaposizione(int from, int to) {
        Nodo corrente = head;
        Nodo precedente = null;
        Nodo correnteTo = head;
        Nodo precedenteTo = null;
        int posizione = 0;
        while(corrente != null && posizione < from) {
            precedente = corrente;
            corrente = corrente.next;
            posizione++;
        }
        posizione = 0;
        while(correnteTo != null && posizione < to) {
            precedenteTo = correnteTo;
            correnteTo = correnteTo.next;
            posizione++;
        }
        if(precedente == null) {
            head = corrente.next;
        } else {
            precedente.next = corrente.next;
        }
        if(precedenteTo == null) {
            corrente.next = head;
            head = corrente;
        } else {
            corrente.next = correnteTo;
            precedenteTo.next = corrente;
        }
    }
     private void muoviallatesta(int from) {
        Nodo corrente = head;
        Nodo precedente = null;
        int posizione = 0;
        while(corrente != null && posizione < from) {
            precedente = corrente;
            corrente = corrente.next;
            posizione++;
        }
        if(precedente == null) {
            return;
        }
        precedente.next = corrente.next;
        corrente.next = head;
        head = corrente;
    }
    private int contaelementi() {
        int conta = 0;
        Nodo corrente = head;
        while(corrente != null) {
            conta++;
            corrente = corrente.next;
        }
        return conta;
    }
    public void muoviallacoda(int from){
        Nodo corrente = head;
        Nodo precedente = null;
        int posizione = 0;
        while(corrente != null && posizione < from) {
            precedente = corrente;
            corrente = corrente.next;
            posizione++;
        }
        if(precedente == null) {
            head = corrente.next;
        } else {
            precedente.next = corrente.next;
        }
        Nodo coda = head;
        while(coda.next != null) {
            coda = coda.next;
        }
        coda.next = corrente;
        corrente.next = null;
    }
    
}
class posizioneNonPresente extends Exception{

}


