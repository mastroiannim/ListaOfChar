package test.mastroiannim;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


class ListaOfChar extends grecomg.ListaOfChar {

    public ListaOfChar (){super();}
    public ListaOfChar (char[] c){super(c);}
    public ListaOfChar ( ListaOfChar a, ListaOfChar b ){super(a,b);}

    /*public String toString(){
        String s="(";
        Nodo i = head;
        while(i!=null){
            s+= i.info;
            i = i.next;
            if(i!=null)
                s+=", ";
        }
        s+="):";
        return s;
    }*/
}

public class Correzione{

    @Test
    public void testBeforeC1ListaVuotaReturn() throws Exception{
        ListaOfChar loc = new ListaOfChar();
        int i = loc.beforeC1('x', 'a');
        assertEquals(0, i);
    } 

    @Test
    public void testBeforeC1ListaVuota() throws Exception{
        ListaOfChar loc1 = new ListaOfChar();
        ListaOfChar loc2 = new ListaOfChar();
        loc1.beforeC1('x', 'a');
        loc2.append('a');
        assertEquals(loc2.toString(), loc1.toString());
    } 

    @Test
    public void testBeforeC1NonEsisteReturn() throws Exception{
        ListaOfChar loc = new ListaOfChar();
        loc.append('a');
        loc.append('b');
        loc.append('c');
        int i = loc.beforeC1('x', 'd');
        assertEquals(3, i);
    } 

    @Test
    public void testBeforeC1NonEsiste() throws Exception{
        ListaOfChar loc1 = new ListaOfChar();
        ListaOfChar loc2 = new ListaOfChar();

        loc1.append('a');
        loc1.append('b');
        loc1.append('c');
        loc1.beforeC1('x', 'd');

        loc2.append('a');
        loc2.append('b');
        loc2.append('c');
        loc2.append('d');
        assertEquals(loc2.toString(), loc1.toString());
    } 

    @Test
    public void testBeforeC1SolaOccorrenzaReturn() throws Exception{
        ListaOfChar loc = new ListaOfChar();
        loc.append('a');
        loc.append('x');
        loc.append('c');
        int i = loc.beforeC1('x', 'b');
        assertEquals(1, i);
    } 

    @Test
    public void testBeforeC1SolaOccorrenza() throws Exception{
        ListaOfChar loc1 = new ListaOfChar();
        ListaOfChar loc2 = new ListaOfChar();

        loc1.append('a');
        loc1.append('x');
        loc1.append('c');
        loc1.beforeC1('x', 'b');

        loc2.append('a');
        loc2.append('b');
        loc2.append('x');
        loc2.append('c');
        assertEquals(loc2.toString(), loc1.toString());
    } 

    @Test
    public void testBeforeC1MultiplaOccorrenzaReturn() throws Exception{
        ListaOfChar loc = new ListaOfChar();
        loc.append('a');
        loc.append('x');
        loc.append('x');
        loc.append('c');
        int i = loc.beforeC1('x', 'b');
        assertEquals(2, i);
    } 

    @Test
    public void testBeforeC1MultiplaOccorrenza() throws Exception{
        ListaOfChar loc1 = new ListaOfChar();
        ListaOfChar loc2 = new ListaOfChar();

        loc1.append('a');
        loc1.append('x');
        loc1.append('x');
        loc1.append('c');
        loc1.beforeC1('x', 'b');

        loc2.append('a');
        loc2.append('x');
        loc2.append('b');
        loc2.append('x');
        loc2.append('c');
        assertEquals(loc2.toString(), loc1.toString());
    } 

    @Test
    public void testShuffleToMinoreZero() throws Exception{
        ListaOfChar loc = new ListaOfChar();
        ListaOfChar locOk = new ListaOfChar();
        
        loc.append('x');
        loc.append('a');
        loc.append('b');
        loc.append('y');
        loc.shuffle(3, -1);
        
        locOk.append('y');
        locOk.append('x');
        locOk.append('a');
        locOk.append('b');
        assertEquals(locOk.toString(), loc.toString());
    }

    @Test
    public void testShuffleToUgualeZero() throws Exception{
        ListaOfChar loc = new ListaOfChar();
        ListaOfChar locOk = new ListaOfChar();

        loc.append('x');
        loc.append('a');
        loc.append('b');
        loc.append('y');
        loc.shuffle(3, 0);
        
        locOk.append('y');
        locOk.append('x');
        locOk.append('a');
        locOk.append('b');
        assertEquals(locOk.toString(), loc.toString());
    }

    @Test
    public void testShuffleToMaggioreUltimo() throws Exception{
        ListaOfChar loc = new ListaOfChar();
        ListaOfChar locOk = new ListaOfChar();

        loc.append('x');
        loc.append('a');
        loc.append('y');
        loc.append('b');
        loc.shuffle(2, 5);
        
        locOk.append('x');
        locOk.append('a');
        locOk.append('b');
        locOk.append('y');
        assertEquals(locOk.toString(), loc.toString());
    }

    @Test
    public void testShuffleToUgualeUltimo() throws Exception{
        ListaOfChar loc = new ListaOfChar();
        ListaOfChar locOk = new ListaOfChar();

        loc.append('x');
        loc.append('a');
        loc.append('y');
        loc.append('b');
        loc.shuffle(2, 4);
        
        locOk.append('x');
        locOk.append('a');
        locOk.append('b');
        locOk.append('y');
        assertEquals(locOk.toString(), loc.toString());
    }

    @Test
    public void testShuffleCase() throws Exception{
        ListaOfChar loc1 = new ListaOfChar();
        ListaOfChar locOk = new ListaOfChar();

        loc1.append('a');
        loc1.append('c');
        loc1.append('d');
        loc1.append('b');
        loc1.shuffle(3, 1);
        
        
        locOk.append('a');
        locOk.append('b');
        locOk.append('c');
        locOk.append('d');
        assertEquals(locOk.toString(), loc1.toString());
    }

    @Test
    public void testCostruttoreArray(){
        char[] array = {'a', 'b', 'c', 'd'};
        ListaOfChar loc1 = new ListaOfChar(array);
        ListaOfChar locOk = new ListaOfChar();
        
        locOk.append('a');
        locOk.append('b');
        locOk.append('c');
        locOk.append('d');
        assertEquals(locOk.toString(), loc1.toString());
    }

    @Test
    public void testCostruttoreMerge(){
        char[] array1 = {'b', 'd', 'e'};
        char[] array2 = {'a', 'c', 'f', 'g'};
        ListaOfChar loc1 = new ListaOfChar(new ListaOfChar(array1), new ListaOfChar(array2));
        ListaOfChar locOk = new ListaOfChar();
        
        locOk.append('a');
        locOk.append('b');
        locOk.append('c');
        locOk.append('d');
        locOk.append('e');
        locOk.append('f');
        locOk.append('g');
        assertEquals(locOk.toString(), loc1.toString());
    }
}