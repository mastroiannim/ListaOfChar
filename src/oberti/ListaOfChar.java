package oberti;



public class ListaOfChar
{
    public Nodo head;
    public Nodo next;
    public static int length;
   public ListaOfChar(){
       head = null;
       length = 0;
    }    
    
      public void append(char o){
        Nodo x =  new Nodo(o);
        Nodo i = head;
        if(i == null){
            head = x;
        }else{
            while(i.next != null){
                i=i.next;
            }
            i.next = x;
        }
        length++;
        return;
    }
    
    public int beforeC1(char c1, char c2){
        boolean trovato = false;
        Nodo indice = head;
        int ritorno = 0;
        Nodo precedente = null;
        int posizioneC1 = 0;;
        Nodo Nodec2 = new Nodo(c2);
        for(int i = 0; i< ListaOfChar.length-1; i++){
            precedente = indice;
            indice = indice.next;
            posizioneC1++;
        }
        
        if(indice != null){
            System.out.println("sono entrato");
                if(indice.info == c1){
                     System.out.println("sono entrato giusto");
                    trovato = true;
                    precedente.next = Nodec2;
                    Nodec2.next = indice;
                    ritorno = posizioneC1-1;
                }
            }
            
            
        if(precedente == null){ // se la lista è vuota
            System.out.println("lista è vuota");
            this.append(Nodec2.info);
        }else if (indice == null){ // se c1 non viene trovato;
            System.out.println("c1 non trovato");
            this.append(Nodec2.info);
        }
        
       
        return ritorno;
    }
    
    public void shuffle( int from , int to) throws LengthException{
        if(from > this.length) throw new LengthException();
        int posizione = 0;
        Nodo indice = head;
        int posizioneTo = 0;
        int posizioneFrom = 0;
        
         
        Nodo attuale = head;
        Nodo precedente = null;
        Nodo attualeDestinazione = head;
        Nodo precedenteDestinazione = null;
        while(attuale != null) {
            precedente = attuale;
            attuale = attuale.next;
            posizione++;
        }
        posizione = 0;
        while(attualeDestinazione != null) {
            precedenteDestinazione = attualeDestinazione;
            attualeDestinazione = attualeDestinazione.next;
            posizione++;
        }
        if(precedente == null) {
            head = attuale.next;
        } else {
            precedente.next = attuale.next;
        }
        if(precedenteDestinazione == null) {
            attuale.next = head;
            head = attuale;
        } else {
            attuale.next = attualeDestinazione;
            precedenteDestinazione.next = attuale;
        }
    
        
        
        
        
        if(to <= 0){
            Nodo attuale2 = head;
            Nodo precedente2 = null;
            while(attuale != null ) {
                precedente2 = attuale2;
                attuale = attuale.next;
            }
            
            precedente2.next = attuale2.next;
            attuale2.next = head;
            head = attuale2;
        }
        
        if( to >= ListaOfChar.length){
            this.append(indice.info);
        }
        
        
        
    }
    
    
    class LengthException extends RuntimeException{}
}
