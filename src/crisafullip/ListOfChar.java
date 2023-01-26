package crisafullip;



public class ListOfChar
{
    public Nodo corrente;
    int lunghezza;
    public Nodo head;
    char info;
    
    //PROF.
    //manca toString!
    
    //PROF.
    public ListOfChar(){
        head = null;
        lunghezza = 0;
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
            i = i.succ;
        }
        i = new Nodo(info);
        j.succ = i;
    }
    
    public ListOfChar(char[] caratteri){
        if(caratteri.length == 0){
            head = null;
            lunghezza = 0;
            
        }else{
            head = new Nodo(caratteri[0]);
            Nodo corrente = head;
            lunghezza = 1;
            for(int i = 0; i < caratteri.length; i++){
                corrente.succ = new Nodo(caratteri[i]);
                corrente = corrente.succ;
                lunghezza++;
            }
        
        }
    }
    
    public ListOfChar(ListOfChar l1, ListOfChar l2){
        Nodo cor1 = l1.head;
        Nodo cor2 = l2.head;
        Nodo corrente;

        if(cor1 == null){
            head = cor2;
            lunghezza = l2.lunghezza;
            return;
        }
        if(cor2 == null){
            head = cor1;
            lunghezza = l1.lunghezza;
            return;
        }
    }
    
    public int beforeC1(char c1, char c2) {
        Nodo corrente = head;
        Nodo prec = null;
        int pos = 0;
        while (corrente != null) {
            if (corrente.info == c1) {
                Nodo newNode = new Nodo(c2);
                newNode.succ = corrente;
                if (prec == null) {
                    head = newNode;
                } else {
                    prec.succ = newNode;
                }
                pos++;
                
            }
            prec = corrente;
            corrente = corrente.succ;
            lunghezza++;
        }
        //Serve ad aggiungere c2 in fondo nel caso c1 non lo trovo
        Nodo newNode = new Nodo(c2);
        prec.succ = newNode;
        lunghezza++;
        return pos;
    }
    
    
    public void shuffle(int from, int to) throws crisafullip.FuoriListaException {
        
        if(from < 0 || from >= lunghezza || to < 0 || to >= lunghezza){
            throw new FuoriListaException();
        }
    
        Nodo corrente = head;
        Nodo precFrom = null;
        Nodo correnteFrom = null;
    
        for(int i = 0; i < from; i++){
            precFrom = corrente;
            corrente = corrente.succ;
            
        }
        correnteFrom = corrente;
    
        if (precFrom == null) {
            head = correnteFrom.succ;
        }else{
            precFrom.succ = correnteFrom.succ;
        }
        
        if(to <= 0){
            correnteFrom.succ = head;
            head = correnteFrom;
        }else{
            Nodo correnteTo = head;
            for (int k = 0; k < to-1; k++) {
                correnteTo = correnteTo.succ;
            }
            correnteFrom.succ = correnteTo.succ;
            correnteTo.succ = correnteFrom;
        }
    }  
    
    
    
    
}

class FuoriListaException extends Exception{}


