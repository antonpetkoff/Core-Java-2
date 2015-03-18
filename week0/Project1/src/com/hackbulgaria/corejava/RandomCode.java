package com.hackbulgaria.corejava;

public class RandomCode {

    public static boolean canBalance(int... array) {
        if (array.length == 1) {
            return false;
        }
        
        int left = 0, right = array.length - 1;
        int diff = array[left] - array[right];
        while (left < right) {
            System.out.println(left + " " + right + " " + diff);
            if (diff == 0) {
                if (right - left == 2) {
                    return false;
                }
                
                ++left;
                --right;
                diff = array[left] - array[right];
            } else if (diff < 0) {
                ++left;
                diff = Math.abs(diff) - array[left];
            } else {
                --right;
                diff = Math.abs(diff) - array[right];
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        System.out.println(canBalance(1, 1, 1, 2, 1));
        
    }
    
}
