package hack.bulgaria.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public class RestConsumer {
    
    private static final String STUDENTS_URL = "https://hackbulgaria.com/api/students/";
    private static final String CHECKINS_URL = "https://hackbulgaria.com/api/checkins/";
    
    private String getContent(String url) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
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
    
    public int countPeopleInTwoCourses() throws ClientProtocolException, JSONException, IOException {
        JSONArray people = new JSONArray(getContent(STUDENTS_URL));
        int counter = 0;
        
        for (int i = 0; i < people.length(); ++i) {
            if (1 < people.getJSONObject(i).getJSONArray("courses").length()) {
                ++counter;
            }
        }
        
        return counter;
    }
    
    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                @Override
                public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = e2.getValue().compareTo(e1.getValue());
                    return res != 0 ? res : 1;
                }
            }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
    
    public String getTopTenVisitors() throws ClientProtocolException, JSONException, IOException {
        JSONArray visits = new JSONArray(getContent(CHECKINS_URL));
        Map<String, Integer> map = new TreeMap<String, Integer>();
        String tempName = null;
        
        for (int i = 0; i < visits.length(); ++i) {
            tempName = visits.getJSONObject(i).getString("student_name");
            if (map.containsKey(tempName)) {
                map.put(tempName, map.get(tempName) + 1);
            } else {
                map.put(tempName, 1);
            }
        }
        
        Set<Map.Entry<String, Integer>> sorted = entriesSortedByValues(map);
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (Iterator<Map.Entry<String, Integer>> iterator = sorted.iterator(); i < 10 && iterator.hasNext(); ++i) {
            Map.Entry<String, Integer> entry = iterator.next();
            result.append(entry + "\n");
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
        RestConsumer rc = new RestConsumer();
        System.out.println(rc.getTopTenVisitors());
    }
    
}
