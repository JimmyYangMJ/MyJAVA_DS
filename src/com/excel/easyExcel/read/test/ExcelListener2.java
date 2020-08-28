package com.excel.easyExcel.read.test;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author ymj
 * @Date： 2020/7/20 14:04
 * @description:
 */
public class ExcelListener2 extends AnalysisEventListener<DemoData2> {
    //一行一行读取excel内容
    @Override
    public void invoke(DemoData2 data, AnalysisContext analysisContext) {
        System.out.println("asd");
        System.out.println("****"+data);
    }
    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("wer");
        System.out.println("表头："+headMap);
    }
    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) { }
}
