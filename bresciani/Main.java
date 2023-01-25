package bresciani;

public class Main
{

    public static void main(String[] args){
        char[] valori = {'a' ,'b' ,'c' ,'d'};
        ListaOfChar list = new ListaOfChar(valori);
        list.beforeC1('a','a');
        list.beforeC1('a','b');
        list.beforeC1('a','c');
        System.out.println(valori);
        Nodo corrente = list.head;
        System.out.println(corrente);
        while(corrente != null){
            System.out.println(corrente.info + " ");
            corrente = corrente.next;
        }
    }
}
