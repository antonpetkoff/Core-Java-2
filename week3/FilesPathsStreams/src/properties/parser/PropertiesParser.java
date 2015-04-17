package properties.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import file.utils.FileUtils;

public class PropertiesParser {

    public static Map<String, String> parseProperties(File file) {
        String str = null;
        try {
            str = FileUtils.readFrom(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Map<String, String> result = new HashMap<String, String>();
        Scanner scanner = new Scanner(str);

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            
            if (!line.startsWith("#")) {
                int firstEquals = line.indexOf('=');
                if (firstEquals != -1) {
                    result.put(line.substring(0, firstEquals), line.substring(firstEquals + 1, line.length()).trim());
                }
            }
        }
        
        scanner.close();
        return result;
    }
    
}
