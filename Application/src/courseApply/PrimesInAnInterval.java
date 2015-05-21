package courseApply;

import java.util.ArrayList;

public class PrimesInAnInterval {

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if ((n < 2) || (n % 2 == 0)) {
            return false;
        }
        for (int i = 3; i*i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static ArrayList<Integer> primesInAnInterval(int a, int b) {
        if (a < 0 || a > b) {
            System.out.println("invalid input");
            return new ArrayList<>();
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = a; i <= b; ++i) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }
    
    private static void testInterval(int a, int b) {
        ArrayList<Integer> list;
        list = primesInAnInterval(a, b);
        for (Integer i : list) {
            System.out.print(i.toString() + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        testInterval(2, 20);
        testInterval(10, 30);
        testInterval(20, 10);
        testInterval(-20, 10);
    }
    
}