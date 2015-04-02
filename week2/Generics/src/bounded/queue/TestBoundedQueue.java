package bounded.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBoundedQueue {
    
    @Test
    public void testBoundedQueue() {
        BoundedQueue<Integer> boundedQueue = new BoundedQueue<>(3);
        boundedQueue.offer(1);
        boundedQueue.offer(2);
        boundedQueue.offer(3);
        boundedQueue.offer(4);
        boundedQueue.offer(5);
        
        assertEquals(boundedQueue.size(), 3);
        assertEquals(boundedQueue.remove(), Integer.valueOf(3));
        assertEquals(boundedQueue.remove(), Integer.valueOf(4));
        assertEquals(boundedQueue.remove(), Integer.valueOf(5));
        assertEquals(boundedQueue.size(), 0);
    }
    
}
