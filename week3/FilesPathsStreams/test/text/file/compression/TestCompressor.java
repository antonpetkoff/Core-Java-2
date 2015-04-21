package text.file.compression;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestCompressor {

    private ArrayList<String> list;
    
    @Before
    public void setUp() {
        list = new ArrayList<String>(Arrays.asList("neiko", "lapa", "slivi"));
    }
    
    @Test
    public void testSerialization() {
        String encoded = Compressor.serializeToString(list);
        
        @SuppressWarnings("unchecked")
        ArrayList<String> decoded = (ArrayList<String>) Compressor.deserializeFromString(encoded);
        
        assertTrue(list.equals(decoded));
    }
    
}
