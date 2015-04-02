package utilities;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

public class Utilities {
    
    public static boolean areBracketsBalanced(String str) {        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.size() == 0;
    }
    
    @SuppressWarnings("unchecked")
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

    public static <T> void rotate(Collection<T> c, int rotateStep) {
        if (rotateStep == 0) {
            return;
        }
        
        LinkedList<T> deque = new LinkedList<T>();
        deque.addAll(c);
        
        rotateStep %= deque.size();
        
        
        if (rotateStep > 0) {
            while (rotateStep > 0) {
                T temp = deque.removeLast();
                deque.addFirst(temp);
                --rotateStep;
            }
        } else {
            while (rotateStep < 0) {
                T temp = deque.removeFirst();
                deque.addLast(temp);
                ++rotateStep;
            }
        }
        
        c.clear();
        
        for (T elem : deque) {
            c.add(elem);
        }
    }
    
}
