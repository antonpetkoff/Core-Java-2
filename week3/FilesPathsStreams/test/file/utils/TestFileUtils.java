package file.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
public class TestFileUtils {

    @Test
    public void testReadFromFile() {
        String expected = "";
        String actual = "Neiko lapa mekici na poleto\n\nPencho mrazi raiberi.";
        
        try {
            File file = new File("res/test.txt");
            expected = FileUtils.readFrom(file);
            
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testReadFromPath() {
        String expected = "";
        String actual = "Neiko lapa mekici na poleto\n\nPencho mrazi raiberi.";
        
        try {
            File file = new File("res/test.txt");
            expected = FileUtils.readFrom(file.toPath());
            
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        
        assertEquals(expected, actual);
    }
    
}
