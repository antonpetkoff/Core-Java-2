package text.file.compression;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import file.utils.FileUtils;

public class Compressor {
    
    public static void compress(Path filePath) throws FileNotFoundException, IOException {
        String text = FileUtils.readFrom(filePath);
        
        ArrayList<String> list = new ArrayList<String>();
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

                if (!list.contains(temp.toString())) {
                    list.add(temp.toString());
                }
                
                compressed.append("~" + list.indexOf(temp.toString()));
                temp = new StringBuilder();
            }
        }
        
        String fileName = filePath.getFileName().toString().replaceFirst("\\..*", "");
        String writePath = filePath.getParent().toString() + "/" + fileName + ".compr";
        String serializedList = serializeToString(list);
        String forWriting = String.valueOf(compressed.length()) + compressed.toString() + serializedList;
        
        FileUtils.writeTo(forWriting, Paths.get(writePath));
    }
    
    public static void decompress(Path filePath) throws FileNotFoundException, IOException {
        String text = FileUtils.readFrom(filePath);
        int compressedLength = Integer.valueOf(text.substring(0, text.indexOf('~')));
        String compressed = text.substring(text.indexOf('~'), text.indexOf('~') + compressedLength);
        String serializedList = text.substring(text.indexOf('~') + compressedLength);
        
        @SuppressWarnings("unchecked")
        ArrayList<String> list = (ArrayList<String>) deserializeFromString(serializedList);
        StringBuilder decompressed = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for (int i = 0; i < compressed.length(); ++i) {
            if (Character.isWhitespace(compressed.charAt(i))) {
                decompressed.append(' ');
            } else if (compressed.charAt(i) == '~') {
                ++i;
                while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                    temp.append(compressed.charAt(i));
                    ++i;
                }
                --i;
                
                decompressed.append(list.get(Integer.valueOf(temp.toString())));
                temp = new StringBuilder();
            }
        }
        
        String fileName = filePath.getFileName().toString().replaceFirst("\\..*", "");
        String writePath = filePath.getParent().toString() + "/" + fileName + ".decompr";
        
        FileUtils.writeTo(decompressed.toString(), Paths.get(writePath));
    }
    
    protected static String serializeToString(Serializable obj) {
        String encoded = null;
        
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos);) {
            oos.writeObject(obj);
            encoded = new String(Base64.encode(baos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return encoded;
    }
    
    protected static Object deserializeFromString(String str) {
        byte[] data = null;
        try {
            data = Base64.decode(str);
        } catch (Base64DecodingException e) {
            e.printStackTrace();
        }
        
        Object obj = null;
        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));) {
            obj = ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "/home/tony/Desktop/compressThis";
        Compressor.compress(Paths.get(path + ".txt"));
        Compressor.decompress(Paths.get(path + ".compr"));
    }
}
