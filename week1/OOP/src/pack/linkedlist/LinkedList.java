package pack.linkedlist;

/**
 * Doubly-Linked List implementation
 */
public class LinkedList<T> implements List<T> {

    protected class ListNode {
        T item;
        ListNode next;
        ListNode prev;
    }

    protected int size;
    protected ListNode first;
    protected ListNode last;

    public LinkedList() {
        size = 0;
        first = last = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getFirst() {
        return null == first ? null : first.item;
    }

    @Override
    public T getLast() {
        return null == last ? null : last.item;
    }

    @Override
    public T get(int index) {
        checkIndexBounds(index);
        return getNodeAt(index).item;
    }

    @Override
    public void addFirst(T elem) {
        ListNode newNode = new ListNode();
        newNode.item = elem;
        newNode.prev = null;
        
        if (size == 0) {
            newNode.next = null;
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        
        ++size;
    }
    
    @Override
    public void addLast(T elem) {
        ListNode newNode = new ListNode();
        newNode.item = elem;
        newNode.next = null;

        if (size == 0) {
            newNode.prev = null;
            first = last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }

        ++size;
    }

    
    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     * 
     * If the index you pass equals the list's size, the add() method calls
     * addLast() method.
     *
     * @param index
     *            index at which the specified element is to be inserted
     * @param element
     *            element to be inserted
     */
    @Override
    public void add(int index, T elem) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add(int index, T elem): index out of bounds!");
        }
        
        if (index == size) {
            addLast(elem);
        } else if (index == 0) {
            addFirst(elem);
        } else {
            ListNode pivotNode = getNodeAt(index);
            ListNode newNode = new ListNode();

            newNode.item = elem;
            newNode.next = pivotNode;
            newNode.prev = pivotNode.prev;

            pivotNode.prev.next = newNode;
            pivotNode.prev = newNode;
            ++size;
        }
    }

    @Override
    public void set(int index, T elem) {
        checkIndexBounds(index);
        getNodeAt(index).item = elem;
    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(T elem) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }
    
    private void checkIndexBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get(int): index out of range!");
        }
    }
    
    protected ListNode getNodeAt(int index) {
        // check if index in bounds
        
        ListNode temp;

        if (index < size / 2) {
            temp = first;
            int i = 0;

            while (i != index) {
                temp = temp.next;
                ++i;
            }
        } else {
            temp = last;
            int i = size - 1;

            while (i != index) {
                temp = temp.prev;
                --i;
            }
        }

        return temp;
    }

}
