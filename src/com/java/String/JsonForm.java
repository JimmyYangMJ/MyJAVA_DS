package com.java.String;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author ymj
 * @Date： 2020/7/15 14:42
 * @description: json 字符串转化
 */
public class JsonForm {
    public static void main(String[] args) {
        String data = "{\n" +
                "\"status\": \"1\",\n" +
                "\"info\": \"OK\",\n" +
                "\"infocode\": \"10000\",\n" +
                "\"count\": \"1\",\n" +
                "\"suggestion\": {\n" +
                "\"keywords\": [],\n" +
                "\"year\": \"2005\",\n" +
                "\"price\": 30,\n" +
                "\"suggestions\": {\n" +
                "\"keywords\": [],\n" +
                "\"year\": \"2005\",\n" +
                "\"price\": 30\n" +
                "}\n" +
                "}\n" +
                "}";
        JSONObject json = JSONObject.parseObject(data);
        JSONArray jsonArray = json.getJSONObject("suggestion").getJSONObject("suggestions").getJSONArray("poi_list");
        JSONObject obj = (JSONObject) jsonArray.get(0);
        System.out.println(obj.get("year"));


    }
}
