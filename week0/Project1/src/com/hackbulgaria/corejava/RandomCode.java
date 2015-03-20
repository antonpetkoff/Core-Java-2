package com.hackbulgaria.corejava;

public class RandomCode {
    
    public static int sumOfNumbers(String input) {
        String[] numbers = input.split("[a-zA-Z\\s]+");
        int sum = 0;
        
        for (String s : numbers) {
            System.out.println(s);
        }
        
        for (String s : numbers) {
            if (!s.isEmpty()) {
                sum += Integer.parseInt(s);
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        String str = "000 three five -1 1";
        System.out.println(sumOfNumbers(str));
    }
    
}
