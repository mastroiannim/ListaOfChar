package todeschinip;
public class ListaOfChar
{
    Nodo head;
    int length=0;
    ListaOfChar(){
        this.head=null;
    }
    
    public ListaOfChar append(char c){
        Nodo i=head;
        Nodo n=new Nodo(c);
        if(head==null){
            head=n;
        }else{
            while(i.next!=null){
                i=i.next;
            }
            i.next=n;
        }
        length++;
        return this;
    }
     public String toString(){
        String s="(";
        Nodo j=head;
        for(int i=0;i<length;i++){
            s+=j.info+",";
            j=j.next;
        }
        s+="): "+length;
        return s;
    }
    public Nodo get(int n){
        if(n>length) throw new fuoriDallaListaException();
        Nodo j=head;
        for(int i=0;i<n;i++){
            j=j.next;
        }
        return j;
    }
    public void insertAt(int pos, char info) {
        if (pos < 0 || pos > length)  throw new fuoriDallaListaException();
        Nodo n = new Nodo(info);
        if (pos <= 0) {
            n.next = head;
            head = n;
        }else{

        Nodo i = head;
        int count = 0;
        while (i != null) {
            if (count == pos - 1) {
                n.next = i.next;
                i.next = n;
            }
            i = i.next;
            count++;
        }
    }
        length++;
    }
    public void removeAt(int pos) {
        if (pos < 0 || pos > length)  throw new fuoriDallaListaException();
        if(pos == 0){
            head = head.next;
        }
        if(pos == length){
            Nodo i = head;
            while(i != null){
                i = i.next;
            }
            i = null;
        }
        Nodo i = head;
        int conta = 0;
        while (i != null) {
            if (pos-1 == conta) {
                i.next = i.next.next;
            }
            conta++;
            i = i.next;
        }
        
        length--;
    }
    //ESERCIZIO 3
    ListaOfChar(char[] c){
        this.head=null;
        for(int i=0;i<c.length;i++){
            this.append(c[i]);
        }
    }
    //ESERCIZIO 2
    public void shuffle(int from,int to){
        if(from<0||from>length)throw new fuoriDallaListaException();
        if(to>=length){
            Nodo n=this.get(from);
            this.append(n.info);
        }else{
            Nodo n=this.get(from);
            this.insertAt(to,n.info);
        }
        this.removeAt(from);
    }
    //ESERCIZIO 1
    public int beforeC1(char c1,char c2){
        if(head==null){
            this.append(c2);
            return length;
        }
        Nodo i=head;
        Nodo n=new Nodo(c2);
        int j=0;
        while(i.info!=c1 && i.next!=null){
            i=i.next;
            j++;
        }
        this.insertAt(j,c2);
        return j;
    }
}
class Nodo{
    char info;
    Nodo next;
    Nodo(char c){
        this.info=c;
        this.next=null;
    }
    
}
class fuoriDallaListaException extends RuntimeException{
    
}