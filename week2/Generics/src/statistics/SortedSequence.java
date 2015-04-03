package statistics;

import java.util.Iterator;

public class SortedSequence implements Iterable<Integer> {
    
    protected class ListNode {
        int value;
        ListNode prev;
        ListNode next;
        
        ListNode(int value, ListNode prev, ListNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
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
        
        if (first == null) {
            first = last = middle = new ListNode(elem, null, null);
            ++size;
            middleIndex = 0;
            return;
        }
        
        ListNode temp = last;
        while (temp.value > elem && temp != null) {
            //temp = temp.prev;
            // TODO
        }
        
        // implement insertion which maintains sorted order
        
        
        // handle middle node
    }
    
    private void linkNode(Integer elem) {
        // TODO
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
