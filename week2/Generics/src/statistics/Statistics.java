package statistics;

import java.util.LinkedHashMap;

public class Statistics {
    
    // buckets hold all <element, count> tuples and handle the mode
    private LinkedHashMap<Integer, Integer> buckets;
    private SortedSequence sorted;
    
    private long sum = 0;
    
    private int mostFrequentCount = 0;   // the count of the most frequent in buckets
    private Integer mostFrequentNumber = null;
    
    public Statistics() {
        buckets = new LinkedHashMap<Integer, Integer>();
        sorted = new SortedSequence();
    }
    
    /**
     * O(n) worst case complexity
     */
    public void add(int number) {
        sum += number;
        
        sorted.add(number);
        
        if (buckets.containsKey(number)) {
            buckets.put(number, buckets.get(number) + 1);
        } else {
            buckets.put(number, 1);
        }
        
        // maintain mode invariant
        if (buckets.get(number) > mostFrequentCount) {
            mostFrequentCount = buckets.get(number);
            mostFrequentNumber = number;
        }
    }
    
    /**
     * O(1) complexity
     */
    public Double getMean() {
        return sum / (double) (sorted.size());
    }
    
    /**
     * O(1) complexity
     */
    public Integer getRange() {
        if (sorted.isEmpty()) {
            return null;
        }
        if (sorted.size() == 1) {
            return 0;
        }
        return sorted.getMaximum() - sorted.getMinimum();
    }
    
    /**
     * O(1) complexity
     */
    public Double getMedian() {
        return sorted.getMedian();
    }
    
    /**
     * O(1) complexity
     */
    public Integer getMode() {
        return mostFrequentNumber != null ? mostFrequentNumber : null;
    }
    
}
