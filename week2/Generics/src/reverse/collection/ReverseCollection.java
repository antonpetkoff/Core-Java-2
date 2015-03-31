package reverse.collection;

import java.util.ArrayList;
import java.util.Collection;

public class ReverseCollection {
    
    public static <T> void reverse(Collection<T> collection) {
        Object[] arr = collection.toArray();
        
        for (int i = 0; i < arr.length / 2; i++) {
            Object temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1]  = temp;
        }
        
        collection.clear();
        
        for (int i = 0; i < arr.length; i++) {
            collection.add((T) arr[i]);
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> collection = new ArrayList<Integer>();
        
        for (int i = 0; i < 10; i++) {
            collection.add(i);
        }
        
        reverse(collection);
        
        System.out.println(collection);
    }
    
}
