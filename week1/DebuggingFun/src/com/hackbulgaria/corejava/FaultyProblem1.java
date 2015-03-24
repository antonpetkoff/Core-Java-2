package com.hackbulgaria.corejava;

public class FaultyProblem1 {
    public long getLargestPalindrome(long N) {
        while (--N > 0) {
            if (Utils.isPalindrome(N)) {
                break;
            }
        }
        return N;
    }

}
