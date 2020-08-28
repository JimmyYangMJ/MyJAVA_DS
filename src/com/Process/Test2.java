package com.Process;

import java.io.*;

/**
 * @author ymj
 * @Date： 2020/8/3 13:05
 * @description: 运行系统命令
 */
public class Test2 {

    public static void main(String[] args) {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("windows")){
            runCMD();
//            runBat();
        }else {
            runShell();
        }
    }

    private static boolean runBat(){
        try {
            String dir = "D:\\IDEA-workspace\\MyJAVA_DS\\src\\com\\Process\\startRedis.bat";//此处是指定路径
            Process process = Runtime.getRuntime().exec(dir);

            // 记录dos命令的返回信息
            StringBuffer resStr = new StringBuffer();
            // 获取返回信息的流
            InputStream in = process.getInputStream();
            Reader reader = new InputStreamReader(in, "GBK");
            BufferedReader bReader = new BufferedReader(reader);
            for (String res = ""; (res = bReader.readLine()) != null;) {
                resStr.append(res + "\n");
            }
            System.out.println(resStr.toString());
            bReader.close();
            reader.close();
            process.getOutputStream().close();  // 不要忘记了一定要关
            System.out.println("已经启动");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    private static boolean runCMD(){
        try {
            File dir = new File("D:\\redis\\Redis-x64-3.2.100");//此处是指定路径
            String[] cmd = new String[] { "cmd", "/c",
                    "start /b redis-server.exe redis.windows.conf"
            };// cmd[2]是要执行的dos命令
            System.out.println("运行命令：" + cmd[2]);
            Process process = Runtime.getRuntime().exec(cmd,null,dir);
//            Runtime.getRuntime().exec("ping 47.96.130.110");

            // 记录dos命令的返回信息
            StringBuffer resStr = new StringBuffer();
            // 获取返回信息的流
            InputStream in = process.getInputStream();
            Reader reader = new InputStreamReader(in, "GBK");
            BufferedReader bReader = new BufferedReader(reader);
            for (String res = ""; (res = bReader.readLine()) != null;) {
                resStr.append(res + "\n");
            }
            System.out.println(resStr.toString());
            bReader.close();
            reader.close();
            process.getOutputStream().close();  // 不要忘记了一定要关
            System.out.println("已经启动");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    private static boolean runShell(){
        System.out.println("linux 系统");
        return true;
    }

}
