package hashmap.nonull;

import java.util.HashMap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestHashMapNoNull {

    private HashMapNoNull<Integer, Integer> map;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void testPutNoNull() {
        exception.expect(IllegalNullHashMapKey.class);
        map = new HashMapNoNull<Integer, Integer>();    // doesn't accept null keys
        map.put(null, 1);
    }
    
    @Test
    public void testPutWithNull() {
        map = new HashMapNoNull<Integer, Integer>(true);
        map.put(null, 2);
    }
    
    @Test
    public void testGetNoNull() {
        exception.expect(IllegalNullHashMapKey.class);
        map = new HashMapNoNull<Integer, Integer>(false);
        map.get(null);
    }
    
    @Test
    public void testGetWithNull() {
        map = new HashMapNoNull<Integer, Integer>(true);
        map.get(null);
    }
    
    @Test
    public void testPutAllNoNull() {
        map = new HashMapNoNull<Integer, Integer>(false);
        HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
        elements.put(1, 2);
        elements.put(2, 55);
        elements.put(6, 124);
        elements.put(null, 7);
        
        exception.expect(IllegalNullHashMapKey.class);
        map.putAll(elements);
    }
    
    @Test
    public void testPutAllWithNull() {
        map = new HashMapNoNull<Integer, Integer>(true);
        HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
        elements.put(1, 2);
        elements.put(2, 55);
        elements.put(6, 124);
        elements.put(null, 7);
        
        map.putAll(elements);
    }
    
}
