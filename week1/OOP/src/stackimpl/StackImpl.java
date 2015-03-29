package stackimpl;

public class StackImpl<T> implements Stack<T> {

    class Node {
        T item;
        Node next;
    }

    protected Node top;
    protected int size;

    StackImpl() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(T elem) {
        Node prevTop = top;
        Node newTop = new Node();
        newTop.item = elem;
        newTop.next = prevTop;
        top = newTop;
        ++size;
    }

    @Override
    public T peek() {
        return top == null ? null : top.item;
    }

    @Override
    public T pop() {
        if (top == null) {
            return null;
        }

        T topItem = top.item;
        top = top.next;
        --size;
        
        return topItem;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

}
