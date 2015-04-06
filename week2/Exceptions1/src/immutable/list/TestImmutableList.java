package immutable.list;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class TestImmutableList {

    @Test
    public void testGet() {
        ArrayList<ArrayList<Integer>> elements = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();

        elements.add(a);
        elements.add(b);
        elements.add(c);

        ImmutableList<ArrayList<Integer>> immutableList = new ImmutableList<ArrayList<Integer>>(elements);
        ArrayList<Integer> newA = immutableList.get(0);
        newA.add(1);
        newA.add(2);

        assertEquals(newA.size(), 2);
        assertEquals(a.size(), 0);
        assertEquals(false, a.equals(newA));
    }

}
