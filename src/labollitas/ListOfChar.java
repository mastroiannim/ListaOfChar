package labollitas;
public class ListOfChar
{
    public Nodo head;
    public int lunghezza;

    //PROF.
    //manca toString!

    //PROF.
    public ListOfChar(){
        head = null;
    }

    public ListOfChar(char[] p){
        for(int i = 0; i<p.length; i++){
            append(p[i]);
        }
    }
    public ListOfChar(ListOfChar l1, ListOfChar l2){
        
    }
    public void append(char o){
        Nodo x =  new Nodo(o);
        Nodo a = head;
        Nodo indice = head;
        if(a==null){
            head = x;
        }else{
            while(indice.next != null){
                indice=indice.next;
            }
            indice.next = x;
        }
        lunghezza++;
        return;
    }
    public void insertAt(char o, int posizione)
    {
        Nodo nuovo = new Nodo(o);
        if (posizione==0) {
            nuovo.next=head;
            head=nuovo;
            lunghezza++;
            return;
        }
        Nodo indice = head;
        for (int i=0; i<posizione-1; i++) {
            indice = indice.next;
        }
        nuovo.next=indice.next;
        indice.next=nuovo;
        lunghezza++;
    }
    public int beforeC1(char c1, char c2){
        Nodo nuovo = new Nodo(c2);
        Nodo a = head;
        Nodo indice = head;
        int posizione = 0;
        if(a==null){
            head=nuovo;
            return posizione;
        }else{
            while(indice.next.info != c1){
                indice = indice.next;
                posizione++;
            }
            nuovo.next = indice.next;
            indice.next=nuovo;
        }
        lunghezza++;
        return posizione+1;
    }
    public void shuffle(int from, int to)throws posizioneNonPresente{ 
        Nodo x=head;
        Nodo indice=head;
        if(from>lunghezza || from<0){
            throw new posizioneNonPresente();
        }
        for(int i=0;i<from;i++){
            x=x.next;
        }
        for(int i=0;i<from-1;i++){
            indice=indice.next;
        }
        Nodo nuovo=new Nodo(x.info);
        if(to<=0){
            indice.next=indice.next.next;
            nuovo.next=head;
            head=nuovo;
        }else if(to>=lunghezza){
            indice.next=indice.next.next;
            append(x.info);
            lunghezza--;
        }else{
            indice.next=indice.next.next;
            insertAt(x.info, to);
            lunghezza--;
        }
    }
}
class posizioneNonPresente extends Exception{
}
