package Montanelli;
public class Main
{
    public static void main(String[] args)
    {
       char [] test={'a','b','f', 'm'};
        ListOfChar l =new ListOfChar(test);
         ListOfChar lEmp =new ListOfChar();
       System.out.println(l);
        l.beforeC1('z', 'j');
       System.out.println(l);
        System.out.println(l.indexOf('f'));
        l.beforeC1('f', 'n');
         System.out.println(l);
         lEmp.beforeC1('z', 'j');
         System.out.println(lEmp);
        l.shuffle(2,0);
        System.out.println(l);
         l.shuffle(2,5);
         System.out.println(l);
    }
}
