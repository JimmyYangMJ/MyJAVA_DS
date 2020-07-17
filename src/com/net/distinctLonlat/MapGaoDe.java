package com.net.distinctLonlat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class MapGaoDe {

    /**
     * @param addr
     * 查询的地址
     * @return
     * @throws IOException
     */
    public String[] getCoordinate(String addr) {
        String lng = null;//经度
        String lat = null;//纬度
        String address = null;
        try {
            address = java.net.URLEncoder.encode(addr, "UTF-8");
        }catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        //System.out.println(address);
        String keywords = getURLEncode(addr);
        System.out.println(keywords);
        String url = "https://www.amap.com/service/poiInfo" +
                "?query_type=TQUERY&pagesize=20&pagenum=1&qii=true&cluster_state=5&need_utd=true&utd_sceneid=1000" +
                "&div=PC1000&addr_poi_merge=true&is_classify=true&zoom=12&city=330100&geoobj=120.01762%7C30.24298%7C120.399395%7C30.337844" +
                "&keywords=" + keywords;
        URL myURL = null;

        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader insr = null;
        BufferedReader br = null;
        try {
            httpsConn = (URLConnection) myURL.openConnection();
            if (httpsConn != null) {
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = null;
                while((data= br.readLine())!=null){
                    JSONObject json = JSONObject.parseObject(data);
                    JSONArray jsonArray = json.getJSONObject("data").getJSONObject("locres").getJSONArray("poi_list");
                    JSONObject obj = (JSONObject) jsonArray.get(0);
                    lng = (String) obj.get("longitude");
                    lat = (String) obj.get("latitude");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(insr!=null){
                try {
                    insr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new String[]{lng,lat};
    }

    public String getURLDecode(String url) {
        String decode = URLDecoder.decode(url);
        return decode;
    }

    public String getURLEncode(String url) {
        return URLEncoder.encode(url);
    }

    public static void main(String[] args) {
        MapGaoDe mapGaoDe = new MapGaoDe();
        String[]  s = mapGaoDe.getCoordinate("宁阳县");
        System.out.println(s[0] + " " + s[1]);
    }
}