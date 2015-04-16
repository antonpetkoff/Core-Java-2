package utilities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;

import on.off.collection.OnOffCollection;

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
            arr[arr.length - i - 1] = temp;
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

    public static <T> T findFirstUnique(Collection<T> c) {
        LinkedHashMap<T, Integer> map = new LinkedHashMap<T, Integer>();

        for (T key : c) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (T key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T[] intersectSets(Class<T> cls, T[][] sets) {
        if (sets.length == 1) {
            return sets[0];
        }
        
        int minSetIndex = 0, minSetLen = sets[0].length;
        for (int i = 1; i < sets.length; ++i) {
            if (sets[i].length < minSetLen) {
                minSetIndex = i;
                minSetLen = sets[i].length;
            }
        }

        ArrayList<T> survivors = new ArrayList<T>(Arrays.asList(sets[minSetIndex]));
        
        for (int i = 0; i < sets.length; ++i) {
            if (i == minSetIndex) {
                continue;
            }

            survivors.retainAll(new ArrayList<T>(Arrays.asList(sets[i])));
        }
        
        T[] result = (T[]) Array.newInstance(cls, survivors.size());
        
        for (int i = 0; i < result.length; i++) {
            result[i] = survivors.get(i);
        }
        
        return result;
    }

}
