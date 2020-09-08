package com.excel.test;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class BicycleData {
    //设置excel表头名称
    @ExcelProperty(value = "经度转换",index = 0)
    private Double lon;
    @ExcelProperty(value = "纬度转换",index = 1)
    private Double lat;
    @ExcelProperty(value = "名称",index = 2)
    private String name1;
    @ExcelProperty(value = "固/浮",index = 3)
    private String name2;

}
