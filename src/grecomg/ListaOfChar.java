package grecomg;

public class ListaOfChar
{
    private Node head = null;
    private int length = 0;
    
    public ListaOfChar() {}
    
    public ListaOfChar(char[] c){
        for (int i = 0; i < c.length; i++)
            append(c[i]);
    }
    
    public ListaOfChar(ListaOfChar list){
        for (int i = 0; i < list.length; i++)
            append(list.get(i));
    }
    
    public ListaOfChar(ListaOfChar listA, ListaOfChar listB)
    {
        this(listA);
        boolean notLast = true;
        int lastB = 0;
        while (notLast)
        {
            try {
                char c = listB.get(lastB);
                lastB++;
                int insert = 0;
                while (insert < length && Character.compare(c, get(insert)) > 0)
                    insert++;
                insertAt(insert, c);
            } catch (OutOfBoundsException e) {
                notLast = false;
            }
        }
    }
    
    public ListaOfChar append(char o){
        return insertAt(length, o);
    }
    
    public ListaOfChar insertAt(int index, char o){
        if(index > length || index < 0)
            throw new OutOfBoundsException();
        Node n = new Node(o);
        Node prev = null;
        Node next = head;
        if (index == 0) {
            head = n;
        } else {
            while(index > 0)
            {
                prev = next;
                next = next.next;
                index--;
            }
        }
        n.next = next;
        if (prev != null)
            prev.next = n;
        length++;
        return this;
    }
    
    public char get(int index){
        if(index >= length || index < 0)
            throw new OutOfBoundsException();
        Node n = head;
        for(int i = 0; i < index; i++)
            n = n.next;
        return n.info;
    }
    
    public ListaOfChar remove(int index){
        if(index >= length || index < 0)
            throw new OutOfBoundsException();
        Node n = head;
        Node prev = null;
        while(index > 0){
            prev = n;
            n = n.next;
            index--;
        }
        if (prev == null) {
            head = head != null ? n.next : head;
        } else {
            prev.next = n.next != null ? n.next : null;
        }
        n = null;
        length--;
        return this;
    }
    
    public String toString()
    {
        String s = "[";
        for (int i = 0; i < length; i++)
            s += get(i) + (i < length-1 ? " ; " : "");
        return s + "]";
    }
    
    public int beforeC1(char c1, char c2)
    {
        int occur = -1;
        for (int i = 0; i < length; i++)
            occur = Character.compare(c1, get(i)) == 0 ? i : occur;
        occur = occur == -1 ? length : occur;
        insertAt(occur, c2);
        return occur;
    }
    
    public ListaOfChar shuffle(int from, int to)
    {
        if (length == 0) 
            throw new EmptyListException();
        to = to <= 0 ? 0 : (to >= length ? length-1 : to);
        char t1 = get(from);
        remove(from);
        return insertAt(to, t1);
    }
    
    private class Node
    {
        private char info;
        private Node next;
        
        public Node(char o){
            this.info = o;
            this.next = null;
        }
    }

    private class OutOfBoundsException extends RuntimeException{}
    private class EmptyListException extends RuntimeException{}
}
