package pack.linkedlist;

/**
 * Doubly-Linked List implementation
 */
public class LinkedList<T> implements List<T> {

    class ListNode {
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
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get(int): index out of range!");
        }

        ListNode temp = first;
        int i = 0;
        while (i != index) {
            temp = temp.next;
            ++i;
        }

        return temp.item;
    }

    @Override
    public void append(T elem) {
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

    @Override
    public void add(int index, T elem) {
        // TODO Auto-generated method stub

    }

    @Override
    public void set(int index, T elem) {
        // TODO Auto-generated method stub

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

}
