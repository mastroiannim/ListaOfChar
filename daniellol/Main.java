package daniellol;

public class Main {
    public static void main(String[] args) {
        ListaOfChar test = new ListaOfChar();
        test.append('c');
        test.append('a');
        test.append('b');
        test.append('d');
        test.append('d');
        test.append('a');
        test.beforeC1('d', 'z');
        System.out.println(test.toString());

        ListaOfChar test1 = new ListaOfChar(new char[] {'a', 'b', 'c'});
        System.out.println(test1.toString());

        ListaOfChar test2 = new ListaOfChar(new ListaOfChar(new char[] {'a', 'b', 'c'}), new ListaOfChar(new char[] {'b', 'c', 'd'}));
        System.out.println(test2.toString());
        
    }
}
