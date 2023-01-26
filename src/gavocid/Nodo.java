package gavocid;

public class Nodo
{
    public Object info; //PROF.
    public Nodo succ; //PROF.
    
    public Nodo(char o){
        this.info = o;
        this.succ=null;
    }
}
