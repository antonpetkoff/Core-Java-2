package statistics;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestStatistics {

    private Statistics stats;
    
    @Before
    public void setUp() {
        stats = new Statistics();
    }
    
    @Test
    public void testGetMean() {
        Random rand = new Random();
        int sum = 0, count = 0;
        
        for (int i = 0; i < 100; ++i) {
            int temp = rand.nextInt(1000); 
            sum += temp;
            ++count;
            stats.add(temp);
        }
        
        Double expected = sum / (double) count;
        assertEquals(expected, Double.valueOf(stats.getMean()));
    }
    
    @Test
    public void testGetRange() {
        assertEquals(null, stats.getRange());
        stats.add(666);
        assertEquals(Integer.valueOf(0), stats.getRange());
        stats = new Statistics();
        
        final int start = 0;
        final int end = 100;
        
        for (int i = start; i <= end; i++) {
            stats.add(i);
        }
        
        assertEquals(Integer.valueOf(end - start), Integer.valueOf(stats.getRange()));
    }
    
    @Test
    public void testGetMedian() {
        for (int i = 0; i < 100; ++i) {
            stats.add(i);
        }
        
        assertEquals(Double.valueOf(49.5), stats.getMedian());
    }
    
    @Test
    public void testGetMode() {
        Random rand = new Random();
        int mostFrequentNumber = 0;
        int mostFrequentCount = 0;
        
        for (int number = 0; number < 10; ++number) {
            int numberCount = rand.nextInt(5);
            
            for (int iter = 0; iter < numberCount; ++iter) {
                stats.add(number);
            }
            
            if (numberCount > mostFrequentCount) {
                mostFrequentCount = numberCount;
                mostFrequentNumber = number;
            }
        }
        
        assertEquals(Integer.valueOf(mostFrequentNumber), stats.getMode());
    }
    
}
