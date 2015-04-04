package unchecked.example;

public class DatabaseCorruptedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -705121152007009473L;
    
    public DatabaseCorruptedException(String msg) {
        super(msg);
    }
    
}
