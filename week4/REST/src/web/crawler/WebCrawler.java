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
    private String domain;
    private String rootURL;
    
    public WebCrawler(String domain, String rootURL) {
        httpclient = HttpClients.createDefault();
        this.domain = domain;
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
    
    private boolean isSameDomain(String url) {
        if (url.startsWith("http://")) {
            if (url.startsWith("www.", 7)) {
                return url.substring(11).startsWith(domain);
            } else {
                return url.substring(7).startsWith(domain);
            }
        } else if (url.startsWith("https://")) {
            if (url.startsWith("www.", 8)) {
                return url.substring(12).startsWith(domain);
            } else {
                return url.substring(8).startsWith(domain);
            }
        }
        return false;
    }
    
    public List<String> filterLinks(String rootURL, List<String> links) {
        List<String> filtered = new ArrayList<String>();

        for (String link : links) {
            if (link.startsWith("/")) {
                filtered.add(rootURL + link.substring(1));
            }
            else if (link.startsWith("#") || link.isEmpty() || !isSameDomain(link)) {
                continue;
            } else {
                filtered.add(link);
            }
        }
        
        return filtered;
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
    
    public String getDomain() {
        return domain;
    }
    
    public static void main(String[] args) throws ClientProtocolException, IOException {
        WebCrawler wc = new WebCrawler("hackbulgaria.com", "https://hackbulgaria.com/");
        String content = wc.getContent("https://hackbulgaria.com/");
        System.out.println(content + '\n');
        List<String> links = wc.getAllLinks(content);
        System.out.println(links);
        System.out.println(wc.filterLinks(wc.getRootURL(), links));
    }

    
}
