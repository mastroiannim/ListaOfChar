package arzuffis;
public class ListaOfChar extends RuntimeException
{
    public int lunghezza = 1;
    Node head = new Node('h');
    public ListaOfChar(char[] ac){
        Node i = this.head;
        i.oggetto = 'h';
        for(int k = 0; k < ac.length; k++){
            i.oggetto = ac[k];
            i.posizione = k;
            i = i.prossimo;
            lunghezza++;
        }
    }
    public ListaOfChar(char[] ac1, char[] ac2){
        Node c = this.head;
        for(int i = 0; i < ac1.length; i++){
            c.oggetto = ac1[i];
            c.posizione = i;
            c = c.prossimo;
            lunghezza++;
        }
        for(int i = 0; i < ac2.length; i++){
            c.oggetto = ac2[i];
            c.posizione = i;
            c = c.prossimo;
            lunghezza++;
        }
    }
    public int beforeC1(char c1, char c2){
        int posizioneCorrente = -1;
        Node i = head;
        Node appoggio =  new Node(c1);
        if(head != null){
            for(int k = 0; k < lunghezza; k++){
                if(appoggio.oggetto == i.oggetto){
                    posizioneCorrente = k;
                }
                i = i.prossimo;
            }
            i = head;
            for(int c = 0; c <= posizioneCorrente; c++){
                i = i.prossimo;
            }
            for(int h = posizioneCorrente; h < lunghezza; h++){
                i.prossimo = i;
                i.oggetto = null;
            }
            for(int c = 0; c < posizioneCorrente; c++){
                i = i.prossimo;
            }
            i.oggetto = null;
            insertAt(posizioneCorrente, c2);
        }else if(head == null){
            head = appoggio;
        }else if(posizioneCorrente == -1){
            Node c = new Node(c2);
            append(c);
        }
        return posizioneCorrente;
    }
    public void shuffle(int from, int to){
        Node f = head;
        Node c = head;
        if(to <= 0){
            for(int i = 0; i < from; i++){
                f = f.prossimo;
            }
            for(int h = 0; h < lunghezza; h++){
                c.prossimo = c;
            }
            c = head;
            c.oggetto = f;
            remove(from);
        }else if(to >= lunghezza){
            append(f);
        }else{
            for(int i = 0; i < from; i++){
                f = f.prossimo;
            }
            for(int t = 0; t < to; t++){
                c = c.prossimo;
            }
            c = f;
        }
    }
    public void insertAt(int a, char c){
        Node nuovo = new Node(c);
        Node b = head;
        for(int k = 0; k < a; k++){
            b = b.prossimo;
        }
        b.oggetto = nuovo.oggetto;
    }
     public void append(Node c){
        Node x =  new Node(c);
        Node i = head;
        if(i==null){
            head = x;
            head.posizione = 0;
        }else{
            while(i.prossimo != null){
                i=i.prossimo;
            }
            x.posizione = lunghezza;
            i.prossimo = x;
        }
        lunghezza++;
    }
    public void remove(int index)throws OutOfRange{
        Node i = head;
        for(int y = 0; y < index -1; y++){
            i = i.prossimo;
        }
        i.prossimo = i.prossimo.prossimo;
        lunghezza--;
    }
    public class Node
    {
        Object oggetto;
        Node prossimo;
        public int posizione;
        public Node(Object c){
            this.oggetto = c;
            this.prossimo = null;
            this.posizione = 0;
        }
    }
}
