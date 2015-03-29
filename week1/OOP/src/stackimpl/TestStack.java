package stackimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStack {

    @Test
    public void testStackImpl() {
        StackImpl<Integer> stack = new StackImpl<Integer>();

        assertEquals(null, stack.peek());
        assertEquals(null, stack.pop());

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            assertEquals(i, stack.size());
        }

        assertEquals(false, stack.isEmpty());
        assertEquals(Integer.valueOf(5), stack.pop());
        assertEquals(Integer.valueOf(4), stack.pop());
        assertEquals(Integer.valueOf(3), stack.peek());

        stack.clear();

        assertEquals(true, stack.isEmpty());
    }
    
    @Test
    public void testStackInvariant() {
        StackInvariant<Integer> stack = new StackInvariant<Integer>();
        
        assertEquals(null, stack.peek());
        assertEquals(null, stack.pop());
        assertEquals(false, stack.contains(2));

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            assertEquals(i, stack.size());
        }

        assertEquals(false, stack.isEmpty());
        assertEquals(Integer.valueOf(5), stack.pop());
        assertEquals(Integer.valueOf(4), stack.pop());
        assertEquals(Integer.valueOf(3), stack.peek());
        
        assertEquals(true, stack.contains(3));
        assertEquals(false, stack.contains(4));
        
        stack.push(3);
        assertEquals(3, stack.size());
        stack.push(4);
        assertEquals(4, stack.size());

        stack.clear();

        assertEquals(true, stack.isEmpty());
    }
    
}
