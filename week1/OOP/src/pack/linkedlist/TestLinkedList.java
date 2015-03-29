package pack.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {

    private static LinkedList<Integer> list;

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
            list.append(i);
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
    public void testAppend() {
        fillList(9);
        assertEquals(Integer.valueOf(0), list.getFirst());
        assertEquals(Integer.valueOf(8), list.getLast());
    }

    @Test
    public void testGet() {
        fillList(10);
        assertEquals(Integer.valueOf(9), list.getLast());
        assertEquals(Integer.valueOf(2), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(4));
    }

}
