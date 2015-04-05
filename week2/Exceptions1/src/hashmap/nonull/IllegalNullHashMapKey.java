package hashmap.nonull;

public class IllegalNullHashMapKey extends RuntimeException {

    private static final long serialVersionUID = -2245550917269511298L;

    public IllegalNullHashMapKey(String msg) {
        super(msg);
    }
    
}
