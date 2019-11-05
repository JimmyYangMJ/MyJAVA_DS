package com.java.Comparator;

import java.util.*;

public class MapSort {
    public static void main(String[] args) {
        Map map=new TreeMap();
        map.put("图书" , 4);
        map.put("音像" , 6);
        map.put("素材" , 9);
        map.put("音乐" , 8);
        map.put("影视" , 7);
        map.put("动漫" , 4);
        map.put("歌曲" , 3);
        map.put("图片" , 2);
        map.put("图标" , 6);

        List<String> lists = new ArrayList<String>();
        lists.add("as");
        lists.add("qq");
        List<String> list = new ArrayList<String>(lists);
        System.out.println(list);
        System.out.println("qqqqqqqqqqqqqqqqq");
        ArrayList<Map.Entry<String,Integer>> entries= sortMap(map);
        for( int i=0;i<5;i++){
            System. out.print(entries.get(i).getKey()+":" +entries.get(i).getValue());
        }
    }

    /**
     * 对HashMap 进行排序
     * @param map
     * @return
     */
    public static ArrayList<Map.Entry<String,Integer>> sortMap(Map map){

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1 , Map.Entry<String, Integer> obj2) {
                return obj2.getValue() - obj1.getValue();
            }
        });
        return (ArrayList<Map.Entry<String, Integer>>) entries;
    }

    /**
     * TreeMap 更改排序内容
     */
    public static void sortByValue() {
        Map<String,String> map = new TreeMap<String,String>();
        map.put("a", "dddd");
        map.put("d", "aaaa");
        map.put("b", "cccc");
        map.put("c", "bbbb");

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, String> e: list) {
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
}
