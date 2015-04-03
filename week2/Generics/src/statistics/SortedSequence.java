package statistics;

import java.util.Iterator;

public class SortedSequence implements Iterable<Integer> {
    
    protected class ListNode {
        int value;
        ListNode prev;
        ListNode next;
        
        ListNode(int value) {
            this.value = value;
        }
        
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
        if (first == null) {
            first = last = middle = new ListNode(elem, null, null);
            ++size;
            middleIndex = 0;
            return;
        }
        
        // maintain sorted invariant
        ListNode temp = last;
        while (temp.value > elem && temp != null) {
            temp = temp.prev;
        }
        
        if (temp == null) {             // add before first node
            linkNodeAsFirst(elem);
        } else {                        // add after temp node or last node
            linkNodeAfter(temp, elem);
        }
        
        ++size;
        
        // maintain middle node
        if (size / 2 > middleIndex) {
            middleIndex = size / 2;
            middle = middle.next;
        } else if (size / 2 < middleIndex) {
            middleIndex = size / 2;
            middle = middle.prev;
        }
        
    }
    
    private void linkNodeAsFirst(Integer elem) {
        ListNode newNode = new ListNode(elem, null, first);
        first.prev = newNode;
        first = newNode;
    }
    
    private void linkNodeAfter(ListNode pivot, Integer elem) {
        ListNode newNode = new ListNode(elem);
        newNode.prev = pivot;
        
        if (pivot.next != null) {
            newNode.next = pivot.next;
            pivot.next.prev = newNode;
        } else {
            newNode.next = null;
        }
        
        pivot.next = newNode;
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
