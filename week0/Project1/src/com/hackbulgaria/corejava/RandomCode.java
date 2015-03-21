package com.hackbulgaria.corejava;

public class RandomCode {
    
    public static int sumOfNumbers(String input) {
        String[] numbers = input.split("(?!-)\\D+");
        int sum = 0;
        
        for (String number : numbers) {
            System.out.println(number);
        }
        
        for (String s : numbers) {
            if (!s.isEmpty()) {
                sum += Integer.valueOf(s);
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(sumOfNumbers("000 three five -1 1"));
    }
    
}
