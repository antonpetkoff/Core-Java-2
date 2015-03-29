package pack.linkedlist;

public interface List {

    int size();
    
    boolean isEmpty();
    
    int getFirst();
    
    int getLast();
    
    int get(int index);
    
    void add(int index, int elem);
    
    //void addFirst();
    
    //void addLast();
    
    void set(int index, int elem);
    
    void remove(int index);
    
    boolean contains(int elem);
    
    void clear();
}
