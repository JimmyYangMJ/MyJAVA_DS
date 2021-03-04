import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLConnection;

public class Test7 {


    public static void main(String[] args) throws IOException {
        String urlName = "http://api.map.baidu.com/geoconv/v1/?coords=121.672623,31.022732&from=1&to=5&ak=kSQ5knK6qNUWLkq8iG0DGdIf4eCyvwOi";
        java.net.URL url = new java.net.URL(urlName);
        URLConnection connection = url.openConnection();
//            connection.addRequestProperty("Cookie", "JSESSIONID=071D56FE7890F1349164A3228BACC3EF");
        connection.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

        // 输出收到的内容
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while((line = br.readLine()) != null) {
            stringBuffer.append(line);
        }
        System.out.println(stringBuffer.toString());
        JSONObject ret = JSON.parseObject(stringBuffer.toString());

        // {"status":0,"result":[{"x":121.68330976272066,"y":31.026876056117897}]}
        // 121.68330473470948,31.026871745822255
    }

}