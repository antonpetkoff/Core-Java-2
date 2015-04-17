package file.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static String reduceFilePath(String path) {
        return Paths.get(path).normalize().toString();
    }

    public static String readFrom(File file) throws FileNotFoundException, IOException {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            if (null != (line = reader.readLine())) {
                result.append(line);
            }

            while (null != (line = reader.readLine())) {
                result.append('\n').append(line);
            }
        }

        return result.toString();
    }

    public static String readFrom(Path path) throws FileNotFoundException, IOException {
        return readFrom(new File(path.toString()));
    }
    
    public static void writeTo(String text, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
        }
    }
    
    public static void writeTo(String text, Path path) throws IOException {
        writeTo(text, new File(path.toString()));
    }
    
}
