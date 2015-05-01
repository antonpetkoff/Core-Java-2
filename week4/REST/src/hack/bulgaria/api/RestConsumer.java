package hack.bulgaria.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    
    public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
        RestConsumer rc = new RestConsumer();
        System.out.println(rc.getContent(CHECKINS_URL));
    }
    
}
