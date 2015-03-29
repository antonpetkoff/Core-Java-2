package stackimpl;

public class StackImpl<T> implements Stack<T> {

    class Node {
        T item;
        Node next;
    }

    private Node top;
    private int size;

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

    public static void main(String[] args) {

        Stack<Integer> stack = new StackImpl<Integer>();

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println("clear the stack");
        stack.clear();

        System.out.println(stack.isEmpty());
    }

}
