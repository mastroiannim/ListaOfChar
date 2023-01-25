import zini.ListaOfChar;

class Main {
    public static void main(String[] args) {
        ListaOfChar list = new ListaOfChar();
        list.append('c').append('i').append('a').append('o');
        System.out.println(list.toString());
        
        list.beforeC1('c', 's');
        System.out.println(list.toString());
        char[] charles = {'c','a','r','l','o'};
        
        ListaOfChar rails = new ListaOfChar(charles);
        System.out.println(rails.toString());

        list.shuffle(1, 2);
        System.out.println(list.toString());
    }
}
