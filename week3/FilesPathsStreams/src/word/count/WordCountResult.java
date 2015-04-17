package word.count;

public final class WordCountResult {

    private int wordCount;
    private int lineCount;
    private int charCount;
    
    public WordCountResult() {
        this(0, 0, 0);
    }
    
    public WordCountResult(int wordCount, int lineCount, int charCount) {
        this.wordCount = wordCount;
        this.lineCount = lineCount;
        this.charCount = charCount;
    }
    
    public int getWordCount() {
        return this.wordCount;
    }
    
    public int getLineCount() {
        return this.lineCount;
    }
    
    public int getCharCount() {
        return this.charCount;
    }
    
}
