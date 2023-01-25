package sonzognig;
public class Main
{
    public static void main (String[] args) {
        //char[] caratteri = {'a','z','e','r','b','a','i','j','a','n'};
        char[] caratteri1 = {'a','d','e','h'};
        char[] caratteri2 = {'b','c','f','g'};
        ListOfChar l1 = new ListOfChar(caratteri1);
        ListOfChar l2 = new ListOfChar(caratteri2);
        ListOfChar l = new ListOfChar(l1,l2);
        /*l.append('a');
        l.append('b');
        l.append('c');
        l.append('d');
        l.append('e');
        l.append('f');
        System.out.println(l.toString());  
        l.shuffle(4,-3);*/
        System.out.println(l.toString());
    }
}
