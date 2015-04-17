package file.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import properties.parser.PropertiesParser;
import file.utils.FileUtils;

public class TestPropertiesParser {

    private File tempFile;
    private String testStr = "# this=comment\na1=b1 \na2 =b2\na3    =    b3\n   a4 = b4\n"
                            + "a5=b6=b7=b8\na6=b9 #comment \na7==b10";    
    
    @Before
    public void setUp() {
        try {
            tempFile = File.createTempFile(UUID.randomUUID().toString(), ".properties", new File("res/"));
            FileUtils.writeTo(testStr, tempFile);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testParseProperties() {
        String expected = "{a3    =b3,    a4 =b4, a1=b1, a2 =b2, a5=b6=b7=b8, a6=b9 #comment, a7==b10}";
        String actual = PropertiesParser.parseProperties(tempFile).toString();
        assertEquals(expected, actual);
    }
    
    @After
    public void tearDown() {
        if (!tempFile.delete()) {
            fail("could not delete tempFile");
        }
    }
    
}
