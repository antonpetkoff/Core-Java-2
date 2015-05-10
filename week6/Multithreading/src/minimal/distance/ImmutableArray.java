package minimal.distance;

import java.util.Arrays;

public final class ImmutableArray<T> {

    private final T[] array;
    
    public ImmutableArray(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public T get(int index) {
        return array[index];
    }
    
    public int length() {
        return array.length;
    }
    
}
