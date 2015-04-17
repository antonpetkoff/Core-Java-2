package word.count;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import file.utils.FileUtils;

public class WordCounter {

    public static WordCountResult wordCount(Path path) {
        String text = null;
        try {
            text = FileUtils.readFrom(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new WordCountResult(text.split("\\s+").length, text.split("\\n").length + 1, text.length());
    }

    public static WordCountResult wordCount(File file) {
        return wordCount(file.toPath());
    }

}
