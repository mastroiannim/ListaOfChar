package scanzif;
public class ListaOfChar
{
    int length;
    Node head;
    public ListaOfChar()
    {
        length=0;
        head=new Node('h');
    }
    public ListaOfChar(ListaOfChar oldlist)
    {
        length=0;
        head=new Node('h');
        for(int i=0;i<oldlist.length;i++){
            append(oldlist.getAt(i));
        }
    }
    public ListaOfChar(char[] chars)
    {
        length=0;
        head=new Node('h');
        for(int i=0;i<chars.length;i++){
            append(chars[i]);
        }
    }
    public ListaOfChar(ListaOfChar oggetto1, ListaOfChar oggetto2)
    {
        length=0;
        head=new Node('h');
        int contatore1=0;
        int contatore2=0;
        for(int i=0;i<oggetto1.length()+oggetto2.length();i++){
            if(contatore2==oggetto2.length()){
                append(oggetto1.getAt(contatore1));
                contatore1++;
            }else if(contatore1==oggetto1.length()){
                append(oggetto2.getAt(contatore2));
                contatore2++;
            }
            else if(oggetto1.getAt(contatore1)<=oggetto2.getAt(contatore2)){
                append(oggetto1.getAt(contatore1));
                contatore1++;
            }else{
                append(oggetto2.getAt(contatore2));
                contatore2++;
            }
        }
    }
    public int beforeC1(char c1, char c2){
        int posizioneContraria=reverse().search(c1);
        if(posizioneContraria==-1){
            append(c2);
            return length()-1;
        }else{
            int posizione=length()-1-posizioneContraria;
            insertAt(posizione, c2);
            return posizione;
        }
    }
    public int search(char carattere){
        if(length()==0){
            return -1;
        }
        Node header=head;
        int posizione=0;
        while(header.next.info!=carattere){
            header=header.next;
            posizione++;
            if(header.next==null){
                return -1;
            }
        }
        return posizione;
    }
    public void shuffle(int from, int to){
        if(to<0){
            to=0;
        }else if(to>length()){
            to=length();
        }
        if(to<from){
            insertAt(to, getAt(from));
            removeAt(from+1);
        }else{
            insertAt(to+1, getAt(from));
            removeAt(from);
        }
    }
    public void append(char info){
        Node header=head;
        while(header.next!=null){
            header=header.next;
        }
        header.next=new Node(info);
        length++;
    }
    public void test(){
        append('a');
        append('b');
        append('c');
    }
    public void insertAt(int num, char info){
        if(num<0 || num>length){
            throw new OutOfRangeIndex("Index out of bounds");
        }else{
            Node header=head;
            for(int i=0;i<num;i++){
                header=header.next;
            }
            Node node=new Node(info);
            node.next=header.next;
            header.next=node;
            length++;
        }
    }
    public char getAt(int num){
        if(num<0 || num>=length){
            throw new OutOfRangeIndex(num+" Index out of bounds");
        }else{
            Node header=head;
            for(int i=0;i<=num;i++){
                header=header.next;
            }
            return header.info;
        }
    }
    public void removeAt(int num){
        if(num<0 || num>=length){
            throw new OutOfRangeIndex("Index out of bounds");
        }else{
            Node header=head;
            for(int i=0;i<num;i++){
                header=header.next;
            }
            header.next=header.next.next;
            length--;
        }
    }
    public int length(){
        return length;
    }
    public ListaOfChar copyFrom(int num){
        if(num<0 || num>=length){
            throw new OutOfRangeIndex("Index out of bounds");
        }else{
            ListaOfChar list=new ListaOfChar();
            for(int i=num;i<length;i++){
                list.append(getAt(i));
            }
            return list;
        }
    }
    public void switchAt(int num1,int num2){
        if(num1<0 || num1>=length || num2<0 || num2>=length){
            throw new OutOfRangeIndex("Index out of bounds");
        }
        char copia=getAt(num1);
        insertAt(num1, getAt(num2));
        removeAt(num1+1);
        insertAt(num2, copia);
        removeAt(num2+1);
    }
    public ListaOfChar reverse(){
        ListaOfChar copy=new ListaOfChar();
        for(int i=length-1;i>=0;i--){
            copy.append(getAt(i));
        }
        return copy;
    }
    public String toString(){
        String string="";
        for(int i=0;i<length;i++){
            string+=getAt(i);
            if(i!=length-1){
                string+=", ";
            }
        }
        return string;
    }
}
class OutOfRangeIndex extends RuntimeException{
    public OutOfRangeIndex(String errorMessage){
        super(errorMessage);
    }
}
