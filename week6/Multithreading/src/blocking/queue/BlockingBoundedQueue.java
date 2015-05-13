package blocking.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BlockingBoundedQueue<T> implements Queue<T> {

    private LinkedList<T> list;
    private int upperBound;
    
    public BlockingBoundedQueue(int upperBound) {
        if (upperBound < 1) {
            throw new IllegalArgumentException("upperBound must be a positive integer");
        }
        this.upperBound = upperBound;
        list = new LinkedList<T>();
    }
    
    @Override
    public T poll() {
        synchronized(list) {
            while (list.size() == 0) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            list.notifyAll();
            return list.poll();
        }
    }
    
    @Override
    public boolean offer(T e) {
        synchronized (list) {
            while (list.size() == upperBound) {
                try {
                    list.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            
            boolean result = list.offer(e);
            list.notifyAll();
            return result;            
        }
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
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
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

    @Override
    public boolean add(T e) {
        return list.add(e);
    }

    @Override
    public T remove() {
        return list.remove();
    }

    @Override
    public T element() {
        return list.element();
    }

    @Override
    public T peek() {
        return list.peek();
    }
    
}