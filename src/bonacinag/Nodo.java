package bonacinag;

public class Nodo
{
    public Nodo nodoNext;
    public char info;
    
    public Nodo(char x)
    {
       this.nodoNext = null;
       this.info = x;
    }
}
