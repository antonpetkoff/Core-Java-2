package web.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class WebCrawler {

    private CloseableHttpClient httpclient;
    private String rootURL;
    
    public WebCrawler(String rootURL) {
        httpclient = HttpClients.createDefault();
        this.rootURL = rootURL;
    }
    
    public String getContent(String url) throws ClientProtocolException, IOException {
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        StringBuilder content = new StringBuilder();
        
        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String line = null;
            
            try(BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));) {
                while ((line = br.readLine()) != null) {
                    content.append(line);
                }
            }
            
        } finally {
            response.close();
        }
        
        return content.toString();
    }
    
    public List<String> getAllLinks(String content) {
        List<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    public String getRootURL() {
        return rootURL;
    }
    
    public static void main(String[] args) throws ClientProtocolException, IOException {
        WebCrawler wc = new WebCrawler("http://google.com");
        String content = wc.getContent("https://hackbulgaria.com/");
        System.out.println(content);
        System.out.println(wc.getAllLinks(content));
    }

    
}
