package gavocid;


public class DueListe{
        Nodo head;
        public void Liste(listaGavoci lista1, listaGavoci lista2) {
            Nodo l = lista1.head;
            Nodo ll = lista2.head;
            Nodo x = new Nodo();
            Nodo y = x;
        
            while (l != null && ll != null) {
                if (l.info.compareTo(ll.info) < 0) {
                    y.succ = l;
                    l = l.succ;
                } else {
                    y.succ = ll;
                    ll = ll.succ;
                }
                y = y.succ;
            }
        
            if (l != null) {
                y.succ = l;
            } else {
                y.succ = ll;
            }
        
            head = x.succ;
        }
}
