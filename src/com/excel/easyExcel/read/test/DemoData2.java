package com.excel.easyExcel.read.test;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData2 {
    //设置excel表头名称
    @ExcelProperty(value = "经度转换",index = 0)
    private String jing;
    @ExcelProperty(value = "纬度转换",index = 1)
    private String wei;
    @ExcelProperty(value = "名称",index = 2)
    private String ming;
    @ExcelProperty(value = "固/浮",index = 3)
    private String gu;
}
