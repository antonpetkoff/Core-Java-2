package com.hackbulgaria.corejava;

public class RandomCode {
     
    public static void main(String[] args) {
        String str = "kitten%20pic.jpg";
        String[] splitted = str.split("%\\w{2}");
        String result = str.replaceAll("%20", " ").replaceAll("%3A", ":")
                           .replaceAll("%3D", "?").replaceAll("%2F", "/");
        
        for (String s : splitted) {
            System.out.println(s);
        }
        
        System.out.println(result);
    }
    
}
