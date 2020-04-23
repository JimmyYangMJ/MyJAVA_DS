package com.mysql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.ChecksumType;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
/**
 * @author ymj
 * @Date： 2020/4/20 21:23
 */
public class Test {

    public static void main(String[] args) throws IOException {
//        String filePath = "D:\\master-bin.000004";
//        File binlogFile = new File(filePath);
//        EventDeserializer eventDeserializer = new EventDeserializer();
//        eventDeserializer.setChecksumType(ChecksumType.CRC32);
//        BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile,
//                eventDeserializer);
//
//        try {
//            // 准备写入的文件名称
//            /*
//             * File f1 = new File("D:\\mysql-bin.000845.sql"); if
//             * (f1.exists()==false){ f1.getParentFile().mkdirs(); }
//             */
//            FileOutputStream fos = new FileOutputStream(
//                    "D:\\text.txt", true);
//            for (Event event; (event = reader.readEvent()) != null;) {
//                System.out.println(event.toString());
//
//                // 把数据写入到输出流
//                fos.write(event.toString().getBytes());
//            }
//            // 关闭输出流
//            fos.close();
//            System.out.println("输入完成");
//        } finally {
//            reader.close();
//        }
        test();

    }
    public static void test() throws IOException {
        String filePath="D:\\mysql57\\mysql-5.7.29-winx64\\data\\master-bin.000002";
        File binlogFile = new File(filePath);
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setCompatibilityMode(
                EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG,
                EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY
        );
        BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile, eventDeserializer);
        try {
            for (Event event; (event = reader.readEvent()) != null; ) {
                System.out.println(event.toString());
            }
        } finally {
            reader.close();
        }

    }

}
