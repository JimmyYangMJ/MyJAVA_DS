package com.excel.easyExcel.read.test;

import com.alibaba.excel.EasyExcel;

/**
 * @author ymj
 * @Date： 2020/7/20 14:08
 * @description:
 */
public class TestEasyExcelRead2 {
    public static void main(String[] args) {

        // 实现excel读操作
        String filename = "D:/漕河泾街道宾南路、安定路、冠生园路、钦州南路、五原路6月10日(108个).xls";
        EasyExcel.read(filename, DemoData2.class, new ExcelListener2()).sheet().doRead();
        System.out.println("666");
    }
}
