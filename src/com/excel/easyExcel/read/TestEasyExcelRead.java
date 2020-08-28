package com.excel.easyExcel.read;

import com.alibaba.excel.EasyExcel;
import com.excel.easyExcel.DemoData;

/**
 * @author ymj
 * @Date： 2020/7/20 14:08
 * @description:
 */
public class TestEasyExcelRead {
    public static void main(String[] args) {

        // 实现excel读操作
        String filename = "D:/test.xlsx";
        EasyExcel.read(filename, DemoData.class,new ExcelListener()).sheet().doRead();
    }
}
