package statistics;

import java.util.LinkedHashMap;
import java.util.TreeSet;

public class Statistics {
    
    private TreeSet<Integer> ordered;                   // maintains the order of elements
    private LinkedHashMap<Integer, Integer> buckets;    // holds all <element, count> tuples
    
    private long sum = 0;
    private int count = 0;
    
    public Statistics() {
        ordered = new TreeSet<Integer>();
        buckets = new LinkedHashMap<Integer, Integer>();
    }
    
    public void add(int number) {
        ++count;
        sum += number;
        
        if (buckets.containsKey(number)) {
            buckets.put(number, buckets.get(number) + 1);
        } else {
            buckets.put(number, 1);
            ordered.add(number);
        }
    }
    
    public double getMean() {
        return sum / (double) (count);
    }
    
}
