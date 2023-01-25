package daniellol;

import java.util.Arrays;
import java.util.List;

public class ListaOfChar {
    Node head;
    int length;

    ListaOfChar() {
        head = null;
        length = 0;
    }

    ListaOfChar(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            append(chars[i]);
        }
    }

    ListaOfChar(ListaOfChar chars1, ListaOfChar chars2) {
        char[] temp = new char[chars1.length + chars2.length];
        for (int i=0; i<chars1.length; i++) {
            temp[i] = chars1.get(i);
        }
        int c = 0;
        for (int i=chars1.length; i<temp.length; i++) {
            temp[i] = chars2.get(c);
            c++;
        }
        
        Arrays.sort(temp);

        for (int i=0; i<temp.length; i++) {
            append(temp[i]);
        }
    }

    public char get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Out of range");
        }
        if (index == 0) {
            return head.info;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.info;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Out of range");
    }

    public void append(char info) {
        Node newNode = new Node(info);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next!= null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        
        length++;
    }

    public ListaOfChar insertAt(int index, char info) throws IndexOutOfBoundsException {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Posizione fuori dal range");
        }

        Node newNode = new Node(info);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }

        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index - 1) {
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
            count++;
        }
        length++;
        return this;
    }

    public ListaOfChar removeAt(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Posizione fuori dal range");
        }

        if (index == 0) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next!= null) {
                temp = temp.next;
            }
            temp.next = null;
    
            length--;
            
            return this;
        }
        return this;
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp!= null) {
            sb.append(temp.info);
            temp = temp.next;
            if (temp!= null) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }

    public ListaOfChar beforeC1(char c1, char c2) {
        Node cc2 = new Node(c2);
        if (head == null) {
            head = cc2;
            length++;
            return this;
        }
        
        Node p = head;
        int pos = 0;
        int c1Pos = pos;
        boolean c1Exists = false;
        while (p.next != null) {
            p = p.next;
            if (p.info == c1) {
                c1Pos = pos;
                c1Exists = true;
            }
            pos++;
        }
        if (c1Exists) insertAt(c1Pos+1, c2);
        else append(c2);
        length++;

        return this;
    }

    public ListaOfChar shuffle(int from, int to) throws Exception {
        if (from < 0 || from >= length) throw new IndexOutOfBoundsException("Index is out of range");
        if (head == null) throw new Exception("List is empty!");
        Node p = head;
        int pos = 0;
        char moveChar = ' ';
        while (p.next != null) {
            p = p.next;
            if (pos == from) {
                moveChar = p.info;
                removeAt(from);
                pos++;
            }
            pos++;
        }
        if (to <= 0) {
            insertAt(1, moveChar);
            return this;
        }
        if (to >= length) {
            append(moveChar);
            return this;
        }
        insertAt(to, moveChar);

        return this;
    }

    class Node {
        char info;
        Node next;

        Node(char info) {
            this.info = info;
        }
    }
}
