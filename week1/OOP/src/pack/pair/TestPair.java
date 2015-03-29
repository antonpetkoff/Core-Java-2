package pack.pair;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPair {

    @Test
    public void testPair() {
        Pair one = new Pair(123, 1.5);
        Pair two = new Pair(123, 1.5);
        Pair three = new Pair("asd", true);
        
        assertEquals(true, one.equals(two));
        assertEquals(false, two.equals(three));
        assertEquals("(123,1.5)", two.toString());
        assertEquals("(asd,true)", three.toString());
    }
    
}
