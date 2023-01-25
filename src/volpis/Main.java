package volpis;
class Main{
    public static void main(String[] args) {
        char[] parola = {'C','i','a','o'};

        /*for (int i=0; i<parola.length; i++) {
            System.out.println(parola[i]);
        }
        */
        ListOfChar l = new ListOfChar(parola);
        char c1 = 'o';
        char c2 = 'Z';

        System.out.println(l.length);
        System.out.println(l);
        /*
        System.out.println("inserito alla pos " +l.beforeC1(c1, c2));
        System.out.println(l);
        */
        
        System.out.println(l.shuffle(0,2));
    }
}