package sonzognig;
public class ListOfChar
{
    Node head;
    Node index;
    int length;
    public ListOfChar(){
        head = null;
        length = 0;
    }
    public ListOfChar(char[] caratteri){
        head = new Node(caratteri[0]);
        index = head;
        for(int i=1; i<caratteri.length; i++){
            index.nextNode = new Node(caratteri[i]);
            index = index.nextNode;
        }
        length = caratteri.length;
    }
    public ListOfChar(ListOfChar list1, ListOfChar list2){
        int in1 = 0;
        int in2 = 0;
        boolean finito1 = true;
        boolean finito2 = false;
        if(list1.get(0) < list2.get(0)){
            head = new Node(list1.get(0));
            in1 = 1;
        }
        else{
            head = new Node(list2.get(0));
            in2 = 1;
        }
        index = head;
        for(int i=1; i<(list1.length+list2.length); i++){
            if(finito2 || (finito1 && list1.get(in1) < list2.get(in2))){
                index.nextNode = new Node(list1.get(in1));
                in1++;
                if(in1 == list1.length){
                    finito1 = false;
                }
            }
            else{
                index.nextNode = new Node(list2.get(in2));   
                in2++;
                if(in2 == list2.length){
                    finito2 = true;
                }
            }
            index = index.nextNode;
        }
        length = (list1.length+list2.length);
    }
    class OutOfRangeException extends RuntimeException{}
    public char get(int pos){
        if(length < pos){
            throw new OutOfRangeException(); 
        }
        index = head;
        for(int i=0; i<pos; i++){
            index = index.nextNode;
        }
        return index.content;
    }
    public void insertAt(int pos, char c){
        Node temp = null;
        index = head;
        if(length < pos || pos < 0){
            throw new OutOfRangeException(); 
        }
        if(pos == 0){
            temp = index;
            head = new Node(c);
            head.nextNode = temp;
        }
        else{
            for(int i=0; i<(pos-1); i++){
                index = index.nextNode;
            }
            temp = index.nextNode;
            index.nextNode = new Node(c);
            index = index.nextNode;
            index.nextNode = temp;   
        }
        length++;
    }
    public void remove(int pos){
        Node temp = null;
        index = head;
        if(length < pos || pos < 0){
            throw new OutOfRangeException(); 
        }
        if(pos == 0){
            head = head.nextNode;
        }
        for(int i=0; i<(pos-1); i++){
            index = index.nextNode;
        }
        temp = index.nextNode.nextNode;
        index.nextNode = temp;
        length--;
    }
    public void append(char c){
        if(head == null){
            head = new Node(c);
        }
        else{
            index = head;
            while(index.nextNode != null){
                index = index.nextNode;
            }
            index.nextNode = new Node(c);
            length++;
        }
    }
    public void reverse(){
        int n = 0;
        append(get(0));
        remove(0);
        for(int i=length; i>0; i--){
            insertAt(length-n, get(0));
            remove(0);
            n++;
        }
    }
    public int beforeC1(char c1, char c2){
        int pos = -1;
        int i;
        if(length == 0){
            append(c2);
            pos = 0;
        }
        else{
            for(i=0; i<length; i++){
                if(get(i) == c1){
                    pos = i;
                }
            }
            if(pos == -1){
                append(c2);
                pos = length-1;
            }
            else{
                insertAt(pos, c2);   
            }
        }
        return pos;
    }
    public void shuffle(int from, int to){
        if(from < 0 || from > length){
            throw new OutOfRangeException(); 
        }
        char valore;
        valore = get(from);
        if(to < 0){
            remove(from);
            insertAt(0, valore);
        }
        else  if(to > length){
            append(valore);
            remove(from);
        }
        else{
            if(from >= to){
                remove(from);
                insertAt(to, valore);    
            }
            else{
                insertAt(to, valore);
                remove(from);
            }    
        }
    }
    public String toString(){
        String s = "";
        index = head;
        int i = 0;
        s+= "Testa: " + head.content + "\n";
        while(index != null){
            s += "Nodo " + (i+1) + ": " + get(i) + "\n";
            index = index.nextNode;
            i++;
        }
        return s;
    }
}
