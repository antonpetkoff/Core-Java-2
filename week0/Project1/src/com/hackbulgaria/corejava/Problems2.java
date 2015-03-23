package com.hackbulgaria.corejava;

import java.io.IOException;

public interface Problems2 {
    boolean isOdd(int number);

    boolean isPrime(int number);

    int min(int... array);

    int kthMin(int k, int[] array);

    float getAverage(int[] array);

    long getSmallestMultiple(int upperBound);
    
    // better solution for getSmallestMultiple
    long getSmallestMultipleBetter(int upperBound);

    long getLargestPalindrome(long N);

    int[] histogram(short[][] image);

    long doubleFac(int n);

    long kthFac(int k, int n);

    int getOddOccurrence(int[] array);

    long pow(int a, int b);

    long maximalScalarSum(int[] a, int[] b);

    int maxSpan(int[] array);

    boolean canBalance(int[] array);

    // helper method for rescale
    int averageMatrix(int[][] matrix, int x, int y, int height, int width);
    
    int[][] rescale(int[][] original, int newWidth, int newHeight);

    String reverseMe(String argument);

    String copyEveryChar(String input, int k);

    String reverseEveryWord(String arg);

    boolean isPalindrome(String argument);

    boolean isPalindrome(int number);

    int getPalindromeLength(String input);

    int countOcurrences(String needle, String haystack);

    String decodeURL(String input);

    int sumOfNumbers(String input);

    boolean areAnagrams(String A, String B);

    boolean hasAnagramOf(String string, String string2);
    
    void convertToGreyScale(String imgPath) throws IOException;
}
