package broken.links;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

public class BrokenLinksFinder {
    
    private static boolean isBrokenLink(Path path) {
        if (Files.isSymbolicLink(path)) {
            
            Path targetPath = null;
            try {
                targetPath = Files.readSymbolicLink(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if (!Files.exists(targetPath)) {
                return true;                // is broken link
            }
        }
        return false;
    }
    
    public static void printBrokenLinks(Path path) {
        if (!Files.exists(path)) {
            return;
        }
        
        Queue<File> queue = new LinkedList<File>();
        queue.add(new File(path.toString()));
        
        while (!queue.isEmpty()) {
            File temp = queue.remove();
            
            if (temp.isDirectory()) {
                for (File file : temp.listFiles()) {
                    queue.add(file);
                }
            } else if (temp.isFile()) {
                
                if (isBrokenLink(temp.toPath())) {
                    System.out.println(temp.toPath());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String path = "/home/tony/Desktop";
        printBrokenLinks(Paths.get(path));
    }
    
}
