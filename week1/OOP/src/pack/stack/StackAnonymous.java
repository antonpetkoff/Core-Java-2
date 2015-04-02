package pack.stack;

import pack.linkedlist.LinkedList;

public class StackAnonymous<T> implements Stack<T> {
    
    private LinkedList<T> list = createList();
    
    private LinkedList<T> createList() {
        // anonymous class goes here
        return new LinkedList<T>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void push(T elem) {
        list.addFirst(elem);
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public T pop() {
        T temp = list.getFirst();
        list.removeFirst();
        return temp;
    }

    @Override
    public void clear() {
        list.clear();
    }
    
}
