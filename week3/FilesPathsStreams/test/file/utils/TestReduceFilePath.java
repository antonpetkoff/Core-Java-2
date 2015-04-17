package file.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestReduceFilePath {

    @Test
    public void testReduceFilePath() {
        assertEquals("/", FileUtils.reduceFilePath("//////////////"));
        assertEquals("/", FileUtils.reduceFilePath("/"));
        assertEquals("/", FileUtils.reduceFilePath("/srv/../"));
        assertEquals("/srv/www/htdocs/wtf", FileUtils.reduceFilePath("/srv/www/htdocs/wtf/"));
        assertEquals("/srv/www/htdocs/wtf", FileUtils.reduceFilePath("/srv/www/htdocs/wtf"));
        assertEquals("/srv", FileUtils.reduceFilePath("/srv/./././././"));
        assertEquals("/etc/wtf", FileUtils.reduceFilePath("/etc//wtf/"));
        assertEquals("/", FileUtils.reduceFilePath("/etc/../etc/../etc/../"));
        assertEquals("/", FileUtils.reduceFilePath("/../"));
        assertEquals("/", FileUtils.reduceFilePath("/..///"));
    }
    
}
