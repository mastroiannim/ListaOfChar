package arzuffis;
public class Main
{
    public static char[] arrayChar = {'a', 'b', 'd', 't'};
    public static void main()throws NullPointerException{
        ListaOfChar lista = new ListaOfChar(arrayChar);
        ListaOfChar listal = new ListaOfChar(arrayChar, arrayChar);
        lista.beforeC1('b', 'd');
        lista.shuffle(3, 2);
    }   
}
