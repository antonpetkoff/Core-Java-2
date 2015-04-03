package statistics;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class TestSortedSequence {

    private SortedSequence seq;
    private final static int INT_COUNT = 100;
    
    @Before
    public void setUp() {
        seq = new SortedSequence();
        fillSequenceRandomly();
    }
    
    private void fillSequenceRandomly() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < INT_COUNT; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        for (Integer integer : list) {
            seq.add(integer);
        }
    }
    
    @Test
    public void testSequenceSortedInvariant() {
        int i = 0;
        for (Integer integer : seq) {
            assertEquals(Integer.valueOf(i), integer);
            ++i;
        }
    }
    
    @Test
    public void testAddEqualNumbers() {
        seq = new SortedSequence();
        seq.add(6);
        seq.add(5);
        seq.add(7);
        seq.add(6);
        seq.add(6);
        seq.add(7);
        seq.add(5);
        seq.add(7);
        seq.add(5);
        
        int i = 0, expected = 4;
        for (Integer integer : seq) {
            if (i % 3 == 0) {
                ++expected;
            }
            ++i;
            assertEquals(Integer.valueOf(expected), integer);
        }
    }
    
    @Test
    public void testGetMedian() {
        assertEquals(Double.valueOf(49.5), Double.valueOf(seq.getMedian()));
    }

}
