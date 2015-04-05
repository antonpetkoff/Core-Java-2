package hashmap.nonull;

import java.util.HashMap;
import java.util.Map;

public class HashMapNoNull<K, V> extends HashMap<K, V> {

    /**
     * 
     */
    private static final long serialVersionUID = -628090725756480803L;

    private boolean acceptNull;
    
    public HashMapNoNull() {
        super();
        this.acceptNull = false;
    }
    
    public HashMapNoNull(boolean acceptNull) {
        super();
        this.acceptNull = acceptNull;
    }
    
    @Override
    public V put(K key, V value) {
        if (!acceptNull && key == null) {
            throw new IllegalNullHashMapKey("HashMapNoNull doesn't accept null keys!");
        }
        return super.put(key, value);
    }
    
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if (!acceptNull) {
            for (K key : m.keySet()) {
                if (key == null) {
                    throw new IllegalNullHashMapKey("HashMapNoNull doesn't accept null keys!");
                }
            }
        }
        
        super.putAll(m);
    }
    
    @Override
    public V get(Object key) {
        if (!acceptNull && key == null) {
            throw new IllegalNullHashMapKey("HashMapNoNull doesn't accept null keys!");
        }
        return super.get(key);
    }
    
}
