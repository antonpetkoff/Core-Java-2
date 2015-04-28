package file.download;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

public class FileDownloader {
    
    public static String testURL = "http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg";
    
    public static void downloadFile(String sourceURL, String destination) throws IOException {
        URL url = new URL(sourceURL);
        String fileName = sourceURL.substring(sourceURL.lastIndexOf('/') + 1, sourceURL.length());
        byte[] bytes = new byte[1024];
        int bytesRead = 0;
        
        try(InputStream is = url.openStream();
                FileOutputStream fos = new FileOutputStream(Paths.get(destination + fileName).normalize().toString());) {
            while(-1 != (bytesRead = is.read(bytes))) {
                fos.write(bytes, 0, bytesRead);
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            downloadFile(testURL, "/home/tony/Desktop/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
