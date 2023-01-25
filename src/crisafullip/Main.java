package crisafullip;


public class Main
{
    public static void main(String[] args) throws crisafullip.FuoriListaException {
        char[] caratteri = {'a','b','c','d','e','f'};
        ListOfChar l = new ListOfChar(caratteri);
        
        Nodo corrente = l.head;
        while(corrente != null) {
            System.out.print(corrente.info + " ");
            corrente = corrente.succ;
        }
        System.out.println();
        
        
        l.shuffle(0,5);
        corrente = l.head;
        while (corrente != null) {
            System.out.print(corrente.info + " ");
            corrente = corrente.succ;
        }
        System.out.println();
        
        l.beforeC1('a','d');
        System.out.println(l.beforeC1('a','b'));
    }
    
}
