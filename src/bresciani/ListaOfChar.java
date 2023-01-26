package bresciani;

public class ListaOfChar
{
    //PROF.
    //manca toString!

    //PROF.
    public ListaOfChar(){
        head = null;
    }

    //PROF.
    public ListaOfChar(ListaOfChar a, ListaOfChar b){
    }


    //PROF.
    public void append(char info){
        if(head == null){
            head = new Nodo();
            head.info = info;
            return;
        }
        Nodo i = head;
        Nodo j = null;
        while(i != null){
            j = i;
            i = i.next;
        }
        i = new Nodo();
        i.info = info;
        j.next = i;
    }

    public  Nodo  head;
    public int beforeC1(char c1, char c2){
        Nodo n = new Nodo();
        Nodo j = head;
         if (j == null) {
            j = n;
            return 0;
        }
        Nodo corrente = j;
        Nodo precendente = null;
        int posizione = 0;
        while (corrente != null) {
            if (corrente.info == c1) {
                precendente = corrente;
                posizione++;
            }
            corrente = corrente.next;
        }
        if (precendente == null) {
            n.next = j;
            j = n;
            return 0;
        } else {
            n.next = precendente.next;
            precendente.next = n;
            return posizione;
        }
    }
    
    public ListaOfChar(char[] valori){
        Nodo j = head;
        for(int i = valori.length -1; i<=0; i++){
            Nodo n = new Nodo();
            n.info = valori[i];
            n.next = j;
            j = n;
        }
    }
}
