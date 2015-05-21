package courseApply;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.apache.commons.io.FileUtils.contentEquals;
import java.util.LinkedList;

public class ListDuplicatingFiles {
	
	private static ArrayList<String> listDuplicatingFiles(String dir)
    throws InterruptedException, IOException {
        
        File root = new File(dir);
        
        if (!root.exists() || !root.isDirectory()) {
            return null;
        }
        
        LinkedList<File> queue = new LinkedList<>();
        ArrayList<String> filePaths = new ArrayList<>();
        
        File[] tempFileList = root.listFiles();
        for(File x : tempFileList) {
            queue.addLast(x);
        }
        
        while(!queue.isEmpty()) {
            File tempFile = queue.pollFirst();
            
            if(tempFile.isFile()) {
                boolean isUnique = true;
                for(String path : filePaths) {
                    if (contentEquals(tempFile, new File(path))) {
                        isUnique = false;
                        break;
                    }
                }
                
                if (isUnique) {
                    filePaths.add(tempFile.getCanonicalPath());
                }
            }
            else if(tempFile.isDirectory()) {
                tempFileList = tempFile.listFiles();
                for(File x : tempFileList) {
                    queue.addLast(x);
                }
            }
            else {
                throw new InterruptedException(tempFile.getCanonicalPath());
            }
        }
        
        // iterate, trim and leave only filenames!
        return filePaths;
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        String rootDir = "/home/tony/eclipse_workspace/CoreJava/src";
        ArrayList<String> filePaths = listDuplicatingFiles(rootDir);
        for (String x : filePaths) {
            System.out.println(x);
        }
    }
	
}
