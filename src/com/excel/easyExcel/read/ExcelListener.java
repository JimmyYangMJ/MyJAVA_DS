package com.excel.easyExcel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.excel.easyExcel.DemoData;

import java.util.Map;

/**
 * @author ymj
 * @Date： 2020/7/20 14:04
 * @description:
 */
public class ExcelListener extends AnalysisEventListener<DemoData> {
    //一行一行读取excel内容
    @Override
    public void invoke(DemoData data, AnalysisContext analysisContext) {
        System.out.println("****"+data);
    }
    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }
    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) { }
}
