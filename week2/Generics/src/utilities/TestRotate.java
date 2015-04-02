package utilities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestRotate {
    
    private ArrayList<Integer> list = new ArrayList<Integer>();
    
    @Before
    public void setUp() {
        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }
    }
    
    @Test
    public void rotateRight() {
        RotateCollection.rotate(list, 3);
        assertEquals(list.get(0), Integer.valueOf(5));
        assertEquals(list.get(1), Integer.valueOf(6));
        assertEquals(list.get(2), Integer.valueOf(7));
        assertEquals(list.get(3), Integer.valueOf(1));
        assertEquals(list.get(4), Integer.valueOf(2));
        assertEquals(list.size(), 7);
    }
    
    @Test
    public void rotateLeft() {
        RotateCollection.rotate(list, -9);
        assertEquals(list.get(4), Integer.valueOf(7));
        assertEquals(list.get(5), Integer.valueOf(1));
        assertEquals(list.get(6), Integer.valueOf(2));
        assertEquals(list.size(), 7);
    }
    
}
