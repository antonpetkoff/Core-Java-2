package com.hackbulgaria.corejava;

public class RandomCode {

    public static long getSmallestMultipleBetter(int upperBound) {
        int[] numbers = new int[upperBound];
        for (int i = 0; i < upperBound; ++i) {
            numbers[i] = i + 1;
        }
        
        int pivot = 1, tempFactor = 0;
        long result = 1;
        
        while (pivot < upperBound - 1) {
            while (numbers[pivot] == 1) {
                ++pivot;
            }

            tempFactor = numbers[pivot];
            result *= tempFactor;

            for (int i = pivot; i < upperBound; i += pivot + 1) {
                System.out.println(i);
                numbers[i] /= tempFactor;
            }
            
            System.out.print("pivot = " + pivot + ": ");
            for (int i = 0; i < upperBound; ++i) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

            ++pivot;
            System.out.println("Pivot now is = " + pivot);
        }

        return result;
    }
    
    public static void main(String[] args) {
        
        System.out.println(getSmallestMultipleBetter(10));
        
    }
    
}
