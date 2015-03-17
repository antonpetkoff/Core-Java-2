package com.hackbulgaria.corejava;

import java.util.Arrays;
import java.util.HashMap;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        return Math.abs(number) % 2 == 1;
    }

    @Override
    public boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }
        else if (number < 2 || (number % 2 == 0)) {
            return false;
        }
        for (int i = 3; i*i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int min(int... array) {
        int min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public int kthMin(int k, int[] array) {
        if (k > array.length) {
            return 0;
        }
        
        for (int i = 1; i < array.length - 1; ++i) {
            for (int j = 0; j < i + 1; ++j) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] =  temp;
                }
            }
        }

        return array[k - 1];
    }

    @Override
    public float getAverage(int[] array) {
        if (array.length == 0) {
            return 0.0f;
        }
 
        float sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }
        return sum / array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        HashMap<Integer, Integer> primes = new HashMap<Integer, Integer>();
        long result = 1;
        
        for (int i = 2; i <= upperBound; ++i) {
            if (isPrime(i)) {
                primes.put(i, 1);
            }
            else {
                for (int key : primes.keySet()) {
                    if (i % key == 0) {
                        primes.put(key, primes.get(key) + 1);
                        break;
                    }
                }
            }
        }
        
        for (int key : primes.keySet()) {
            //System.out.println(key + " " + primes.get(key));
            for (int i = 1; i < primes.get(key); ++i) {
                result *= key;
            }
        }
        
        return result;
    }
    
    @Override
    public long getLargestPalindrome(long N) {
        while (N > 0) {
            String str = String.valueOf(N);
            if (str.equals(new StringBuilder(str).reverse().toString())) {
                return N;
            }
            --N;
        }
        return 0;
    }

    @Override
    public int[] histogram(short[][] image) {
        
        int[] buckets = new int[256];
        
        for (int row = 0; row < image.length; ++row) {
            for (int col = 0; col < image[row].length; ++col) {
                buckets[image[row][col]] += 1;
            }
        }
        
        return buckets;
    }

    // helper method for doubleFac
    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; ++i) {
            result *= i;
        }
        return result;
    }
    
    @Override
    public long doubleFac(int n) {
        return factorial((int)(factorial(n)));
    }

    @Override
    public long kthFac(int k, int n) {
        long result = 1;
        for (int i = n; i > 0; i -= k) {
            result *= i;
        }
        return result;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        Arrays.sort(array);
        int count = 1, result = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] == array[i+1]) {
                ++count;
            }
            else {
                if (count % 2 == 1) {
                    result = array[i];
                    break;
                }
                count = 1;
            }
        }
        return result;
    }

    @Override
    public long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        else if (b % 2 == 0) {
            return pow(a, b/2) * pow(a, b/2);
        }
        return a * pow(a, b-1);
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long result = 0;
        
        for (int i = 0; i < a.length; ++i) {
            result += a[i] * b[i];
        }
        return result;
    }

    @Override
    public int maxSpan(int[] array) {
        int maxLen = 0, len = 0;
        for (int left = 0; left < array.length; ++left) {
            for (int right = array.length - 1; right > left; --right) {
                if (array[left] == array[right]) {
                    len = right - left + 1;
                }
                if (len < maxLen) {
                    return maxLen;
                }
            }
        }
        return maxLen;
    }

    @Override
    public boolean canBalance(int[] array) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String reverseMe(String argument) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String copyEveryChar(String input, int k) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String reverseEveryWord(String arg) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isPalindrome(String argument) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPalindrome(int number) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getPalindromeLength(String input) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String decodeURL(String input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int sumOfNumbers(String input) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        // TODO Auto-generated method stub
        return false;
    }

}
