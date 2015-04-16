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
    public void testMeanInvariant() {
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
    
}
