package gherardid;


public class Main
{
    public static void main(String[] args){
        char[] arr = new char[]{ 'a','b','c','d','d'};
        ListaOfChar myList=new ListaOfChar(arr);
        myList.beforec1('d','z');
        myList.shuffle(0,3);
    }
}
