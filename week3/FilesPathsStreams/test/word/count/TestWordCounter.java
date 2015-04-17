package word.count;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class TestWordCounter {

    @Test
    public void testWordCounter() {
        WordCountResult result = WordCounter.wordCount(new File("res/wordCountTestFile.txt"));

        assertEquals(Integer.valueOf(5), Integer.valueOf(result.getLineCount()));
        assertEquals(Integer.valueOf(17), Integer.valueOf(result.getWordCount()));
        assertEquals(Integer.valueOf(114), Integer.valueOf(result.getCharCount()));
    }

}
