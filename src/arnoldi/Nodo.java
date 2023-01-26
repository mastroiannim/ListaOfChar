package arnoldi;


public class Nodo
{
    public char info;
    public Nodo next;
    public Nodo(char  i)
    {
       this.info=i;
       this.next=null;
    }
    public char getInfo(){
        return this.info;
    }
    public Nodo getNext(){
        return this.next;
    }
}
