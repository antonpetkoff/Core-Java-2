package atomic.integer;

public class AtomicInteger {
    
    private volatile int value;
    private final Object lock = new Object();
    
    public AtomicInteger() {
        
    }
    
    public AtomicInteger(int initialValue) {
        this.value = initialValue;
    }
    
    public final int get() {
        return value;
    }
    
    public synchronized void set(int value) {
        synchronized (lock) {
            this.value = value;
        }
    }
}
