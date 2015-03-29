package pack.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestLinkedList {

    private static LinkedList<Integer> list;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        list = new LinkedList<Integer>();
    }

    /**
     * fills with 0, 1, 2, ..., (upperBound - 1)
     * 
     * @param upperBound
     */
    private static void fillList(int upperBound) {
        for (int i = 0; i < upperBound; ++i) {
            list.addLast(i);
        }
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, list.isEmpty());
        assertEquals(0, list.size());
        fillList(4);
        assertEquals(false, list.isEmpty());
        assertEquals(4, list.size());
    }

    @Test
    public void testAddFirst() {
        list.addFirst(1);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.getFirst());
        list.addFirst(2);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(2), list.getFirst());
        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }
    
    @Test
    public void testAddLast() {
        fillList(9);
        assertEquals(Integer.valueOf(0), list.getFirst());
        assertEquals(Integer.valueOf(8), list.getLast());
    }
    
    @Test
    public void testAdd() {
        list.add(0, 1);
        assertEquals(Integer.valueOf(1), list.getFirst());
        list.add(1, 2);
        assertEquals(Integer.valueOf(2), list.getLast());
        list.add(1, 3);
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    public void testSet() {
        fillList(6);
        list.set(0, 15);
        assertEquals(Integer.valueOf(15), list.getFirst());
        list.set(5, 10);
        assertEquals(Integer.valueOf(10), list.getLast());
        list.set(3, 99);
        assertEquals(Integer.valueOf(99), list.get(3));
    }
    
    @Test
    public void testGet() {
        fillList(10);
        assertEquals(Integer.valueOf(9), list.getLast());
        assertEquals(Integer.valueOf(2), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(4));
    }
    
    @Test
    public void testGetThrowsIllegalArgumentException() {
        fillList(5);
        exception.expect(IllegalArgumentException.class);
        list.get(-1);
        list.get(6);
    }
    
    @Test
    public void testGetNodeAt() {
        fillList(3);
        assertEquals(Integer.valueOf(1), list.getNodeAt(1).item);
        assertEquals(Integer.valueOf(2), list.getNodeAt(2).item);
        
        list = null;
        list = new LinkedList<Integer>();
        fillList(10);
        assertEquals(Integer.valueOf(4), list.getNodeAt(4).item);
        assertEquals(Integer.valueOf(5), list.getNodeAt(5).item);
        assertEquals(Integer.valueOf(6), list.getNodeAt(6).item);
    }

}
