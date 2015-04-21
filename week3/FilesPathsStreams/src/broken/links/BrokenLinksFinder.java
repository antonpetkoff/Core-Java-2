package broken.links;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BrokenLinksFinder {
    
    private static boolean isBrokenLink(Path path) {
        Map<String, Object> attributes = null;
        try {
            attributes = Files.readAttributes(path, "isSymbolicLink");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        // readAttributes doesn't recognize symbolic links on my Ubuntu... sad
        if (null != attributes && (boolean) attributes.get("isSymbolicLink")
                || Files.isSymbolicLink(path)) {
            Path targetPath = null;
            try {
                targetPath = Files.readSymbolicLink(path);
            } catch (IOException e2) {
                e2.printStackTrace();
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
