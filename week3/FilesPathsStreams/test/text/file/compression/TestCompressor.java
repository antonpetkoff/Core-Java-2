package text.file.compression;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import file.utils.FileUtils;

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
    
    @Test
    public void testCompression() throws FileNotFoundException, IOException {
        String filePath = "res/" + UUID.randomUUID().toString();
        String testText = "buffalo buffalo buffalo rides a buffalo buffalo buffalo.";
        FileUtils.writeTo(testText, Paths.get(filePath + ".txt"));
        Compressor.compress(Paths.get(filePath + ".txt"));
        Compressor.decompress(Paths.get(filePath + ".compr"));
        String decompressed = FileUtils.readFrom(Paths.get(filePath + ".decompr"));
        
        Files.delete(Paths.get(filePath + ".txt"));
        Files.delete(Paths.get(filePath + ".compr"));
        Files.delete(Paths.get(filePath + ".decompr"));
        
        assertEquals(testText, decompressed);
    }
    
}
