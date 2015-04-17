package fix.encoding;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncodingFixer {

    public static void fixEncoding(Path source, Path destination) {
        byte[] bytesRead = null;
        try {
            bytesRead = Files.readAllBytes(source);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(destination.toString()), StandardCharsets.UTF_8))) {
            bw.write(new String(bytesRead, Charset.forName("Windows-1251")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        fixEncoding(Paths.get("res/subtitlesInWindows1251.srt"), Paths.get("res/subtitlesInUTF8.txt"));
    }
    
}
