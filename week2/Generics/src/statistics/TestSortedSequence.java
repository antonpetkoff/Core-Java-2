package statistics;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class TestSortedSequence {

    @Test
    public void testSortedSequenceAdd() {
        SortedSequence seq = new SortedSequence();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        
        System.out.println(list);

        for (Integer integer : list) {
            seq.add(integer);
        }
        

        int i = 0;
        for (Integer integer : seq) {
            System.out.println(integer);
            //assertEquals(Integer.valueOf(i), integer);
            ++i;
        }

    }

}
