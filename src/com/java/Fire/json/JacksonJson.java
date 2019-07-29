package com.java.Fire.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JacksonJson {

    public static void main(String[] args) throws Exception {
        testJsonObject();
        System.out.println("=========华丽丽的分割线==============");
        testJsonFile();
    }

    static void testJsonObject() throws IOException {

        /** 构造JSONObject对象*/
        ObjectMapper om = new ObjectMapper();

        /** 构造对象*/
        Person p = new Person();
        p.setName("Tom");
        p.setAge(20);
        p.setScores(Arrays.asList(60,70,80));

        /**
         * 将对象解析为json字符串
         * 方法： writeValueAsString(对象)
         * 对象 -- json字符串
         */
        String jsonStr = om.writeValueAsString(p);
        System.out.println(jsonStr);

        /**
         * 从json字符串重构对象
         * 方法： readValue
         * json字符串 -- 对象
         */
        Person p2 = om.readValue(jsonStr, Person.class);
        System.out.println(p2.getName());
        System.out.println(p2.getAge());
        System.out.println(p2.getScores());

        /**
         *  从json字符串重构为JsonNode对象
         *  json字符串 -- jsonNode对象
         */
        System.out.println("从json字符串重构为JsonNode对象");
        JsonNode node = om.readTree(jsonStr);
        System.out.println(node.get("name").asText());
        System.out.println(node.get("age").asText());
        System.out.println(node.get("scores"));
    }

    static void testJsonFile() throws IOException {
        ObjectMapper om = new ObjectMapper();

        //从json文件中加载，并重构为java对象
        File json2 = new File("books2.json");

        /**
         * 文件（json字符串） -- 对象数组
         * 方法： readValue（文件，）
         * jsonstr -- 对象数组
         */
        List<Book> books = om.readValue(json2, new TypeReference<List<Book>>(){});
        for (Book book : books) {
            System.out.println(book.getAuthor());
            System.out.println(book.getTitle());
        }
    }
}

