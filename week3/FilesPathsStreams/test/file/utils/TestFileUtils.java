package file.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.junit.Test;

public class TestFileUtils {

    @Test
    public void testReadFromFile() {
        String expected = "Neiko lapa mekici na poleto\n\nPencho mrazi raiberi.";
        String actual = "";

        try {
            File file = new File("res/test.txt");
            actual = FileUtils.readFrom(file);

        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testReadFromPath() {
        String expected = "Neiko lapa mekici na poleto\n\nPencho mrazi raiberi.";
        String actual = "";

        try {
            File file = new File("res/test.txt");
            actual = FileUtils.readFrom(file.toPath());

        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }

        assertEquals(expected, actual);
    }
    
    @Test
    public void testWriteToFile() {
        String expected = "random\ntext\nfile";
        String actual = "";
        
        File tempFile;

        try {
            tempFile = File.createTempFile(UUID.randomUUID().toString(), ".txt");
            FileUtils.writeTo(expected, tempFile);
            actual = FileUtils.readFrom(tempFile);
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        
        assertEquals(expected, actual);
    }

}
