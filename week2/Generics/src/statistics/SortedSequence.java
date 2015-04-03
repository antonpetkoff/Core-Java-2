package statistics;

import java.util.Iterator;

public class SortedSequence implements Iterable<Integer> {
    
    protected class ListNode {
        ListNode prev;
        ListNode next;
        int value;
    }
    
    private ListNode first;
    private ListNode last;
    private ListNode middle;
    private int size;
    private int middleIndex;
    
    SortedSequence() {
        first = last = middle = null;
        size = 0;
        middleIndex = -1;
    }
    
    public double getMedian() {
        if (size == 0) {
            return 0.0;
        }
        if (size % 2 == 0) {
            return (middle.value + middle.prev.value) / 2.0;
        }
        return middle.value;
    }
    
    public void add(Integer elem) {
        // TODO
        
        // implement insertion which maintains sorted order
        // handle middle node
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new SortedListIterator();
    }
    
    private class SortedListIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Integer next() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            
        }
        
    }
    
}
