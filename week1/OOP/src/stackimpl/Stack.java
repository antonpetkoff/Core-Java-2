package stackimpl;

public interface Stack<T> {
    
    boolean isEmpty();
    
    int size();
    
    void push(T elem);

    T peek();
    
    T pop();
    
    void clear();
    
}
