package text.file.compression;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import file.utils.FileUtils;

public class Compressor {

    private ArrayList<String> map;
    
    public Compressor() {
        map = new ArrayList<String>();
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
                --i;

                if (!map.contains(temp.toString())) {
                    map.add(temp.toString());
                }
                
                compressed.append("~" + map.indexOf(temp.toString()));
                temp = new StringBuilder();
            }
        }
        
        String fileName = filePath.getFileName().toString().replaceFirst("\\..*", "");
        String writePath = filePath.getParent().toString() + "/" + fileName + ".compr";
        
        try {
            FileUtils.writeTo(compressed.toString(), Paths.get(writePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String path = "/home/tony/Desktop/compressThis.txt";
        Compressor compressor = new Compressor();
        compressor.compress(Paths.get(path));
    }
}
