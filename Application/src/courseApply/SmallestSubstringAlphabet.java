package courseApply;

public class SmallestSubstringAlphabet {

	// TODO: make case insensitive and format output
	public static String smallestSubstringContainingTheAlphabet(String str) {
        char[] chars = str.toCharArray();
        int[] hasFound = new int[128];      // 256 symbols in ASCII table
        int[] toBeFound = new int[128];
        for(int i = 97; i < 123; ++i) {     // 97 + 26 = 123, 97 is 'a', 122 is 'z'
            toBeFound[i] = 1;
        }
        final int ALPHABET_LEN = 26;
        int count = 0;
        int minBegin = 0, minEnd = 0, minWindowLength = Integer.MAX_VALUE;
        
        for(int begin = 0, end = 0; end < chars.length; ++end) {
            int asciiCode = (int) chars[end];
            if (toBeFound[asciiCode] == 0) {
                continue;
            }
            
            ++hasFound[asciiCode];
            
            if (hasFound[asciiCode] <= toBeFound[asciiCode]) {
                ++count;
            }
            
            if (count == ALPHABET_LEN) {
                // advance begin
                while (hasFound[(int) chars[begin]] > toBeFound[(int) chars[begin]]
                        || toBeFound[(int) chars[begin]] == 0) {
                    if (hasFound[(int) chars[begin]] > toBeFound[(int) chars[begin]]) {
                        --hasFound[(int) chars[begin]];
                    }
                    ++begin;
                }
                
                // update minimum
                int windowLength = end - begin + 1;
                if (windowLength < minWindowLength) {
                    minWindowLength = windowLength;
                    minBegin = begin;
                    minEnd = end;
                }
            }
        }
        
        return str.substring(minBegin, minEnd);
    }
    
    public static void main(String[] args) {
        System.out.println(smallestSubstringContainingTheAlphabet(
                "abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn"));
        
        System.out.println(smallestSubstringContainingTheAlphabet(
                "aaaaaabcdefghijklmnopqrstuvwxyz"));
    }
}
