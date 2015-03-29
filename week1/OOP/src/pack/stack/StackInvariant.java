package pack.stack;

public class StackInvariant<T> extends StackImpl<T> {
    
    boolean contains(T elem) {
        Node temp = top;
        
        while (temp != null) {
            if (elem.equals(temp.item)) {
                return true;
            }
            temp = temp.next;
        }
        
        return false;
    }
    
    @Override
    public void push(T elem) {
        if (!contains(elem)) {
            super.push(elem);
        }
    }
    
}
