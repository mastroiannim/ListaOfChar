package bresciani;

public class ListaOfChar
{
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
