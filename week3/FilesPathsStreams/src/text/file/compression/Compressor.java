package text.file.compression;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import file.utils.FileUtils;

public class Compressor {

    private HashMap<String, Integer> map;
    
    public Compressor() {
        map = new HashMap<String, Integer>();
    }
    
    public void compress(Path filePath) {
        String text = null;
        try {
            text = FileUtils.readFrom(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int counter = 0;
        StringBuilder compressed = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == ' ') {
                compressed.append(text.charAt(i));
            } else {
                while (i < text.length() && text.charAt(i) != ' ') {
                    temp.append(text.charAt(i));
                    ++i;
                }
                
                if (!map.containsKey(temp)) {
                    map.put(temp.toString(), counter);
                    ++counter;
                }
                
                compressed.append("~" + map.get(temp));
                temp = new StringBuilder();
            }
        }
        
        String fileName = filePath.getFileName().toString().replaceFirst("\\..*", "");
        String writePath = filePath.getParent().toString() + fileName + ".compr";
        
        try {
            FileUtils.writeTo(compressed.toString(), Paths.get(writePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
