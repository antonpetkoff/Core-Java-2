package bounded.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BoundedQueue<T> implements Queue<T> {
    
    final private int bound;
    private LinkedList<T> list;
    
    public BoundedQueue(int bound) {
        this.bound = bound;
        this.list = new LinkedList<T>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean whatAdd = true;
        
        for (T elem : c) {
            whatAdd = list.add(elem);
        }
        
        return whatAdd;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    /**
     * If the bound is reached, the head is removed to make space
     * for the new element.
     * 
     * @return false if head is removed, else true
     */
    @Override
    public boolean add(T e) {
        if (list.size() == bound) {
            list.removeFirst();
            list.addLast(e);
            return false;
        }
        
        list.addLast(e);
        return true;
    }

    /**
     * If the bound is reached, the head is removed to make space
     * for the new element.
     * 
     * @return false if head is removed, else true
     */
    @Override
    public boolean offer(T e) {
        if (list.size() == bound) {
            list.removeFirst();
            list.addLast(e);
            return false;
        }
        
        list.addLast(e);
        return true;
    }

    @Override
    public T remove() {
        return list.removeFirst();
    }

    @Override
    public T poll() {
        return list.removeFirst();
    }

    @Override
    public T element() {
        return list.getFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
            str.append(iterator.next().toString() + ", ");
        }
        
        return str.toString().substring(0, str.length() - 2);
    }
    
    public static void main(String[] args) {
        BoundedQueue<Integer> boundedQueue = new BoundedQueue<>(3);
        boundedQueue.offer(1);
        boundedQueue.offer(2);
        boundedQueue.offer(3);
        boundedQueue.offer(4);
        boundedQueue.offer(5);
        System.out.println(boundedQueue.toString()); //3,4,5
    }
}
