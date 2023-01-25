package gherardiv;
public class ListaOfChar
{
    public Nodo head = null;
    public int length = 0;

    public ListaOfChar(char[] array){
        for (char c : array) {
            this.append(new Nodo(c));
        }
    }

    public ListaOfChar(ListaOfChar list1, ListaOfChar list2){
        ListaOfChar result = this;
        Nodo current1 = list1.head;
        Nodo current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.info < current2.info) {
                result.append(new Nodo(current1.info));
                current1 = current1.next;
            } else {
                result.append(new Nodo(current2.info));
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            result.append(new Nodo(current1.info));
            current1 = current1.next;
        }

        while (current2 != null) {
            result.append(new Nodo(current2.info));
            current2 = current2.next;
        }
    }

    public ListaOfChar(){
    }

    public void append(Nodo nodo){
        if(head == null) {
            head = nodo;
            length++;
            return;
        }
        Nodo current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = nodo;
        length++;
    }

    public void insertAt(int index, Nodo node) throws InsertOutOfBoundingError
    {
        if(index > length){
            throw new InsertOutOfBoundingError("stai cercando di inserire in una posizione troppo alta");
        }
        if (index == 0) {
            node.next = head;
            head = node;
            length++;
            return;
        }
        Nodo current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        length++;
    }

    public Nodo get(int index) throws GetOutOfBoundingError{
        if(index > length){
            throw new GetOutOfBoundingError("stai cercando di ottenere un elemento in una posizione troppo alta");
        }
        Nodo current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    public void remove(int index) throws Exception {
        if(index > length){
            throw new Exception("stai cercando di rimuovere in una posizione troppo alta");
        }
        Nodo current = head;
        for(int i = 0;i < index - 1; i++){
            current = current.next;
        }
        current.next = current.next.next;
        length--;
    }
    
    @Override
    public String toString(){
        StringBuilder text = new StringBuilder();
        Nodo current = head;
        for(int i = 0; i < length; i++){
            text.append(current.info).append(", ");
            current = current.next;
        }
        return text.toString();
    }

    public int beforeC1(char c1, char c2) throws Exception {
        Nodo nodo = new Nodo(c2);
        if(length == 0){
            append(nodo);
            return 0;
        }
        if(head.info == c1){
            insertAt(0, nodo);
            return 0;
        }

        Nodo current = head;
        int index = -1;
        for(int i = 0; i < length; i++){
            if(current.info == c1){
                index = i;
                break;
            }
            current = current.next;
        }
        if(index == -1){
            append(nodo);
            return 0;
        }
        insertAt(index, nodo);
        return index;
    }

    public void shuffle(int from, int to) throws Exception {
        Nodo current = get(from);
        remove(from);
        if(to < 0) to = 0;
        if(to > length){
            append(current);
            return;
        }
        insertAt(to, current);
    }
    class InsertOutOfBoundingError extends Exception{
        private String message;

        public InsertOutOfBoundingError(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
    class GetOutOfBoundingError extends Exception{
        private String message;

        public GetOutOfBoundingError(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) {
        ListaOfChar test = new ListaOfChar();
        try {
            test.append(new Nodo('a'));
            test.append(new Nodo('c'));
            test.append(new Nodo('e'));
            test.append(new Nodo('h'));
            test.append(new Nodo('j'));

            // es1
            // test.beforeC1('d', 'M');
            // es2
            // test.shuffle(3, -2);
            // es3
            // char[] caratteri = {'c', 'g', 'e', 'p', 'o'};
            // ListaOfChar nuovo = new ListaOfChar(caratteri);
            // System.out.println(nuovo);

            // es4
            // ListaOfChar nuovo = new ListaOfChar();
            // nuovo.append(new Nodo('b'));
            // nuovo.append(new Nodo('d'));
            // nuovo.append(new Nodo('f'));
            // nuovo.append(new Nodo('h'));
            // nuovo.append(new Nodo('i'));

            // ListaOfChar ultimo = new ListaOfChar(test, nuovo);
            // System.out.println(ultimo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("risutato lista test: " + test);
        }
    }
}
