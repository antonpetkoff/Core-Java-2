package utilities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestUtilities {

    private ArrayList<Integer> list = new ArrayList<Integer>();

    @Before
    public void setUp() {
        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }
    }

    @Test
    public void testAreBracketsBalanced() {
        assertEquals(true, Utilities.areBracketsBalanced("((()())())"));
        assertEquals(false, Utilities.areBracketsBalanced("))())"));
        assertEquals(false, Utilities.areBracketsBalanced("((())))))())"));
    }

    @Test
    public void testReverse() {
        Utilities.reverse(list);

        for (int i = 1; i <= 7; i++) {
            assertEquals(list.get(i - 1), Integer.valueOf(list.size() + 1 - i));
        }
    }

    @Test
    public void testRotateRight() {
        Utilities.rotate(list, 3);
        assertEquals(list.get(0), Integer.valueOf(5));
        assertEquals(list.get(1), Integer.valueOf(6));
        assertEquals(list.get(2), Integer.valueOf(7));
        assertEquals(list.get(3), Integer.valueOf(1));
        assertEquals(list.get(4), Integer.valueOf(2));
        assertEquals(list.size(), 7);
    }

    @Test
    public void testRotateLeft() {
        Utilities.rotate(list, -9);
        assertEquals(list.get(4), Integer.valueOf(7));
        assertEquals(list.get(5), Integer.valueOf(1));
        assertEquals(list.get(6), Integer.valueOf(2));
        assertEquals(list.size(), 7);
    }

    @Test
    public void testFindFirstUnique() {
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        list.set(5, 5);
        list.set(6, 4);
        list.set(7, 3);
        list.set(8, 1);

        assertEquals(Integer.valueOf(2), Utilities.findFirstUnique(list));
    }
    
    @Test
    public void testIntersectSets() {
        //assertEquals({5}, Utilities.intersectSets(sets));

        Integer[] A = { 1, 2, 3, 4, 5 };
        Integer[] B = { 4, 5, 6 };
        Integer[] C = { 5, 6, 7, 8 };
        Integer[][] sets = { A, B, C };
        
        Integer[] result = Utilities.intersectSets(Integer.class, sets);
        
        assertEquals(result.length, 1);
        assertEquals(result[0], Integer.valueOf(5));
    }

}
