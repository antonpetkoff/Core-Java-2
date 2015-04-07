package file.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {

    private FileUtils() {
        
    }
    
    public static String readFrom(File file) throws FileNotFoundException, IOException {
        StringBuilder result = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            
            while (null != (line = reader.readLine())) {
                result.append(line);
            }
        }
        
        return result.toString();
    }
    
    public static String readFrom(Path path) throws FileNotFoundException, IOException {
        return readFrom(new File(path.toString()));        
    }
    
}
