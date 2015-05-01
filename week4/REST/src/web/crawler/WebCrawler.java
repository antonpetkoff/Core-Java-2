package web.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
    
    /**
     * 
     * @param domain
     * @param rootURL   always ends with /
     * @throws MalformedURLException
     * @throws URISyntaxException
     */
    public WebCrawler(String domain, String rootURL) throws MalformedURLException, URISyntaxException {
        httpclient = HttpClients.createDefault();
        this.domain = domain;
        this.rootURL = new URL(rootURL + "/").toURI().normalize().toString();
    }
    
    private String getContent(String url) throws ClientProtocolException, IOException {
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
    
    private List<String> filterLinks(String rootURL, List<String> links) {
        List<String> filtered = new ArrayList<String>();

        for (String link : links) {
            if (link.startsWith(".") || link.startsWith("#") || link.isEmpty()) {
                continue;
            } else if (link.startsWith("/")) {
                filtered.add(rootURL + link.substring(1));
            } else if (!link.startsWith("/") && link.endsWith(".html")) {
                filtered.add(rootURL + link);
            } else if (isSameDomain(link)) {
                filtered.add(link);
            }
        }
        
        return filtered;
    }
    
    private List<String> getAllLinks(String content) {
        List<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }
    
    /**
     * 
     * @param needle    String to search for
     * @return  a list of all links which contain needle
     */
    public List<String> find(String needle) {
        Set<String> visited = new TreeSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(rootURL);
        List<String> result = new ArrayList<String>();
        
        String content = null, tempURL = null;
        List<String> tempList = null;
        
        while(!queue.isEmpty()) {
            tempURL = queue.remove();
            try {
                content = getContent(tempURL);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (content.contains(needle)) {
                result.add(tempURL);
            }
            
            tempList = filterLinks(tempURL, getAllLinks(content));
            for (String link : tempList) {
                if (!visited.contains(link)) {
                    queue.add(link);
                }
            }
        }
        
        return result;
    }

    public String getRootURL() {
        return rootURL;
    }
    
    public String getDomain() {
        return domain;
    }
    
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        WebCrawler wc = new WebCrawler("ebusiness.free.bg", "http://ebusiness.free.bg");
        System.out.println(wc.find("код"));
    }

}
