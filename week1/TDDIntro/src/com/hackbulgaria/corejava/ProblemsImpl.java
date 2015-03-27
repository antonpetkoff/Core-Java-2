package com.hackbulgaria.corejava;

public class ProblemsImpl implements Problems {

    @Override
    public int getNumberOfDigits(int n) {
        n = n < 0 ? -n : n;
        
        if (n < 10) {
            return 1;
        }
        
        int count = 0;
        while (n > 0) {
            n /= 10;
            ++count;
        }
        
        return count;
    }
    
}
