package pack.linkedlist;

public interface List<T> {

    int size();
    
    boolean isEmpty();
    
    T getFirst();
    
    T getLast();
    
    T get(int index);
    
    void append(T elem);
    
    void add(int index, T elem);
    
    //void addFirst(T elem);
    
    //void addLast(T elem);
    
    void set(int index, T elem);
    
    void remove(int index);
    
    boolean contains(T elem);
    
    void clear();
}
