package com.excel.test.read;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.excel.test.BicycleData;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ymj
 * @Date： 2020/7/20 14:08
 * @description:
 */
public class BicycleRead {
    static String homeDir = "D:\\shanghaiCYY\\运维项目\\单车测绘\\2徐汇区汇总2020-09-07\\汇总\\";
    static String fire = "(优化) 斜土路(斜土路街道)(101).xls";
    static List<String> bicycleDatalist = new ArrayList<>();

    public static void main(String[] args) {
        // 实现excel读操作
        String filename = homeDir + fire;
        EasyExcel.read(filename, BicycleData.class, new ExcelListener()).sheet().doRead();

        // 提取位置名称
        int count  = 0;
        for (int i = 0; i < bicycleDatalist.size(); i++) {
            if (i%4 == 2) {
                System.out.println(bicycleDatalist.get(i));
                count++;
            }
        }
        System.out.println("****" + count);
    }
}
class ExcelListener extends AnalysisEventListener<BicycleData> {
    //一行一行读取excel内容
    @Override
    public void invoke(BicycleData data, AnalysisContext analysisContext) {
        BicycleRead.bicycleDatalist.add(data.getName2());
    }
    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }
    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成****" + BicycleRead.bicycleDatalist.size());
    }
}

