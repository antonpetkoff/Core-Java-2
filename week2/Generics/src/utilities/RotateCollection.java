package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class RotateCollection {

    public static <T> void rotate(Collection<T> c, int rotateStep) {
        if (rotateStep == 0) {
            return;
        }
        
        LinkedList<T> deque = new LinkedList<T>();
        deque.addAll(c);
        
//        rotateStep = rotateStep > 0 ? 
//                rotateStep % c.size() : -(Math.abs(rotateStep) % c.size());
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
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }
        
        rotate(list, 3);
        
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
        
        list.clear();
        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }
        
        rotate(list, -9);
        
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
    
}
