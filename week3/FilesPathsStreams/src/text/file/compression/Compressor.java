package text.file.compression;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    private ArrayList<String> list;
    
    public Compressor() {
        list = new ArrayList<String>();
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

                if (!list.contains(temp.toString())) {
                    list.add(temp.toString());
                }
                
                compressed.append("~" + list.indexOf(temp.toString()));
                temp = new StringBuilder();
            }
        }
        
        String fileName = filePath.getFileName().toString().replaceFirst("\\..*", "");
        String writePath = filePath.getParent().toString() + "/" + fileName + ".compr";
        
        try {
            FileUtils.writeTo(String.valueOf(compressed.length()) + compressed.toString(), Paths.get(writePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    
    public static void main(String[] args) {
        String path = "/home/tony/Desktop/compressThis.txt";
        Compressor compressor = new Compressor();
        compressor.compress(Paths.get(path));
    }
}
