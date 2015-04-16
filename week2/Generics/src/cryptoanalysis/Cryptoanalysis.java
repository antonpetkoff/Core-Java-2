package cryptoanalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Cryptoanalysis {

    public static final String text = readFromFile(new File("res/encrypted.txt"));

    public static String readFromFile(File file) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            if (null != (line = reader.readLine())) {
                result.append(line);
            }

            while (null != (line = reader.readLine())) {
                result.append('\n').append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
    
    public static String applyCipher(Map<Character, Character> cipher) {
        StringBuilder deciphered = new StringBuilder();
        
        for (int i = 0 ; i < text.length(); ++i) {
            if (Character.isLetter(text.charAt(i))) {
                deciphered.append(cipher.get( Character.toLowerCase(text.charAt(i)) ));
            } else {
                deciphered.append(text.charAt(i));
            }
        }
        
        return deciphered.toString();
    }
    
    public static String mostFrequentLetters(String text) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < text.length(); ++i) {
            if (Character.isLetter(text.charAt(i))) {
                Character temp = Character.toLowerCase(text.charAt(i));
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>()
        {
            @Override
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                return (o2.getValue()).compareTo( o1.getValue());
            }
        } );
        
        StringBuilder order = new StringBuilder();
        for (Entry<Character, Integer> entry : list) {
            order.append(entry.getKey());
        }
        
        return order.toString();
    }
    
    public static Map<Character, Character> generateCipher(String from, String to) {
        if (from.length() != to.length()) {
            throw new IllegalArgumentException("from and to must match lenghts");
        }
        
        Map<Character, Character> cipher = new HashMap<>();
        
        for(int i = 0; i < from.length(); ++i) {
            cipher.put(from.charAt(i), to.charAt(i));
        }
        
        return cipher;
    }
    
    public static void main(String[] args) {
        String mostFrequentInText = mostFrequentLetters(text);
        String mostFrequentInEnglish = "etaoinshrdlcumwfgypbvkjxq";
        String deciphered = applyCipher(generateCipher(mostFrequentInText, mostFrequentInEnglish));
        System.out.println(deciphered);
    }
}
