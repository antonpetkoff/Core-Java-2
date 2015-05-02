package news.parser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class NewsParser {

    public NewsParser() {
        
    }
    
    public String getNews() throws FeedException, IOException {
        URL url = new URL("http://www.sportal.bg/uploads/rss_category_2.xml");
        HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
        // Reading the feed
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(httpcon));
        List entries = feed.getEntries();
        Iterator itEntries = entries.iterator();
 
        StringBuilder sb = new StringBuilder();
        
        while (itEntries.hasNext()) {
            SyndEntry entry = (SyndEntry) itEntries.next();
            sb.append("<h3>").append("Title: " + entry.getTitle()).append("</h3>\n");
            sb.append("<a href=\"").append(entry.getLink()).append("\">Link</a> \n");
            sb.append("<p>").append("Publish Date: " + entry.getPublishedDate()).append("</p>\n");
            sb.append("<p>").append("Description: " + entry.getDescription().getValue()).append("</p>\n");
            sb.append("</br>\n");
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) throws FeedException, IOException {
        NewsParser np = new NewsParser();
        System.out.println(np.getNews());
    }
    
}
