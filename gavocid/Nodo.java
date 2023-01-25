package gavocid;

public class Nodo
{
    Object info;
    Nodo succ;
    
    public Nodo(char o){
        this.info = o;
        this.succ=null;
    }
}
