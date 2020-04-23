package com.Process;

import java.io.*;

/**
 * 运行系统命令
 * @author ymj
 * @Date： 2020/4/22 11:27
 */
public class test1 {
    public static void main(String[] args) throws IOException {
//        File dir = new File("D:\\mysql57\\mysql-5.7.29-winx64\\bin");
//        // String command="netstat -an";
//        String command = "c:\\windows\\system32\\cmd.exe /c mysqlbinlog  ../data/master-bin.000006 | more";
//        Runtime r = Runtime.getRuntime();
//        Process p = r.exec(command, null, dir);
//        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        StringBuffer sb = new StringBuffer();
//        String inline;
//        while (null != (inline = br.readLine())) {
//            sb.append(inline).append("\n");
//        }
//        System.out.println(sb.toString());
         convert();
        System.out.println("结束转译-------------");
    }

    public static void convert(){
        try {
            File dir = new File("D:\\mysql57\\mysql-5.7.29-winx64\\bin");//此处是指定路径
            String[] cmd = new String[] { "cmd", "/c",
                    "mysqlbinlog -v ../data/master-bin.000006 | more"
            };// cmd[2]是要执行的dos命令
            System.out.println(cmd[2]);
            Process process = Runtime.getRuntime().exec(cmd,null,dir);

            // 记录dos命令的返回信息
            StringBuffer resStr = new StringBuffer();
            // 获取返回信息的流
            InputStream in = process.getInputStream();
            Reader reader = new InputStreamReader(in);
            BufferedReader bReader = new BufferedReader(reader);
            for (String res = ""; (res = bReader.readLine()) != null;) {
                resStr.append(res + "\n");
            }
            System.out.println(resStr.toString());
            bReader.close();
            reader.close();
            process.getOutputStream().close();  // 不要忘记了一定要关

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
