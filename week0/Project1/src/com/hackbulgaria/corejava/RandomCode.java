package com.hackbulgaria.corejava;

public class RandomCode {
    
    public static int sumOfNumbers(String input) {
        input = input.replaceAll("-{2,}", "");
        System.out.println(input);
        String[] numbers = input.split("[^-\\d]");
        
        int sum = 0;
        
        for (String number : numbers) {
            System.out.println(number);
        }
        
        for (String s : numbers) {
            if (!s.isEmpty() && s != "-") {
                sum += Integer.valueOf(s);
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(sumOfNumbers("000 three five -1 1----"));
    }
    
}
