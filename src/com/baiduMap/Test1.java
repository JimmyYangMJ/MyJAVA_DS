package com.baiduMap;

/**
 * @author ymj
 * @Date： 2020/7/7 9:01
 */
public class Test1 {
    public static void main(String[] args) {
        /** 数据格式：
         *      POLYGON(([经度1] [纬度1], [经度n] [纬度n]))
         *  */
        String string =
                "POLYGON((121.525379966273 31.2371499052445, 121.525391776035 31.2371540236511, 121.52548424248 31.2369661964181, 121.5254726928 31.2369620372368, 121.525379966273 31.2371499052445))";
        int begin = 9, end = string.length()-2;
        String temp = string.trim().substring(begin, end);
        String[] point = temp.split(",");
        System.out.println(temp);
        for (String tempPoint : point) {
            System.out.println(tempPoint.trim());
        }

    }
}
